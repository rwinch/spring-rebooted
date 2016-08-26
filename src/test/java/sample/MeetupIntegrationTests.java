package sample;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MeetupIntegrationTests {
	@Autowired
	TestRestTemplate rest;

	@Test
	public void meetup()  throws Exception {
		ResponseEntity<String> meetup = 
				rest.getForEntity("/", String.class);
		
		assertThat(meetup.getBody()).contains("St Louis");
	}

}












