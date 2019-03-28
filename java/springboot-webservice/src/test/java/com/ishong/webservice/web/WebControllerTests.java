package com.ishong.webservice.web;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 메인 페이지 테스트를 위한 코드
 * @author Inseok
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WebControllerTests {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void loadMainPage() {
		// when
		String body = restTemplate.getForObject("/", String.class);
		
		// then
		// HTML에 포함된 일부 문자만 비교하여 테스트
		assertThat(body).contains("스프링부트로 시작하는 웹 서비스");
	}
}
