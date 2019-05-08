package com.example.validationClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/validation")
public class ValidationClientController {

	@Autowired
	private RestTemplate restTemplate;

	final String uri = "http://localhost:8081/terminal/";

	@RequestMapping(value = "/{terminalId}", method = RequestMethod.GET, produces = { "application/json" })
	public Terminal fetchTerminalInfo(@PathVariable("terminalId") String terminalId) {
		System.out.println("eees");
		ResponseEntity<Terminal> terminalResponse =
		        restTemplate.exchange(uri,
		                    HttpMethod.GET, null, new ParameterizedTypeReference<Terminal>() {
		            });
		Terminal t1 = terminalResponse.getBody();

		try {
			System.out.println("eees");
			Thread.sleep(2000);
			System.out.println("eee");
			ResponseEntity<Terminal> unlockTerminal =
			        restTemplate.exchange(uri+terminalId,
			                    HttpMethod.PUT, null, new ParameterizedTypeReference<Terminal>() {
			            });
			t1=unlockTerminal.getBody();
			System.out.println(t1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return t1;
	}

}
