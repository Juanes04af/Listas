import java.util.Scanner;
class Pokemon {
    String name;
    int level;
    double experienciaGuardada;
    int expMax;
    Pokemon next;
    public Pokemon(String name, int level) {
        this.name = name;
        this.level = level;
        this.experienciaGuardada=0;
        this.expMax=30+20*level;
        this.next = null;
    }
}
class Pokedex {
    private Pokemon head;
    public void addPokemon(String name, int level) {
        Pokemon newPokemon = new Pokemon(name, level);
        if (head == null) {
            head = newPokemon;
            return;
        }
        Pokemon temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newPokemon;
        System.out.println("Pokémon " + name + " agregado exitosamente.");
    }
    public void removePokemon(String name) {
        Pokemon temp = head, prev = null;
        if (temp != null && temp.name.equals(name)) {
            head = temp.next;
            return;
        }
        while (temp != null && !temp.name.equals(name)) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) return;
        prev.next = temp.next;
    }
    public void showPokedex() {
        Pokemon temp = head;
        if (temp==null) {
            System.out.println("No hay Pokemones en la lista.");
            return;
        }
        while (temp != null) {
            System.out.print("Nombre: " + temp.name + "\nNivel: " + temp.level + "\nExperiencia: " + temp.experienciaGuardada + "/" + temp.expMax + "\n\n");
            temp = temp.next;
        }
    }
    public void Actualizarnivel(double Exp, String name) {
        Pokemon temp = head;
        while (temp != null) {
            if (temp.name.equals(name)) {
                temp.experienciaGuardada += Exp; 
                while (temp.experienciaGuardada >= temp.expMax && temp.level < 100) { 
                    temp.experienciaGuardada -= temp.expMax; 
                    temp.level += 1;                 
                    temp.expMax = 30 + 20 * temp.level;
                }
                if (temp.level == 100) {
                    temp.experienciaGuardada = 0; 
                }
            }else{
                System.out.println("Pokémon no encontrado.");
                return;
            }
            temp = temp.next;
            System.out.println(name + ". Nuevo nivel: " + temp.level);
        }
    }
    public void mostrarPokemon(String name){
        Pokemon temp = head;
        while (temp != null) {
            if (temp.name.equals(name)){
                System.out.println("Pokemon: "+temp.name+"\nLevel: +"+temp.level+"\nExperiencia: "+temp.experienciaGuardada+"/"+temp.expMax);
            }
            temp = temp.next;
        }
    }
}
public class PokedexMejorado{
    public static void main(String[] args) {
        Pokedex pokedex = new Pokedex();
        pokedex.addPokemon("Pikachu", 10);
        pokedex.addPokemon("Charizard", 36);
        pokedex.addPokemon("Bulbasaur", 5);
        System.out.println("Bienvenido a la Pokedex.");
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
        System.out.println("Escriba alguna de las siguientes opciones: \n1) Agregar Pokémon \n2) Eliminar Pokémon \n3) Mostrar Pokedex \n4) Mostrar Pokémon \n5) Actualizar nivel \n6) Salir");
        opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion) {
            case 1:
                System.out.println("Escriba el nombre del Pokémon a agregar.");
                String nombre = scanner.nextLine();
                System.out.println("Escriba el nivel del Pokémon.");
                int nivel = scanner.nextInt();
                pokedex.addPokemon(nombre, nivel);              
                break;
            case 2:
                System.out.println("Escriba el nombre del Pokémon a eliminar.");
                nombre = scanner.nextLine();
                pokedex.removePokemon(nombre);
                break;
            case 3:
                pokedex.showPokedex();
                break;
            case 4:
                System.out.println("Escriba el nombre del Pokémon a mostrar.");
                nombre = scanner.nextLine();
                pokedex.mostrarPokemon(nombre);
                break;
            case 5:
                System.out.println("Escriba el nombre del Pokémon a actualizar.");
                nombre = scanner.nextLine();
                System.out.println("Escriba la experiencia a agregar.");
                double exp = scanner.nextDouble();
                pokedex.Actualizarnivel(exp, nombre);
                break;
            case 6:
                System.out.println("Saliendo de la Pokedex.");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }  
        } while (opcion != 6);
        
    }
}