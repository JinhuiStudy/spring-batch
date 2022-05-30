package com.batch.springbatch.config.writer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class FileWriterConfig {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ItemWriter filePrintWriter() {
		return items -> items.forEach(t -> log.info(t.toString()));
	}
}
