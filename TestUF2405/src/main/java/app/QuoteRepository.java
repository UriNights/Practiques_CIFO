package app;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface QuoteRepository extends CrudRepository<Quote, Long> {
}