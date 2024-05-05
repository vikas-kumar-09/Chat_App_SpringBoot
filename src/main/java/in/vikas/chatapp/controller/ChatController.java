package in.vikas.chatapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.vikas.chatapp.Repository.ChatMessageRepository;
import in.vikas.chatapp.model.ChatMessage;

/**
 * Controller class for handling chat-related functionality.
 */
@RestController
public class ChatController {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        chatMessageRepository.save(chatMessage);
        return chatMessage;
    }
    /**
     * Registers a user for chat.
     * 
     * param chatMessage The chat message containing the sender's information.
     * param headerAccessor The SimpMessageHeaderAccessor object used to access session attributes.
     * return The registered chat message.
     */
    
    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

    /**
     * Sends a chat message to all connected users.
     * 
     * param chatMessage The chat message to be sent.
     * return The sent chat message.
     */
    
    // @MessageMapping("/chat.send")
    // @SendTo("/topic/public")
    // public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
    //     return chatMessage;
    // }
     
     /**
     * Returns a simple message when accessed via GET request.
     * 
     * return A simple message.
     */

    // Just for checking purpose
    @GetMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello from ChatController!";
    }

    // sudo yum localinstall java-1.8.0-amazon-corretto*.rpm
}
