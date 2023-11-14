package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    /*new controller method to show initial HTML form*/
    @GetMapping("/showForm")
    public String showForm(){
        return "hello-world-form";
    }

    /*new controller method to process the HTML form*/
                    /*match the html action*/
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloWorld";
    }

    /*need a controller method to read form data and add data to the model*/

    @RequestMapping("/toUpperCase")
    public String nameToUpperCase(HttpServletRequest request, Model model){
        /*read the request parameter from the HTML form */
        String name = request.getParameter("student_name");
        /*convert the data to all caps */
        /*create the message */
        String result = "Yo! " + name.toUpperCase();
        /*add message to the model */
        model.addAttribute("message", result);
        return "helloWorld";

    }

    @PostMapping("/toUpperCaseBinding")
    public String nameToUpperCaseBinding(@RequestParam("student_name") String studentName, Model model){
        /*read the request parameter from the HTML form */
        //String name = request.getParameter("student_name");
        /*convert the data to all caps */
        /*create the message */
        String result = "Hey! " + studentName.toUpperCase();
        /*add message to the model */
        model.addAttribute("message", result);
        return "helloWorld";

    }
}
