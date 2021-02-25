package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderInfoDAO;
import com.qa.ims.persistence.domain.OrderInfo;
import com.qa.ims.utils.Utils;

/**
 * Takes in orderinfo details for CRUD functionality
 *
 */
public class OrderInfoController implements CrudController<OrderInfo> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderInfoDAO orderinfoDAO;
	private Utils utils;

	public OrderInfoController(OrderInfoDAO orderinfoDAO, Utils utils) {
		super();
		this.orderinfoDAO = orderinfoDAO;
		this.utils = utils;
	}

	/**
	 * Reads all orderinfos to the logger
	 */
	@Override
	public List<OrderInfo> readAll() {
		List<OrderInfo> orderinfos = orderinfoDAO.readAll();
		for (OrderInfo orderinfo : orderinfos) {
			LOGGER.info(orderinfo);
		}
		return orderinfos;
	}

	/**
	 * Creates a orderinfo by taking in user input
	 */
	@Override
	public OrderInfo create() {
		LOGGER.info("Please enter a an item ID");
		Long i = utils.getLong();
		LOGGER.info("Please enter a order ID");
		Long o = utils.getLong();
		LOGGER.info("please enter a quantity");
		Long qua = utils.getLong();
		OrderInfo orderinfo = orderinfoDAO.create(new OrderInfo(i, o, qua));
		LOGGER.info("orderinfo created");
		
		return orderinfo;
	}	

	/**
	 * Updates an existing orderinfo by taking in user input
	 */
	@Override
	public OrderInfo update() {
		LOGGER.info("Please enter the id of the orderinfo you would like to update");
		Long oi = utils.getLong();
		LOGGER.info("Please enter the item id of the orderinfo you would like to update");
		Long i = utils.getLong();
		LOGGER.info("Please enter a order id");
		Long o = utils.getLong();
		LOGGER.info("Please enter a quantity");
		Long qua = utils.getLong();
		OrderInfo orderinfo = orderinfoDAO.update(new OrderInfo(i, o , qua,oi));
		LOGGER.info("orderinfo Updated");
		return orderinfo;
	}

	/**
	 * Deletes an existing orderinfo by the id of the orderinfo
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the orderinfo you would like to delete");
		Long oi = utils.getLong();
		return orderinfoDAO.delete(oi);
	}

}
