package dio.designPatters.strategy;

import org.springframework.stereotype.Component;

@Component
public class SmsMessageStrategy implements MessageStrategy {
    @Override
    public void sendMessage(String message, String s) {
        System.out.println("Enviando mensagem por SMS: " + message);

    }
}
