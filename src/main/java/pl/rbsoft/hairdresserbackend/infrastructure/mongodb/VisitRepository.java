package pl.rbsoft.hairdresserbackend.infrastructure.mongodb;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import pl.rbsoft.hairdresserbackend.domain.Visit;

public interface VisitRepository extends MongoRepository<Visit, String> {
    List<Visit> findAllByVisitDateBetween(LocalDateTime from, LocalDateTime to);
}
