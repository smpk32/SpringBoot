package com.sangmin;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.sangmin.domain.Board;
import com.sangmin.domain.Member;
import com.sangmin.persistence.BoardRepository;
import com.sangmin.persistence.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class QueryMethodTest {
	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private MemberRepository memberRepo;
//	@Before
//	public void dataPrepare() {
//		for (int i = 1; i <=200 ; i++) {
//			Board board = new Board();
//			board.setTitle("테스트 제목 "+i);
//			board.setWriter("테스터");
//			board.setContent("테스트 내용 : "+ i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			boardRepo.save(board);
//		}
//		System.out.println("22222");
//	}
//	
//	@Test
//	public void testFindByTitle() {
//		List<Board> boardList = boardRepo.findByTitle("테스트 제목 10");
//		System.out.println("검색 결과");
//		for(Board board : boardList) {
//			System.out.println("--->"+board.toString());
//		}
//		
//	}
	
//	@Test
//	public void testByContentContaning() {
//		List<Board> boardList = boardRepo.findByTitleContaining("1");
//		
//		System.out.println("검색결과");
//		for(Board board : boardList) {
//			System.out.println("--->"+board.toString());
//		}
//	}
	
//	@Test
//	public void testFindByTitleContainingOrContentContaining() {
//		List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("17", "17");
//		
//		System.out.println("검색결과");
//		for(Board board : boardList) {
//			System.out.println("--->"+board.toString());
//		}
//	}
	
//	@Test
//	public void testFindByTitleContainingOrderBySeqDesc() {
//		List<Board> boardList = boardRepo.findByTitleContainingOrderBySeqDesc("17");
//		
//		System.out.println("검색결과");
//		for(Board board:boardList) {
//			System.out.println("--->"+board.toString());
//		}
//	}
//	@Test
//	public void testFindByTitleContaining() {
//		Pageable paging = PageRequest.of(0, 5,Sort.Direction.DESC,"seq");
//		Page<Board> pageInfo = boardRepo.findByTitleContaining("제목", paging);
//		
//		System.out.println("PAGE SIZE : "+pageInfo.getSize());
//		System.out.println("TOTAL PAGES : "+pageInfo.getTotalPages());
//		System.out.println("TOTAL COUNT : "+pageInfo.getTotalElements());
//		System.out.println("NEXT : "+pageInfo.nextPageable());
//		
//		List<Board> boardList = pageInfo.getContent();
//		System.out.println("검색결과");
//		for(Board board:boardList) {
//			System.out.println("--->"+board.toString());
//		}
//	}
	@Test
	public void testManyToOneInsert() {
		Member member1 = new Member();
		member1.setId("member1");
		member1.setPassword("member111");
		member1.setName("둘리");
		member1.setRole("User");
		//memberRepo.save(member1);
		
		Member member2 = new Member();
		member2.setId("member2");
		member2.setPassword("member222");
		member2.setName("도우너");
		member2.setRole("Admin");
		//memberRepo.save(member2);
		
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setMember(member1);
			board.setTitle("둘리가 등록한 게시글 "+i);
			board.setContent("둘리가 등록한 게시글 내용 "+i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			//boardRepo.save(board);
		}
		memberRepo.save(member1);
		
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setMember(member2);
			board.setTitle("도우너가 등록한 게시글 "+i);
			board.setContent("도우너가 등록한 게시글 내용 "+i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			//boardRepo.save(board);
		}
		memberRepo.save(member2);
	}
	

}
