package com.example.terminalServer;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TerminalServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TerminalServerApplication.class, args);

	}
	
	@Bean
	public List<Terminal> getTerminal() {
		return new Terminal().createTerminalPool();
	}

//	public static List<Terminal> getTerminalPool() {
//
//		List<Terminal> terminalPool = new ArrayList<Terminal>();
//
//		for (int i = 0; i < 5; i++) {
//			System.out.println(i+"***********");
//
//			terminalPool.add(new Terminal(1000 + i, 0, new Date(), false));
//		}
//		
//		System.out.println(terminalPool);
//
//		return null;
//
//	}

}
