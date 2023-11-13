package com.bilgeadam.springbootrest.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bilgeadam.springbootrest.model.Ogrenci;

@Repository
public class OgrenciRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List<Ogrenci> getAll() {
		String sql = "select * from \"public\".\"OGRENCI\" order by \"ID\" asc";
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Ogrenci.class));
	}

	public Ogrenci getByID(long id) {
		String sql = "select * from \"public\".\"OGRENCI\" where \"ID\" = :ID";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ID", id);
		return namedParameterJdbcTemplate.queryForObject(sql, paramMap,
				BeanPropertyRowMapper.newInstance(Ogrenci.class));
	}

	public boolean deleteByID(long id) {
		String sql = "delete from \"public\".\"OGRENCI\" where \"ID\" = :ID";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ID", id);
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

	public boolean save(Ogrenci ogrn) {
		String sql = "INSERT INTO \"public\".\"OGRENCI\"(\"NAME\", \"OGR_NUMBER\",\"YEAR\") VALUES (:NAME, :OGRNumber, :Year)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("NAME", ogrn.getNAME());
		paramMap.put("OGRNumber", ogrn.getOGR_NUMBER());
		paramMap.put("Year", ogrn.getYEAR());
		return namedParameterJdbcTemplate.update(sql,paramMap) == 1 ;
	}

}
