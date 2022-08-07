package com.korea.mapper;

import org.apache.ibatis.annotations.Param;

import com.korea.domain.ReplyVO;

public interface ReplyMapper {

	
	//등록
	public int insert(ReplyVO vo);
	
	//조회
	public ReplyVO read(Long rno);
	
	//수정
	public int update(ReplyVO reply);
	//삭제
	public int delete(int rno);
	
	// 페이징 처리
	
	public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bon") Long bno);// 14p 29번
	
}
