import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Casos de prueba para el algoritmo de las n reinas
 *
 * @author  Juan Jose Parra, Luisa Maria Vasquez
 * @version 25/02/2018
 */
public class ReinasTest
{
    /**
     * Default constructor for test class DigraphAMTest
     */
    public ReinasTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Método que prueba que el algoritmo para el problema de las n reinas funciona
     */
    @Test
    public void Nreinas()
    {
     int cuatro=Punto1.queens(4);
     int cinco=Punto1.queens(5);
     int seis=Punto1.queens(6);
     int ocho=Punto1.queens(8);
     int diez=Punto1.queens(10);
    
     
     assertEquals(cuatro,2);
     assertEquals(cinco,10);
     assertEquals(seis,4);
     assertEquals(ocho,92);
     assertEquals(diez,724);   

    }
}
