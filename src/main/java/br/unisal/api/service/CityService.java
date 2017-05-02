package br.unisal.api.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.unisal.api.dao.CityDAO;
import br.unisal.api.model.City;

@Component
public class CityService {
	
	@Autowired
	private CityDAO db;

	public List<City> getCities() {
		return db.getCities();
	}

	public City getCityById(Long id) {
		return db.getCityById(id);
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean save(City city) throws ConstraintViolationException{
		db.saveOrUpdate(city);
		return true;
	}
	
	@Transactional(rollbackFor = Exception.class)
    public boolean update(City city) throws ConstraintViolationException {
        db.update(city);
        return true;
    }

}
