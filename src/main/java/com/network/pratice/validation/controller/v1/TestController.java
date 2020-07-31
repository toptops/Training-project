package com.network.pratice.validation.controller.v1;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.network.pratice.validation.dto.Request;

@RestController
public class TestController {
	
	@GetMapping("/hello")
	public String hello(@Valid Request data) throws Exception{
		return "hello";
	}
}
