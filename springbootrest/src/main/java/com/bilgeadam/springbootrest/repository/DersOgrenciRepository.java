package com.bilgeadam.springbootrest.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bilgeadam.springbootrest.model.Ders;
import com.bilgeadam.springbootrest.model.DersOgrenci;
import com.bilgeadam.springbootrest.model.DersOgrenciDTO;
import com.bilgeadam.springbootrest.model.Ogrenci;

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
		//localhost:8080/dersogrenci/getall
		String sql = "select * from \"public\".\"DERS_OGRENCI\" order by \"ID\" asc";
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(DersOgrenci.class));
	}

	public List<DersOgrenciDTO> getAllDTO() {
		//localhost:8080/dersogrenci/getall

		String sql = "select \"DERS_OGRENCI\".\"ID\",\"DERS_OGRENCI\".\"DEVAMSIZLIK\",\"DERS_OGRENCI\".\"NOTE\",\"DERS_OGRENCI\".\"OGRENCI_ID\",\"DERS_OGRENCI\".\"DERS_ID\",\"DERS\".\"KONU_ID\",\"DERS\".\"OGRETMEN_ID\",\"OGRENCI\".\"ID\", \"OGRENCI\".\"NAME\",\"OGRENCI\".\"OGR_NUMBER\",\"OGRENCI\".\"YEAR\" from \"DERS_OGRENCI\" inner join \"OGRENCI\" ON \"OGRENCI\".\"ID\" = \"DERS_OGRENCI\".\"OGRENCI_ID\" inner join \"DERS\" ON \"DERS\".\"ID\" = \"DERS_OGRENCI\".\"DERS_ID\"";
		RowMapper<DersOgrenciDTO> rowMapper = new RowMapper<DersOgrenciDTO>() {
			
			@Override
			public DersOgrenciDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

				DersOgrenciDTO dersogrDto = new DersOgrenciDTO();

				DersOgrenci dersogr = new DersOgrenci();
				dersogr.setID(rs.getLong("ID"));
				dersogr.setDERS_ID(rs.getLong("DERS_ID"));
				dersogr.setOGRENCI_ID(rs.getLong("OGRENCI_ID"));
				dersogr.setDEVAMSIZLIK(rs.getInt("DEVAMSIZLIK"));
				dersogr.setNOTE(rs.getInt("NOTE"));

				Ders ders = new Ders();
				ders.setID(rs.getLong("ID"));
				ders.setKONU_ID(rs.getLong("KONU_ID"));
				ders.setOGRETMEN_ID(rs.getLong("OGRETMEN_ID"));

				Ogrenci ogrenci = new Ogrenci();
				ogrenci.setID(rs.getLong("ID"));
				ogrenci.setNAME(rs.getString("NAME"));
				ogrenci.setOGR_NUMBER(rs.getLong("OGR_NUMBER"));
				ogrenci.setYEAR(rs.getLong("YEAR"));

				dersogrDto.setDersogr(dersogr);
				dersogrDto.setDers(ders);
				dersogrDto.setOgrenci(ogrenci);
				
				return dersogrDto;
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}

	public DersOgrenci getByID(long id) {

		String sql = "select * from \"public\".\"DERS_OGRENCI\" where \"ID\" = :ID";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ID", id);
		return namedParameterJdbcTemplate.queryForObject(sql, paramMap,
				BeanPropertyRowMapper.newInstance(DersOgrenci.class));
	}
	
	public DersOgrenciDTO getByIDDTO(long id) {

		String sql = "select \"DERS_OGRENCI\".\"ID\",\"DERS_OGRENCI\".\"DEVAMSIZLIK\",\"DERS_OGRENCI\".\"NOTE\",\"DERS_OGRENCI\".\"OGRENCI_ID\",\"DERS_OGRENCI\".\"DERS_ID\",\"DERS\".\"KONU_ID\",\"DERS\".\"OGRETMEN_ID\",\"OGRENCI\".\"ID\", \"OGRENCI\".\"NAME\",\"OGRENCI\".\"OGR_NUMBER\",\"OGRENCI\".\"YEAR\" from \"DERS_OGRENCI\" inner join \"OGRENCI\" ON \"OGRENCI\".\"ID\" = \"DERS_OGRENCI\".\"OGRENCI_ID\" inner join \"DERS\" ON \"DERS\".\"ID\" = \"DERS_OGRENCI\".\"DERS_ID\" where \"DERS_OGRENCI\".\"ID\" = :ID";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ID", id);
		RowMapper<DersOgrenciDTO> rowMapper = new RowMapper<DersOgrenciDTO>() {
			
			@Override
			public DersOgrenciDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				DersOgrenciDTO dersogrDto = new DersOgrenciDTO();

				DersOgrenci dersogr = new DersOgrenci();
				dersogr.setID(rs.getLong("ID"));
				dersogr.setDERS_ID(rs.getLong("DERS_ID"));
				dersogr.setOGRENCI_ID(rs.getLong("OGRENCI_ID"));
				dersogr.setDEVAMSIZLIK(rs.getInt("DEVAMSIZLIK"));
				dersogr.setNOTE(rs.getInt("NOTE"));

				Ders ders = new Ders();
				ders.setID(rs.getLong("ID"));
				ders.setKONU_ID(rs.getLong("KONU_ID"));
				ders.setOGRETMEN_ID(rs.getLong("OGRETMEN_ID"));

				Ogrenci ogrenci = new Ogrenci();
				ogrenci.setID(rs.getLong("ID"));
				ogrenci.setNAME(rs.getString("NAME"));
				ogrenci.setOGR_NUMBER(rs.getLong("OGR_NUMBER"));
				ogrenci.setYEAR(rs.getLong("YEAR"));

				dersogrDto.setDersogr(dersogr);
				dersogrDto.setDers(ders);
				dersogrDto.setOgrenci(ogrenci);
				
				return dersogrDto;
			}
		};
		return namedParameterJdbcTemplate.queryForObject(sql, paramMap, rowMapper);
	}

	public boolean deleteByID(long id) {

		String sql = "delete from \"public\".\"DERS_OGRENCI\" where \"ID\" = :ID";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ID", id);
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

	public boolean save(DersOgrenci dersOgrenci) {
		String sql = "INSERT INTO \"public\".\"DERS_OGRENCI\"(\"DERS_ID\", \"OGRENCI_ID\", \"DEVAMSIZLIK\", \"NOTE\") VALUES (:DERSID, :OGRID, :DEVAMSIZLIK , :NOTE)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("DERSID", dersOgrenci.getDERS_ID());
		paramMap.put("OGRID", dersOgrenci.getOGRENCI_ID());
		paramMap.put("DEVAMSIZLIK", dersOgrenci.getDEVAMSIZLIK());
		paramMap.put("NOTE", dersOgrenci.getNOTE());
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

}
