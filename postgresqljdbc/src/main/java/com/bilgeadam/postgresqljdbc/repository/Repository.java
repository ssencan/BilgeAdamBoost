package com.bilgeadam.postgresqljdbc.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bilgeadam.postgresqljdbc.Constants;

public abstract class Repository<T> implements IRepository<T> {

	protected Connection getConnection() throws SQLException {
		return Constants.getConnection();
	}

	@Override
	public abstract boolean save(T entity) throws SQLException;

	@Override
	public abstract boolean deleteByID(long id) throws SQLException;

	@Override
	public abstract T getByID(long id) throws SQLException;

	@Override
	public abstract ArrayList<T> getAll() throws SQLException;

}
