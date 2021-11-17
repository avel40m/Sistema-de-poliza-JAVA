package Sistema_Poliza;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Cuota {

    private int numeroCuota;
    private double montoCuota;
    private boolean pagada;
    private Date vencimiento;
    private String tipoPago;

    public Cuota() {
    }

    public Cuota(int numeroCuota, double montoCuota, boolean pagada, Date vencimiento, String tipoPago) {
        this.numeroCuota = numeroCuota;
        this.montoCuota = montoCuota;
        this.pagada = pagada;
        this.vencimiento = vencimiento;
        this.tipoPago = tipoPago;
    }

    public int getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(int numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public double getMontoCuota() {
        return montoCuota;
    }

    public void setMontoCuota(double montoCuota) {
        this.montoCuota = montoCuota;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    @Override
    public String toString() {
        return "Cuota{" + "numeroCuota=" + numeroCuota + ", montoCuota=" + montoCuota + ", pagada=" + pagada + ", vencimiento=" + vencimiento + ", tipoPago=" + tipoPago + '}';
    }

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Cuota crearCuota(int i,String formaPago, double pagoTotal,int cantidadCuota,double asegurado,double granizo) {
        double pagarCuota = 0;
        if(granizo != 0){
            pagarCuota = (pagoTotal + asegurado + granizo) / cantidadCuota;
        }else{
            pagarCuota = (pagoTotal + asegurado) / cantidadCuota;
        }
        
        Cuota c = new Cuota();
        c.setNumeroCuota(i);
        c.setMontoCuota(pagarCuota);
        System.out.println("¿Se pago la cuota "+i+"? - (SI - NO)");
        c.setPagada(controlCuota(c));
        System.out.println("Ingresar la fecha de vencimiento de la cuota");
        c.setVencimiento(pasarFecha(leer.next()));
        c.setTipoPago(formaPago);
        return c;
        
    }

    private boolean controlCuota(Cuota c) {
        String resp = leer.next().toUpperCase();
        if (resp.equals("SI")) {
            return true;
        } else {
            return false;
        }
    }
    
    private Date pasarFecha(String dia){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        
        try {
            fecha = formato.parse(dia);
        } catch (Exception e) {
            System.out.println(e);
        }
        return fecha;
    }
    
}
