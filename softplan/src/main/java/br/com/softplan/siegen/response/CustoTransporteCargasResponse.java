/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.softplan.siegen.response;

/**
 *
 * @author Tron
 */
public class CustoTransporteCargasResponse {

    private float custoTransporte;

    public CustoTransporteCargasResponse() {
    }

    public float getCustoTransporte() {
        return custoTransporte;
    }

    public void setCustoTransporte(float custoTransporte) {
        this.custoTransporte = custoTransporte;
    }

    @Override
    public String toString() {
        return "{\"custoTransporte\": " + custoTransporte + "\"}";
    }

}
