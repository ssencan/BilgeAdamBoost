package com.bilgeadam.postgresqljdbc.repository;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepository<T> {

	boolean save(T entity) throws SQLException;

	boolean deleteByID(long id) throws SQLException;

	T getByID(long id) throws SQLException;
	
	ArrayList<T> getAll() throws SQLException;
}
