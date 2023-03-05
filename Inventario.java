import java.util.*;

public class Inventario {
    
    private static final Object K = null;

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

    public String searchCategory(String nombreProducto, Map<String, ArrayList<String>> map) {
        String llave = "INVALIDA";
        for (String  key : map.keySet()) {
            ArrayList<String> productos = map.get(key);
            for(int i = 0; i < productos.size(); i++){
                String producto = productos.get(i).replaceAll(" ", "").trim();
                if (producto.equalsIgnoreCase(nombreProducto.replaceAll(" ", "")))
                    llave = key;
            }
        }
        
        return llave;
    }

    public String printMap(Map<String, ArrayList<String>> map) {
        Random rand = new Random();
        String lista = "";
        for (String key : map.keySet()) {
            ArrayList<String> articulos = map.get(key);
            for (String articulo : articulos) {
                int numRand = rand.nextInt(1, 50);
                lista = lista + "Producto: " + articulo.trim() + "| Categoria: " + key + "| Existencias: " + numRand + "\n";
            }
        }
        return lista;
    }
            
}

    
