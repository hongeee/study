package com.ishong.webservice.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

/**
 * 모든 Entity 클래스의 상위 클래스가 되어 Entity들의 createDate, modifiedDate를 자동으로 관리하기 위한 역할
 * - @MappedSuperclass : JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들을 포함하여 컬럼으로 인식하도록 함
 * - @EntityListeners(AuditingEntityListener.class) : BaseTimeEntity 클래스에 Auditing 기능 포함
 * @author Inseok
 *
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
	
	// Entity가 생성되어 저장될 때 시간이 자동 저장
	@CreatedDate
	private LocalDateTime createDate;
	
	// 조회한 Entity의 값을 변경할 때 시간이 자동 저장
	@LastModifiedDate
	private LocalDateTime modifiedDate;
}
