package in.vikas.chatapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vikas.chatapp.model.ChatMessage;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long>{
      // You can add custom query methods if needed
}
