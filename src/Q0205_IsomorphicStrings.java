import java.util.HashMap;

public class Q0205_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> sToT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!sToT.containsKey(s.charAt(i)) && !sToT.containsValue(t.charAt(i))) {
                sToT.put(s.charAt(i), t.charAt(i));
            } else if (!sToT.containsKey(s.charAt(i))
                    || !sToT.containsValue(t.charAt(i))
                    || sToT.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
