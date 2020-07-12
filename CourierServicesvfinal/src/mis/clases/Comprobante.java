/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mis.clases;
import java.util.Date;
/**
 *
 * @author javan
 */
public class Comprobante {    
    private int tipo;
    private String ciudad_origen;
    private String ciudad_destino;
    private String fecha;
    private float monto;

    public Comprobante(int tipo, String ciudad_origen, String ciudad_destino, String fecha, float monto) {
        this.tipo = tipo;
        this.ciudad_origen = ciudad_origen;
        this.ciudad_destino = ciudad_destino;
        this.fecha = fecha;
        this.monto = monto;
    }    
    
    public int getTipo() {
        return tipo;
    }

    public String getCiudad_origen() {
        return ciudad_origen;
    }

    public void setCiudad_origen(String ciudad_origen) {
        this.ciudad_origen = ciudad_origen;
    }

    public String getCiudad_destino() {
        return ciudad_destino;
    }

    public void setCiudad_destino(String ciudad_destino) {
        this.ciudad_destino = ciudad_destino;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }   

    public void mostrar() {
        System.out.println("COMPROBANTE");
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Ciudad de origen: " + this.getCiudad_origen());
        System.out.println("Ciudad de destino: " + this.getCiudad_destino());
        System.out.println("Fecha: " + this.getFecha());
        System.out.println("Monto: " + this.getMonto());        
    }
}
