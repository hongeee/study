package com.ishong.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ishong.webservice.domain.posts.PostsRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {
	
	/**
	 * Spring에서 Bean을 주입받는 방식
	 * - @Autowired
	 * - Setter
	 * - 생성자
	 * 생성자로 주입받는 방식을 권장하며 Lombok @AllArgsConstructor를 사용하여 모든 필드를 인자값으로 받는 생성자 사용 가능
	 * 해당 클래스의 의존성 관계가 변경될때마다 생성자 코드를 수정하지 않아도 됨
	 */
	PostsRepository postsRepository;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello world.";
	}
	
	@PostMapping("/posts")
	public void savePosts(@RequestBody PostsSaveRequestDto dto) {
		postsRepository.save(dto.toEntity());
	}
}
