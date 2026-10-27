package br.gov.sp.cps.produtos_soap.endpoint;

import br.gov.sp.cps.produtos_soap.exception.ProdutoNaoEncontradoException;
import br.gov.sp.cps.produtos_soap.model.ConsultarProdutoRequest;
import br.gov.sp.cps.produtos_soap.model.ConsultarProdutoResponse;
import br.gov.sp.cps.produtos_soap.model.ConsultarProdutoRequest;
//import br.gov.sp.cps.produtos_soap.model.ConsultarProdutoResponse;

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
        } else {

        throw new ProdutoNaoEncontradoException(
                "Produto não encontrado: " + request.getCodigo());
        }
        return response;
    }
}