import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstNonRepeatingCharacter {
    public Character findFirstNonRepeatingCharacterWithMap(String string) {

        Map<Character, Integer> charactersCount = new LinkedHashMap<>();
        char[] characters = string.toCharArray();

        for (char current : characters) {
            if (charactersCount.containsKey(current)) {
                charactersCount.put(current, current + 1);
            } else {
                charactersCount.put(current, 1);
            }
        }

        for (Character key : charactersCount.keySet()) {
            if (charactersCount.get(key) == 1) {
                return key;
            }
        }
        return null;
    }

    public Character findFirstNonRepeatingCharacterWithPointers(String string) {
        char[] characters = string.toCharArray();

        Character result = null;

        for (int i = 0; i < characters.length; i++) {
            char characterAtStart = characters[i];
            result = characterAtStart;

            for (int j = 0; j < characters.length; j++) {
                char character = characters[j];
                if (character == characterAtStart && i != j) {
                    result = null;
                    break;
                }
            }
            if (result != null) {
                return result;
            }
        }

        return null;
    }
}
