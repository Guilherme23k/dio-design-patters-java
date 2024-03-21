package dio.designPatters.facade;

import dio.designPatters.model.Cliente;
import dio.designPatters.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageFacade {

    @Autowired
    private MessageService messageService;

    public void enviarMensagem(String email, String mensagem) {
        messageService.sendMessage(email, mensagem);
    }

}

