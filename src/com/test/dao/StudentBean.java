package com.test.dao;

public class StudentBean
{
	public StudentBean()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	private int id;
	private String username;
	private String userpsw;
	private int age;
	private int weight;
	private String sex;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getUserpsw()
	{
		return userpsw;
	}
	public void setUserpsw(String userpsw)
	{
		this.userpsw = userpsw;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getWeight()
	{
		return weight;
	}
	public void setWeight(int weight)
	{
		this.weight = weight;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public StudentBean(int id,String username,String userpsw,int age,int weight,String sex)
	{
		super();
		this.id=id;
		this.username=username;
		this.userpsw = userpsw;
		this.age=age;
		this.weight=weight;
		this.sex=sex;
	}
	

}
