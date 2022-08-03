package com.korea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.korea.domain.BoardVO;

public interface BoardMapper {
	
	@Select("select * from tbl_board1 where bno>0")
	public List<BoardVO> getList() ;
	
	public List<BoardVO> getListXML();
	
	public void insertXML(BoardVO board);

	
	@Insert
	("insert into tbl_board1(bno,title,content,writer) values(seq_board.nextval, #{title},#{content},#{writer})")
	public void insert(BoardVO board);
	

	@SelectKey
	(
			statement="select seq_board.currval from dual",
			keyProperty="bno",
			before=false,
			resultType=long.class
	)
	@Insert
	("insert into tbl_board1(bno,title,content,writer) values(seq_board.nextval, #{title},#{content},#{writer})")
	public long insertSelectKey(BoardVO board);
	//Ãß°¡
	public long insertSelectKeyXML(BoardVO board);
	
	
	@Select("select * from tbl_board where bno=#{bno}")
	public BoardVO read(Long bno);
	
	public BoardVO readXML(Long bno);
}
