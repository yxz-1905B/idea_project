package com.fh.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

		@RequestMapping("/uploadFile")
		public static String uploadFile (MultipartFile imgs,HttpServletRequest request, String files){

		   if(imgs!=null && imgs.getSize()>0){
			 //文件拷贝  将文件上传的文件 拷贝到服务器的files目录下
			   //先找到要保存的目录（服务器的根目录）
			   String realPath = request.getServletContext().getRealPath(files);
			   //将文件保存在 根目录下的files目录下
			   File f=new File(realPath);
			   //判断此目录是否存在 
			   if(!f.exists()){
				   //创建此目录
				   f.mkdirs();
			   };
			   //拷贝文件 
			   try {
				   //输入流
				InputStream is = imgs.getInputStream();
				//输出流
				FileOutputStream os=new FileOutputStream(realPath+"/"+imgs.getOriginalFilename());
				//每次读写字节数
				byte[] bts=new byte[2048];
				//具体拷贝过程
				while(is.read(bts)!=-1){
					os.write(bts);
				};
				//关流  释放资源
				os.close();
				is.close();
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return files+"/"+imgs.getOriginalFilename();
		   }
		   return "上传文件不存在";
		}
	 }

