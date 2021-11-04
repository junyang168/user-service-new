package com.broadcom.userservice;

public class User {

	private  int id;
	private  String name;
	private  int age;
	private String address1;
	private String address2;

	public User() {
		
	}

	public User(int id, String name, int age, String address1, String address2  ) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address1 = address1;
		this.address2 = address2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public String getAddress1() {
		return address1;

	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

}
