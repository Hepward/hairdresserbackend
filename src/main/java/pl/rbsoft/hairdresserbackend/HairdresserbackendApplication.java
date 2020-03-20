package pl.rbsoft.hairdresserbackend;

import io.github.kaiso.relmongo.config.EnableRelMongo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
@EnableRelMongo
public class HairdresserbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(HairdresserbackendApplication.class, args);
	}

}
