package Sistema_Poliza;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        ArrayList<Poliza> polizas = new ArrayList();
        
        System.out.println("--Seccion de poliza---");
        System.out.println("Crear vehiculo");
        Vehiculo vehiculo = new Vehiculo();
        Vehiculo v = vehiculo.crearVehiculo();
        System.out.println("Crear cliente");
        Cliente cliente = new Cliente();
        Cliente c = cliente.crearCliente();
        System.out.println("Sector de polizas");
        Poliza poliza = new Poliza();
        Poliza p = poliza.crearPoliza();
        p.setVehiculo(v);
        p.setCliente(c);
      
        
        polizas.add(p);
        
        System.out.println("----Datos de la poliza----");
        System.out.println(p.toString());
    }
    
}
