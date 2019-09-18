package cracker;

public class CoinsAllSolutions {
    
    public static int complete, partial, solution;
    
    public static void main(String[] args) {
        solve("");
        System.out.println("partial: "+partial);
        System.out.println("complete: "+complete);
        System.out.println("solution: "+solution);
    }
    
    public static boolean isSolution(String state){
        int sum = 0;
        for (int i = 0; i < state.length(); i++) {
            if(state.charAt(i) == '1'){
                sum+= 10;
            }
            if (state.charAt(i) == '2') {
                sum += 25;
            }
            if (state.charAt(i) == '5') {
                sum += 50;
            }
        }
        return sum == 100;
    }
    
    public static void solve(String state){
        if (state.length() == 10) {
            complete++;
            if (isSolution(state)) {
                solution++;
                System.out.println(state);
            }
        }else{// general case
            partial++;
            if (isSolution(state)) {
                solution++;
                System.out.println(state);
            }
            solve(state + "1");
            solve(state + "2");
            solve(state + "5");
        }
    }
    
}
