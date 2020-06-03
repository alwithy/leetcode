import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Q0950_RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        if (deck == null || deck.length <= 1) {
            return deck;
        }
        // 模拟抽牌
        Deque<Integer> index = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            index.add(i);
        }
        Arrays.sort(deck);
        int[] res = new int[deck.length];
        for (int i = 0; i < deck.length; i++) {
            res[index.pollFirst()] = deck[i];
            if (!index.isEmpty()) {
                index.add(index.pollFirst());
            }
        }

        return res;
    }
}
