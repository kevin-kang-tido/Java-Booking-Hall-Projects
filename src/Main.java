//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int[] convertInputToIndices(String inputChair) {
        String[] parts = inputChair.split("-");
        if (parts.length == 2) {
            int row = parts[0].toUpperCase().charAt(0) - 'A';
            int col = Integer.parseInt(parts[1]) - 1;
            return new int[]{row, col};
        }
        return null;
    }
}