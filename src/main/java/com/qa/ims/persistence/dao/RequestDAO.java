package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Request;
import com.qa.ims.utils.DBUtils;

public class RequestDAO implements Dao<Request> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Request modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("custID");
		Long idd = resultSet.getLong("orderID");
		return new Request(id, idd);
	}

	/**
	 * Reads all requests from the database
	 * 
	 * @return A list of requests
	 */
	@Override
	public List<Request> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM request");) {
			List<Request> requests = new ArrayList<>();
			while (resultSet.next()) {
				requests.add(modelFromResultSet(resultSet));
			}
			return requests;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Request readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM request ORDER BY orderID DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates a request in the database
	 * 
	 * @param request - takes in a request object. idd will be ignored
	 */
	@Override
	public Request create(Request request) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO request(custID) VALUES (?)");) {
			statement.setLong(1, request.getId());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}