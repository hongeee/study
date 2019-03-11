package com.ishong.webservice.domain.posts;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Posts 클래스와 PostsRepository 인터페이스 생성 후
 * 검증하기 위한 테스트 코드 작성
 * @author Inseok
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTests {

	@Autowired
	PostsRepository postsRepository;
	
	@After
	public void cleanUp() {
		/**
		 * 이후 테스트 코드에 영향을 끼치지 않기 위해
		 * 테스트 종료 시 Repository를 모두 비움
		 */
		postsRepository.deleteAll();
	}
	
	@Test
	public void savePostAndloadPost() {
		// given
		// 테스트 기반 환경 구축
		/**
		 * Builder를 사용하기 위해 코드 작성 중 에러 발생 시
		 * lombok 설치 여부 확인과 프로젝트에 lombok.jar 포함 여부 확인
		 * 의존성에 lombok 추가 외에 lombok.jar 설치 과정을 거쳐야 함
		 */
		postsRepository.save(Posts.builder()
				.title("타이틀")
				.content("컨텐츠")
				.author("홍길동")
				.build());
		
		// when
		// 테스트하고자 하는 행위 선언
		List<Posts> postsList = postsRepository.findAll();
		
		// then
		// 테스트 결과 검증
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle(), is("타이틀"));
		assertThat(posts.getContent(), is("컨텐츠"));
		assertThat(posts.getAuthor(), is("홍길동"));
	}
}
