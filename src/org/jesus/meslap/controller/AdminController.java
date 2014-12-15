package org.jesus.meslap.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jesus.meslap.annotation.AdminAuth;
import org.jesus.meslap.entity.User;
import org.jesus.meslap.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserService uService;
	
	
	@AdminAuth
	@RequestMapping(value="/list.do")
	public ModelAndView list(HttpServletRequest req,HttpServletResponse resp){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/list");
		return mav;
	}
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public ModelAndView loginView(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/login");
		return mav;
	}
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public ModelAndView loginLogic(HttpServletRequest request, @ModelAttribute("user") User user){
		ModelAndView mav = new ModelAndView();
		User userInDb = uService.get(user.getUserId());
		if(userInDb != null){
			if(userInDb.getPassword().equals(user.getPassword())){
				HttpSession session = request.getSession();
				session.setAttribute(User.USER_ATTR, user);
				String nowUri = (String) session.getAttribute("nowUri");
				if(nowUri==null)
					nowUri = "/admin/list.do";
				mav.setViewName("redirect:"+nowUri);
				return mav;
			}
		}
		mav.addObject("mesg","error-1");
		mav.setViewName("redirect:/admin/login.do");
		return mav;
	}
	
	@RequestMapping(value="/logout.do")
	public ModelAndView logoutLogic(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		session.invalidate();
		mav.setViewName("redirect:/admin/login.do");
		return mav;
	}
}
