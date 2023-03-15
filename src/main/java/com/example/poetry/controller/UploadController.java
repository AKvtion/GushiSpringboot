package com.example.poetry.controller;

import com.example.poetry.base.config.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("upload")
public class UploadController {

    @Value("${file.location}")
    String filelocation;
    @Value("${file.path}")
    String filepath;

    @RequestMapping("/onlode")
    public Result onlode(Model model, HttpServletRequest httpRequest,
                         @RequestParam("file") MultipartFile file) throws IOException {
        //判断如果文件不为空
        if (!file.isEmpty()) {
            //上传文件路径
            //String path = "D:/JavaWeb/match/img";
            //System.out.println("上传文件路径path" + path);
            //上传文件名
            String filename = file.getOriginalFilename();
            //上传文件类型
            System.out.println("上传文件类型getContentType:" + file.getContentType());
            //上传文件名
            System.out.println("上传文件名getOriginalFilename:" + file.getOriginalFilename());
            /**
             * 创建一个文件对象，把存文件的路径和文件名放进去
             */
            File filepath = new File(filelocation, filename);
            //路径不存在就创建一个路径
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            /**
             * 将上传文件保存到一个目标文件中
             */
            file.transferTo(new File(filelocation + File.separator + filename));
            //返回
            return new Result().success(filename+filepath);
        }
        return new Result().fail("上传失败",400);
    }


}
