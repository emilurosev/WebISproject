package lms.plugin.chat.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import lms.plugin.chat.model.ChatMessage;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long>{
	
}
