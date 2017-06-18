package videoteca.source;
import java.util.*;
/**
 * Clase Videoteca que representa una colección de películas 
 * 
 * @author Queralt Sosa Mompel
 * @vesion 17/06/2017
 * 
 */
public class Videoteca {
    private String nombre;
    private static int orden;
    private ArrayList<Film> films = new ArrayList<>();
    
    /**
     * Constructor de Videoteca: Inicializa la Videoteca
     * con la string pasada por parámetro
     *
     */
    public Videoteca(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Método add()
     * 
     * @return true si se añade nueva película
     */
    public Boolean add (Film f) {
        if (films.contains(f)) {
            return false;
        }
        
        films.add(f);
        return true;
    }
    
    /**
     * Método setOrder()
     * 
     * Establece el orden del listado de películas
     * en función del parámetro entero pasado
     * 
     */
    public void setOrder(int ord) {
        orden = ord;
        Collections.sort(films);
    }
    
    /**
     * Método getFilms()
     * 
     * @return listado de películas ordenadas
     */
    public Set<Film> getFilms() {
        SortedSet<Film> result = new TreeSet<>();
        for (Film f : films) {
            result.add(f);
        }
        return result;
    }
    
    
    /**
     * Método getOrden()
     * 
     * @return entero que devuelve el orden del listado
     */
    public static int getOrden() {
        return orden;
    }
    
    /**
     * Método getGenres()
     * 
     * @return lista de los géneros de películas 
     * ordenadas alfabéticamente
     */    
    public List<String> getGenres() {
        List<String> result = new LinkedList<String>();
        for (Map.Entry<String, Integer> entry : getRistras().entrySet()) {
            result.add(entry.getKey() + ": " + entry.getValue());
        }
        return result;
    }
    
    /**
     * Método auxiliar getRistras()
     * 
     * @return mapa con el listado de géneros
     * de todas las películas y la cantidad de estas
     */
    private Map<String, Integer> getRistras() {
        Map<String, Integer> result = new TreeMap<>();
        for (Film f : films) {
            System.out.print(f.getGenre() + "\n");
            if (result.get(f.getGenre()) == null) {
                result.put(f.getGenre(), 1);
            } else {
                result.put(f.getGenre(), result.get(f.getGenre()+1));
            }
        }
        return result;
    }
    
    /**
     * Método toString()
     * 
     * @return string representación como ristra
     * de las películas que conforman la Videoteca
     */
    public String toString(){
        
        String result = nombre +":\n";
        int count = 1;
        for (Film f : getFilms()) {
            result += count + ") " + f.toString() + "\n";
        }
        return result;
    }
    
    
}