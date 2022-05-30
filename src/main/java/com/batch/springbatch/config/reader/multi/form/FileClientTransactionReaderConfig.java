package com.batch.springbatch.config.reader.multi.form;

import com.batch.springbatch.config.dominio.Client;
import com.batch.springbatch.config.dominio.Transaction;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;

public class FileClientTransactionReaderConfig implements ItemStreamReader<Client> {
  private Object object;
  private final ItemStreamReader<Object> delegate;

  public FileClientTransactionReaderConfig(ItemStreamReader<Object> delegate) {
    this.delegate = delegate;
  }

  @Override
  public void open(ExecutionContext executionContext) throws ItemStreamException {
    delegate.open(executionContext);
  }

  @Override
  public void update(ExecutionContext executionContext) throws ItemStreamException {
    delegate.update(executionContext);
  }

  @Override
  public void close() throws ItemStreamException {
    delegate.close();
  }

  @Override
  public Client read() throws Exception {
    if (object == null)
      object = delegate.read();

    Client client = (Client) object;
    object = null;

    if (client != null) {
      while(peek() instanceof Transaction)
        client.getTransactions().add((Transaction) object);
    }

    return client;
  }

  private Object peek() throws Exception {
    object = delegate.read();
    return object;
  }

}
