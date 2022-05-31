package com.batch.springbatch.config.processor;

import com.batch.springbatch.config.dominio.Bill;
import com.batch.springbatch.config.dominio.Usage;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BillProcessorConfig {

    @Bean
    ItemProcessor<Usage, Bill> billProcessor() {
        return new BillProcessor();
    }

}