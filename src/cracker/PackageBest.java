package cracker;

public class PackageBest {
    
    public static int complete, partial, solution;
    
    public static void main(String[] args) {
        solve("");
        System.out.println("partial: "+partial);
        System.out.println("complete: "+complete);
        System.out.println("solution: "+solution);
    }
    
    public static boolean isSolution(String state){
        double sum = 0;
        for (int i = 0; i < state.length(); i++) {
            if(state.charAt(i) == 'a'){
                sum+= 0.3;
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
        return Math.abs(sum - 10.0) < 0.0001;
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
            solve(state + "a");
            solve(state + "b");
            solve(state + "c");
            solve(state + "d");
        }
    }
    
}
