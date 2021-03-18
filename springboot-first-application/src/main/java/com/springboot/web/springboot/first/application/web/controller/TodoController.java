package com.springboot.web.springboot.first.application.web.controller;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.web.springboot.first.application.web.model.Todo;
import com.springboot.web.springboot.first.application.web.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	TodoService todoservice;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//Date - dd/MM/YYYY
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	} 
	
	@RequestMapping(value="/list-todos", method=RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		System.out.println("Here is the name" +model.get("name"));
		String name = (String) model.get("name");
		model.put("todos", todoservice.retrieveTodos(name));
		model.put("name", "chaitanya");
		return "list-todos";
	}
	
	@RequestMapping(value="/add-todo", method=RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		System.out.println("Entered add todo request mapping " +model.get("name"));
		model.addAttribute("todo", new Todo(0, (String)model.get("name"), "", new Date(), false));
		
		System.out.println("Here is the todo attribute "+model.getAttribute("todo"));
		System.out.println("Here is the todo attribute "+model.toString());
		return "add-todo";
	}
	
	/*
	 * @RequestMapping(value="/add-todo", method=RequestMethod.POST) public String
	 * addTodo(ModelMap model, @RequestParam String desc) {
	 * todoservice.addTodo((String) model.get("name"), desc, new Date(), false);
	 * String name = (String) model.get("name"); model.put("todos",
	 * todoservice.retrieveTodos(name)); return "redirect:/list-todos"; }
	 */
	@RequestMapping(value="/add-todo", method=RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "add-todo";
		}
		
		todoservice.addTodo((String) model.get("name"), todo.getDesc(), new Date(), false);
		System.out.println("Entered add todo mapping");
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/update-todo", method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		System.out.println("Entered add todo request mapping " +model.get("name") +"   " +id);
		Todo todo = todoservice.retrieveTodo(id);
		model.put("todo", todo);
		//model.addAttribute("todo", todo);
		System.out.println(todo.toString());
		return "add-todo";
	}
	
	@RequestMapping(value="/delete-todo", method=RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		todoservice.deleteTodo(id);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/update-todo", method=RequestMethod.POST)
	public String saveUpdatedTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "add-todo";
		}
		todo.setUser((String) model.get("name"));
		todoservice.updateTodoList(todo);
		return "redirect:/list-todos";
	}
}