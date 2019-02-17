package com.infiniteskills.mvc.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.infiniteskills.mvc.data.entities.Project;
import com.infiniteskills.mvc.data.services.ProjectService;
import com.infiniteskills.mvc.data.validators.ProjectValidator;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value="find/{projectId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Project findProjectObject(Model model,@PathVariable("projectId")Long projectId)
	{
		return this.projectService.find(projectId);
	}
	
	
	@RequestMapping(value="/{projectId}")
	public String findProject(Model model,@PathVariable("projectId") Long projectId)
	{
		model.addAttribute("project", this.projectService.find(projectId));
		return "project";
	}
	
	
	
	@RequestMapping(value="/find",method=RequestMethod.GET)
	public String find(Model model){
		model.addAttribute("projects", this.projectService.findAll());
		return "projects";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
//	public String addProject(HttpSession session){
	public String addProject(Model model){
//		session.setAttribute("token", "12345");
//		System.out.println("invoking addProject");
		model.addAttribute("types", new ArrayList<String>(){{
			add("");
			add("Single Year");
			add("Multi Year");
		}});
		model.addAttribute("project", new Project());
		return "project_add";
	}

/*	@RequestMapping(value="/add", method=RequestMethod.POST)
//	public String saveProject(HttpServletRequest request,HttpSession session){
//	public String saveProject(@RequestParam("name") String name,HttpSession session){
//	public String saveProject(@RequestParam("name") Long name,HttpSession session){
	public String saveProject(@Valid @ModelAttribute Project project){

//		System.out.println(session.getAttribute("token"));
//		System.out.println(request.getParameter("name"));
//		System.out.println(name);
		System.out.println("invoking saveProject");
		System.out.println(project);
		return "project_add";
	}*/
	/*@RequestMapping(value="/add", method=RequestMethod.POST)
	public String saveProject(@Valid @ModelAttribute Project project, Errors errors,RedirectAttributes attributes){
		
		if(!errors.hasErrors()){
			System.out.println("The project validated.");
		}else{
			System.out.println("the project did not validate");
		}
		project.setProjectId(55L);
		this.projectService.save(project);
		System.out.println(project);
	attributes.addAttribute("projectId", project.getProjectId().toString());
		//		return "project_add";
//		return "redirect:/project/find";
		return "redirect:/";
	}
	*/
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveProject(@Valid @ModelAttribute Project project,
			Errors errors, RedirectAttributes attributes) {
		project.setProjectId(55L);
		this.projectService.save(project);
		attributes.addFlashAttribute("project", project);
		return "redirect:/";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.setValidator(new ProjectValidator());
	}
	
	/*@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new ProjectValidator());
	}*/
	
	

/*	@RequestMapping(value="/add", method=RequestMethod.POST, params={"type=multi"})
	public String saveMultiYearProject(){
		System.out.println("invoking saveMultiYearProject");
		return "project_add";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST, params={"type=multi","special"})
	public String saveSpecialProject(){
		System.out.println("invoking saveSpecialProject");
		return "project_add";
	}*/
}
