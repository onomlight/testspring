package com.korea.controller;

 

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.korea.domain.BoardDTO;
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
	@GetMapping("/test9")
	public void test9(SampleDTO dto,Model model) {
		log.info("URL : /test9...");
		log.info("dto : " + dto);
		
		model.addAttribute("dto",dto);
	}
	
	
	
	@GetMapping("/test10")
	public String test10() { //내가원하는 위치에 넣고싶다고하면 반환형을 스트링으로 요청
		log.info("URL : /test10...");
		
		return "/test10";
	}
	
	
	@GetMapping("/forward")
	public String Forward(SampleDTO dto,Model model) {
		log.info("URL : /forward...");
		
		model.addAttribute("dto",dto);
		
		return "forward:result";
	}
	
	@GetMapping("/redirect") //리퀘스트를 담았더라도 내용전달이안됨 리다이렉트쓸대는 밑에 내용으로 사용해야함 
	public String redirect(SampleDTO dto,RedirectAttributes rttr) {
		log.info("URL : /redirect...");
		
		//model.addAttribute("dto",dto);
		rttr.addFlashAttribute("dto",dto);
		
		return "redirect:result";
	}
	@GetMapping("/result")
	public void result(Model model) {
		
		log.info("URL : /result...");
		BoardDTO dto= new BoardDTO().builder()
				.no(1010)
				.content("내용내용")
				.writer("작성자~")
				.build();
		model.addAttribute("board",dto);
		
	}
	
	
	@GetMapping("/objectTest")
	public @ResponseBody SampleDTO ObjectTest() {
		SampleDTO dto = new SampleDTO();
		dto.setName("길동스");
		dto.setAge(22);
		
		return dto;
	}
	
	
	@GetMapping("/objectTest2")
	public ResponseEntity<String> ObjectTest2() {
		SampleDTO dto = new SampleDTO();
		dto.setName("길동스");
		dto.setAge(22);
		
		HttpHeaders header = new HttpHeaders();
		header.add("content-Type","application/xml;charset=utf-8");
		
		return new ResponseEntity<String>(dto.toString(),header,HttpStatus.OK);
	}
	
//	
//	@GetMapping("/test12")
//	public void test12() {
//		
//	}
}
