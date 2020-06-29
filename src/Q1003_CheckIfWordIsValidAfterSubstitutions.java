import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q1003_CheckIfWordIsValidAfterSubstitutions {
    public boolean isValid(String S) {
        if (S == null || S.length() == 0) return false;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            sb.append(S.charAt(i));

            while (sb.length() >= 3
                    && sb.substring(sb.length() - 3).equals("abc")) {
                sb.delete(sb.length() - 3, sb.length());
            }
        }

        return sb.length() == 0;
    }
}
