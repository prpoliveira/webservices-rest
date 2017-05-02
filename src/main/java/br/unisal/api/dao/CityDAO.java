package br.unisal.api.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Component;

import br.unisal.api.model.City;

@Component
@SuppressWarnings("unchecked")
public class CityDAO extends HibernateDAO<City> {

	public CityDAO() {
		super(City.class);
	}

	public City getCityById(Long id) {
		City city = null;
		city = super.get(id);
		return city;
	}

	public List<City> getCities() {
		List<City> cities = null;
		
		Query q = getSession().createQuery("select c from City c");
		cities = q.list();
			
		return cities;
	}

	public void salvar(City c) throws ConstraintViolationException{
		super.save(c);
	}
}
