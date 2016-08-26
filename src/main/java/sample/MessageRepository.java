package sample;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface MessageRepository extends 
	PagingAndSortingRepository<Message, Long> {

	Message findByText(@Param("text") String text);
}
