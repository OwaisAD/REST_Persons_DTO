package facades;

import dtos.PersonDTO;
import dtos.PersonsDTO;
import dtos.RenameMeDTO;
import entities.Person;
import entities.RenameMe;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class PersonFacade implements IPersonFacade {

    private static PersonFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private PersonFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static PersonFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


    @Override
    public PersonDTO addPerson(String fName, String lName, String phone) {
        Person person = new Person(fName, lName, phone);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new PersonDTO(person);
    }

    @Override
    public PersonDTO deletePerson(int id) {
        /*EntityManager em = emf.createEntityManager();
        Person fromDB = em.find(Person.class, id);

        if(fromDB == null) {
            throw new EntityNotFoundException("No such person with id: " + id);
        }

        try {
            em.getTransaction().begin();
            em.remove(fromDB);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return*/
        return null;
    }

    @Override
    public PersonDTO getPerson(int id) {
        return null;
    }

    @Override
    public PersonsDTO getAllPersons() {
        return null;
    }

    @Override
    public PersonDTO editPerson(PersonDTO p) {
        return null;
    }
}
