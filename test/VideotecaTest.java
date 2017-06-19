package videoteca.test;
import videoteca.source.*;

import org.junit.*;
import static org.junit.Assert.*;

public class VideotecaTest {
    private Videoteca videoteca, videoteca2;
    private Film f1, f2, f3, f4, f5, f6;
    
    @Before 
    public void inicializa() {
        videoteca = new Videoteca("Mi videoteca");
        videoteca2 = new Videoteca("Mi videoteca2");
        
        f1 = new Film("Los miserables", "Musical", 2012);
        f2 = new Film("El fantasma de la ópera", "Musical", 2004);
        f3 = new Film("Cantando bajo la lluvia", "Musical", 1952);
        
        f4 = new Film("Rogue One: Una historia de Star Wars", "Ciencia ficción", 2016);
        f5 = new Film("Lo que el viento se llevó", "Epica", 1939);
        f6 = new Film("Buscando a Nemo", "Dibujos", 2004);
        
    }
    
    
    @After
    public void finaliza() {
        System.out.println("Test finalizado correctamente.");
    }

    //Escriba aquí los tests
    
    // test1 para método add(Film f)
    @Test
    public void test1(){
        videoteca.setOrder(0);
        assertEquals("Prueba 1: Videoteca vacía orden(0)", "Mi videoteca:\n", videoteca.toString());
        videoteca.add(f1);
        videoteca.add(f2);
        videoteca.add(f3);
        assertEquals("Prueba 2: Añadimos 3 películas orden(0)", "Mi videoteca:\n1) " 
            + f3.toString() + "\n2) " + f2.toString() + 
                "\n3) " + f1.toString() + "\n", videoteca.toString());
            
        videoteca.add(f1);
        assertEquals("Prueba 3: Añadimos 3 películas orden(0)", "Mi videoteca:\n1) " 
            + f3.toString() + "\n2) " + f2.toString() + 
                "\n3) " + f1.toString() + "\n", videoteca.toString());
                
        /// 
        
        videoteca2.setOrder(1);
        assertEquals("Prueba 4 : Videoteca2 vacía orden(1)", "Mi videoteca2:\n", 
            videoteca2.toString());
            
        videoteca2.add(f4);
        videoteca2.add(f5);
        videoteca2.add(f6);
        
        assertEquals("Prueba 5: Añadimos 3 películas orden(1)", "Mi videoteca2:\n1) " 
            + f5.toString() + "\n2) " + f6.toString() + 
                "\n3) " + f4.toString() + "\n", videoteca2.toString());
    }
    
    
    // test2 para método setOrder(int n) y getFilms()
    @Test
    public void test2() {
        videoteca.setOrder(1);
        videoteca.add(f1);
        videoteca.add(f2);
        videoteca.add(f3);
        assertEquals("Prueba 1: setOrder(1)", "[" + f3.toString() + ", " + f2.toString() + 
                ", " + f1.toString() + "]", videoteca.getFilms().toString());
        
        videoteca2.add(f4);
        videoteca2.add(f5);
        videoteca2.add(f6);
        videoteca2.setOrder(0);
        assertEquals("Prueba 2: setOrder(0)", "[" + f6.toString() + ", " + f5.toString() + 
            ", " + f4.toString() + "]", videoteca2.getFilms().toString());
    }
    
    // test3 para método getGenres()
    @Test
    public void test3() {
        assertTrue("Prueba 1: Videoteca2 vacía", 
            ("[]").equals(videoteca2.getGenres().toString()));
        
        videoteca.add(f1);
        videoteca.add(f2);
        videoteca.add(f3);
        videoteca.add(f1);
        videoteca.add(f4);
        assertEquals("Prueba 2: getGenres()", "[Ciencia ficción: " + 1 + 
             ", Musical: " + 3 + "]", videoteca.getGenres().toString());
             
        videoteca2.add(f4);
        videoteca2.add(f5);
        videoteca2.add(f5);
        videoteca2.add(f6);
        assertEquals("Prueba 3: getGenres()", "[Ciencia ficción: "+1+ 
            ", Dibujos: " + 1 + ", Epica: " + 1 + "]", 
                videoteca2.getGenres().toString());

    }
}
