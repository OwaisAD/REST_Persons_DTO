package facades;

import dtos.PersonDTO;
import entities.Person;
import entities.RenameMe;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class PersonFacadeTest {

    private static EntityManagerFactory emf;
    private static PersonFacade facade;

    public PersonFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = PersonFacade.getFacadeExample(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the code below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Person.deleteAllRows").executeUpdate();
            em.persist(new Person("Elon", "Musk", "12345678"));
            em.persist(new Person("Bill", "Gates", "87654321"));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }


    @Test
    public void testAddingAPerson() {
        PersonDTO person = facade.addPerson("Owais", "Dashti", "60606060");
        //Expect firstName
        assertEquals("Owais", person.getfName());
        //Expect lastName
        assertEquals("Dashti", person.getlName());
        //Expect phone
        assertEquals("60606060", person.getPhone());

        assertEquals(3, person.getId());
    }

    @Test
    public void testDeletingAPerson() {

    }

    @Test
    public void testGettingAPerson() {

    }

    @Test
    public void testGettingAllPersons() {

    }

    @Test
    public void testEditingAPerson() {

    }

}
