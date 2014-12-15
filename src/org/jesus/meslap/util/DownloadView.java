package org.jesus.meslap.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView {
	
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		File file = (File)model.get("downloadFile");
		response.setContentType("application/download; charset=utf-8");
		response.setContentLength((int)file.length());
		
		String fileName = null;
		fileName = URLEncoder.encode(file.getName(),"utf-8");
		
//		String userAgent = request.getHeader("User-Agent");
//		boolean ie = userAgent.indexOf("MSIE") > -1;
//		if(ie){
//			fileName = URLEncoder.encode(file.getName(),"utf-8");
//		}else{
//			fileName = URLEncoder.encode(file.getName(),"utf-8");//file.getName();//= new String(file.getName().getBytes("utf-8"));
//		}
		
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		OutputStream out  = response.getOutputStream();
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
			if(fis!=null)
				fis.close();
			}catch(Exception e){}
		}
		out.flush();
	}

}
