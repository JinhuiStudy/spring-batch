package com.batch.springbatch.config.writer;

import com.batch.springbatch.config.dominio.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class FileWriterConfig {
	@Bean
	public ItemWriter<Client> filePrintWriter() {
		return items -> items.forEach(t -> log.info(t.toString()));
	}
}
