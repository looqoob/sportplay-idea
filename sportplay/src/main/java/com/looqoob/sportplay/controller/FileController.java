package com.looqoob.sportplay.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {

    @Value("${server.port}")
    private String port;

    private static final String ip = "http://localhost";

    @RequestMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();//获取文件名称
        //定义文件唯一标识
        String flag = IdUtil.fastSimpleUUID();
        String rootFilePath = System.getProperty("user.dir") + "/src/main/resources/files/" + flag + "_" + originalFilename;//路径
        System.out.println(rootFilePath);//将文件写入
        FileUtil.writeBytes(file.getBytes(),rootFilePath);
        return ip + ":" + port + "/files/" + flag;
    }

    @GetMapping("/{flag}")
    public void getFiles(HttpServletResponse response, @PathVariable String flag){
        OutputStream os;
        String basePath = System.getProperty("user.dir") + "/src/main/resources/files/";
        List<String> fileNames = FileUtil.listFileNames(basePath);
        String file = fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse("");
        try {
            if(StrUtil.isNotEmpty(file)){
                response.addHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(file,"UTF-8"));
                response.setContentType("application/octet-stream");
                byte[] bytes = FileUtil.readBytes(basePath + file);
                os = response.getOutputStream();
                os.write(bytes);
                os.flush();
                os.close();
            }
        }catch (Exception e){
            System.out.println("");
        }
    }

    @GetMapping("/delete")
    public String requestparmText(String fileName) {
        String path = System.getProperty("user.dir") + "/src/main/resources/files/";
        File file = new File(path + fileName);
        System.out.println(file);

        boolean f = file.delete();
        if (f!= true) {
            return "删除失败";
        }
        return "删除成功";
    }
}
