package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /*add mapping for "/list"*/
    @GetMapping("/list")
    public String listEmployees(Model model){
        /* get the employees form db */
        List<Employee> employees = employeeService.findAll();

        /* add to the spring model */
        model.addAttribute("employees",employees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        /* create model attribute to bind form data */
        Employee employee = new Employee();

        /* add to the spring model */
        model.addAttribute("employee",employee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model){
        /* get the employee from the service */
        Employee employee = employeeService.findById(id);

        /* set employee in the model to prepopulate the form */
        model.addAttribute("employee", employee);

        /* send over to our form */
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id, Model model){
        /* delete employee */
        employeeService.deleteById(id);

        /* redirect to the /employee/list */
        return "redirect:/employees/list ";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee employee){
        /* save the employee */
        employeeService.save(employee);
        /* use redirect to prevent duplicate submissions */
        return "redirect:/employees/list";
    }
}
