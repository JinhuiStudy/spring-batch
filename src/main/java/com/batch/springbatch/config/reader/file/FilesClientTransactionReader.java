package com.batch.springbatch.config.reader.file;

import com.batch.springbatch.config.dominio.Client;
import com.batch.springbatch.config.dominio.Transaction;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.core.io.Resource;

public class FilesClientTransactionReader implements ItemStreamReader<Client>, ResourceAwareItemReaderItemStream<Client> {
	private Object objAtual;
	private FlatFileItemReader<Object> delegate;
	
	public FilesClientTransactionReader(FlatFileItemReader<Object> delegate) {
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
		if (objAtual == null)
			objAtual = delegate.read();

		Client client = (Client) objAtual;
		objAtual = null;
		
		if (client != null) {
			while (peek() instanceof Transaction)
				client.getTransactions().add((Transaction) objAtual);
		}
		return client;
	}

	private Object peek() throws Exception {
		objAtual = delegate.read();
		return objAtual;
	}

	@Override
	public void setResource(Resource resource) {
		delegate.setResource(resource);
	}

}
