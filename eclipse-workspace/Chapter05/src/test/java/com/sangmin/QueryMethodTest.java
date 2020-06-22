package com.sangmin;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sangmin.domain.Board;
import com.sangmin.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class QueryMethodTest {
	@Autowired
	private BoardRepository boardRepo;
	
	@Before
	public void dataPrepare() {
		for (int i = 1; i <=200 ; i++) {
			Board board = new Board();
			board.setTitle("테스트 제목 "+i);
			board.setWriter("테스터");
			board.setContent("테스트 내용 : "+ i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardRepo.save(board);
		}
		System.out.println("22222");
	}
	
	@Test
	public void testFindByTitle() {
		List<Board> boardList = boardRepo.findByTitle("테스트 제목 10");
		System.out.println("검색 결과");
		for(Board board : boardList) {
			System.out.println("--->"+board.toString());
		}
		
	}

}
