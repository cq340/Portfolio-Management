package com.citi.portfolio.controller;


import com.citi.portfolio.service.serviceInterface.UploadFileService;
import com.citi.response.entity.Response;
import com.citi.response.entity.ResponseEnum;
import com.citi.response.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
    @Autowired
    UploadFileService uploadFileService;


    @PostMapping("/uploadFile")
    public Response singleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("type") String type) {

        if (file.isEmpty()) {
            return ResponseUtil.error(ResponseEnum.UPLOAD_FAIL);
        }
        uploadFileService.saveFile(file);
        if (uploadFileService.readFile(type)) {
            System.out.println("接收成功+");
            return ResponseUtil.success();
        }
        return ResponseUtil.error(ResponseEnum.UPLOAD_FAIL);
    }
}

