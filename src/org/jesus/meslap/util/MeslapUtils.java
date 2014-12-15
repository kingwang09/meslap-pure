package org.jesus.meslap.util;

import javax.servlet.http.HttpServletRequest;

public class MeslapUtils {
	
	public String getPath(HttpServletRequest request, String folderName){
		String path = request.getSession().getServletContext().getRealPath("/"+folderName);
		return path;
	}
}
