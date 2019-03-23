package com.ishong.webservice.web;

import com.ishong.webservice.domain.posts.Posts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Controller에서 사용할 DTO 클래스
 * 테이블과 매핑되는 Entity 클래스를 Request/Response 클래스로 사용하지 않는 것을 권장
 * Entity 클래스가 변경되면 여러 클래스에 영향을 끼치게 되는 반면 Request와 Response용 DTO는 View를 위한 클래스이기 때문에 잦은 변경이 필요 
 * View Layer와 DB Layer를 철저하게 역할 분리하는 것을 권장
 * @author Inseok
 *
 */
@Setter
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
	
	private String title;
	private String content;
	private String author;
	
	public Posts toEntity() {
		return Posts.builder()
				.title(title)
				.content(content)
				.author(author)
				.build();
	}
}
