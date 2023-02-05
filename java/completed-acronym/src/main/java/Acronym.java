import java.util.Arrays;

class Acronym {
    private final String[] arr;

    Acronym(String phrase) {
        arr = phrase.replaceAll("[_-]", " ").replaceAll(" +", " ").split(" ");
    }

    String get() {
        return Arrays.stream(arr).reduce("", (acc, curr) ->  acc + Character.toUpperCase(curr.charAt(0)));
    }

}
