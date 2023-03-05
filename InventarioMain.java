import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.*;

public class InventarioMain {
  public static void main(String[] args) {

    FactoryMap<String, ArrayList<String>> map = new FactoryMap<>();
    Inventario inventory = new Inventario();
    Scanner in = new Scanner(System.in);

    System.out.println("********Inventario*********\n");
    System.out.println("1: HashMap\n2: LinkedHashMap\n3: TreeMap\n\nEscoja la implementación de Map a utilizar (1-3): ");

    try {
        int num = in.nextInt();
        in.nextLine();
        Map<String, ArrayList<String>> mapa = map.getInstance(num);

        System.out.println("Ingrese la ruta del archivo ej C:\\ejemplos\\example1.txt");
        String fpath = in.nextLine();

        try {
            File myObj = new File(fpath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                inventory.fillInventory(mapa, data);

            }
            System.out.println(mapa.size());
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        while (num <= 6){
            System.out.println("\n1: Agregar producto\n2: Mostrar categoria de un producto\n3: Mostrar datos de un producto\n4: Mostrar datos de un producto (ordenado)\n5: Mostrar producto y categoría del inventario\n6: Mostrar producto y categoría del inventario (ordenado)\n\n7: Salir del programa");
            num = in.nextInt();
            in.nextLine();
            
            switch (num) {
                case 1:
                    System.out.println("\nCategorias: ");
                    for (String key : mapa.keySet()) {
                        System.out.println("- " + key);
                    }
                    System.out.println("Ingrese la categoría del producto: ");
                    String categoria = in.nextLine();
                    System.out.println("Ingrese el nombre del producto: ");
                    String nombreP = in.nextLine();
    
                    inventory.addProduct(categoria, nombreP, mapa);
    
                    break;
            
                case 2:
                    System.out.println("\nIngrese el nombre del producto:");
                    String choice = in.nextLine();
                    System.out.println("\nLa categoria de " + choice + " es: " + inventory.searchCategory(choice, mapa));
                    break;
                
                case 3:
                    break;
    
                case 4:
                    break;
    
                case 5:
                    break;
                
                case 6: 
                    break;

                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
            }

        }


    } catch (Exception e) {
        in.nextLine();
        // TODO: handle exception
        System.out.println("Opción inválida");
    }


	  
  }
}
