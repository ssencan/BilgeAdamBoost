package com.bilgeadam.springbootrest.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.bilgeadam.springbootrest.model.Ogretmen;
import com.bilgeadam.springbootrest.repository.OgretmenRepository;

@Service
public class OgretmenService {

	private OgretmenRepository ogretmenRepository;

	public OgretmenService(OgretmenRepository ogretmenRepository) {
		this.ogretmenRepository = ogretmenRepository;
	}

	public List<Ogretmen> getAllOgretmen() {
//		try {
			return ogretmenRepository.getAll();
//		} catch (Exception e) {
//			e.getMessage();
//			e.printStackTrace();
//			return null;
//		}
	}
	

	public boolean deleteByIDOgretmen(long id) {
//		try {
			return ogretmenRepository.deleteByID(id);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
	}

	public Ogretmen getByIDOgretmen(long id) {
//		try {
			return ogretmenRepository.getByID(id);
//		} catch (EmptyResultDataAccessException e) {
//			return null; // or handle as needed, e.g., throw a custom exception
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
	}

	public boolean saveOgretmen(Ogretmen ogr) {
//		try {
			return ogretmenRepository.save(ogr);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
	}
	
	 public String print() {
	        return "Merhaba Dünya!";
	    }
//	public List<Ogretmen> getAllLike(String name) {
//		String sql = "select * from \"public\".\"OGRETMEN\" where \"NAME\" LIKE :NAME";
//		Map<String, Object> paramMap = new HashMap<>();
//		paramMap.put("NAME", "%" + name + "%"); // % işareti parameter içersinde olacak
//		return namedParameterJdbcTemplate.query(sql, paramMap, BeanPropertyRowMapper.newInstance(Ogretmen.class));
//	}
}
