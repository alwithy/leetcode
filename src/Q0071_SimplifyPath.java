import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Q0071_SimplifyPath {
    public static String simplifyPath(String path) {
        StringBuilder res = new StringBuilder();
        Deque<String> deque = new ArrayDeque<>();
        String[] arr = path.split("/");
        for (String s : path.split("/")) {
            if (s.equals("..")) {
                if (deque.size() >= 1) {
                    deque.removeLast();
                }
            } else if (s.equals(".") || s.equals("/") || s.equals("")) {
                continue;
            } else {
                deque.add(s);
            }
        }

        for (String s : deque) {
            res.append("/").append(s);
        }

        if (res.length() == 0) res.append("/");

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "/a//b////c/d//././/..";
        System.out.println(simplifyPath(s));
    }
}
