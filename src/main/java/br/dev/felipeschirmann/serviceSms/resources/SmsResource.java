package br.dev.felipeschirmann.serviceSms.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.felipeschirmann.serviceSms.dto.SmsDTO;
import br.dev.felipeschirmann.serviceSms.jms.JMSProducer;

@RestController
@RequestMapping(value = "/sendSms")
public class SmsResource {

	@Autowired
	JMSProducer jmsProducer;
	
	@PostMapping
	public ResponseEntity<SmsDTO> SendEmail(@RequestBody SmsDTO dto) {
		jmsProducer.sendToQueue(dto);
		return ResponseEntity.ok().body(dto);
	}
	
}
