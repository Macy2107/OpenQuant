import java.util.Random;
import java.util.*;
import java.util.HashSet;
import java.util.Set;

class Main {
    private static int rollDice(Random random) {
        return random.nextInt(6) + 1;
    }
    public static void main(String[] args) {
        Random random = new Random();
        
        int valid_cases = 0;
        int num_iters = 100_000;
        
        for (int i = 0; i < num_iters; i++) {
            Set<Integer> seen_faces = new HashSet<>();
            
            while (true) {
                int roll = rollDice(random); // RECALL
                seen_faces.add(roll);
                
                if (roll % 2 == 1 && seen_faces.size() < 4) {
                    break;
                }
                
                if (seen_faces.size() == 6) {
                    valid_cases++;
                    break;
                }
            }
        }
        System.out.println((double) valid_cases / num_iters);
    }
}
