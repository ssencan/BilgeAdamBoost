package com.bilgeadam.postgresqljdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bilgeadam.postgresqljdbc.Constants;
import com.bilgeadam.postgresqljdbc.model.Ders;
import com.bilgeadam.postgresqljdbc.model.DersDTO;
import com.bilgeadam.postgresqljdbc.model.Konu;
import com.bilgeadam.postgresqljdbc.model.Ogretmen;

public class DersRepository
{
	
	public boolean save(Ders ders) throws SQLException
	{
		boolean result = false;
		Connection con = Constants.getConnection();
		String sql = "INSERT INTO \"public\".\"DERS\"(\"OGRETMEN_ID\", \"KONU_ID\") VALUES (?, ?)";
		PreparedStatement stmnt = con.prepareStatement(sql);
		stmnt.setLong(1, ders.getOGRETMEN_ID());
		stmnt.setLong(2, ders.getKONU_ID());
		result = stmnt.executeUpdate() == 1;
		stmnt.close();
		con.close();
		return result;
	}
	
	public boolean saveDTO(DersDTO dersDto) throws SQLException
	{
		boolean result = false;
		Connection con = Constants.getConnection();
		String sql = "INSERT INTO \"public\".\"DERS\"(\"OGRETMEN_ID\", \"KONU_ID\") VALUES (?, ?)";
		PreparedStatement stmnt = con.prepareStatement(sql);
		stmnt.setLong(1, dersDto.getOgr().getID());
		stmnt.setLong(2, dersDto.getKonu().getID());
		result = stmnt.executeUpdate() == 1;
		stmnt.close();
		con.close();
		return result;
	}
	
	public ArrayList<Ders> getAll() throws SQLException
	{
		ArrayList<Ders> list = new ArrayList<>();
		Connection con = Constants.getConnection();
		Statement stmnt = con.createStatement();
		ResultSet result = stmnt.executeQuery("select * from \"public\".\"DERS\" order by \"ID\" asc");
		while (result.next())
		{
			long id = result.getLong("ID");
			long ogretmen_id = result.getLong("OGRETMEN_ID");
			long konu_id = result.getLong("KONU_ID");
			list.add(new Ders(id, ogretmen_id, konu_id));
		}
		result.close();
		stmnt.close();
		con.close();
		return list;
	}

	public ArrayList<DersDTO> getAllDTO() throws SQLException
	{
		ArrayList<DersDTO> list = new ArrayList<>();
		Connection con = Constants.getConnection();
		Statement stmnt = con.createStatement();
		ResultSet result = stmnt.executeQuery("select \"DERS\".\"OGRETMEN_ID\", \"OGRETMEN\".\"NAME\" AS \"OGR_NAME\", \"OGRETMEN\".\"IS_GICIK\", \"DERS\".\"KONU_ID\", \"KONU\".\"NAME\" AS \"KONU_NAME\" from \"DERS\" inner join \"OGRETMEN\" ON \"OGRETMEN\".\"ID\" = \"DERS\".\"OGRETMEN_ID\" inner join \"KONU\" ON \"KONU\".\"ID\" = \"DERS\".\"KONU_ID\";");
		while (result.next())
		{
			Ogretmen ogr = new Ogretmen(result.getLong("OGRETMEN_ID"), result.getString("OGR_NAME"), result.getBoolean("IS_GICIK"));
			Konu konu = new Konu(result.getLong("KONU_ID"), result.getString("KONU_NAME"));
			list.add(new DersDTO(ogr, konu));
		}
		result.close();
		stmnt.close();
		con.close();
		return list;
	}
	
	public boolean deleteByID(long id) throws SQLException
	{
		Connection con = Constants.getConnection();
		String sql = "delete from \"public\".\"DERS\" where \"ID\" = ?";
		PreparedStatement stmnt = con.prepareStatement(sql);
		stmnt.setLong(1, id);
		boolean result = stmnt.executeUpdate() == 1;
		stmnt.close();
		con.close();
		return result;
	}
	
	public Ders getByID(long id) throws SQLException
	{
		Ders ders = null;
		Connection con = Constants.getConnection();
		String sql = "select * from \"public\".\"DERS\" where \"ID\" = ?";
		PreparedStatement stmnt = con.prepareStatement(sql);
		stmnt.setLong(1, id);
		ResultSet result = stmnt.executeQuery();
		while (result.next())
		{
			ders = new Ders(result.getLong("ID"), result.getLong("OGRETMEN_ID"), result.getLong("KONU_ID"));
		}
		result.close();
		stmnt.close();
		con.close();
		return ders;
	}
	//DTO ile yapıcaktım ama dersdto içinde id yok
//	public DersDTO getByIDDTO(long id) throws SQLException
//	{
//		DersDTO dersDTO = null;
//		Connection con = Constants.getConnection();
//		String sql = "select * from \"public\".\"DERS\" where \"ID\" = ?";
//		PreparedStatement stmnt = con.prepareStatement(sql);
//		stmnt.setLong(1, id);
//		ResultSet result = stmnt.executeQuery();
//		while (result.next())
//		{
//			dersDTO = new DersDTO(result.getLong("ID"), result.getLong("OGRETMEN_ID"), result.getLong("KONU_ID"));
//		}
//		result.close();
//		stmnt.close();
//		con.close();
//		return dersDTO;
//	}
	
}