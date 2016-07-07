package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Hoell on 07.07.2016.
 */
@Controller
@RequestMapping("child")
public class DummyController {

    @RequestMapping("")
    @ResponseBody
    public String index(){
        return "hello";
    }
}
