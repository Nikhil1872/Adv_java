package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String sayHello()
	{
		System.out.println("in controller");
		return "hello";
	}
	
	@RequestMapping("/info")
	public ModelAndView getInfo(HttpServletRequest request)
	{
		String msg="Welcome "+request.getParameter("name");
		return new ModelAndView("info", "msg", msg);
		
	}
	@RequestMapping("inforeq")
	public String getRequestInfo(HttpServletRequest req, ModelMap map )
	{
	
		
		System.out.println("in inforequestController");
		map.addAttribute("rang", req.getParameter("color"));
		map.addAttribute("name", req.getParameter("name"));
		
		return "inforeq";
		
	}
	
}
