package com.bilgeadam.springbootrest.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.bilgeadam.springbootrest.model.Ders;
import com.bilgeadam.springbootrest.model.DersDTO;
import com.bilgeadam.springbootrest.repository.DersRepository;

@Service
public class DersService {

	private DersRepository dersRepository;

	public DersService(DersRepository dersRepository) {
		this.dersRepository = dersRepository;
	}

	public List<Ders> getAllDers() {
		try {
			return dersRepository.getAll();
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			return null;
		}
	}

	public List<DersDTO> getAllDersDto() {
		try {
			return dersRepository.getAllDTO();
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			return null;
		}
	}

	public boolean deleteByIDDers(long id) {
		try {
			return dersRepository.deleteByID(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Ders getByIDDers(long id) {
		try {
			return dersRepository.getByID(id);
		} catch (EmptyResultDataAccessException e) {
			return null; // or handle as needed, e.g., throw a custom exception
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public DersDTO getByIDDersDto(long id) {
		try {
			return dersRepository.getByIDDTO(id);
		} catch (EmptyResultDataAccessException e) {
			return null; // or handle as needed, e.g., throw a custom exception
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean saveDers(Ders ders) {
		try {
			return dersRepository.save(ders);
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
