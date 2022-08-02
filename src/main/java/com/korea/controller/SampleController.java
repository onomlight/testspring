package com.korea.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.korea.domain.SampleDTO;
import com.korea.domain.SampleDTOList;
import com.korea.domain.TodoDTO;
import com.korea.domain.TodoDTO2;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/sample/*") // 샘플을 기준으로 하위에있는 폴더들을 할수있도록함
public class SampleController {
	
	@RequestMapping(value="/test",method=RequestMethod.GET) // 여러형태메서들을 추가하면 확인가능함
	public void test1() 
	{
		log.info("URL : /test");
	}
	
	
	@GetMapping("/test2")
	public void test2()
	{
		log.info("URL : /test2");
	}
	
	@GetMapping("/test3")
	public void test3(SampleDTO dto)
	{
		log.info("dto's info : " + dto);
	}
	
	@GetMapping("/test4")
	public void test4(@RequestParam("name") String name, @RequestParam("age") Integer age) {
		log.info("URL : /test4");
		log.info("name :" + name + "age : " + age);
	}
	
	@GetMapping("test5") // 숫자는 인티저
	public void test5(@RequestParam("name") String[] list) {
		log.info("URL : /test5");
		for(String str : list) {
			System.out.println(str+ " ");
		}
	 
	
	}
	
	@GetMapping("/test6")
	public void test6(SampleDTOList list) {
		log.info("URL : / test6");
		for(SampleDTO dto : list.getList()) {
			//http://localhost:8080/sample/test6?list%5b0%5d.name="홍길동"&list%5b1%5d.age=55&list%5b2%5d.name="김상중"
			log.info(dto);
		}
	}
	
	//@InitBinder 를 이용해서 커스텀 데이터 타입 변환을 처리할 수 잇음
	// new CustomDateEditor(dataFormat,true) // true : 널값허용 , false 널값 불허용
	
//	@InitBinder
//	public void InitBinder(WebDataBinder binder) {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(df,false));
//	}
	//이컨트롤러 사용할때 특정한 날짜 코맷을 지정해서 사용가능함
	@GetMapping("/test7")
	public void test7(TodoDTO dto) {
		log.info("URL : /test7");
		log.info(dto);
	}
	
	@GetMapping("/test8")
	public void test8(TodoDTO2 dto) {
		log.info("URL : /test8");
		log.info(dto);
	}
}
