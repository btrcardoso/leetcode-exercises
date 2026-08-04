package simulations.pt3;
import java.util.*;

public class FileNaming {

    public static String[] fileNaming(String[] names) {

        Map<String, Integer> map = new HashMap<>();

        for (int i=0; i< names.length; i++) {

                String comingName = names[i];

                if (map.containsKey(comingName)) {

                        int qt = map.get(comingName) + 1;
                        String newName = comingName + "(" + qt + ")";
                        map.put(comingName, qt);
                        map.put(newName, 0);
                        names[i] = newName;

                } else {
                        map.put(comingName, 0);
                }

        }


        return names;

    }

    public static void main(String[] args) {
        runTest(
                new String[]{"doc", "doc", "image", "doc(1)", "doc"},
                new String[]{"doc", "doc(1)", "image", "doc(1)(1)", "doc(2)"}
        );

        runTest(
                new String[]{"a", "a", "a", "a"},
                new String[]{"a", "a(1)", "a(2)", "a(3)"}
        );

        // edge cases
        runTest(
                new String[]{"file"},
                new String[]{"file"}
        );
    }

    private static void runTest(String[] input, String[] expected) {
        String[] result = fileNaming(input);
        System.out.println(
                Arrays.toString(input) +
                        " -> result: " + Arrays.toString(result) +
                        " | expected: " + Arrays.toString(expected) +
                        (Arrays.equals(result, expected) ? " ✅" : " ❌")
        );
    }
}