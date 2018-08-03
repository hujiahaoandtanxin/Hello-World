package com.hujiahao.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hujiahao.model.Msg;
import com.hujiahao.model.Wireman;
import com.hujiahao.service.WiremanService;

@Controller
public class UploadFileController {
	
	//引入一个日志类
	protected static Logger logger=Logger.getLogger(WiremanController.class);
	@Autowired
	WiremanService wiremanService;
	
	/**
	 * 此控制层是文件上传功能的实现
	 * 1 把图片上传到服务器自定的目录里
	 * 2 把图片所在的服务器目录中的路径根据传来的openid（电工）放到数据库里更新
	 * @param request
	 * @param file
	 * @param wireman
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/file")
	@ResponseBody//默认把对象返回---变成json字符串
	public String uploadFile(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file,Wireman wireman) throws IOException {
		System.out.println("执行upload");
        request.setCharacterEncoding("UTF-8");
        logger.info("执行图片上传");
        String user = request.getParameter("user");
        //获取前端传来的openid
        String openid = request.getParameter("openid");
        System.out.println(openid);
        logger.info("user:"+user);
        if(!file.isEmpty()) {
            logger.info("成功获取照片");
            String fileName = file.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            String path = null;
            String type = null;
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            logger.info("图片初始名称为：" + fileName + " 类型为：" + type);
            if (type != null) {
                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                	 // 获取服务器的webapps下的images文件路径
                	String projectPath = request.getSession().getServletContext().getRealPath("/");//这方法是实现获取到服务器的路径
                    String realPath = new File(projectPath ).getParentFile().getAbsolutePath();//这方法是获取文件路径的上一层路径的绝对路径
                    // 自定义的文件名称
                    String trueFileName = String.valueOf(System.currentTimeMillis())+"."+suffix ;
                    // 设置存放图片文件的路径
                    path = realPath + "\\cred_pic\\" + trueFileName;
                    
                    //存放保存图片的路径放到数据库----路径按照服务器的来保存--用于查询显示上一张的功能
                   String savePath =  "http://localhost:8080/cred_pic/"+trueFileName;
                    wireman.setCredPicUrl(savePath);
                    wireman.setOpenId(openid);
                    int result = wiremanService.updateByOpenIdSelective(wireman);
                    System.out.println(result);
                    
                    logger.info("存放图片文件的路径:" + path);
                    file.transferTo(new File(path));
                    logger.info("文件成功上传到指定目录下");
                }else {
                    logger.info("不是我们想要的文件类型,请按要求重新上传");
                    return "error";
                }
            }else {
                logger.info("文件类型为空");
                return "error";
            }
        }else {
            logger.info("没有找到相对应的文件");
            return "error";
        }
        return "success";
  
		
	}
}
