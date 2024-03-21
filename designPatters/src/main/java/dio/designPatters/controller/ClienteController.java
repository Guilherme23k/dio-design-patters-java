package dio.designPatters.controller;

import dio.designPatters.facade.MessageFacade;
import dio.designPatters.model.Cliente;
import dio.designPatters.service.ClienteService;
import dio.designPatters.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private MessageFacade messageFacade;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        Iterable<Cliente> clientes = clienteService.buscarTodos();
        return ResponseEntity.ok().body((List<Cliente>) clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> buscarClientePorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.buscarPorId(id);
        if (cliente != null) {
            return ResponseEntity.ok().body(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> adicionarCliente(@RequestBody Cliente cliente) {
        clienteService.inserir(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{id}/enviar-mensagem")
    public ResponseEntity<Void> enviarMensagem(@PathVariable Long id, @RequestBody String mensagem) {

        Optional<Cliente> clienteOptional = clienteService.buscarPorId(id);
        if (clienteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Cliente cliente = clienteOptional.get();
        String emailDoCliente = cliente.getEmail();
        messageFacade.enviarMensagem(emailDoCliente, mensagem);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        clienteService.atualizar(id, cliente);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

