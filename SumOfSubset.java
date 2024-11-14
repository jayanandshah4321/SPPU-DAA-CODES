import java.util.ArrayList;
import java.util.List;

public class SubsetSumBacktracking {
    static int M = 35;
    static int[] w = {5, 7, 10, 12, 15, 18, 20};

    public static void main(String[] args) {
        List<Integer> solution = new ArrayList<>();
        findAllSubsets(0, 0, solution);
    }

    public static void findAllSubsets(int index, int currentSum, List<Integer> solution) {
        if (currentSum == M) {
            System.out.println("Subset found: " + solution);
            return;
        }

        if (index >= w.length || currentSum > M) {
            return;
        }

        // Include the current element
        solution.add(w[index]);
        findAllSubsets(index + 1, currentSum + w[index], solution);

        // Backtrack and remove the element
        solution.remove(solution.size() - 1);

        // Exclude the current element and move to the next
        findAllSubsets(index + 1, currentSum, solution);
    }
}
