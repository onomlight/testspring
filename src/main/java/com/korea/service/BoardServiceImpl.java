package com.korea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korea.domain.BoardVO;
import com.korea.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
@NoArgsConstructor
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
		//mapper.insertXML(board);
		mapper.insertSelectKeyXML(board);
		
	}

	@Override
	public BoardVO get(Long bno) {
		
		return mapper.readXML(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		int result = mapper.updateXML(board);
		if(result >1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean remove(Long bno) {
		int result = mapper.deleteXML(bno);
		if(result >1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<BoardVO> getList() {
		 
		return mapper.getList();
	}
}
