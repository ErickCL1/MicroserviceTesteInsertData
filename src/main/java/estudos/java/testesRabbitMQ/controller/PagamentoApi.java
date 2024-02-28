package estudos.java.testesRabbitMQ.controller;

import estudos.java.testesRabbitMQ.dto.PagamentoDto;
import estudos.java.testesRabbitMQ.facade.PagamentoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoApi {
    @Autowired private PagamentoFacade pagamentoFacade;

    @PostMapping
    public String processar(@RequestBody PagamentoDto request){
        return pagamentoFacade.solicitarPagamento(request);
    }



}
