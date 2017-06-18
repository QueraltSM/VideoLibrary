package videoteca.source;
/**
 * Clase Film que representa películas 
 * 
 * @author JDGD
 * @vesion 10/01/2017
 * 
 */
public class Film implements Comparable<Film> {
    private String title;   // nombre de la película
    private String genre;   // clasificación temática de la película
    private int year;       // año de estreno de la película

    /**
     * Constructor al que se le pasa el título, 
     * el género y el año de estreno de la película
     * 
     * @param title nombre de la película
     * @param genre género de la película
     * @param year año de estreno de la pelicula
     */ 
    public Film(String title, String genre, int year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }

    /**
     * Devuelve el nombre de la película
     * 
     * @return título de la película
     */ 
    public String getTitle() {
        return title;
    }

    /**
     * Devuelve la clasificación temática de la película
     * 
     * @return género de la película
     */ 
    public String getGenre() {
        return genre;
    }

    /**
     * Devuelve el año de estreno de la película
     * 
     * @return año de la película
     */ 
    public int getYear() {
        return year;
    }
    
    /**
     * Método equals()
     * 
     * @return true si dos películas son iguales
     */
    public boolean equals(Film i) {
        return ((i.getTitle().equals(title)) && (i.getYear() == year));
    }
    
    /**
     * Método toString()
     * 
     * @return string de la representaión como ristra de una película
     */
    public String toString () {
        return title + " | " + genre + " | " + year; 
    }
    
    public int getOrder() {
        return Videoteca.getOrden();    
    }
    
    /**
     * Método compareTo(Film f)
     * 
     * Si Videoteca.getOrder() es igual a 0 se ordena el listado
     * por título, género y año. Si es igual a 1, por año, título y 
     * género.
     */
     
    public int compareTo(Film f) {
        if (getOrder()==0) {
            
            // título, género, año
            if (f.getTitle().compareTo(getTitle())<0) {
                return 1;
            } else if (f.getTitle().compareTo(getTitle())>0) {
                return -1;
            }
            
            if (f.getGenre().compareTo(getGenre())<0) {
                return 1;
            } else if (f.getGenre().compareTo(getGenre())>0) {
                return -1;   
            }
            
            if (f.getYear() < getYear()) {
                return 1;
            } else if (f.getYear() > getYear()) {
                return -1;   
            }
            return 0;
            
            
        } else if (getOrder()==1) {
            // año, título, género
            if (f.getYear() < getYear()) {
                return 1;
            } else if (f.getYear() > getYear()) {
                return -1;   
            }
            
            if (f.getTitle().compareTo(getTitle())<0) {
                return 1;
            } else if (f.getTitle().compareTo(getTitle())>0) {
                return -1;
            }
            
            if (f.getGenre().compareTo(getGenre())<0) {
                return 1;
            } else if (f.getGenre().compareTo(getGenre())>0) {
                return -1;   
            }
            return 0;
            
        }
        
        return 2;
    }
    
    
    
}
