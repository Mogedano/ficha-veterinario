package com.init.fichaVeterinario.entity;

import javax.persistence.*;


@Entity  //Conecta con BBDD
@Table(name="pet")   //nombre tabla
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name") 
	private String name;
	
	@Column(name="age")
	private int age;	
	
	//Constructores	
	public Pet(long id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public Pet(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Pet() {
	}

	//Getters y Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	//toString()
	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", age=" + age + "]";
	}	

}
