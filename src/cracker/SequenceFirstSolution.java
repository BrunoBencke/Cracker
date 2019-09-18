package cracker;

public class SequenceFirstSolution {
    
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
    
    public static boolean solve(String state){
        if (state.length() == 5) {
            complete++;
            if (isSolution(state)) {
                solution++;
                System.out.println(state);
                return true;
            }
        }else{// general case
            partial++;
            if(solve(state + "a")){ return true; }
            if(solve(state + "b")){ return true; }
            if(solve(state + "c")){ return true; }
            if(solve(state + "d")){ return true; }
            if(solve(state + "e")){ return true; }            
        }
        return false;
    }
    
}
