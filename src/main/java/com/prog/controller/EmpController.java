package com.prog.controller;

import java.util.*;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prog.entity.Employee;
import com.prog.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	private EmpService service;
	@GetMapping("/")
	public String home(Model m)
	{
		List<Employee> emp=service.getAllEmp();
		m.addAttribute("emp",emp);
		return "index";
	}
	@GetMapping("/addemp")
	public String addEmpForm()
	{
		return "add_emp.html";
	}
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,HttpSession session)
	{
		session.setAttribute("msg", "Employee details added sucessfully");
		System.out.println(e);
		service.addEmp(e);
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m)
	{
		Employee e=service.getEpById(id);
		m.addAttribute("emp",e);
		return "edit.html";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute Employee e,HttpSession session)
	{
		session.setAttribute("msg", "Employee details updated sucessfully");
		System.out.println(e);
		service.addEmp(e);
		return "redirect:/";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,HttpSession session)
	{
		service.deleteEmpByID(id);
		session.setAttribute("msg", "Employee details deleted sucessfully");
		return "redirect:/";
	}
}

