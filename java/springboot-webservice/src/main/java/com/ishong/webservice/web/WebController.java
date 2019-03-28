package com.ishong.webservice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

/**
 * main.hbs 호출을 위한 Controller
 * @author Inseok
 *
 */
@Controller
@AllArgsConstructor
public class WebController {

	/*
	 * Spring 4.3부터 @RequestMapping 을 대체할 수 있는 매핑 어노테이션이 추가되어
	 * @GetMapping("/" 은 @RequestMapping(value="/", method = RequestMethod.GET) 와 같음
	 * handlebars-spring-boot-starter 사용으로 path와 파일 확장자는 자동 지정됨
	 * (prefix: src/main/resources/templates, suffix: .hbs)
	 */
	@GetMapping("/")
	public String main() {
		return "main";
	}
}
