package com.sangmin.persistence;

import org.springframework.data.repository.CrudRepository;

import com.sangmin.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {

}
