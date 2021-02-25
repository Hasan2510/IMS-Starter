package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.RequestDAO;
import com.qa.ims.persistence.domain.Request;
import com.qa.ims.utils.Utils;

/**
 * Takes in request details for CRUD functionality
 *
 */
public class RequestController implements CrudController<Request> {

	public static final Logger LOGGER = LogManager.getLogger();

	private RequestDAO requestDAO;
	private Utils utils;

	public RequestController(RequestDAO requestDAO, Utils utils) {
		super();
		this.requestDAO = requestDAO;
		this.utils = utils;
	}

	/**
	 * Reads all requests to the logger
	 */
	@Override
	public List<Request> readAll() {
		List<Request> requests = requestDAO.readAll();
		for (Request request : requests) {
			LOGGER.info(request);
		}
		return requests;
	}

	/**
	 * Creates a request by taking in user input
	 */
	@Override
	public Request create() {
		LOGGER.info("Please enter customer ID");
		Long id = utils.getLong();
		Request request = requestDAO.create(new Request(id));
		LOGGER.info("order created");
		return request;
	}

	/**
	 * Updates an existing request by taking in user input
	 */
	@Override
	public Request update() {
		LOGGER.info("Please enter the order ID you would like to update");
		Long idd = utils.getLong();
		LOGGER.info("Please enter the customer ID");
		Long id = utils.getLong();
		Request request = requestDAO.update(new Request(idd , id));
		LOGGER.info("order Updated");
		return request;
	}

	/**
	 * Deletes an existing request by the id of the request
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the orderID you would like to delete");
		Long id = utils.getLong();
		return requestDAO.delete(id);
	}

}
