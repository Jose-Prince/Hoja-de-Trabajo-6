/**
 * @author José Prince
 * @date 06/03/2023
 * Algoritmos y estructura de datos
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Inventario {

    
    /** 
     * @param map
     * @param linea
     * Llena el mpa con los datos del inventario
     */
    public void fillInventory(Map<String, ArrayList<String>> map, String linea){
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

    
    /** 
     * @param map
     * Añade un producto al map segun su clasificación
     */
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

    
    /** 
     * @param map
     * @return String
     * Busca la categoría de un producto
     */
    public String searchCategory(String nombreProducto, Map<String, ArrayList<String>> map) {
        String llave = "INVALIDA";
        for (String  key : map.keySet()) {
            ArrayList<String> productos = map.get(key);
            for(int i = 0; i < productos.size(); i++){
                String producto = productos.get(i).replaceAll(" ", "").trim();
                if (producto.equalsIgnoreCase(nombreProducto.replaceAll(" ", "").trim()))
                    llave = key;
            }
        }
        
        return llave;
    }

    
    /** 
     * @param map
     * @return String
     * Imprime la lista de los productos junto a su categoria y sus existencias
     */
    public String printMapProduct(Map<String, ArrayList<String>> map) {
        Random rand = new Random();
        String lista = "";
        for (String key : map.keySet()) {
            ArrayList<String> articulos = map.get(key);
            for (String articulo : articulos) {
                int numRand = rand.nextInt(1, 50);
                lista = lista + articulo.trim() + " | Categoria: " + key + "| Existencias: " + numRand + "\n";
            }
        }
        return lista;
    }

    
    /** 
     * @param map
     * @return String
     * Imprime de forma ordenada los productos junto a su clasificación y número de existencias
     */
    public String printMapProductSort(Map<String, ArrayList<String>> map) {
        ArrayList<String> products = new ArrayList<String>();
        for (String key : map.keySet()) {
            ArrayList<String> articulos = map.get(key);
            for (String articulo : articulos) {
                products.add(articulo);
            }
        }

        Collections.sort(products);
        Random rand = new Random();
        String lista = "";
        for (String product : products) {
            int numRand = rand.nextInt(1, 50);
            lista = lista + product.trim() + " | Categoria: " + searchCategory(product, map) + "| Existencias: " + numRand + "\n";
        }

        return lista;
    }

    
    /** 
     * @param map
     * @return String
     * Imprime la clasificación de los productos junto a los productos respectivos
     */
    public String printMapCategory(Map<String, ArrayList<String>> map) {
        String producto = "";

        for (String key : map.keySet()) {
            ArrayList<String> articulos = map.get(key);
            for (String articulo : articulos) {
                producto = producto +  key + "| " + articulo.trim() + "\n";
            }
        }
        return producto;
    }

    
    /** 
     * @param map
     * @return String
     * Imprime de forma ordenada la clasificación de los productos junto a los productos respectivos
     */
    public String printMapCategorySort(Map<String, ArrayList<String>> map) {
        String list = "";
        ArrayList<String> categorias = new ArrayList<String>();
        for (String key : map.keySet()) {
            categorias.add(key);
            ArrayList<String> articulos = map.get(key);
            map.put(key, articulos);
        }
        Collections.sort(categorias);
        
        for (String categoria : categorias) {
            ArrayList<String> articulos = map.get(categoria);
            for (String articulo : articulos) {
                list = list + categoria + "| " + articulo.trim() + "\n";
            }
        }

        return list;
    }       
}

    
