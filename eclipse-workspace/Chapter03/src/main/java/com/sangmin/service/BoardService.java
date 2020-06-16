package com.sangmin.service;

import java.util.List;

import com.sangmin.BoardVO;

public interface BoardService {
	String hello(String name);
	BoardVO getboard();
	List<BoardVO> getBoardList();
}
