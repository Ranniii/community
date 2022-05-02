package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello, Spring Boot.";
    }

    @Autowired
    AlphaService alphaService;

    @RequestMapping("/data")
    @ResponseBody
    public String getData() {
        return alphaService.find();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(req.getMethod());
        System.out.println(req.getServletPath());
        System.out.println(req.getProtocol());
        Enumeration<String> enumeration = req.getHeaderNames();
        while(enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            String value = req.getHeader(name);
            System.out.println(name+": "+value);
        }
        System.out.println(req.getParameter("code"));

        resp.setContentType("text/html;charset=utf-8");
        try(PrintWriter pw = resp.getWriter()) {
            pw.write("<h1>niukewang</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(name = "current", required = false, defaultValue = "1") int current,
            @RequestParam(name = "limit", required = false, defaultValue = "10") int limit
    ) {
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }

    @RequestMapping(path = "/students/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(
            @PathVariable("id") int id
    ) {
        System.out.println(id);
        return "a student";

    }

    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name, String age) {
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView getTeacher() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "hongmei");
        mav.addObject("age", "35");
        mav.setViewName("/demo/view");
        return  mav;

    }

    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getTeacher(Model model) {
        model.addAttribute("name","pku");
        model.addAttribute("age","100");
        return "/demo/view";
    }

    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> getEmp() {
        Map<String,String> m = new HashMap<>();
        m.put("name","zxr");
        m.put("age","24");
        m.put("salary","300000.00");
        return m;
    }
}
