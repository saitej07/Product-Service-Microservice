package com.saiteja.product_service_microservice;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MySQLContainer;

import static org.assertj.core.api.Assertions.assertThat;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceMicroserviceApplicationTests {

	@ServiceConnection
	static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.0.26");

	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	static {
		mySQLContainer.start();
	}

	@Test
	void shouldCreateProduct() {
		String requestBody = """
				{
				    "name": "Iphone 15",
				    "description": "This is Apple mobile",
				    "price": 100000
				}
				""";

		var responseBodyString =RestAssured.given()
				.contentType("application/json")
				.body(requestBody)
				.when()
				.post("/api/product")
				.then()
				.log().all()
				.statusCode(201)
				.extract()
				.body().asString();

		assertThat(responseBodyString).isEqualTo("Product Created Successfully");
	}

}
