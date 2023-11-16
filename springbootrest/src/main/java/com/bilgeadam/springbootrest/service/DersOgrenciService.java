package com.bilgeadam.springbootrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.bilgeadam.springbootrest.model.DersOgrenci;
import com.bilgeadam.springbootrest.model.DersOgrenciDTO;
import com.bilgeadam.springbootrest.repository.DersOgrenciRepository;

@Service
public class DersOgrenciService {

	@Autowired
	private DersOgrenciRepository dersOgrenciRepository;


	public List<DersOgrenci> getAllDersOgrenci() {
		try {
			return dersOgrenciRepository.getAll();
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			return null;
		}
	}

	public List<DersOgrenciDTO> getAllDersOgrenciDto() {
		try {
			return dersOgrenciRepository.getAllDTO();
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			return null;
		}
	}

	public boolean deleteByIDDersOgrenci(long id) {
		try {
			return dersOgrenciRepository.deleteByID(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public DersOgrenci getByIDDersOgrenci(long id) {
		try {
			return dersOgrenciRepository.getByID(id);
		} catch (EmptyResultDataAccessException e) {
			return null; // or handle as needed, e.g., throw a custom exception
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public DersOgrenciDTO getByIDDersOgrenciDto(long id) {
		try {
			return dersOgrenciRepository.getByIDDTO(id);
		} catch (EmptyResultDataAccessException e) {
			return null; // or handle as needed, e.g., throw a custom exception
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean saveDersOgrenci(DersOgrenci dersogr) {
		try {
			return dersOgrenciRepository.save(dersogr);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
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
