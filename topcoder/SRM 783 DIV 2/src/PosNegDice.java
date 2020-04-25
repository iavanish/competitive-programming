public class PosNegDice {

    public int[] evaluateRoll(int T, int[] positiveDice, int[] negativeDice) {
        int[] dice = new int[7];
        for (int i : positiveDice) {
            dice[i]++;
        }
        for (int i : negativeDice) {
            dice[i]--;
        }

        int success = 0;
        int stress = 0;
        for (int i = 1; i < 7; i++) {
            if (dice[i] > 0 && i <= T) {
                success = 1;
            }
            if (dice[i] < 0) {
                stress += Math.abs(dice[i]);
            }
        }

        return new int[] {success, stress};
    }

}
