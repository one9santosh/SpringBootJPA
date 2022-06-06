package com.example.demo;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
@Autowired
	StudentDAO dao;
Logger log=Logger.getAnonymousLogger();
@RequestMapping("insert")
public ModelAndView insert(HttpServletRequest req,HttpServletResponse res) {
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	
	log.info("recieved name and email from front end");
	ModelAndView mv=new ModelAndView();
	log.info("model and view object created");
	Student s=new Student();
	log.info("pojo object created");
	s.setName(name);
	log.info("name is set to the pojo");
	s.setEmail(email);
	log.info("email is set to the pojo");
	Student sd=dao.insert(s);
	log.info("insert method called successfully");
	if(sd!=null) {
		log.info("sucessful student insertion");
		mv.setViewName("status.jsp");
	}
	
	return mv;
}
@RequestMapping("update")
public ModelAndView update(HttpServletRequest req,HttpServletResponse res) {
	String name=req.getParameter("name");
	String email=req.getParameter("email");
int sid=Integer.parseInt(req.getParameter("sid"));
	log.info("recieved name and email from front end");
	
	ModelAndView mv=new ModelAndView();
	log.info("model and view object created");
	Student ss=new Student();
	log.info("pojo object created");
	ss.setName(name);
	log.info("name is set to the pojo");
	ss.setEmail(email);
	log.info("email is set to the pojo");
	ss.setSid(sid);
	Student sd=dao.update(ss);
	log.info("update method called successfully");
	if(sd!=null) {
		log.info("sucessful student insertion");
		mv.setViewName("status.jsp");
	}
	
	return mv;
}
@RequestMapping("delete")
public ModelAndView delete(HttpServletRequest req,HttpServletResponse res) {
	int sid=Integer.parseInt(req.getParameter("sid"));	
	ModelAndView mv=new ModelAndView();
	Student s=new Student();
	s.setSid(sid);
	String sd=dao.deleteByid(sid);
	if(sd!=null) {
		log.info("sucessful student insertion");
		mv.setViewName("status.jsp");
	}
	return mv;
}

@RequestMapping("getall")
public ModelAndView getstudents(HttpServletRequest req,HttpServletResponse res) {
	log.info("in get all request");
	ModelAndView mv=new ModelAndView();
	log.info("created mv object");
	List<Student> list=dao.getall();
	log.info("called getall method");
	mv.setViewName("display.jsp");
	log.info("went to jsp");
	mv.addObject("list",list);
	log.info("sent a list to the jsp");
	return mv;
}


	
}
