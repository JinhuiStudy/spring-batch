package com.batch.springbatch.config.writer;

import com.batch.springbatch.config.dominio.Bill;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class BillWriterConfig {

	@Bean
	public ItemWriter<Bill> billWriter(DataSource dataSource) {

		return new JdbcBatchItemWriterBuilder<Bill>()
					.beanMapped()
					.dataSource(dataSource)
					.sql(   "INSERT INTO BILL_STATEMENTS " +
							"(id, first_name, last_name, minutes, data_usage,bill_amount) " +
							" VALUES " +
							"(:id, :firstName, :lastName, :minutes, :dataUsage, :billAmount)")
					.build();
	}
}
