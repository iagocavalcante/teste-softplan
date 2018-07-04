package br.com.softplan.siegen;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import br.com.softplan.siegen.controller.CustoTransporteCargasController;
import br.com.softplan.siegen.request.CustoTransporteCargasRequest;
import br.com.softplan.siegen.response.CustoTransporteCargasResponse;
import br.com.softplan.siegen.util.TipoTransporteEnum;

@RunWith(SpringRunner.class)
@RestClientTest(CustoTransporteCargasController.class)
public class CustoTransporteCargasControllerTest {

    @Autowired
    CustoTransporteCargasController controller;

    @Autowired
    private MockRestServiceServer server;

    @Test
    public void calculoEfetuadoComSucesso() throws Exception {
        CustoTransporteCargasRequest request = new CustoTransporteCargasRequest();
        request.setCargaTransportada(6);
        request.setDistanciaNaoPavimentada(20);
        request.setDistanciaPavimentada(80);
        request.setTipoTransporte(TipoTransporteEnum.CAMINHAO_BAU);

        CustoTransporteCargasResponse apiResponse = new CustoTransporteCargasResponse();

        apiResponse.setCustoTransporte(57.600002f);

        this.server.expect(requestTo("/api/calcular-transporte-cargas")).andRespond(withSuccess());

        ResponseEntity<CustoTransporteCargasResponse> resp = this.controller.calcularTransporteCargas(request);
        assertEquals(HttpStatus.OK, resp.getStatusCode());
        assertEquals(apiResponse.getCustoTransporte(), resp.getBody().getCustoTransporte(), 0);
    }
    
    @Test
    public void requestSemParametroTipoTransporte() throws Exception {
        CustoTransporteCargasRequest request = new CustoTransporteCargasRequest();
        request.setCargaTransportada(6);
        request.setDistanciaNaoPavimentada(20);
        request.setDistanciaPavimentada(80);

        CustoTransporteCargasResponse apiResponse = new CustoTransporteCargasResponse();

        apiResponse.setCustoTransporte(57.600002f);

        this.server.expect(requestTo("/api/calcular-transporte-cargas")).andRespond(withSuccess());

        ResponseEntity<CustoTransporteCargasResponse> resp = this.controller.calcularTransporteCargas(request);
        assertEquals(HttpStatus.BAD_REQUEST, resp.getStatusCode());
    }
}
