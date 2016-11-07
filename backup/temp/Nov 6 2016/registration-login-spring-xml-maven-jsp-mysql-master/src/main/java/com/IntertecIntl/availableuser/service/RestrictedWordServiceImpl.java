package com.IntertecIntl.availableuser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IntertecIntl.availableuser.model.RestrictedWord;
import com.IntertecIntl.availableuser.repository.RestrictedWordRepository;


@Service
public class RestrictedWordServiceImpl implements RestrictedWordService {

	@Autowired
    private RestrictedWordRepository restrictedWordRepository;
	@Override
	public void save(RestrictedWord name) {
		restrictedWordRepository.save(name);
		
	}

	@Override
	public RestrictedWord findByName(String name) {
		
		return restrictedWordRepository.findByName(name);
	}

	@Override
	public List<RestrictedWord> findAll() {
		
		return restrictedWordRepository.findAll();
	}

}
