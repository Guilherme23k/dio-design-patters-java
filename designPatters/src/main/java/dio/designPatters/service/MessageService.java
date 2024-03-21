package dio.designPatters.service;

import dio.designPatters.strategy.MessageStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Qualifier("emailMessageStrategy")
    @Autowired
    private MessageStrategy messageStrategy;

    public void setMessageStrategy(MessageStrategy messageStrategy) {
        this.messageStrategy = messageStrategy;
    }

    public void sendMessage(String email, String message) {
        messageStrategy.sendMessage(email, message);
    }
}

