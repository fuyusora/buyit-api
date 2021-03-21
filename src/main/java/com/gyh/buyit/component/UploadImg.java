package com.gyh.buyit.component;

import com.gyh.buyit.entity.FileResult;
import com.gyh.buyit.service.BannerService;
import com.gyh.buyit.service.GoodService;
import com.gyh.buyit.service.SkuService;
import com.gyh.buyit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Controller
@ResponseBody
public class UploadImg {
    /**
     * 文件上传
     * @param picture
     * @param request
     * @return
     */

    @Autowired
    UserService userService;

    @Autowired
    SkuService skuService;

    @Autowired
    GoodService goodService;

    @Autowired
    BannerService bannerService;

    @RequestMapping("/upload")
    public FileResult upload(@RequestParam("uploadType") String uploadType,@RequestParam("id") int id, @RequestParam("picture") MultipartFile picture, HttpServletRequest request) {
        System.out.println(uploadType);
        String pathPre = "D://buyit//image";
        String path="";
        String urlPre="http://localhost:8181/image/";
        switch (uploadType){
            case "avatar":
                path=pathPre+"//avatar";
                break;
            case "skuImg":
                path=pathPre+"//good//sku";
                break;
            case "detailImg":
                path=pathPre+"//good//detail";
                break;
            case "banner":
                path=pathPre+"//banner";
                break;
        }


        File filePath = new File(path);
        System.out.println("文件的保存路径：" + path);
        if (!filePath.exists() && !filePath.isDirectory()) {
            System.out.println("目录不存在，创建目录:" + filePath);
            filePath.mkdir();
        }

        //获取原始文件名称(包含格式)
        String originalFileName = picture.getOriginalFilename();
        System.out.println("原始文件名称：" + originalFileName);

        //获取文件类型，以最后一个`.`为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        System.out.println("文件类型：" + type);
        //获取文件名称（不包含格式）
        String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

        String uuid= UUID.randomUUID().toString().replace("-", "");
        String fileName = uuid + "." + type;
        System.out.println("新文件名称：" + fileName);

        //在指定路径下创建一个文件
        File targetFile = new File(path, fileName);
        String imageUrl=path+"/"+fileName;
        System.out.println("图片地址："+path+"/"+fileName);
        //将文件保存到服务器指定位置
        try {
            picture.transferTo(targetFile);
            System.out.println("上传成功");
            switch (uploadType){
                case "avatar":
                    userService.setUserAvatar(id,urlPre+"avatar/"+fileName);
                    break;
                case "skuImg":
                    skuService.setSkuImg(id,urlPre+"good/sku/"+fileName);
                    break;
                case "detailImg":
                    goodService.setDetailImg(id,urlPre+"good/detail/"+fileName);
                    break;
                case "banner":
                    bannerService.setBannerPath(id,urlPre+"banner/"+fileName);
                    break;
            }
            //将文件在服务器的存储路径返回
            return new FileResult(true,fileName,path+"/"+fileName);
        } catch (IOException e) {
            System.out.println("上传失败");
            e.printStackTrace();
            return new FileResult(false, "上传失败","");
        }
    }}
