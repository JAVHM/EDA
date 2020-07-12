/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mis.clases;

import miGestión.GestiónMensajería;

/**
 *
 * @author SEBASTIAM
 */
public class Tarificador {
    private Comprobante c;   
    private static final float montoKM = 20.56f;
    private int[][] distancias={{0,1,3,7},
                               {1,0,4,8},
                               {3,4,0,5},
                               {7,8,5,0}};
    private String[] ciudadOrigen = {"A","B","C","D"};
    private String[] ciudadDestino = {"A","B","C","D"};

    public Tarificador(Comprobante c) {
        this.c = c;
    } 

    public Comprobante getC() {
        return c;
    }

    public float getMontoKM() {
        return montoKM;
    }
    
    public void calcularMonto() {
        float monto = 0;
        for(int i = 0; i < distancias.length; i++) {
            for(int j = 0; j < distancias[i].length; j++) {
                if(c.getCiudad_origen().equals(ciudadOrigen[i]) && c.getCiudad_destino().equals(ciudadDestino[j])) {
                    monto = distancias[i][j] * montoKM;
                }
            }
        }
        c.setMonto(monto);
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
