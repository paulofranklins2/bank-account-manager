import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private final Person person = new Person("Paulo", "Cunha", "000-00-0000", "pcunha@gmail.com", "000-000-0000", "XYZ st");

    @Test
    void getAddress() {
        assertEquals("XYZ st", person.getAddress());
    }

    @Test
    void setAddress() {
        person.setAddress("ABC st");
        assertEquals("ABC st", person.getAddress());
    }

    @Test
    void getPhone() {
        assertEquals("000-000-0000", person.getPhone());
    }

    @Test
    void setPhone() {
        person.setPhone("111-111-1111");
        assertEquals("111-111-1111", person.getPhone());
    }

    @Test
    void getEmail() {
        assertEquals("pcunha@gmail.com", person.getEmail());
    }

    @Test
    void setEmail() {
        person.setEmail("<EMAIL>");
        assertEquals("<EMAIL>", person.getEmail());
    }

    @Test
    void getFirstName() {
        assertEquals("Paulo", person.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Cunha", person.getLastName());
    }

    @Test
    void getSsn() {
        assertEquals("000-00-0000", person.getSsn());
    }
}