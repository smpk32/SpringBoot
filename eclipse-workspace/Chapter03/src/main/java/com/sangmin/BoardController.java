package com.sangmin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sangmin.service.BoardService;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/hello")
	public String hello(String name) {
		return boardService.hello(name);
	}
	
	 @GetMapping("/getBoard")
	 public BoardVO getBoard() {
		 return boardService.getboard();
	 }
	 
	 @GetMapping("/getBoardList")
	 public List<BoardVO> getBoardVOList(){
		 return boardService.getBoardList();
	 }
}
