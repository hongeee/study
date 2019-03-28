package com.ishong.webservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ishong.webservice.domain.posts.Posts;
import com.ishong.webservice.domain.posts.PostsRepository;
import com.ishong.webservice.web.PostsSaveRequestDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

	@Autowired
	private PostsService postsService;
	
	@Autowired
	private PostsRepository postsRepository;
	
	@After
	public void cleanUp() {
		postsRepository.deleteAll();
	}
	
	@Test
	public void saveDtoToPosts() {
		// given
		PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
				.title("테스트 타이틀")
				.content("테스트")
				.author("테스터")
				.build();
		
		// when
		postsService.save(dto);
		
		// then
		Posts posts = postsRepository.findAll().get(0);
		assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
	}
}
