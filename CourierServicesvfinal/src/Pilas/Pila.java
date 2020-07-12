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
public class Pila implements InterfazPila{
    public Comprobante[] datos;
    private int cima;
    private static final int TAM_MAX = 50;
    
    public Pila(){
        datos = new Comprobante[TAM_MAX];
        cima = -1;
    }
    
    public boolean estaVacia(){
        boolean estado = (cima == -1);
        return estado;
    }
    
    public boolean estaLlena(){
        boolean estado = (cima + 1 == TAM_MAX);
        return estado;
    }
    
    public void apilar(Comprobante c){
        if(!this.estaLlena()){
            cima++;
            datos[cima] = c;
        }
    }
    
    public Comprobante desapilar(){
        Comprobante c = null;
        if(!this.estaVacia()){
            c = datos[cima];
            cima--;
        }
        return c;
    }
    
    public void mostrarElementos(){        
        for(int i = 0; i <= cima; i++){
            datos[i].mostrar();
        }        
    }
}
