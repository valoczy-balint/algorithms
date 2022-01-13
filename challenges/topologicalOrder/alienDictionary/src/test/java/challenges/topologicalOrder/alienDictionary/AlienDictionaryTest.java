package challenges.topologicalOrder.alienDictionary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlienDictionaryTest {
    private final AlienDictionary alienDictionary = new AlienDictionary();

    @Test
    public void testBuild() {
        List<String> inputs = List.of("wrt", "wrf", "er", "ett", "rftt");
        Map<Character, Set<Character>> graph = alienDictionary.buildGraph(inputs);

        Map<Character, Set<Character>> expected = Map.of(
                'r', Set.of('t'),
                't', Set.of('f'),
                'e', Set.of('r'),
                'w', Set.of('e')
        );


        Assertions.assertEquals(expected, graph);
    }

    @Test
    public void test() {
        List<String> inputs = List.of("wrt", "wrf", "er", "ett", "rftt");
        List<Character> letterOrder = alienDictionary.getLetterOrder(inputs);

        List<Character> expected = List.of('w', 'e', 'r', 't', 'f');

        Assertions.assertEquals(expected, letterOrder);
    }

    @Test
    public void testOrder() {
        Map<Character, Set<Character>> graph = Map.of(
                'a', Set.of('b', 'c'),
                'c', Set.of('b'),
                'b', Set.of('d', 'e'),
                'e', Set.of('f')
        );
        List<Character> letterOrder = alienDictionary.findOrder(graph);

        assertTrue(letterOrder.indexOf('b') > letterOrder.indexOf('a'));
        assertTrue(letterOrder.indexOf('c') > letterOrder.indexOf('a'));
        assertTrue(letterOrder.indexOf('b') > letterOrder.indexOf('c'));
        assertTrue(letterOrder.indexOf('d') > letterOrder.indexOf('b'));
        assertTrue(letterOrder.indexOf('e') > letterOrder.indexOf('b'));
        assertTrue(letterOrder.indexOf('f') > letterOrder.indexOf('e'));
    }
}
