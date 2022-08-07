package com.korea.mapper;

import org.apache.ibatis.annotations.Param;

import com.korea.domain.ReplyVO;

public interface ReplyMapper {

	
	//���
	public int insert(ReplyVO vo);
	
	//��ȸ
	public ReplyVO read(Long rno);
	
	//����
	public int update(ReplyVO reply);
	//����
	public int delete(int rno);
	
	// ����¡ ó��
	
	public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bon") Long bno);// 14p 29��
	
}
