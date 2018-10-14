package tb.com.catalogservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("tb.com.catalogservices.models")
@EnableJpaRepositories(basePackages="tb.com.catalogservices.repository")
@SpringBootApplication
public class CatalogservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogservicesApplication.class, args);
	}
}
