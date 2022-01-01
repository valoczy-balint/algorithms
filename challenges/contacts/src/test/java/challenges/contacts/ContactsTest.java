package challenges.contacts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ContactsTest {

    private final Contacts contacts = new Contacts();

    @Test
    public void test() {

        List<List<String>> inputs = List.of(
                List.of("add", "hackerrank"),
                List.of("add", "hack"),
                List.of("find", "hac"),
                List.of("find", "hak")
        );

        List<Integer> expected = List.of(2, 0);
        List<Integer> result = Contacts.contacts(inputs);

        Assertions.assertEquals(expected, result);
    }
}
