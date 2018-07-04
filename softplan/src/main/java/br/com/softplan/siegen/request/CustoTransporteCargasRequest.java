/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.softplan.siegen.request;

import br.com.softplan.siegen.util.TipoTransporteEnum;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @author Tron
 */
public class CustoTransporteCargasRequest {
    
    @ApiModelProperty(notes="Distancia em quilometros de rodovia pavimentada")
    private float distanciaPavimentada;
    
    @ApiModelProperty(notes="Distancia em quilometros de rodovia nao pavimentada")
    private float distanciaNaoPavimentada;
    
    @ApiModelProperty(notes="Tipo de transporte")
    private TipoTransporteEnum tipoTransporte;
    
    @ApiModelProperty(notes="Quantidade de carga transportada")
    private int cargaTransportada;
    
    public CustoTransporteCargasRequest() {
    }

    public float getDistanciaPavimentada() {
        return distanciaPavimentada;
    }

    public void setDistanciaPavimentada(float distanciaPavimentada) {
        this.distanciaPavimentada = distanciaPavimentada;
    }

    public float getDistanciaNaoPavimentada() {
        return distanciaNaoPavimentada;
    }

    public void setDistanciaNaoPavimentada(float distanciaNaoPavimentada) {
        this.distanciaNaoPavimentada = distanciaNaoPavimentada;
    }

    public TipoTransporteEnum getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(TipoTransporteEnum tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public int getCargaTransportada() {
        return cargaTransportada;
    }

    public void setCargaTransportada(int cargaTransportada) {
        this.cargaTransportada = cargaTransportada;
    }

}
