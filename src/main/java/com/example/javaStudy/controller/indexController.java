package com.example.javaStudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class indexController {

    @GetMapping("hello")
    public String Hello(Model model){
        model.addAttribute("data","hi~");
        return "hello";
    }

    @GetMapping("example01")
    public String example01(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "example01";
    }

    @GetMapping("example02")
    @ResponseBody
    public ClassExample example02(@RequestParam("name") String name) {
        ClassExample classExample = new ClassExample();
        classExample.setName(name);
        return classExample;
    }

    public class ClassExample{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
