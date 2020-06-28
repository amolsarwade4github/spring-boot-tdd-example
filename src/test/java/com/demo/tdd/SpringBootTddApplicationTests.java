package com.demo.tdd;

import com.demo.tdd.domain.Car;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootTddApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getCar_ShouldReturnCarDetails() throws Exception {
		// arrange

		// action
		ResponseEntity<Car> response = restTemplate.getForEntity("/car/prius", Car.class);

		// assert
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response.getBody().getName()).isEqualTo("prius");
		Assertions.assertThat(response.getBody().getType()).isEqualTo("hybrid");
	}

}
