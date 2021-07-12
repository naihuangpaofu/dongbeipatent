package com.ljy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ljy.pojo.Img;
import io.minio.errors.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * <p>
 * 图片表 服务类
 * </p>
 *
 * @author liujunyi
 * @since 2021-07-07
 */
public interface IImgService extends IService<Img> {
    String upload(MultipartFile file) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, InvalidBucketNameException, ErrorResponseException;
}
