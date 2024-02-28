package estudos.java.testesRabbitMQ.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import estudos.java.testesRabbitMQ.dto.PagamentoDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoRequestProducer {
    //class de integração com o Rabbit
    @Autowired private AmqpTemplate amqpTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();
    public void integrar (PagamentoDto pagamento) throws JsonProcessingException {
        amqpTemplate.convertAndSend(
                "pagamento-request-exchange",
                "pagamento-request-routing-key",
                    objectMapper.writeValueAsString(pagamento)

        );
    }

}
