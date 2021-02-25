package com.qa.ims.persistence.domain;

public class Request {

	private Long id;
	private Long idd;
	
	public Request(Long id) {
		this.setId(id);
		
	}
	
	public Request(Long id, Long idd) {
		this.setId(id);
		this.setIdd(idd);
		
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Long getIdd() {
		return idd;
	}

	public void setIdd(Long idd) {
		this.idd = idd;
	}

	@Override
	public String toString() {
		return "custid:" + id + " orderid:" +idd ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idd == null) ? 0 : idd.hashCode());
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
		Request other = (Request) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idd == null) {
			if (other.idd != null)
				return false;
		} else if (!idd.equals(other.idd))
			return false;
		return true;
	}

}