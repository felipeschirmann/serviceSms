package br.dev.felipeschirmann.serviceSms.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.dev.felipeschirmann.serviceSms.dto.SmsDTO;

@Service
public class JMSProducer {
	@Autowired
	JmsTemplate jms;
	
	@Value("${spring.artemis.queue}")
	private String queue;
	
	Logger logger = LoggerFactory.getLogger(JMSProducer.class);
	
	public void sendToQueue(SmsDTO dto){
		try {
		ObjectMapper mapper = new ObjectMapper();
		Object msg = mapper.writeValueAsString(dto);
		
		jms.convertAndSend(queue, msg);
		logger.info("Message Send to Queue");
		} catch (Exception e) {
			logger.error("Message Send to Queue: {}", e);
		}
	}
}
