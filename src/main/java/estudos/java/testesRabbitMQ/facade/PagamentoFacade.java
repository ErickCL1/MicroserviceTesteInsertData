package estudos.java.testesRabbitMQ.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import estudos.java.testesRabbitMQ.dto.PagamentoDto;
import estudos.java.testesRabbitMQ.producer.PagamentoRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PagamentoFacade {

    @Autowired private PagamentoRequestProducer producer;
    public String solicitarPagamento(PagamentoDto request) {
        try {
            producer.integrar(request);
        } catch (JsonProcessingException e) {
            return "Ocorreu um erro ao solicitar pagamento .. " + e.getMessage();
        }
        return "Pagamento aguardando confirmação";
    }

    public void erroPagamento(String payload) {
        System.err.println("=== PEDIDO NÃO ENCONTRADO ===" + payload);
    }

    public void sucessPagamento(String payload) {
        System.out.println("=== PEDIDO ENCONTRADO E LIBERADO PARA RETIRADA ===" + payload);
    }
}