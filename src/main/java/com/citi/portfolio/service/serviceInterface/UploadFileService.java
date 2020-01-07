package com.citi.portfolio.service.serviceInterface;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by changqing on 2018/8/15.
 */
public interface UploadFileService {
    boolean saveFile(MultipartFile file);
    boolean readFile(String type);
}
