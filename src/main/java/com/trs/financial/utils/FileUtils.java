package com.trs.financial.utils;


import com.google.common.io.Files;
import com.trs.common.base.PreConditionCheck;
import com.trs.web.builder.util.BeanFactoryHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.trs.common.base.PreConditionCheck.checkArgument;
import static com.trs.common.base.PreConditionCheck.checkNotNull;
import static org.springframework.util.StringUtils.isEmpty;

/**
 * @description:
 * @author: liu.zhengwei
 * @create: 2019/11/04 22:17
 */
@Slf4j
public class FileUtils {

    public static File multiPartFile2File(MultipartFile mfile) {
        log.info("MultipartFile转File");
        checkNotNull(mfile, "multiPartFile2File()的参数mfile不能为空");
        File file = null;
        String prePath = null;
        try {
            prePath = BeanFactoryHolder.getEnv().getProperty("file.path.pre");
            String fileName = String.format("%s.%s", UUID.randomUUID(), Objects.requireNonNull(mfile.getOriginalFilename()).split("\\.")[1]);
            String filePath = String.format("%s%s%s", prePath, File.separator, fileName);
            //创建临时目录下的文件
            file = new File(filePath);
            // 如果父目录不存在，创建父目录
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            //MultipartFile转化为
            mfile.transferTo(file);
        } catch (Exception e) {
            log.error(String.format("[%s]路径下进行文件创建失败",prePath));
            throw new IllegalArgumentException("文件存储失败", e);
        }
        return file;
    }

    /**
     * 将inputStream转为音频文件,格式默认为MP3。修改话需要同步修改SynAudioRquestBody的格式
     * @param inputStream
     * @param fmt 文件后缀名
     * @return 文件名称
     * @throws Exception
     */
    public static File input2File(InputStream inputStream,String fmt){
        PreConditionCheck.checkNotNull(fmt,"文件后缀不能为空，不然导致文件无法查看的问题");
        String prePath = BeanFactoryHolder.getEnv().getProperty("file.path.pre");
        //默认都是mp3格式
        String fileName = UUID.randomUUID().toString()+fmt;
        String savePath = String.format("%s/%s", prePath, fileName);
        log.info("文件存储路径：" + fileName);
        //创建临时目录下的文件
        File file = new File(savePath);
        try {
            //判断文件夹目录是否存在，不存在则创建
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            //由于使用uuid进行文件命名 所以不存在重复问题
            file.createNewFile();
            //写入文件
            Files.write(StreamUtils.copyToByteArray(inputStream),file);
        } catch (IOException e) {
            if (file.exists()) {
                file.delete();
            }
            throw new IllegalArgumentException("输入流转文件失败：" +e);
        }
        return file;
    }

    /**
     * 图片转化成base64字符串
     * @param imgFile
     * @return
     */
    public static String fileToBase64(File imgFile) {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        checkNotNull(imgFile, "传入的图片参数不能为空");
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);//返回Base64编码过的字节数组字符串

    }

    /**
     * base64字符串转化成图片
     * @param base64
     * @return
     * @throws IOException
     */
    public static File base64ToFile(String base64) throws IOException {
        checkArgument(!isEmpty(base64), "base64字符串不能为空");
        String suff = "jpg";
        if(base64.contains("data:image")){
            String reg = "/(.*?);";
            Pattern pattern = Pattern.compile(reg);
            Matcher matcher = pattern.matcher(base64);
            if (matcher.find()) {
                suff = matcher.group(1);
            }

            base64 = base64.substring(base64.indexOf(",")+1);
        }
        base64 = base64.replace("\r\n", "");

        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes =  decoder.decodeBuffer(base64);

            //创建文件目录
            String prePath = BeanFactoryHolder.getEnv().getProperty("file.path.pre");
            String fullName = String.format("%s/%s.%s", prePath, UUID.randomUUID(), suff);
            log.info("文件存储路径：" + fullName);
            File file = new File(fullName);
            //判断文件夹目录是否存在，不存在则创建
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            //创建文件
            checkArgument(file.createNewFile(), "文件创建失败：" + fullName);

            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bytes);
            return file;
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 文件转图片
     * @param file
     * @return
     * @throws IOException
     */
    public static BufferedImage toImage(File file) throws IOException {
        checkNotNull(file, "文件参数为空,转图片失败！");
        checkArgument(file.exists(), "文件不存在,转图片失败！");
        return ImageIO.read(file);
    }

//    /**
//     * 获取视频时长：毫秒
//     *
//     * @param file
//     * @return
//     */
//    public static long getVedioTime(File file) {
//        try {
//            log.info("开始获取视频时长");
//            MultimediaObject instance = new MultimediaObject(file);
//            MultimediaInfo result = instance.getInfo();
//            return result.getDuration();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new IllegalArgumentException("获取视频时长失败");
//        }
//    }

    /**
     * 计算文件 MD5
     * @param file
     * @return 返回文件的md5字符串，如果计算过程中任务的状态变为取消或暂停，返回null， 如果有其他异常，返回空字符串
     */
    public static String getFileMd5(File file) {
        try (InputStream stream = java.nio.file.Files.newInputStream(file.toPath(), StandardOpenOption.READ)) {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] buf = new byte[8192];
            int len;
            while ((len = stream.read(buf)) > 0) {
                digest.update(buf, 0, len);
            }
            return DigestUtils.md5DigestAsHex(digest.digest());
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}