package com.ms1491.common.utils;

import java.io.FileNotFoundException;

import org.springframework.util.ResourceUtils;

import com.ms1491.common.exception.RRException;
import com.ms1491.modules.api.utils.ApiCode;


/**
 * 说明：路径工具类
 * @author Administrator
 *
 */
public class PathUtil {
	
	public static final String REGISTER_URL = "https://www.ms1491.com/api/register/";//注册地址
	
	public static final String UPLOAD_PATH = "static/images/upload/";//上传文件路径
	
	public static final String LOGO_PATH = "static/images/logo/cyc.png";//logo文件路径
	
	public static final String DEFAULT_AVATAR_PATH = "static/images/logo/default_avatar_middle.jpg";//默认头像文件路径
	
	
	public static String getDefaultAvatar(){
		try {
			String basepath = ResourceUtils.getURL("classpath:").getPath();
			return basepath+DEFAULT_AVATAR_PATH;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RRException("文件不存在",ApiCode.AC_OTHER_ERROR);
		}
	}
	public static String getLogoPath() throws FileNotFoundException{
		try {
			String basepath = ResourceUtils.getURL("classpath:").getPath();
			return basepath+LOGO_PATH;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RRException("文件不存在",ApiCode.AC_OTHER_ERROR);
		}
	}
	public static String getUploadPath() throws FileNotFoundException{
		try {
			String basepath = ResourceUtils.getURL("classpath:").getPath();
			return basepath+UPLOAD_PATH;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RRException("文件不存在",ApiCode.AC_OTHER_ERROR);
		}
	}
}
