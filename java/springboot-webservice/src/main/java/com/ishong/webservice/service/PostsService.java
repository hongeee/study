package com.ishong.webservice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ishong.webservice.domain.posts.PostsRepository;
import com.ishong.webservice.web.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

/**
 * 트랜잭션 관리를 위한 Service 클래스
 * @author Inseok
 *
 */
@AllArgsConstructor
@Service
public class PostsService {

	private PostsRepository postsRepository;
	
	/*
	 * Controller에서 DTO의 toEntity()를 사용하지 않고 Service 클래스를 따로 두는 이유는
	 * Controller와 Service의 역할을 분리하기 위함
	 * - Service : 비즈니스 로직 & 트랜잭션 관리
	 * - Controller : View와 연동
	 * 
	 * @Transactional
	 * 메소드 내에서 Exception이 발생하면 해당 메소드에서 이루어진 모든 DB작업을 커밋하지 않음
	 * - 롤백하는 것이 아니라 커밋하지 않는 것에 유의
	 */
	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		return postsRepository.save(dto.toEntity()).getId();
	}
}
