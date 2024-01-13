package com.example.demo.Controller;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

//ws://localhost:8081/websocket
@Configuration
@EnableWebSocketMessageBroker
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WebSocketController extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/logedin");
        registry.addEndpoint("/logedin").withSockJS();
    }
    @MessageMapping("/chat")
    @SendTo("/topic/logedin")
    public String send() {
        return "Update";
    }
}
