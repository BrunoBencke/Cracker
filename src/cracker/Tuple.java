package cracker;

public class Tuple {
    
    public static int complete, partial;  
    
    public static void main(String[] args) {
        solve("");
        System.out.println("partial: "+partial);
        System.out.println("complete: "+complete);
    }
           
    public static void solve(String state){
        if (state.length() == 6) {
            complete++;
            System.out.println(state);
        }else{// general case
            partial++;
            if(! state.contains("a")){solve(state + "a");}
            if(! state.contains("b")){solve(state + "b");}
            if(! state.contains("c")){solve(state + "c");}
            if(! state.contains("d")){solve(state + "d");}
        }
    }
    
}
