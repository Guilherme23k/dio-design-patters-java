package dio.designPatters.strategy;

import org.springframework.stereotype.Component;

@Component
public class EmailMessageStrategy implements MessageStrategy {
    @Override
    public void sendMessage(String message, String s) {
        System.out.println("Enviando mensagem por e-mail: " + message);
    }
}


