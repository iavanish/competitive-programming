import java.util.Arrays;

public class ThreeNeighbors {

    public String[] construct(int N) {
        boolean isOdd = (N % 2) != 0;
        N -= (N % 2);

        String[] result = new String[50];
        StringBuilder temp = generateString('.', 50);
        Arrays.fill(result, temp.toString());

        int i = 1;
        while (N > 0) {
            temp = generateString('X', Math.min(50, N/2 + 2));
            if (N/2 + 2 < 50) {
                temp.append(generateString('.', 50 - (N/2 + 2)));
            }
            result[i] = temp.toString();
            i += 3;
            N -= 96;
        }

        if (isOdd) {
            temp = generateString('.', 48);
            temp.append(generateString('X', 2));
            result[48] = temp.toString();
            temp = generateString('.', 48);
            temp.append('X');
            temp.append('.');
            result[49] = temp.toString();
        }

        return result;
    }

    private StringBuilder generateString(char c, int count) {
        StringBuilder result = new StringBuilder();
        while (count-- > 0) {
            result.append(c);
        }
        return result;
    }

}
