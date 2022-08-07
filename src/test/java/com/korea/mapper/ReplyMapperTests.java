package com.korea.mapper;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.korea.domain.ReplyVO;
import com.sun.tools.javac.util.List;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class ReplyMapperTests {
	
	@Autowired
	private ReplyMapper mapper;
	@Test
	public void testMapper() {
		log.info(mapper);
	}
	
	@Test
	public void InserTest() {
		ReplyVO vo= new ReplyVO();
		vo.setBno(110L);
		vo.setReply("´ñ±ÛÅ×½ºÆ®");
		vo.setReplyer("wirter1");
		mapper.insert(vo);
	}
	
	@Test
	
	public void ReadTest() {
		ReplyVO vo = mapper.read(1L);
		
		log.info("read : " + vo);
	}
	
	@Test
	public void UpdateTest() {
		ReplyVO vo = mapper.read(1L);
		vo.setReply("UpdateTest");
		int count = mapper.update(vo);
		log.info("UPDATE COUNT : " + count);
	}
	
	@Test
	public void DeleteTest() {
		mapper.delete(1);
	}
	
	@Test
	public void getListPage() {
		ReplyVO cri = new Criteria();
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 112L);
		replies.forEach(repyl -> log.info(reply));
	}

}
