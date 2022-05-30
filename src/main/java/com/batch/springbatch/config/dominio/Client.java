package com.batch.springbatch.config.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
	private String name;
	private String lastName;
	private String age;
	private String email;

	private List<Transaction> transactions = new ArrayList<>();

	@Override
	public String toString() {
		return "Client{" +
	                "nome='" + name + "'" +
	                ", lastName ='" + lastName + "'" +
	                ", age='" + age + "'" +
	                ", email='" + email + "'" +
				(transactions.isEmpty() ? "" : ", transacoes=" + transactions)
				+ '}';
	}
}