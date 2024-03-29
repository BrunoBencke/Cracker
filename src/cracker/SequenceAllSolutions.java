package cracker;

public class SequenceAllSolutions {
    
    public static int complete, partial, solution;
    
    public static void main(String[] args) {
        solve("");
        System.out.println("partial: "+partial);
        System.out.println("complete: "+complete);
        System.out.println("solution: "+solution);
    }
    
    public static boolean isSolution(String state){
        if (state.charAt(0) <= state.charAt(1) &&
            state.charAt(1) <= state.charAt(2) &&
            state.charAt(2) <= state.charAt(3) &&
            state.charAt(3) <= state.charAt(4)) {
            return true;            
        }
        return false;
    }
    
    public static void solve(String state){
        if (state.length() == 5) {
            complete++;
            if (isSolution(state)) {
                solution++;
                System.out.println(state);
            }
        }else{// general case
            partial++;
            solve(state + "a");
            solve(state + "b");
            solve(state + "c");
            solve(state + "d");
            solve(state + "e");
        }
    }
    
}
