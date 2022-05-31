package com.batch.springbatch.config.processor;

import com.batch.springbatch.config.dominio.Bill;
import com.batch.springbatch.config.dominio.Usage;
import org.springframework.batch.item.ItemProcessor;


public class BillProcessor implements ItemProcessor<Usage, Bill> {

    @Override
    public Bill process(Usage usage) {
        Double billAmount = usage.getDataUsage() * .001 + usage.getMinutes() * .01;
        return new Bill(
                usage.getId(), usage.getFirstName(), usage.getLastName(),
                usage.getDataUsage(), usage.getMinutes(), billAmount
        );
    }
}