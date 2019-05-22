package com.shoppingCart;





import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloWorldTest {
    private HelloWorld helloWorld;
    @Before
    public void setUp() throws Exception {
        helloWorld=new HelloWorld();
    }
    @After
    public  void tearDown(){
        helloWorld=null;
    }
    @Test
    public void testWelcome() {

     String expected="Welcome to Spring Boot Tutorials added for dev";
     String actual=helloWorld.welcome();
     assertEquals(expected,actual);

    }
    @Test
    public void testMyData() {
        String expected="Hello Spring Boot";
        String actual=helloWorld.myData();
        assertEquals(expected,actual);
    }
}
