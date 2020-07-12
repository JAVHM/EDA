/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miGestión;

import Pilas.Pila;
import colas.Cola;
import mis.clases.ClienteCorporativo;
import mis.clases.Comprobante;

/**
 *
 * @author javan
 */
public class GestiónMensajería {    
    private Cola clientes;
    private float recEncomiendas;
    private float recGiros;

    public GestiónMensajería() {
        this.clientes = new Cola();
        this.recEncomiendas = 0;
        this.recGiros = 0;
    }

    public Cola getClienteCorporativo() {
        return clientes;
    }

    public float getRecEncomiendas() {
        return recEncomiendas;
    }

    public float getRecGiros() {
        return recGiros;
    }
    //ERROR? en encontrar C
    public void encolarClientes(ClienteCorporativo C) {
       this.clientes.encolar(C);
    }
    
    public void encolarCliente(ClienteCorporativo c) {
       this.clientes.encolar(c);
    }
    
    public void mostrarGM() {
        System.out.println("\t\tDATOS DE LA GESTIÓN");
        this.clientes.mostrarElementosCola();
        System.out.println(" ");       
    }
    
    public void mostrarRecaudación() { 
        ClienteCorporativo cliente;
        Comprobante c;
        Pila aux = new Pila();
        while(!this.clientes.estaVacia()) {             
            cliente = this.clientes.desencolar();
            while(!cliente.getListaComprobantes().estaVacia()) {
                c = cliente.getListaComprobantes().desapilar(); 
                if(c.getTipo() == 1) {                    
                    this.recGiros = this.recGiros + c.getMonto();
                }else {                    
                    this.recEncomiendas = this.recEncomiendas + c.getMonto();
                }  
                aux.apilar(c);
            } 
            while(!aux.estaVacia()) {
                cliente.getListaComprobantes().apilar(aux.desapilar());
            }            
        } 
    }
    
    public static void main(String[] args) {  
        GestiónMensajería GM = new GestiónMensajería();       
        
        //Este es el cliente 1 a encolar en el gestor de mensajerías
        ClienteCorporativo cliente = new ClienteCorporativo(2589, "Casado");
        Comprobante c = new Comprobante(1, "A", "B", "07/05/2020", 2); 
        Comprobante c2 = new Comprobante(2, "B", "C", "07/05/2020", 3);  
        Comprobante c5 = new Comprobante(1, "C", "D", "07/05/2020", 6);  
        cliente.apilarComprobante(c);
        cliente.apilarComprobante(c2);
        cliente.apilarComprobante(c5);
        //cliente.mostrarCLiente();


        //Este es el cliente 2 a encolar en el gestor de mensajerías
        ClienteCorporativo cliente2 = new ClienteCorporativo(2589, "Casado");
        Comprobante c3 = new Comprobante(1, "D", "A", "07/05/2020", 4); 
        Comprobante c4 = new Comprobante(2, "B", "B", "07/05/2020", 5);
        cliente2.apilarComprobante(c3);
        cliente2.apilarComprobante(c4);
        //cliente2.mostrarCLiente();
        
        GM.encolarCliente(cliente);
        GM.encolarCliente(cliente2);
        GM.mostrarGM(); 
        GM.mostrarRecaudación();               
        System.out.println("Recaudacion de giros: " + GM.getRecGiros());
        System.out.println("Recaudacion de encomiendas: " + GM.getRecEncomiendas());
        cliente.mostrarCLiente();
        cliente2.mostrarCLiente();
    }
}
