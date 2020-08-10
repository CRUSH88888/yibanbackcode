package edu.scau.common.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @description:
 * @auther:cyf
 * @create:2020/6/26 14:20
 **/
public class FileUtil {
    public static String swp = "C:/images";//望平哥特用
    public static String dev = "D:/images";//开发
    public static String pro = "/usr/local/video";//上线

    public static String saveFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String dirName = dev ;
        File dir = new File(dirName);
        if (!dir.exists()){
            dir.mkdir();
        }
        if (file.getOriginalFilename()==null)
        {
            return "null";
        }
        String filePath = dev +"/";
        File dest = new File(filePath + fileName);
        System.out.println(filePath+fileName);
        dest.createNewFile();
        file.transferTo(dest);
        return ApiResponse.URL+"/video/"+fileName;
    }
    public static Boolean deleteFile(String url){
        String oldPath = url;
        oldPath = oldPath.substring(26);//26
        System.out.println("old:"+oldPath);
        File oldFile = new File(pro+oldPath);///usr/local
        System.out.println("delete:" + pro+oldPath);
        Boolean result = oldFile.delete();
        return result;
    }
}
