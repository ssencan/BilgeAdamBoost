package com.bilgeadam.springrest.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bilgeadam.springrest.model.DersOgrenci;

@Repository
public class DersOgrenciRepository {
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List<DersOgrenci> getAll() {
		String sql = "select * from \"public\".\"DERS_OGRENCI\" order by \"ID\" asc";
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(DersOgrenci.class));
	}

	public DersOgrenci getByID(long id) {

		String sql = "select * from \"public\".\"DERS_OGRENCI\" where \"ID\" = :ID";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ID", id);
		return namedParameterJdbcTemplate.queryForObject(sql, paramMap,
				BeanPropertyRowMapper.newInstance(DersOgrenci.class));
	}

	public boolean deleteByID(long id) {

		String sql = "delete from \"public\".\"DERS_OGRENCI\" where \"ID\" = :ID";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ID", id);
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

	   public boolean save(DersOgrenci dersOgrenci)
	    {
	        String sql = "INSERT INTO \"public\".\"DERS_OGRENCI\"(\"DERS_ID\", \"OGRENCI_ID\", \"DEVAMSIZLIK\", \"NOTE\") VALUES (:DERSID, :OGRID, :DEVAMSIZLIK , :NOTE)";
	        Map<String,Object> paramMap = new HashMap<>();
	        paramMap.put("DERSID", dersOgrenci.getDERS_ID());
	        paramMap.put("OGRID", dersOgrenci.getOGR_ID());
	        paramMap.put("DEVAMSIZLIK", dersOgrenci.getDEVAMSIZLIK());
			paramMap.put("NOTE", dersOgrenci.getNOTE());
	        return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	    }

}
