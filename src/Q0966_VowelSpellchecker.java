import java.util.HashMap;
import java.util.HashSet;

public class Q0966_VowelSpellchecker {
    public static String[] spellchecker(String[] wordlist, String[] queries) {
        // 使用三个HashMap分别存放原单词，不区分大小写的单词，还有忽略元音的小写单词
        HashSet<String> words = new HashSet<>();
        HashMap<String, String> wordLow = new HashMap<>();
        HashMap<String, String> wordVow = new HashMap<>();

        for (String word : wordlist) {
            words.add(word);
            if (!wordLow.containsKey(word.toLowerCase())) {
                wordLow.put(word.toLowerCase(), word);
            }

            StringBuilder cur = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char c = Character.toLowerCase(word.charAt(i));
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    cur.append(" ");
                    continue;
                }
                if (c >= 'a') {
                    cur.append(c);
                } else {
                    cur.append((char) (c + 32));
                }
            }

            if (!wordVow.containsKey(cur.toString())) {
                wordVow.put(cur.toString(), word);
            }
        }

        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (words.contains(queries[i])) {
                res[i] = queries[i];
            } else if (wordLow.containsKey(queries[i].toLowerCase())) {
                res[i] = wordLow.get(queries[i].toLowerCase());
            } else {
                StringBuilder cur = new StringBuilder();
                for (int j = 0; j < queries[i].length(); j++) {
                    char c = Character.toLowerCase(queries[i].charAt(j));
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                        cur.append(" ");
                    } else {
                        cur.append(c);
                    }
                }

                res[i] = wordVow.getOrDefault(cur.toString(), "");
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] wordlist = {"YellOw"};
        String[] q = {"yollow"};
        String[] res = spellchecker(wordlist, q);
    }
}
