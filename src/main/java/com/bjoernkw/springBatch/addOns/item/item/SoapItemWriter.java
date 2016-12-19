package com.bjoernkw.springBatch.addOns.item.item;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import java.util.List;
import java.util.Properties;

public class SoapItemWriter implements ItemWriter<Object> {

    private final Logger log = LoggerFactory.getLogger(SoapItemWriter.class);

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    @Autowired
    @Qualifier("soapWsProperties")
    private Properties soapWsProperties;

    public void write(List<?> items) throws Exception {
        log.info("Sending SOAP data.");

        HttpComponentsMessageSender sender = new HttpComponentsMessageSender();
        sender.setCredentials(new UsernamePasswordCredentials(
                soapWsProperties.getProperty("ws.username"),
                soapWsProperties.getProperty("ws.password")));
        webServiceTemplate.setMessageSender(sender);
        webServiceTemplate.setCheckConnectionForFault(false);

        Object request = new Object();

        webServiceTemplate
                .marshalSendAndReceive(
                        "https://",
                        request);
    }
}
