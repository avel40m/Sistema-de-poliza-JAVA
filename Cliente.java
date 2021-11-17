package Sistema_Poliza;

import java.util.Scanner;

public class Cliente {
    
    private String nombre;
    private String apellido;
    private String documento;
    private String mail;
    private String telefono;
    
    public Cliente() {
    }
    
    public Cliente(String nombre, String apellido, String documento, String mail, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.mail = mail;
        this.telefono = telefono;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        if (!nombre.isEmpty()) {
            this.nombre = nombre;
        } else {
            System.out.println("El campo no tiene que ser vacio");
        }
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        if (!apellido.isEmpty()) {
            this.apellido = apellido;
        } else {
            System.out.println("El campo no tiene que ser vacio");
        }
    }
    
    public String getDocumento() {
        return documento;
    }
    
    public void setDocumento(String documento) {
        if (documento.length() == 8) {
            this.documento = documento;
        } else {
            System.out.println("No tiene los 8 caracteres");
        }
    }
    
    public String getMail() {
        return mail;
    }
    
    public void setMail(String mail) {
        boolean band = false;
        if (!mail.isEmpty()) {
            for (int i = 0; i < mail.length(); i++) {
                if (mail.charAt(i) == '@') {
                    System.out.println("Se valido el correo");
                    this.mail = mail;
                    band=true;
                    break;
                }
            }
            if (band = false) {
                System.out.println("No se valido el mail, no se guardo el campo");
            }
            
        } else {
            System.out.println("El campo esstá vacio");
        }
        
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        if (telefono.length() >= 6) {
            this.telefono = telefono;
        } else {
            System.out.println("No se guardo el número telefonico, debe contar con 8 caracteres");
        }
    }
    
    @Override
    public String toString() {
        return "Datos del cliente: {"
                + "nombre: " + nombre + ", apellido: " + apellido + ", documento: " + documento + ""
                + ", mail: " + mail + ", telefono: " + telefono + '}';
    }
    
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Cliente crearCliente() {
        Cliente c = new Cliente();
        System.out.println("Ingrsar el nombre del cliente");
        c.setNombre(leer.next());
        System.out.println("Ingrese el apellido del cliente");
        c.setApellido(leer.next());
        System.out.println("Ingrese el documento del cliente");
        c.setDocumento(leer.next());
        System.out.println("Ingrese el correo electronico del cliente");
        c.setMail(leer.next());
        System.out.println("Ingrese el telefono del cliente");
        c.setTelefono(leer.next());
        return c;
    }
    
}
