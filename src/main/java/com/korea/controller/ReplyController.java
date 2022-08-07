package com.korea.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/replies/")
@RestController
@Log4j
@AllArgsConstructor

public class ReplyController {
	
	private ReplyService service;
	
	@PostMapping(value="/new",consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	log.info("ReplyVO : " vo);
	int tisertCount = service.register(vo);
	log.info("Reply INSERT COUNT : " + insertCount);
		return insertCount ==1 ? new ResponseEntity<>("success",HttpStatus.OK)
				: new ResponeEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}
