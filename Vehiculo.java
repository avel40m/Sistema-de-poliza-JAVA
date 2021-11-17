package Sistema_Poliza;

import java.util.Scanner;

public class Vehiculo {

    private String marca;
    private String modelo;
    private int ano;
    private String motor;
    private String chasis;
    private String color;
    private String tipo;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, int ano, String motor, String chasis, String color, String tipo) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.motor = motor;
        this.chasis = chasis;
        this.color = color;
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        boolean band = false;
        for (int i = 0; i < marcasVehiculo.length; i++) {
            if (marcasVehiculo[i].equals(marca)) {
                System.out.println("Se guardo correctamente");
                this.marca = marca;
                band = true;
                break;
            }
        }
        if (band == false) {
            System.out.println("No se pudo guardar el dato");
        }
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        boolean band = false;
        for (int i = 0; i < chasisVehiculos.length; i++) {
            if (chasisVehiculos[i].equals(chasis)) {
                System.out.println("Se guardo correctamente");
                this.chasis = chasis;
                band = true;
                break;
            }
        }
        if(band == false)
            System.out.println("No se pudo guardar el dato");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        boolean band = false;
        for (int i = 0; i < tipoVehiculo.length; i++) {
            if(tipoVehiculo[i].equals(tipo)){
                System.out.println("Se guardo correctamente");
                this.tipo = tipo;
                band = true;
                break;
            }
        }
        if(band == false){
            System.out.println("No se pudo guardar el dato");
        }
    }

    @Override
    public String toString() {
        return "Datos del vehiculo{" + "marca: " + marca + ", modelo: " + modelo + ", ano: " + ano + ""
                + ", motor: " + motor + ", chasis: " + chasis + ", color: " + color + ", tipo:"
                + " " + tipo + '}';
    }

    private static String[] marcasVehiculo = {"Audi", "Chevrolet", "Honda", "Peugeot", "Toyota"};

    private void mostrarMarcas() {
        System.out.println("---Listado de Marcas Disponibles---");
        for (int i = 0; i < marcasVehiculo.length; i++) {
            System.out.println(marcasVehiculo[i]);
        }
    }

    private static String[] chasisVehiculos = {"Metal", "Plastico", "Acero"};

    private void mostrarChasis() {
        System.out.println("---Listado de chasis---");
        for (int i = 0; i < chasisVehiculos.length; i++) {
            System.out.println(chasisVehiculos[i]);
        }
    }

    private static String[] tipoVehiculo = {"Auto", "Camión", "Traffit", "Cangoo"};

    private void mostrarTipo() {
        System.out.println("---Listado de tipo de vehiculo---");
        for (int i = 0; i < tipoVehiculo.length; i++) {
            System.out.println(tipoVehiculo[i]);
        }
    }

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Vehiculo crearVehiculo() {
        Vehiculo v = new Vehiculo();
        mostrarMarcas();
        System.out.println("Seleccionar marca del vehiculo");
        v.setMarca(leer.next());
        System.out.println("Ingrese al modelo del vehiculo");
        v.setModelo(leer.next());
        System.out.println("Ingresar el año del vehiculo");
        v.setAno(leer.nextInt());
        System.out.println("Ingrese el motor del vehiculo");
        v.setMotor(leer.next());
        mostrarChasis();
        System.out.println("Ingrese el chasis del vehiculo");
        v.setChasis(leer.next());
        System.out.println("Ingresar el color del vehiculo");
        v.setColor(leer.next());
        mostrarTipo();
        System.out.println("Ingrese el tipo del vehiculo");
        v.setTipo(leer.next());
        return v;
    }
}
