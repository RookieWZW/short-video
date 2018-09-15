package com.imooc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/center")
	public String center() {
		return "center";
	}

}
