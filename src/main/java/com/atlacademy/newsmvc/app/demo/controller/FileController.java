package com.atlacademy.newsmvc.app.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/upload")
    public String  upload(@RequestParam("file") MultipartFile file){
        // Get the name of the file
        String filename = file.getOriginalFilename();
        // Get the file extension
        String suffix = filename.substring(filename.lastIndexOf("."));
        // upload files on upload file folder under the D drive
        String path="/Users/anar/Desktop/";
        // prevent duplicate file names random file name
        filename=path+ UUID.randomUUID()+suffix;
        File f=new File(filename);
        // If you do not upload a folder under the D drive to create a
        if(!f.getParentFile().exists()){
            f.getParentFile().mkdirs();
        }
        try {
            // File type into the MultipartFile
            file.transferTo(f);
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }


    @GetMapping(value = "/download/{fileName:.+}")
    public String download(@PathVariable("fileName")String fileName, HttpServletResponse response){
        try {
            // file address, the real environment is stored in the database
            File file=new File(fileName);
            // Create input stream, the incoming file objects
            FileInputStream fis=new FileInputStream("/Users/anar/Desktop/"+file);
            // set the relevant format
            response.setContentType("application/pdf");
            // set the file name and download header
            response.addHeader("Content-disposition", "attachment;filename="+file.getName());
            OutputStream os = response.getOutputStream();
            // normal operation
            byte[] buf = new byte[1024];
            int len = 0;
            while((len = fis.read(buf)) != -1) {
                os.write(buf, 0, len);
            }
            os.close();
            fis.close();
            return "success"; // In order to facilitate the testing I wrote a two html success.html there is a error.html is used to indicate the success or failure
        }catch (IOException e){
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping(value = "/images/{fileName:.+}")
    public String images(@PathVariable("fileName")String fileName, HttpServletResponse response){
        try {
            // file address, the real environment is stored in the database
            File file=new File(fileName);
            // Create input stream, the incoming file objects
            FileInputStream fis=new FileInputStream("/Users/anar/Desktop/"+file);
            // set the relevant format
            response.setContentType("application/pdf");
            // set the file name and download header
            response.addHeader("Content-disposition", "attachment;filename="+file.getName());
            OutputStream os = response.getOutputStream();
            // normal operation
            byte[] buf = new byte[1024];
            int len = 0;
            while((len = fis.read(buf)) != -1) {
                os.write(buf, 0, len);
            }
            os.close();
            fis.close();
            return "success"; // In order to facilitate the testing I wrote a two html success.html there is a error.html is used to indicate the success or failure
        }catch (IOException e){
            e.printStackTrace();
            return "error";
        }
    }

}
