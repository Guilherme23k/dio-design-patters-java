package dio.designPatters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//
//Singleton: Representado pela classe SystemConfig que fornece uma instância que pode ser utilizada globalmente
//Strategy: O Strategy permite que diferentes algoritmos de mensagem sejam selecionados dinamicamente durante a execução do programa, promovendo flexibilidade e reutilização de código.
//Facade: O Facade simplifica a interface entre o cliente e o sistema, fornecendo uma maneira única de interagir com um conjunto de funcionalidades complexas.
//


@SpringBootApplication
public class DesignPattersApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignPattersApplication.class, args);
	}

}
