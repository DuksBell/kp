package com.bingyi.kp.controller;

import com.bingyi.kp.pojo.Fileup;
import com.bingyi.kp.pojo.Review;
import com.bingyi.kp.service.FileService;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

/**
 * @author: dusk
 */
@Controller
public class FileController extends BaseController{
    @Autowired
    private FileService fileService;
    private String filename = "";
    private String filepath = "";
    private Long id = 0L;

    @RequestMapping("/file/list")
    public String query(Model model){
        List<Fileup> fileups = fileService.selectByAll();
        model.addAttribute("files",fileups);
        return "resources";
    }

    @RequestMapping(value = "/file/{fid}")
    public String queryByid(@PathVariable Long fid, Model model){
        Fileup file = new Fileup();
        file.setFid(fid);
        List<Fileup> fileups = fileService.selectByFile(file);
        filepath = fileups.get(0).getPath();
        filename = fileups.get(0).getFilename();
        id = fileups.get(0).getFid();
        model.addAttribute("file",fileups.get(0));
        return "filedown";
    }

    @PostMapping("/file/upload")
    @CrossOrigin
    public String fileUpload(
            @RequestParam("file") MultipartFile file, HttpServletRequest req, Model model, HttpSession session){
        try {
            String fileName = System.currentTimeMillis()+file.getOriginalFilename();
            String destFileName=req.getServletContext().getRealPath("/upload")+ File.separator+fileName;
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            file.transferTo(destFile);
            Fileup fileup = new Fileup();
            fileup.setFilename(fileName);
            fileup.setCtime(new Date());
            fileup.setPath(destFileName);
            fileup.setUsername(session.getAttribute("loginUser").toString());
            fileup.setTotal(0);
            fileService.insert(fileup);
            model.addAttribute("fileName",fileName);
            model.addAttribute("path",destFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }
        return "resources";
    }


    @RequestMapping(value="/download/{fid}")
    @CrossOrigin
    public void download(HttpServletResponse response,
                         HttpServletRequest request,
                         @PathVariable Long fid,
                         Model model)throws Exception{
        String downPath = filepath;
        String substring = downPath.substring(0, downPath.lastIndexOf("\\", downPath.lastIndexOf("\\") ));
        System.out.println(substring);
        FileInputStream in = new FileInputStream(substring+File.separator+filename);
        if(request.getHeader("user-agent").toLowerCase().contains("msie")){
            filename = URLEncoder.encode(filename, "UTF-8");
        }else{
            filename = new String(filename.getBytes("UTF-8"),"iso-8859-1");
        }
        File file = new File(downPath);
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
        response.addHeader("Content-Length", "" + file.length());
        OutputStream os = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len=0;
        while((len=in.read(buffer))!=-1) {
            os.write(buffer, 0, len);
        }

        in.close();
        os.close();
        response.setCharacterEncoding("utf-8");
        Fileup fileup = new Fileup();
        fileup.setFid(id);
        List<Fileup> fileups = fileService.selectByFile(fileup);
        int i = fileups.get(0).getTotal() + 1;
        fileup.setTotal(i);
        fileService.update(fileup);
    }

}
