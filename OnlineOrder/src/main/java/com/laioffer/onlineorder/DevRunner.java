package com.laioffer.onlineorder;

import com.laioffer.onlineorder.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author luluxue
 * @date 2024-10-12 10:53AM
 */
@Component
public class DevRunner implements ApplicationRunner {
	// password encoding
	
	private static final Logger logger = LoggerFactory.getLogger(DevRunner.class);
	
	
	private final CustomerService customerService;
	
	
	public DevRunner(
			CustomerService customerService) {
		this.customerService = customerService;
	}
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		customerService.signUp("foo@mail.com", "123456", "Foo", "Bar");
	}
}

