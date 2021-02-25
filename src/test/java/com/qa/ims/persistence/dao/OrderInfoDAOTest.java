package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.OrderInfo;
import com.qa.ims.utils.DBUtils;

public class OrderInfoDAOTest {

	private final OrderInfoDAO DAO = new OrderInfoDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final OrderInfo created = new OrderInfo(2L ,"Cola", 2F);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<OrderInfo> expected = new ArrayList<>();
		expected.add(new OrderInfo(1L, "Pepsi", 0.5F));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new OrderInfo(1L, "Pepsi", 0.5F), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new OrderInfo(ID, "Pepsi", 0.5F), DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final OrderInfo updated = new OrderInfo(1L, "Fanta", 2F);
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}
