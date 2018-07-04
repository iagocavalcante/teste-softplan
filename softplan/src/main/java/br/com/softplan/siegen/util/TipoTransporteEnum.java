/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.softplan.siegen.util;

/**
 *
 * @author Tron
 */
public enum TipoTransporteEnum {
    CAMINHAO_BAU(1),
    CAMINHAO_CACAMBA(2),
    CARRETA(3);
    
    public int tipoTransporte;

    private TipoTransporteEnum(int tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }
    
    public int getTipoTransporte() {
        return this.tipoTransporte;
    }
   
}
