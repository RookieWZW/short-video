package com.imooc.mapper;

import java.util.List;

import com.imooc.pojo.Comments;
import com.imooc.pojo.vo.CommentsVO;
import com.imooc.utils.MyMapper;

public interface CommentsMapperCustom extends MyMapper<Comments> {
	
	public List<CommentsVO> queryComments(String videoId);
}