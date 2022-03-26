package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    public Database database;
    private static final Person[] PEOPLE = {new Person(11,"Gosho"),
            new Person(22,"Tosho"), new Person(33,"Pesho")};

    @Before
    public void createConstructor() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void prepareConstructor() {
        Person[] peoples = database.getElements();
        Assert.assertArrayEquals(peoples, PEOPLE);
    }

    @Test
    public void testAddPerson() throws OperationNotSupportedException {
        Person personToBeAdded = new Person(44, "Emo");
        database.add(personToBeAdded);
        Person[]people = database.getElements();
        Assert.assertEquals(people[people.length - 1], personToBeAdded);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddPersonWhenPersonIsNullWillThrowException() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testRemovedPerson() throws OperationNotSupportedException {
        database.remove();
        Person[] people = database.getElements();
        Assert.assertEquals(people[people.length - 1].getUsername(), PEOPLE[PEOPLE.length - 2].getUsername());
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByUsernameWhenNoUserPresentThisUsername() throws OperationNotSupportedException {
        Person personByFind = new Person(55, "Emo");
        database.findByUsername(personByFind.getUsername());
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByUsernameWhenUsernameIsNull() throws OperationNotSupportedException {
        Person personByFind = new Person(55, null);
        database.findByUsername(personByFind.getUsername());
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByUsernameIsCaseSensitive() throws OperationNotSupportedException {
        database.findByUsername("gosho");
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByIdWhenNoUserPresentThisId() throws OperationNotSupportedException {
        Person personByFind = new Person(66, null);
        database.findById(personByFind.getId());
    }
}
