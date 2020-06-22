package com.sangmin.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sangmin.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {
	List<Board>	findByTitle(String searchKeyword);
}
