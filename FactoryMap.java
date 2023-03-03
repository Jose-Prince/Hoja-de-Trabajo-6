import java.util.*;

public class FactoryMap<K,V> {
    
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