/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pilas;

import mis.clases.Comprobante;

/**
 *
 * @author andon
 */
public interface InterfazPila {
    public void apilar(Comprobante c);
    public Comprobante desapilar();
    public boolean estaVacia();
}
