/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mis.clases;

import Pilas.Pila;
import miGestión.GestiónMensajería;



/**
 *
 * @author javan
 */
public class ClienteCorporativo {
    private int RUC;
    private String rSocial;
    private Pila listaComprobantes;
    
    public ClienteCorporativo(int RUC, String rSocial) {
        this.RUC = RUC;
        this.rSocial = rSocial;
        this.listaComprobantes = new Pila(); 
    }

    public int getRUC() {
        return RUC;
    }

    public String getrSocial() {
        return rSocial;
    }

    public Pila getListaComprobantes() {
        return listaComprobantes;
    }
    
    public void apilarComprobante(Comprobante c) {
       tarificar(c);
       this.listaComprobantes.apilar(c);
    }
    
    public void tarificar(Comprobante c) {
       Tarificador F = new Tarificador(c);
       F.calcularMonto();
    }
    
    public void mostrarCLiente() {
        System.out.println("\t\tDATOS DEL CLIENTE");
        System.out.println("RUC: " + RUC);
        System.out.println("Razon Social: " + rSocial); 
        this.listaComprobantes.mostrarElementos();
        System.out.println(" ");
        
        
               
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
