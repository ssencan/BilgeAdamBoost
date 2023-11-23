package com.bilgeadam.springbootrest.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bilgeadam.springbootrest.model.Konu;

@Repository
public class KonuRepository {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedjdbcTemplate;

	public KonuRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedjdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.namedjdbcTemplate = namedjdbcTemplate;
	}

	public boolean save(Konu konu) {
		String sql = "INSERT INTO \"public\".\"KONU\"(\"NAME\") VALUES (:NAME)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("NAME", konu.getNAME());
		return namedjdbcTemplate.update(sql, paramMap) == 1;
	}

	public boolean deleteByID(long id) {

		String sql = "delete from \"public\".\"KONU\" where \"ID\" = :IdOlayı";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("IdOlayı", id);
		return namedjdbcTemplate.update(sql, paramMap) == 1;

	}

	public Konu getByID(long id) {
		String sql = "select * from \"public\".\"KONU\" where \"ID\" = :ID";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ID", id);
		return namedjdbcTemplate.queryForObject(sql, paramMap, BeanPropertyRowMapper.newInstance(Konu.class));
		// konu objesi oluşturup başta null verebilirsin sonra konuyu sorguya atıp returnde döndürürsün ama gerek yok çünkü return sorgu diyince yoksa zaten null oluyor.
	}

	public List<Konu> getAll() {
		//int k = 7/0;
		String sql = "select * from \"public\".\"KONU\" order by \"ID\" asc";
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Konu.class));

	}
}
