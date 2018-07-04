/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.softplan.siegen.domain;

import br.com.softplan.siegen.exceptions.CalculoTransporteCargasException;
import br.com.softplan.siegen.util.TipoTransporteEnum;

/**
 *
 * @author Tron
 */
public class CalculoTransporteCargas {

    private final float valorRodoviaPavimentadaPorKm;
    private final float valorRodoviaNaoPavimentadaPorKm;
    private final float fatorMultiplicadorCaminhaoBau;
    private final float fatorMultiplicadorCaminhaoCacamba;
    private final float fatorMultiplicadorCarreta;

    public CalculoTransporteCargas() {
        this.fatorMultiplicadorCarreta = 1.12f;
        this.fatorMultiplicadorCaminhaoBau = 1.0f;
        this.fatorMultiplicadorCaminhaoCacamba = 1.05f;
        this.valorRodoviaPavimentadaPorKm = 0.54f;
        this.valorRodoviaNaoPavimentadaPorKm = 0.62f;
    }

    public float caularTransporteCargas(float distanciaPavimentada, float distanciaNaoPavimentada, TipoTransporteEnum tipoTransporte, int quantidadeCargaTransportada) throws CalculoTransporteCargasException {
        float fatorMultiplicador = fatorMultiplicador(tipoTransporte);
        float custoNaoPavimentada = 0.0f;
        float custoPavimentada = 0.0f;
        if (distanciaNaoPavimentada != 0) {
            custoNaoPavimentada = verificarCustoCustoNaoPavimentada(quantidadeCargaTransportada, distanciaNaoPavimentada);
        }
        if (distanciaPavimentada != 0) {
            custoPavimentada = verificarCustoCustoPavimentada(quantidadeCargaTransportada, distanciaPavimentada);
        }

        return (custoNaoPavimentada + custoPavimentada) * fatorMultiplicador;
    }

    private float fatorMultiplicador(TipoTransporteEnum tipoTransporte) throws CalculoTransporteCargasException {
        try {
            switch (tipoTransporte) {
                case CAMINHAO_BAU:
                    return this.fatorMultiplicadorCaminhaoBau;
                case CAMINHAO_CACAMBA:
                    return this.fatorMultiplicadorCaminhaoCacamba;
                case CARRETA:
                    return this.fatorMultiplicadorCarreta;
                default:
                    throw new CalculoTransporteCargasException("Erro ao obter tipo de transporte");
            }
        } catch (NullPointerException e) {
            throw new CalculoTransporteCargasException("Tipo transporte nulo");
        }
    }

    public float verificarCustoCustoNaoPavimentada(int quantidadeCarga, float distancia) {
        if (quantidadeCarga <= 5) {
            return this.valorRodoviaNaoPavimentadaPorKm * distancia;
        }
        return (float) ((((quantidadeCarga - 5) * 0.02) + this.valorRodoviaNaoPavimentadaPorKm) * distancia);
    }

    public float verificarCustoCustoPavimentada(int quantidadeCarga, float distancia) {
        if (quantidadeCarga <= 5) {
            return this.valorRodoviaPavimentadaPorKm * distancia;
        }
        return (float) ((((quantidadeCarga - 5) * 0.02) + this.valorRodoviaPavimentadaPorKm) * distancia);
    }
}
