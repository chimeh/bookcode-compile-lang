package com.infiniteskills.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infiniteskills.mvc.data.entities.Project;

@Controller
public class HomeController {

	/*@Autowired
	private ProjectService service;
	public String goHomeAgain(Model model,@RequestParam("projectId") Long projectId){
		model.addAttribute("currentPorject",this.service.find(projectId));
		return "home";
	}*/
	
//	flash attributes replaced above redirect attribute
	@RequestMapping(value="/")
	public String goHomeAgain(Model model, @ModelAttribute("project") Project project){
		model.addAttribute("currentProject", project);
		return "home";
	}
	
	
	@RequestMapping("/home")
//	@ResponseBody
	public String goHome(){
		return "home";
	}
	
	
	
	/*@RequestMapping("/")
	public String goHome(Model model){
		
		Project project = new Project();
		project.setName("First Project");
//		project.setSponsor("Nasa");
		project.setDescription("This is a simple project sponsored by NASA");
		
		model.addAttribute("currentProject", project);
		
		return "welcome";
	}*/
}
