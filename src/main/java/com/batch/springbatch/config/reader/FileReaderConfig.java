package com.batch.springbatch.config.reader;

import com.batch.springbatch.config.dominio.Client;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class FileReaderConfig {

	@Bean
	@StepScope
	public FlatFileItemReader<Client> fileFixedWidthReader(

			@Value("#{jobParameters['clients']}") Resource clients) {
			return new FlatFileItemReaderBuilder<Client>()
				.name("fileFixedWidthReader")
				.resource(clients)
				.fixedLength()
				.columns(new Range[] {new Range(1, 10), new Range(11, 20), new Range(21, 23), new Range(24, 36)})
				.names("name", "lastName", "age", "email")
				.targetType(Client.class)
				.build();
	}

	@StepScope
	@Bean
	public FlatFileItemReader<Client> fileDelimitedReader(
			@Value("#{jobParameters['clients']}") Resource clients) {
		return new FlatFileItemReaderBuilder<Client>()
				.name("fileDelimitedReader")
				.resource(clients)
				.delimited()
				.names("name", "lastName", "age", "email")
				.targetType(Client.class)
				.build();
	}

}
