package com.bilgeadam.springbootrest.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.bilgeadam.springbootrest.model.Ogrenci;
import com.bilgeadam.springbootrest.repository.OgrenciRepository;

@Service
public class OgrenciService {

	private OgrenciRepository ogrenciRepository;

	public OgrenciService(OgrenciRepository ogrenciRepository) {
		this.ogrenciRepository = ogrenciRepository;
	}

	public List<Ogrenci> getAllOgrenci() {
//		try {
			return ogrenciRepository.getAll();
//		} catch (Exception e) {
//			e.getMessage();
//			e.printStackTrace();
//			return null;
//		}
	}

	public boolean deleteByIDOgrenci(long id) {
//		try {
			return ogrenciRepository.deleteByID(id);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
	}

	public Ogrenci getByIDOgrenci(long id) {
//		try {
			return ogrenciRepository.getByID(id);
//		} catch (EmptyResultDataAccessException e) {
//			return null; // or handle as needed, e.g., throw a custom exception
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
	}

	public boolean saveOgrenci(Ogrenci ogr) {
//		try {
			return ogrenciRepository.save(ogr);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
	}

	public String print2() {
		return "Merhaba Dünya!";
	}
//	public List<Ogretmen> getAllLike(String name) {
//		String sql = "select * from \"public\".\"OGRETMEN\" where \"NAME\" LIKE :NAME";
//		Map<String, Object> paramMap = new HashMap<>();
//		paramMap.put("NAME", "%" + name + "%"); // % işareti parameter içersinde olacak
//		return namedParameterJdbcTemplate.query(sql, paramMap, BeanPropertyRowMapper.newInstance(Ogretmen.class));
//	}
}
