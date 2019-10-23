package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
	@Autowired
	DBService dbService;
	
	@GetMapping("/")
	public String main() {
		return "search";
	}
	
	@PostMapping("/search")
	@ResponseBody
	public Human search(@RequestBody SearchCondition sCondition) throws Exception {
		System.out.println("sCondition : " + sCondition);
		return dbService.getHuman(sCondition.getKeyword());
	}
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello World";
	}
	
	@GetMapping("/getNow")
	@ResponseBody
	public String now() throws Exception {
		return dbService.getDual();
	}
	
	@GetMapping("/getHuman/{name}")
	@ResponseBody
	public String human(@PathVariable String name) throws Exception {
		return dbService.getHuman(name).toString();
	}
}
