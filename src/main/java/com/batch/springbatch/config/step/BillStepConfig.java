package com.batch.springbatch.config.step;

import com.batch.springbatch.config.dominio.Bill;
import com.batch.springbatch.config.dominio.Client;
import com.batch.springbatch.config.dominio.Usage;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BillStepConfig {

    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step billStep(
            ItemReader<Usage> billReader,
            ItemProcessor<Usage, Bill> billProcessor,
            ItemWriter<Bill> billWriter
    ) {
        return stepBuilderFactory.get("billStep")
                .<Usage, Bill>chunk(1)
                .reader(billReader)
                .processor(billProcessor)
                .writer(billWriter)
                .build();
    }

}
