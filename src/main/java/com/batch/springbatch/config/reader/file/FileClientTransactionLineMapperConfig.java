package com.batch.springbatch.config.reader.file;

import com.batch.springbatch.config.dominio.Client;
import com.batch.springbatch.config.dominio.Transaction;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class FileClientTransactionLineMapperConfig {

  @SuppressWarnings({"rawtypes", "unchecked"})
  @Bean
  public PatternMatchingCompositeLineMapper lineMapper() {
    var lineMapper = new PatternMatchingCompositeLineMapper();
    lineMapper.setTokenizers(tokenizers());
    lineMapper.setFieldSetMappers(fieldSetMappers());
    return lineMapper;
  }

  @SuppressWarnings("rawtypes")
  private Map<String, FieldSetMapper> fieldSetMappers() {
    var fieldSetMappers = new HashMap<String, FieldSetMapper>();
    fieldSetMappers.put("0*", fieldSetMapper(Client.class));
    fieldSetMappers.put("1*", fieldSetMapper(Transaction.class));
    return fieldSetMappers;
  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  private FieldSetMapper fieldSetMapper(Class className) {
    var fieldSetMapper = new BeanWrapperFieldSetMapper();
    fieldSetMapper.setTargetType(className);
    return fieldSetMapper;
  }

  private Map<String, LineTokenizer> tokenizers() {
    var tokenizers = new HashMap<String, LineTokenizer>();
    tokenizers.put("0*", clientLineTokenizer());
    tokenizers.put("1*", transactionLineTokenizer());
    return tokenizers;
  }

  private LineTokenizer clientLineTokenizer() {
    var lineTokenizer = new DelimitedLineTokenizer();
    lineTokenizer.setNames("name", "lastName", "age", "email");
    lineTokenizer.setIncludedFields(1, 2, 3, 4);
    return lineTokenizer;
  }

  private LineTokenizer transactionLineTokenizer() {
    var lineTokenizer = new DelimitedLineTokenizer();
    lineTokenizer.setNames("id", "description", "value");
    lineTokenizer.setIncludedFields(1, 2, 3);
    return lineTokenizer;
  }

}
