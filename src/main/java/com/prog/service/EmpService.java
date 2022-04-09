package com.prog.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.entity.Employee;
import com.prog.repository.EmpRepo;
@Service
public class EmpService {
	@Autowired
	private EmpRepo repo;
	public void addEmp(Employee e)
	{
		repo.save(e);
	}
	public List<Employee> getAllEmp()
	{
		return repo.findAll();
	}
	public Employee getEpById(int id)
	{
		Optional<Employee> e=repo.findById(id);
		if(e.isPresent())
		{
			return e.get();
		}
		return null;
	}
	
	public void deleteEmpByID(int id)
	{
		repo.deleteById(id);
	}
}
