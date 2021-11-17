package Sistema_Poliza;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Poliza {

    private Cliente cliente;
    private Vehiculo vehiculo;
    private int numeroPoliza;
    private Date inicio;
    private Date fin;
    private int cantidadCuota;
    private String formaPago;
    private double pagoTotal;
    private double montoAsegurado;
    private boolean granizo;
    private double montoGranizo;
    private String tipoPoliza;
    private ArrayList<Cuota> cuotas;

    public Poliza() {
    }

    public Poliza(Cliente cliente, Vehiculo vehiculo, int numeroPoliza, Date inicio, Date fin, int cantidadCuota, String formaPago, double pagoTotal, double montoAsegurado, boolean granizo, double montoGranizo, String tipoPoliza, ArrayList<Cuota> cuotas) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.numeroPoliza = numeroPoliza;
        this.inicio = inicio;
        this.fin = fin;
        this.cantidadCuota = cantidadCuota;
        this.formaPago = formaPago;
        this.pagoTotal = pagoTotal;
        this.montoAsegurado = montoAsegurado;
        this.granizo = granizo;
        this.montoGranizo = montoGranizo;
        this.tipoPoliza = tipoPoliza;
        this.cuotas = cuotas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(int numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public boolean isGranizo() {
        return granizo;
    }

    public void setGranizo(boolean granizo) {
        this.granizo = granizo;
    }

    public double getMontoGranizo() {
        return montoGranizo;
    }

    public void setMontoGranizo(double montoGranizo) {
        this.montoGranizo = montoGranizo;
    }

    public String getTipoPoliza() {
        return tipoPoliza;
    }

    public void setTipoPoliza(String tipoPoliza) {
        boolean band = false;
        for (int i = 0; i < tipoDeCorbertura.length; i++) {
            if (tipoDeCorbertura[i].equals(tipoPoliza)) {
                System.out.println("Se guardo correctamente");
                this.tipoPoliza = tipoPoliza;
                band = true;
                break;
            }
        }
        if (band == false) {
            System.out.println("No se guardoo el dato");
        }
    }

    public int getCantidadCuota() {
        return cantidadCuota;
    }

    public void setCantidadCuota(int cantidadCuota) {
        this.cantidadCuota = cantidadCuota;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        boolean band = false;
        for (int i = 0; i < formaDePago.length; i++) {
            if (formaDePago[i].equals(formaPago)) {
                System.out.println("Se guardo opción");
                this.formaPago = formaPago;
                band = true;
                break;
            }

        }
        if (band == false) {
            System.out.println("No se pudo guardar el dato");
        }
    }

    public double getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(double pagoTotal) {
        this.pagoTotal = pagoTotal;
    }

    public double getMontoAsegurado() {
        return montoAsegurado;
    }

    public void setMontoAsegurado(double montoAsegurado) {
        this.montoAsegurado = montoAsegurado;
    }

    public ArrayList<Cuota> getCuotas() {
        return cuotas;
    }

    public void setCuotas(ArrayList<Cuota> cuotas) {
        this.cuotas = cuotas;
    }

    @Override
    public String toString() {
        return cliente + ",\n" + vehiculo + ",\n"
                + "Datos de poliza { numeroPoliza: " + numeroPoliza + ", inicio: " + inicio + ", fin: " + fin + ", "
                + "granizo: " + granizo + ", montoGranizo: " + montoGranizo + ", tipoPoliza: "
                + "" + tipoPoliza + '}' + "\nDatos de cuotas: " + cuotas;
    }

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    private static String[] formaDePago = {"Efectivo", "Tarjeta de credito", "Tarjeta de debito"};
    private static String[] tipoDeCorbertura = {"Tercero", "Robo", "Total", "Parcial"};

    private void verFormaPago() {
        System.out.println("---Seleccion de pago---");
        for (int i = 0; i < formaDePago.length; i++) {
            System.out.println(formaDePago[i]);
        }
    }

    private void verTipoCobertura() {
        System.out.println("---Lista de corbertura---");
        for (int i = 0; i < tipoDeCorbertura.length; i++) {
            System.out.println(tipoDeCorbertura[i]);
        }
    }

    public Poliza crearPoliza() {
        Poliza p = new Poliza();
        System.out.println("Ingrese el número de poliza");
        p.setNumeroPoliza(leer.nextInt());
        System.out.println("Ingrese la fecha de inicio de la poliza");
        p.setInicio(pasarFecha(leer.next()));
        System.out.println("Ingresar la fecha final de la poliza");
        p.setFin(pasarFecha(leer.next()));
        System.out.println("Ingrese la cantidad de cuota");
        p.setCantidadCuota(leer.nextInt());
        System.out.println("Ingrese la forma de pago");
        verFormaPago();
        p.setFormaPago(leer.next());
        System.out.println("Ingrese el pago total de la poliza");
        p.setPagoTotal(leer.nextDouble());
        System.out.println("Ingresar el pago asegurado");
        p.setMontoAsegurado(leer.nextDouble());
        System.out.println("incluye seguro contra granizo");
        p.setGranizo(granizoR(leer.next()));
        pagoContraGranizo(p, leer);
        System.out.println("Elija el tipo de corbertura");
        verTipoCobertura();
        p.setTipoPoliza(leer.next());
        System.out.println("---Crear cuotas---");
        crearCuota(p);
        return p;
    }

    private static Date pasarFecha(String date) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        try {
            fecha = formato.parse(date);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return fecha;
    }

    private boolean granizoR(String resp) {
        if (resp.equals("si")) {
            return true;
        } else {
            return false;
        }
    }

    private static void pagoContraGranizo(Poliza p, Scanner leer) {
        if (p.isGranizo() == true) {
            System.out.println("Ingrese el monoto maximo de granizo");
            p.setMontoGranizo(leer.nextDouble());
        }
    }

    private void crearCuota(Poliza p) {
        ArrayList<Cuota> cuotas = new ArrayList();
        for (int i = 1; i < p.getCantidadCuota(); i++) {
            Cuota c = new Cuota();
            cuotas.add(c.crearCuota(i, p.getFormaPago(),p.getPagoTotal(),p.getCantidadCuota(),p.getMontoAsegurado(),p.getMontoGranizo()));
        }
        p.setCuotas(cuotas);
    }
}
