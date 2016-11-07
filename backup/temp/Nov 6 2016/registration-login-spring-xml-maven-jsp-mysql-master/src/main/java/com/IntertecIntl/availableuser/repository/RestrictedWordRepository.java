package com.IntertecIntl.availableuser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IntertecIntl.availableuser.model.RestrictedWord;

public interface RestrictedWordRepository  extends JpaRepository<RestrictedWord, Long> {
	RestrictedWord findByName(String name);

}
