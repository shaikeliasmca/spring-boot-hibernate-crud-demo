package com.howtodoinjava.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.model.EmployeeEntity;
import com.howtodoinjava.demo.service.EmployeeService;
 
//@RestController
@Controller
@RequestMapping("/employees")
public class EmployeeController
{
    @Autowired
    EmployeeService service;
 
    @GetMapping
//    public ResponseEntity<List<EmployeeEntity>> getAllEmployees(Model model) {
    public String getAllEmployees(Model model) {
        List<EmployeeEntity> list = service.getAllEmployees();
 
        model.addAttribute("employees",list);
//        return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
        return "list-employees.html";
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        EmployeeEntity entity = service.getEmployeeById(id);
 
        return new ResponseEntity<EmployeeEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
//    @PostMapping
    @RequestMapping("/new")
//    public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(EmployeeEntity employee)
//                                                    throws RecordNotFoundException {
    public String createOrUpdateEmployee(Model model)
            throws RecordNotFoundException {
    	EmployeeEntity employee=new EmployeeEntity();
    	model.addAttribute("employee",employee);
//        EmployeeEntity updated = service.createOrUpdateEmployee(employee);
//        return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    	return "add-edit-employee.html";
    }
    @RequestMapping(value = "/createEmployee}",method = RequestMethod.POST)
    public String createEmployee(@ModelAttribute EmployeeEntity employeeEntity) throws RecordNotFoundException {
    	System.out.println("createEmployee"+employeeEntity.getFirstName());
        service.createOrUpdateEmployee(employeeEntity);
        return "redirect:/employees";
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deleteEmployeeById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}