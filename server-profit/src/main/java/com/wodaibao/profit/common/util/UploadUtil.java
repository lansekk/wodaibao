package com.wodaibao.profit.common.util;

import com.wodaibao.common.model.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 上传方法
 *
 */
@Slf4j
public class UploadUtil {
    /**
     * @param file 文件
     * @param path 存储路径
     * @return CommonResult 成功返回存储路径
     */
    public static CommonResult<String> uploadMultipartFile(MultipartFile file, String path) {
        // 取得上传文件
        if (null != file) {
            String myFileName = file.getOriginalFilename();
            // 文件类型
            String fileType = myFileName.substring(myFileName.lastIndexOf('.') + 1, myFileName.length());
            // 定义上传路径
            StringBuilder sb = new StringBuilder();
            sb.append(path);
            sb.append("/");
            sb.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
            sb.append(RandomStringUtils.random(4, "0123456789"));
            sb.append(".");
            sb.append(fileType);
            File localFile = new File(sb.toString());
            File f = new File(path);
            if (!f.exists()) {
                f.mkdirs();
            }
            try {
                file.transferTo(localFile);
            } catch (IOException e) {
                log.error("上传图片失败", e);
                return new CommonResult<String>().setSuccess(false);
            }
            // 本地路径
            return new CommonResult<String>().setSuccess(true).setData(sb.toString());
        }
        return new CommonResult<String>().setSuccess(false);
    }
}