import java.util.*;
class Nodo {
    int dato;
    Nodo siguiente;
    public Nodo(int dato){
        this.dato=dato;
        this.siguiente=null;
    }
}

class Lista{
    Nodo cabeza;
    public Lista(){
        this.cabeza=null;
    }

    public void insertarDatos(int dato){
        Nodo nodoNuevo= new Nodo(dato);
        if (cabeza==null) {
            cabeza=nodoNuevo;
            return;
        }
        Nodo actual=cabeza;
        while (actual.siguiente!=null) {
            actual=actual.siguiente;
        }
        actual.siguiente=nodoNuevo;
    }
    public void eliminar(int valor){
        if (cabeza==null) {
            return;
        }
        if (cabeza.dato==valor) {
            cabeza=cabeza.siguiente;
            return;
        }
        Nodo actual=cabeza;
        while(actual.siguiente!=null && actual.siguiente.dato!=valor){
            actual=actual.siguiente;
        }
        if (actual.siguiente!=null) {
            actual.siguiente=actual.siguiente.siguiente;
        }
    }
    public void modificar(int datoanterior, int datonuevo){
        Nodo actual =cabeza;
        while (actual!=null) {
            if (actual.dato==datoanterior) {
                actual.dato=datonuevo;
                return;
            }
            actual=actual.siguiente;
        }
    }
    public void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("NULL");
    }
}

public class ListasEnlazadas {
    public static void main(String[] args) {
        Lista lista1 =new Lista();
        Scanner sc= new Scanner(System.in);
        int op;
        do {
            System.out.println("Escriba alguna de las sigientes opciones \n 1) agregar elemento a la lista \n 2) Eliminar elemento de la lista \n 3) modificar elemento de la lista \n 4) Mostrar lista \n 5) salir del programa");
            op=sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Escriba el dato a guardar en la lista");
                    int a = sc.nextInt();
                    lista1.insertarDatos(a);
                    break; 
            
                case 2:
                    System.out.println("Escriba el dato a eliminar");
                    a = sc.nextInt();
                    lista1.eliminar(a);
                    break;
                case 3:
                    System.out.println("Escriba dato a modificar");
                    a = sc.nextInt();
                    System.out.println("Escriba nuevo dato a ingresar");
                    int b=sc.nextInt();
                    lista1.modificar(a, b);
                    break;
                case 4:
                    System.out.println("Mostrando lista");
                    lista1.mostrar();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break   ;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (op!=5);
    }
}

