/**
 * @author José Prince
 * @date 06/03/2023
 * Algoritmos y estructura de datos
 */
import java.util.*;

public class FactoryMap<K,V> {
    
    
    /** 
     * @param num
     * @return Map<K, V>
     * Crea la instancia de la implementación de map a utilizar
     */
    public Map<K,V> getInstance(int num) {
        Map<K,V> mapImplementado = null;

        switch (num) {
            case 1:
                mapImplementado = new HashMap<K,V>();
                break;
        
            case 2:
                mapImplementado = new LinkedHashMap<K,V>();
                break;

            case 3:
                mapImplementado = new TreeMap<K,V>();
                break;

        }

        return mapImplementado;
    }

}