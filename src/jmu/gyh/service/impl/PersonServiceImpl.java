package jmu.gyh.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jmu.gyh.mapper.PersonMapper;
import jmu.gyh.po.Person;
import jmu.gyh.service.PersonService;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	@Resource(name = "personMapper")
	private PersonMapper personMapper;

	@Override
	public Person findPerByPersonId(String personId) {
		return this.personMapper.findPerByPersonId(personId);
	}

}
