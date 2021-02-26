package com.qa.ims.persistence.domain;

public class OrderInfo {

	private Long i;
	private Long o;
	private Long oi;
	private Long qua;
	private Double price;

	public OrderInfo(Long i, Long o,Long qua) {
		this.setI(i);
		this.setO(o);
		this.setQua(qua);
	}

	public OrderInfo(Long i, Long o ,Long qua,Long oi) {
		this.setI(i);
		this.setO(o);
		this.setQua(qua);
		this.setOi(oi);
	}
	public OrderInfo(Long i, Long o ,Long qua,Long oi, Double price) {
		this.setI(i);
		this.setO(o);
		this.setQua(qua);
		this.setOi(oi);
		this.setPrice(price);
	}

	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getI() {
		return i;
	}

	public void setI(Long i) {
		this.i = i;
	}

	public Long getO() {
		return o;
	}

	public void setO(Long o) {
		this.o = o;
	}

	public Long getOi() {
		return oi;
	}

	public void setOi(Long oi) {
		this.oi = oi;
	}

	public long getQua() {
		return qua;
	}

	public void setQua(long qua) {
		this.qua = qua;
	}

	@Override
	public String toString() {
		return "ItemID :" + i + " OrderID:" + o + " OrderInfo:" + oi + " Quantity:" + qua + " price" + price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((i == null) ? 0 : i.hashCode());
		result = prime * result + ((o == null) ? 0 : o.hashCode());
		result = prime * result + ((oi == null) ? 0 : oi.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((qua == null) ? 0 : qua.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderInfo other = (OrderInfo) obj;
		if (i == null) {
			if (other.i != null)
				return false;
		} else if (!i.equals(other.i))
			return false;
		if (o == null) {
			if (other.o != null)
				return false;
		} else if (!o.equals(other.o))
			return false;
		if (oi == null) {
			if (other.oi != null)
				return false;
		} else if (!oi.equals(other.oi))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (qua == null) {
			if (other.qua != null)
				return false;
		} else if (!qua.equals(other.qua))
			return false;
		return true;
	}

}