import java.util.ArrayList;
import java.util.List;

public class Q0068_TextJustification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0;
        StringBuilder curLine;
        int curWordsLength, left, curSpaceLength;
        while (i < words.length) {
            curLine = new StringBuilder();

            // left为当前行第一个单词的index
            left = i;
            curWordsLength = words[left].length();
            curSpaceLength = 0;
            while (i + 1 < words.length
                    && curWordsLength + words[i + 1].length() + curSpaceLength + 1 <= maxWidth) {
                // 两个单词间至少有一个空格
                curSpaceLength++;
                curWordsLength += words[i + 1].length();
                i++;
            }

            // 如果是最后一行了
            if (i == words.length - 1) {
                for (int j = left; j < i; j++) {
                    curLine.append(words[j]).append(" ");
                }
                curLine.append(words[i]);
                while (curLine.length() < maxWidth) {
                    curLine.append(" ");
                }
            } else {
                if (curWordsLength == maxWidth) {
                    for (int j = left; j < i; j++) {
                        curLine.append(words[j]);
                        curLine.append(" ");
                    }
                    curLine.append(words[i]);
                } else {// 如果需要添加空格的话
                    if (i == left) {// 如果只有一个单词
                        curLine.append(words[i]);
                        while (curLine.length() < maxWidth) {
                            curLine.append(" ");
                        }
                    } else {
                        // 一共有i - left + 1个单词
                        // 一共i - left个放空格的地方
                        // 一共有maxWidth - curLineLength个空格
                        int d = (maxWidth - curWordsLength)/(i - left);
                        int rest = (maxWidth - curWordsLength) % (i - left);
                        int j = left;
                        for (; j < left + rest; j++) {
                            curLine.append(words[j]);
                            for (int k = 0; k < d + 1; k++) {
                                curLine.append(" ");
                            }
                        }
                        for (; j < i; j++) {
                            curLine.append(words[j]);
                            for (int k = 0; k < d; k++) {
                                curLine.append(" ");
                            }
                        }
                        curLine.append(words[i]);
                    }
                }
            }

            res.add(curLine.toString());
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> res = fullJustify(words, 16);
    }
}
