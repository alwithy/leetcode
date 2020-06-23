import java.util.ArrayList;
import java.util.List;

public class Q0722_RemoveComments {
    public static List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        // 标志多行注释已开始
        boolean commentBegin = false;
        StringBuilder curLine = new StringBuilder();
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length(); j++) {
                char c = source[i].charAt(j);
                if (commentBegin) {
                    if (c == '*' && j + 1 < source[i].length()
                            && source[i].charAt(j + 1) == '/') {
                        commentBegin = false;
                        j++;
                    }
                } else {
                    if (c == '/' && j + 1 < source[i].length()) {
                        char next = source[i].charAt(j + 1);
                        if (next == '*') {
                            commentBegin = true;
                            j++;
                            continue;
                        } else if (next == '/') {
                            break;
                        }
                    }

                    curLine.append(c);
                }
            }

            if (!commentBegin && curLine.length() > 0) {
                res.add(curLine.toString());
                curLine = new StringBuilder();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"a/*comment","line", "more_comment*/b"};
        List<String> res = removeComments(strs);
    }
}
