package com.bilgeadam.springbootrest.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bilgeadam.springbootrest.model.Konu;
import com.bilgeadam.springbootrest.repository.KonuRepository;

@Service
public class KonuService {

	private KonuRepository konuRepository;

	public KonuService(KonuRepository konuRepository) {
		this.konuRepository = konuRepository;
	}

	public List<Konu> getAllKonu() {
//		try {
			return konuRepository.getAll();
//		} catch (Exception e) {
//			e.getMessage();
//			e.printStackTrace();
//			return null;
//		}
	}

	public boolean deleteByIDKonu(long id) {
//		try {
			return konuRepository.deleteByID(id);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
	}


	public Konu getByIDKonu(long id) {
//		try {
			return konuRepository.getByID(id);
//		} catch (EmptyResultDataAccessException e) {
//			System.out.println("Kayıt bulunamadı");
//			e.getMessage();
//			return null;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
	}

	public boolean saveKonu(Konu konu) {
//		try {
			return konuRepository.save(konu);
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
