package com.hql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
public class Employee {
	@Id
	private int E_id;
	private String E_name;
	private String ELast_name;
	private String E_city;

	public Employee() {
		super();
	}

	public Employee(int e_id, String e_name, String eLast_name, String e_city) {
		super();
		E_id = e_id;
		E_name = e_name;
		ELast_name = eLast_name;
		E_city = e_city;
	}

	public int getE_id() {
		return E_id;
	}

	public void setE_id(int e_id) {
		E_id = e_id;
	}

	public String getE_name() {
		return E_name;
	}

	public void setE_name(String e_name) {
		E_name = e_name;
	}

	public String getELast_name() {
		return ELast_name;
	}

	public void setELast_name(String eLast_name) {
		ELast_name = eLast_name;
	}

	public String getE_city() {
		return E_city;
	}

	public void setE_city(String e_city) {
		E_city = e_city;
	}

	@Override
	public String toString() {
		return "Employee [E_id=" + E_id + ", E_name=" + E_name + ", ELast_name=" + ELast_name + ", E_city=" + E_city
				+ "]";
	}
}