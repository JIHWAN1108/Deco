package com.deco.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionDto {	//로그인한 유저 요약 정보 Users 테이블 참조ㄴ
	private int idx;
	private String name;
	private String nickname;
	private String email;
	private String addr;
	private int age;
}
