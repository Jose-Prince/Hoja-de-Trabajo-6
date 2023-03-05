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

    public void addProduct(String categoria, String nombreProducto, Map<String, ArrayList<String>> map) {

        for (String key : map.keySet()) {
            String llave = key.replaceAll(" ", "");
            boolean compare = llave.equalsIgnoreCase(categoria.replaceAll(" ", ""));
            if (compare == true){
                ArrayList<String> articulos = map.get(key);
                articulos.add(nombreProducto);
                map.put(key, articulos);
            }
            
        }

    }
}

    
