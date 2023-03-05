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
                System.out.println(data);

                inventory.fillInventory(mapa, data);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    } catch (Exception e) {
        in.nextLine();
        // TODO: handle exception
        System.out.println("Opción inválida");
    }

    

	  
  }
}
