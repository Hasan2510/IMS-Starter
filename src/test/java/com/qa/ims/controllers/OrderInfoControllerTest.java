package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderInfoController;
import com.qa.ims.persistence.dao.OrderInfoDAO;
import com.qa.ims.persistence.domain.OrderInfo;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderInfoControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderInfoDAO dao;

	@InjectMocks
	private OrderInfoController controller;

	@Test
	public void testCreate() {
		final Long  orderID=2L , itemID=2L, Qua = 2L;
		
		final OrderInfo created = new OrderInfo(orderID, itemID,Qua);

		Mockito.when(utils.getLong()).thenReturn(orderID, itemID,Qua);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(3)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<OrderInfo> OrderInfos = new ArrayList<>();
		OrderInfos.add(new OrderInfo(1L, 1L,1L));

		Mockito.when(dao.readAll()).thenReturn(OrderInfos);

		assertEquals(OrderInfos, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		OrderInfo updated = new OrderInfo(1L, 1L, 1L,1L);

		Mockito.when(this.utils.getLong()).thenReturn(1L, updated.getI(),updated.getO(), updated.getQua());
		//Mockito.when(this.utils.getLong()).thenReturn(updated.getI(),updated.getO(), updated.getQua());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(4)).getLong();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}

}
