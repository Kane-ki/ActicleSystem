package com.msr.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjing
 * @create 2024-11-14 下午5:53
 * @desc
 */
@RestController
public class FileUploadController {
/*    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws Exception {
        //把文件的内容存储到本地磁盘上
        String originalFilename = file.getOriginalFilename();
        //保证文件的名字是唯一的,从而防止文件覆盖
        String filename = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        String url = AliOssUtil.uploadFile(filename,file.getInputStream());
        return Result.success(url);
    }*/
}
