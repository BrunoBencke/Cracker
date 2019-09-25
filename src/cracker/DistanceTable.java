package cracker;

public class DistanceTable {

    public static int complete, partial;
    public static String best_state;
    public static double best_value;
    
    int[][] distance = {{ 0, 18, 36, 29, 47, 13}, 
                    {18,  0, 25, 12,  7, 18},  
                    {36, 25,  0, 15, 31, 23}, 
                    {29, 12, 15,  0, 24, 34}, 
                    {47,  7, 31, 24,  0, 10}, 
                    {13, 18, 23, 34, 10,  0}};

    public static void main(String[] args) {
        solve("");
        System.out.println("partial: " + partial);
        System.out.println("complete: " + complete);
        System.out.println("best state: " + best_state);
        System.out.println("best value: " + best_value);
    }

    public static double evaluate(String state) {
        double sum = 0;
        for (int i = 0; i < state.length(); i++) {
            if (state.charAt(i) == 'a') {
                sum += 0.3;
            }
            if (state.charAt(i) == 'b') {
                sum += 1.2;
            }
            if (state.charAt(i) == 'c') {
                sum += 2.5;
            }
            if (state.charAt(i) == 'd') {
                sum += 0.9;
            }
        }
        return sum;
    }

    public static void solve(String state) {
        if (state.length() == 6) {
            complete++;
            double value = evaluate(state);
            if (value > best_value && value <= 10) {
                best_state = state;
                best_value = value;
            }
        } else {// general case
            partial++;
            //if (c == 'a');{ item = 5; }
            if (! state.contains("C")) { solve(state + "C"); }
            if (! state.contains("D")) { solve(state + "D"); }
            if (! state.contains("E")) { solve(state + "E"); }
            if (! state.contains("F")) { solve(state + "F"); }
        }
    }
}
