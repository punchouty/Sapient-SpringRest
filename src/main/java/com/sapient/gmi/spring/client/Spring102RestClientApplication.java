package com.sapient.gmi.spring.client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Spring102RestClientApplication implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(Spring102RestClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Spring102RestClientApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        log.info("Printing Quote");
        log.info(quote.getValue().getQuote());
    }
}