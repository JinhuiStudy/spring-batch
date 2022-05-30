package com.batch.springbatch.config.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
	private String name;
	private String lastName;
	private String age;
	private String email;

	@Override
	public String toString() {
		return "Client{" +
	                "nome='" + name + "'" +
	                ", lastName ='" + lastName + "'" +
	                ", age='" + age + "'" +
	                ", email='" + email + "'" +
	                '}';
	}
}