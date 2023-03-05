import java.util.*;

public class Inventario {
    
    public void fillInventory(Map<String, ArrayList<String>> map, String linea){
       // linea = linea.replaceAll("|", "");
        String[] products = linea.split("\\|");
        String tipo = products[0];

        if (map.containsKey(tipo)){
            ArrayList<String> articulos = map.get(tipo);
            articulos.add(products[1]);
            map.put(tipo, articulos);
        } else {
            ArrayList<String> productos = new ArrayList<String>();
            productos.add(products[1]);
    
            map.put(tipo, productos);
        }

    }
}
