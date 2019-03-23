package com.ishong.webservice.domain.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.ishong.webservice.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * NoArgsConstructor : 기본 생성자 자동 추가
 * - access = AccessLevel.PROTECTED : 기본 생성자의 접근 권한을 protected로 제한
 * - Entity 클래스를 프로젝트 코드상에서 기본생성자로 생성하는 것은 막되, JPA에서 Entity 클래스를 생성하는것은 허용하기 위해 추가
 * Getter : 클래스 내 모든 필드의 Getter 메소드 자동 생성
 * Entity : 테이블과 링크될 클래스
 * - 언더스코어 네이밍(_)으로 이름을 매칭(ex. PostsManager.java -> post_manager table)
 
 * 
 * @author Inseok
 *
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Posts extends BaseTimeEntity {
	
	/**
	 * Id : 해당 테이블의 PK 필드
	 * GeneratedValue : PK의 생성 규칙으로 기본값은 Auto increment
	 */
	@Id
	@GeneratedValue
	private Long id;
	
	/**
	 * Column : 테이블 컬럼, 선언하지 않을 경우 모든 필드는 컬럼
	 * 기본값 외에 추가로 변경이 필요한 옵션을 선언하기 위해 사용(문자열의 경우 기본값 VARCHAR(255) -> length = 500)
	 */
	@Column(length = 500, nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
	
	private String author;

	/**
	 * Entity class
	 * 실제 DB 테이블과 매칭될 클래스
	 * Builder : 해당 클래스의 빌더패턴 클래스를 생성
	 * - 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
	 * @param title
	 * @param content
	 * @param author
	 */
	@Builder
	public Posts(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
}
