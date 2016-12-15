package com.bjoernkw.springBatch.addOns.item.item;

import org.springframework.batch.item.*;

public class RestItemStreamReader implements ItemStreamReader<Object> {

    public Object read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return null;
    }

    public void open(ExecutionContext executionContext) throws ItemStreamException {

    }

    public void update(ExecutionContext executionContext) throws ItemStreamException {

    }

    public void close() throws ItemStreamException {

    }
}
