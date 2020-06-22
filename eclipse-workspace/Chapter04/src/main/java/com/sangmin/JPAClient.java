package com.sangmin;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.sangmin.domain.Board;

public class JPAClient {
	public static void main(String[] args) {
		//EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		//transaction 생성
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			Board board = new Board();
			board.setTitle("JPA 제목");
			board.setWriter("관리자");
			board.setContent("JPA 글 등록 잘 되네요");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
			em.persist(board);
			
			//transaction commit
			tx.commit();
			
			String jpql = "select b from Board b order by b.seq desc";
			List<Board> boardList = em.createQuery(jpql,Board.class).getResultList();
			for(Board brd : boardList) {
				System.out.println("--->"+ brd.toString());
			}
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
			emf.close();
		}
	}
}
