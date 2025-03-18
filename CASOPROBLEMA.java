import java.util.*;

class Nodo {
    String nombre;
    String email;
    long numero;
    Nodo siguiente;

    public Nodo(String nombre, String email, long numero) {
        this.nombre = nombre;
        this.email = email;
        this.numero = numero;
        this.siguiente = null;
    }
}

class Lista {
    Nodo cabeza;

    public Lista() {
        this.cabeza = null;
    }
    public boolean verificador(String nombre){
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.nombre.equals(nombre)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }
    public void insertarDatos(String nombre, String email, long numero) {
        if (verificador(nombre)) {
            System.out.println("El contacto ya existe.");
            return;
        }
        Nodo nuevoNodo = new Nodo(nombre, email, numero);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public void eliminar(String valor) {
        Nodo actual = cabeza;
        Nodo prev = null;
        if (actual != null && actual.nombre != null && actual.nombre.equals(valor)) {
            cabeza = actual.siguiente;
            return;
        }
        while (actual != null && !actual.nombre.equals(valor)) {
            prev = actual;
            actual = actual.siguiente;
        }
        if (actual == null)
            return;
        prev.siguiente = actual.siguiente;
    }

    public void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println(" Nombre: "+actual.nombre + ".\n Email: " + actual.email + ".\n Telefono: " + actual.numero
                    + ".\n---------------------------------------");
            actual = actual.siguiente;
        }
        System.out.println("NULL");
    }
}

public class CASOPROBLEMA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lista listaContactos = new Lista();
        long numero;
        int opcion;
        String email;
        String nombre;
        listaContactos.insertarDatos("Pepito", "Pepito1234@gmail.com",  1234567890);
        listaContactos.insertarDatos("Ana", "ANAlisis@gmail.com", 789456123);

        System.out.println("Bienvenido al sistema de contactos.");

        do {
            System.out.println("¿Que accion desea realizar?");
            System.out.println("1. Agregar un contacto.");
            System.out.println("2. Eliminar un contacto.");
            System.out.println("3. Modificar un contacto.");
            System.out.println("4. Consultar contactos.");
            System.out.println("5. Salir.");
            System.out.println("Seleccione la accion que desea realizar: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("Ingrese el nombre del contacto: ");
                    nombre = scanner.nextLine();
                    System.out.println("Ingrese el email del contacto: ");
                    email = "Hola@gmail";
                    System.out.println("Ingrese el número de teléfono del contacto: ");
                    numero = scanner.nextLong();
                    scanner.nextLine();
                    listaContactos.insertarDatos(nombre, email, numero);
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del contacto que desea eliminar: ");
                    nombre = scanner.nextLine();
                    listaContactos.eliminar(nombre);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del contacto que desea modificar: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese el nuevo email: ");
                    email = scanner.nextLine();
                    System.out.print("Ingrese el nuevo numero de telefono: ");
                    numero = scanner.nextLong();
                    listaContactos.eliminar(nombre);
                    listaContactos.insertarDatos(nombre, email, numero);
                    break;

                case 4:
                    listaContactos.mostrar();
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;
            }

        } while (opcion != 5);
        scanner.close();

    }

}