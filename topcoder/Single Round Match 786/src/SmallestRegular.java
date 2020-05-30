import java.util.ArrayList;
import java.util.List;

public class SmallestRegular {

    public int[] findLexSmallest(String S) {
        int[] c = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            c[i] = S.charAt(i) == '(' ? 0 : 1;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < S.length() && result.size() < 900; i++) {
            if (c[i] == 1) {
                continue;
            }
            int j = i;
            while (j + 1 < S.length() && c[j + 1] == 0) {
                j++;
            }
            while (j + 1 < S.length() && c[j + 1] == 1) {
                j++;
            }
            if (j < S.length() - 1 && c[j + 1] == 0) {
                result.add(i);
                result.add(j);
                result.add(j + 1);
                for (int x = j + 1; x > i; x--) {
                    c[x] = c[x - 1];
                }
                c[i] = 0;
                i = -1;
            }
        }

        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }

        return r;
    }

}
