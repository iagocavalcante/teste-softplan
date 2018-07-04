/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.softplan.siegen.controller;

import br.com.softplan.siegen.domain.CalculoTransporteCargas;
import br.com.softplan.siegen.exceptions.CalculoTransporteCargasException;
import br.com.softplan.siegen.response.CustoTransporteCargasResponse;
import br.com.softplan.siegen.request.CustoTransporteCargasRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Tron
 */
@RestController
@RequestMapping("/api")
@Api(description = "Calculo de Custo de Transporte de Cargas")
@CrossOrigin(origins = "*")
public class CustoTransporteCargasController {

    private static Logger logger = LoggerFactory.getLogger(CustoTransporteCargasController.class);

    RestTemplate rest;
    CalculoTransporteCargas calculoTransporteCargas = new CalculoTransporteCargas();

    public CustoTransporteCargasController(RestTemplateBuilder builder) {
        this.rest = builder.build();
    }

    @RequestMapping(value = "/calcular-transporte-cargas", consumes = "application/json", method = RequestMethod.POST)
    @ApiOperation(value = "Calcular valor transporte de cargas")
    public ResponseEntity<CustoTransporteCargasResponse> calcularTransporteCargas(@RequestBody CustoTransporteCargasRequest request) throws CalculoTransporteCargasException {
        logger.info("[REQUEST]: " + request.toString());
        logger.info("[REQUEST]: " + request.getTipoTransporte());

        CustoTransporteCargasResponse response = new CustoTransporteCargasResponse();

        try {
            response.setCustoTransporte(
                    calculoTransporteCargas.caularTransporteCargas(
                            request.getDistanciaPavimentada(),
                            request.getDistanciaNaoPavimentada(),
                            request.getTipoTransporte(),
                            request.getCargaTransportada()));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (CalculoTransporteCargasException ex) {
            logger.error("[ERROR]: " + ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    }
}
