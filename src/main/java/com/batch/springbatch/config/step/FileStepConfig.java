package com.batch.springbatch.config.step;

import com.batch.springbatch.config.dominio.Client;
import com.batch.springbatch.config.reader.file.FileClientTransactionReader;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FileStepConfig {
	private final StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step fileFixedWidthStep(
			ItemReader<Client> fileFixedWidthReader,
			ItemWriter<Client> filePrintWriter) {
		return stepBuilderFactory
				.get("fileFixedWidthStep")
				.<Client, Client> chunk(1)
				.reader(fileFixedWidthReader)
				.writer(filePrintWriter)
				.build();
	}

	@Bean
	public Step fileDelimitedStep(
			ItemReader<Client> fileDelimitedReader,
			ItemWriter<Client> filePrintWriter)
	{
		return stepBuilderFactory
				.get("fileDelimitedStep")
				.<Client, Client>chunk(1)
				.reader(fileDelimitedReader)
				.writer(filePrintWriter)
				.build();
	}

	@Bean
	public Step fileMultipleFormatsStep(
			FlatFileItemReader fileMultiplesFormatsItemReader,
			ItemWriter filePrintWriter) {
		return stepBuilderFactory
				.get("fileMultipleFormatsStep")
				.chunk(1)
				.reader(new FileClientTransactionReader(fileMultiplesFormatsItemReader))
				.writer(filePrintWriter)
				.build();
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Bean
	public Step filesMultipleFormatsStep(
			MultiResourceItemReader<Client> filesMultiplesFormatsItemReader,
			ItemWriter filePrintWriter) {
		return stepBuilderFactory
				.get("filesMultipleFormatsStep")
				.chunk(1)
				.reader(filesMultiplesFormatsItemReader)
				.writer(filePrintWriter)
				.build();
	}

}
