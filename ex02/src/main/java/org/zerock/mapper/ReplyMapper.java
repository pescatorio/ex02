package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.ReplyVo;

public interface ReplyMapper {
	
	public int insert(ReplyVo vo);
	public int update(ReplyVo vo);
	public int delete(int rno);
	public ReplyVo get(int rno);
	public List<ReplyVo> getList(int bno);
}
