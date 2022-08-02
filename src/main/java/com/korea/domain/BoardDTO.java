package com.korea.domain;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
//위에는 getter setter 한번에하는거
@NoArgsConstructor
//디폴트 생성자 확인하기
@AllArgsConstructor
//모든 생성자 호출 
@Component
@Builder
public class BoardDTO {
	private int no;
	private String title;
	private String content;
	private String writer;
	private String regdate;
	private String pwd;
	private int count;
	private String ip;
	private String filename;
	private String filesize;
}
