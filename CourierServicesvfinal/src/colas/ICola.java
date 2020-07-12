/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colas;

import mis.clases.ClienteCorporativo;

/**
 *
 * @author JC
 */
public interface ICola {
    public boolean estaVacia();
    public ClienteCorporativo desencolar();
    public void encolar(ClienteCorporativo valor);
}
