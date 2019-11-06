package vn.edu.tdmu.pmd.Movement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Vector2Dtest {
  
    public Vector2Dtest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   
    @Test
    public void addTC01(){
        Vector2D v1=new Vector2D(2, 3);
        Vector2D v2=new Vector2D(1, 2);
        Vector2D expected=new Vector2D(3,5);
        assertEquals(Vector2D.add(v1, v2), expected);
    }
    
    @Test
    public void addTC02(){
        Vector2D v1=new Vector2D(0, 2);
        Vector2D v2=new Vector2D(-1, -3);
        Vector2D expected=new Vector2D(-1,-1);
        assertEquals(Vector2D.add(v1, v2), expected);
    }
    
}