package com.batch.springbatch.config.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
	public String id;
	public String description;
	public Double value;

	@Override
	public String toString() {
		return "description{" + "id='" + id + "'" + ", description='" + description + "'" + ", value='" + value + "'" + '}';
	}
}
