package in.vikas.chatapp.repository;

// import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import in.vikas.chatapp.model.ChatMessage;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long>{

}
