package com.korea.service;

import java.util.List;

import com.korea.domain.ReplyVO;

public interface ReplyService {
	//���
	public int register(ReplyVO vo);
	//��ȸ
	public ReplyVO get(Long rno);
	//����
	public int modify(ReplyVO vo);
	//����
	public int remove(Long rno);
	//����¡
	public List<ReplyVO> getList(Criteria cri, Long bno);
	
}
