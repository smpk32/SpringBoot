package com.sangmin.persistence;

import org.springframework.data.repository.CrudRepository;

import com.sangmin.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String> {

}
