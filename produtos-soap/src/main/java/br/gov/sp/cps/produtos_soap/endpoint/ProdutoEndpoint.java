package br.gov.sp.cps.produtos_soap.endpoint;

import br.gov.sp.cps.produtos_soap.model.ConsultarProdutoRequest;
import br.gov.sp.cps.produtos_soap.model.ConsultarProdutoResponse;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProdutoEndpoint {

    private static final String NAMESPACE = "http://cps.sp.gov.br/produtos";

    @PayloadRoot( namespace = NAMESPACE, localPart = "consultarProdutoRequest"  )
    @ResponsePayload
    public ConsultarProdutoResponse consultarProduto( @RequestPayload ConsultarProdutoRequest request) {

        ConsultarProdutoResponse response =  new ConsultarProdutoResponse();

        if (request.getCodigo() == 123) {

            response.setNome("Notebook BionLite");
            response.setDescricao("Notebook com 16GB de RAM e SSD de 512GB");
            response.setMarca("Avell");
            response.setQuantidadeEstoque(25);

        } else if (request.getCodigo() == 456) {

            response.setNome("Mouse sem fio Harry Potter");
            response.setDescricao("Mouse ergonômico sem fio com sensor de alta precisão collab Harry Potter");
            response.setMarca("Logitech");
            response.setQuantidadeEstoque(20);

        } else {

            response.setNome( "Produto não encontrado" );
            response.setDescricao("-");
            response.setMarca("-");
            response.setQuantidadeEstoque(0);
        }

        return response;
    }
}