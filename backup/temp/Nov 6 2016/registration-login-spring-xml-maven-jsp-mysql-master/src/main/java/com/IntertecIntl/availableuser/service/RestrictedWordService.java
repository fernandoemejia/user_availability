package com.IntertecIntl.availableuser.service;

import java.util.List;

import com.IntertecIntl.availableuser.model.RestrictedWord;

public interface RestrictedWordService {
	void save(RestrictedWord name);

	RestrictedWord findByName(String name);
	List<RestrictedWord> findAll();
	
}
