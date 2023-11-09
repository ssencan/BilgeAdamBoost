package com.bilgeadam.jakartarest.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bilgeadam.jakartarest.Constants;
import com.bilgeadam.jakartarest.model.DersOgrenci;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public class DersOgrenciRepository
{

	public boolean save(DersOgrenci dogrn) throws SQLException
	{
		boolean result = false;
		Connection con = Constants.getConnection();
		String sql = "INSERT INTO \"public\".\"DERS_OGRENCI\"(\"DERS_ID\", \"OGRENCI_ID\",\"DEVAMSIZLIK\",\"NOTE\") VALUES (?, ?, ?, ?)";
		PreparedStatement stmnt = con.prepareStatement(sql);
		stmnt.setLong(1, dogrn.getDERS_ID());
		stmnt.setLong(2, dogrn.getOGR_ID());
		stmnt.setInt(3, dogrn.getDEVAMSIZLIK());
		stmnt.setInt(4, dogrn.getNOTE());
		result = stmnt.executeUpdate() == 1;
		stmnt.close();
		con.close();
		return result;
	}

	public boolean deleteByID(long id) throws SQLException
	{
		Connection con = Constants.getConnection();
		String sql = "delete from \"public\".\"DERS_OGRENCI\" where \"ID\" = ?";
		PreparedStatement stmnt = con.prepareStatement(sql);
		stmnt.setLong(1, id);
		boolean result = stmnt.executeUpdate() == 1;
		stmnt.close();
		con.close();
		return result;
	}

	@POST
	@Path(value = "save")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response print() {
		return Response.status(Status.CREATED).entity("Başarı ile kaydedildi").build();
	}
	
	public ArrayList<DersOgrenci> getAll() throws SQLException
	{
		ArrayList<DersOgrenci> list = new ArrayList<>();
		Connection con = Constants.getConnection();
		Statement stmnt = con.createStatement();
		ResultSet result = stmnt.executeQuery("select * from \"public\".\"DERS_OGRENCI\" order by \"ID\" asc");
		while (result.next())
		{
			long id = result.getLong("ID");
			long ders_id = result.getLong("DERS_ID");
			long ogrn_id = result.getLong("OGRENCI_ID");
			int devamsızlık = result.getInt("DEVAMSIZLIK");
			int not = result.getInt("NOTE");
			list.add(new DersOgrenci(id, ders_id, ogrn_id, devamsızlık, not));
		}
		result.close();
		stmnt.close();
		con.close();
		return list;
	}

	public DersOgrenci getByID(long id) throws SQLException
	{
		DersOgrenci dogrn = null;
		Connection con = Constants.getConnection();
		String sql = "select * from \"public\".\"DERS_OGRENCI\" where \"ID\" = ?";
		PreparedStatement stmnt = con.prepareStatement(sql);
		stmnt.setLong(1, id);
		ResultSet result = stmnt.executeQuery();
		while (result.next())
		{
			dogrn = new DersOgrenci(result.getLong("ID"), result.getLong("DERS_ID"), result.getLong("OGRENCI_ID"), result.getInt("DEVAMSIZLIK"), result.getInt("NOTE"));
		}
		result.close();
		stmnt.close();
		con.close();
		return dogrn;
	}
}
