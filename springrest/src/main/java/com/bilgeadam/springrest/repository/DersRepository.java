package com.bilgeadam.springrest.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bilgeadam.springrest.model.Ders;

@Repository
public class DersRepository {

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

	public List<Ders> getAll() {
		String sql = "select * from \"public\".\"DERS\" order by \"ID\" asc";
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Ders.class));
	}

	public Ders getByID(long id) {

		String sql = "select * from \"public\".\"DERS\" where \"ID\" = :ID";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ID", id);
		return namedParameterJdbcTemplate.queryForObject(sql, paramMap, BeanPropertyRowMapper.newInstance(Ders.class));
	}

	public boolean deleteByID(long id) {

		String sql = "delete from \"public\".\"DERS\" where \"ID\" = :ID";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ID", id);
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

	public boolean save(Ders ders) {

		String sql = "INSERT INTO \"public\".\"DERS\"(\"OGRETMEN_ID\", \"KONU_ID\") VALUES (:OGRTID, :KID)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("OGRTID", ders.getOGRETMEN_ID());
		paramMap.put("KID", ders.getKONU_ID());
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

//	public List<DersDTO> getAllDTO() {
//
//		String sql = "select \"DERS\".\"ID\",\"OGRETMEN_ID\", \"OGRETMEN\".\"NAME\" AS \"OGR_NAME\", \"OGRETMEN\".\"IS_GICIK\", \"DERS\".\"KONU_ID\", \"KONU\".\"NAME\" AS \"KONU_NAME\" from \"DERS\" inner join \"OGRETMEN\" ON \"OGRETMEN\".\"ID\" = \"DERS\".\"OGRETMEN_ID\" inner join \"KONU\" ON \"KONU\".\"ID\" = \"DERS\".\"KONU_ID\";";
//
//		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(DersDTO.class));
//	}
	



//	public boolean saveDTO(DersDTO dersDto) throws SQLException
//	{
//		boolean result = false;
//		Connection con = Constants.getConnection();
//		String sql = "INSERT INTO \"public\".\"DERS\"(\"OGRETMEN_ID\", \"KONU_ID\") VALUES (?, ?)";
//		PreparedStatement stmnt = con.prepareStatement(sql);
//		stmnt.setLong(1, dersDto.getOgr().getID());
//		stmnt.setLong(2, dersDto.getKonu().getID());
//		result = stmnt.executeUpdate() == 1;
//		stmnt.close();
//		con.close();
//		return result;
//	}

	// transaction olayı
//	public boolean save(Ogretmen ogretmen, Konu konu)
//	{
//		boolean result = false;
//		Connection connection = null;
//		PreparedStatement stmt = null;
//		try
//		{
//			connection = Constants.getConnection();
//			connection.setAutoCommit(false);
//			stmt = connection.prepareStatement("INSERT INTO \"public\".\"OGRETMEN\"(\"NAME\", \"IS_GICIK\") VALUES (?, ?)");
//			stmt.setString(1, ogretmen.getNAME());
//			stmt.setBoolean(2, ogretmen.isIS_GICIK());
//			stmt.executeUpdate();
//			stmt.close();
//			// ------------------
//			stmt = connection.prepareStatement("INSERT INTO \"public\".\"KONU\"(\"NAME\") VALUES (?)");
//			stmt.setString(1, konu.getNAME());
//			stmt.executeUpdate();
//			stmt.close();
//			// -----------------
//			stmt = connection.prepareStatement("INSERT INTO \"public\".\"DERS\"(\"OGRETMEN_ID\", \"KONU_ID\") VALUES (?, ?)");
//			// nasıl olsa foreign key 'den patlayacak
//			stmt.setInt(1, 451);
//			stmt.setInt(2, 551);
//			result = stmt.executeUpdate() == 1;
//			stmt.close();
//			connection.commit();
//		}
//		catch (Exception e)
//		{
//			try
//			{
//				result = false;
//				System.err.println(e.getMessage());
//				stmt.close();
//				connection.rollback();
//			}
//			catch (SQLException ex)
//			{
//			}
//		}
//		finally
//		{
//			try
//			{
//				connection.close();
//			}
//			catch (Exception e)
//			{
//			}
//		}
//		return result;
//	}
}