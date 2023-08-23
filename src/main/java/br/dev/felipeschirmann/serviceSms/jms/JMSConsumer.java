package br.dev.felipeschirmann.serviceSms.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.dev.felipeschirmann.serviceSms.dto.SmsDTO;
import br.dev.felipeschirmann.serviceSms.services.SmsService;

@Service
public class JMSConsumer {
    @Autowired
    SmsService service;

    Logger logger = LoggerFactory.getLogger(JMSConsumer.class);
    
    @JmsListener(destination = "${spring.artemis.queue}")
    public void consumer(String msg) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            SmsDTO dto = objectMapper.readValue(msg, SmsDTO.class);

            service.sendSms(dto.getMsg());
            logger.info("Sms send to {}", dto.getPhoneTo());
        } catch (Exception e) {
            logger.error("Sms not send {}", e);
        }
    }
}
