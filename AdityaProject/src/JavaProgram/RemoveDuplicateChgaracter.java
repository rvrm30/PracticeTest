package JavaProgram;
public class RemoveDuplicateChgaracter {
    public static void main(String[] args) {
        String input = "aditya";
        String result = "";

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (result.indexOf(c) == -1) {
                result = result + c;
            }
        }

        System.out.println("Result: " + result);
    }
}
