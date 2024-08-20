import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String input = "The quick brown fox jumps over the lazy dog";
        AdvancedString advStr = new AdvancedString(input);

        System.out.println("Original: " + advStr.getString());

        // Operation 1: Replace "fox" with "cat"
        advStr.replace("fox", "cat");
        System.out.println("After replace: " + advStr.getString());

        // Operation 2: Extract all words starting with "q" and ending with "k"
        List<String> extracted = advStr.extractPattern("\\bq\\w*k\\b");
        System.out.println("Words starting with 'q' and ending with 'k': " + extracted);

        // Operation 3: Delete all the words starting with "q"
        advStr.deletePattern("\\bq\\w+");
        System.out.println("After deleting words starting with 'q': " + advStr.getString());
    }
}

class AdvancedString {
    private String str;

    public AdvancedString(String str) {
        this.str = str;
    }

    public String getString() {
        return str;
    }

    public void replace(String target, String replacement) {
        str = str.replace(target, replacement);
    }

    public List<String> extractPattern(String regex) {
        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }

    public void deletePattern(String regex) {
        str = str.replaceAll(regex, "").replaceAll("\\s+", " ").trim();
    }
}