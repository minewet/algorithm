package com.cos.book.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity // 서버 실행시에 테이블이 h2에 생성됨.
public class Book {
	@Id // PK를 해당 변수로 하겠다는 뜻.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 해당 데이터베이스 번호증가 전략을 따라가겠다.
	private Long id;  //상품번호
	
	private String title; //제목
	private String author;  //진행자
	private String category;  //분야
	private String info;  //상세정보
	private String startDate;  //공구시작일
	private String endDate;  //공구종료일
	private String payDate;  //수요조사참여자결제마감일
	private String bank; //입금은행
	private String account; //계좌번호
	
}
