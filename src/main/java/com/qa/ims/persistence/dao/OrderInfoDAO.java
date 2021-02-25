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

import com.qa.ims.persistence.domain.OrderInfo;
import com.qa.ims.utils.DBUtils;

public class OrderInfoDAO implements Dao<OrderInfo> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public OrderInfo modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long i = resultSet.getLong("itemID");
		Long o = resultSet.getLong("orderID");
		Long oi = resultSet.getLong("orderinfoID");
		Long qua = resultSet.getLong("quantity");
		Double price = qua*howmuch(i);
		return new OrderInfo(i, o, qua,oi,price);
	}

	/**
	 * Reads all items from the database
	 * 
	 * @return A list of items
	 */
	@Override
	public List<OrderInfo> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderinfo");) {
			List<OrderInfo> orderinfos = new ArrayList<>();
			while (resultSet.next()) {
				orderinfos.add(modelFromResultSet(resultSet));
			}
			return orderinfos;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public OrderInfo readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderinfo ORDER BY orderinfoID DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates a item in the database
	 * 
	 * @param item - takes in a item object. id will be ignored
	 */
	@Override
	public OrderInfo create(OrderInfo orderinfo) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orderinfo(itemID,orderID,quantity) VALUES (?, ? ,?)");) {
			statement.setLong(1, orderinfo.getI());
			statement.setLong(2, orderinfo.getO());
			statement.setLong(3, orderinfo.getQua());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	@Override
	public OrderInfo read(Long oid) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orderinfo WHERE orderinfoID = ?");) {
			statement.setLong(1, oid);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates a item in the database
	 * 
	 * @param item - takes in a item object, the id field will be used to
	 *                 update that item in the database
	 * @return
	 */
	@Override
	public OrderInfo update(OrderInfo orderinfo) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE orderinfo SET itemID = ?, orderID = ?, quantity = ? WHERE orderinfoID = ?");) {
			statement.setLong(1, orderinfo.getI());
			statement.setLong(2, orderinfo.getO());
			statement.setLong(3, orderinfo.getQua());
			statement.setLong(4, orderinfo.getOi());

			statement.executeUpdate();
			return read(orderinfo.getOi());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	

	/**
	 * Deletes a item in the database
	 * 
	 * @param id - id of the item
	 */
	@Override
	public int delete(long oi) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orderinfo WHERE orderinfoID = ?");) {
			statement.setLong(1, oi);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	
	public Double howmuch(Long oid) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT value from item where itemID = ?");) {
			statement.setLong(1, oid);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return resultSet.getDouble("value");
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	
}
