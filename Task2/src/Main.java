import java.util.Scanner;

public class Main {
    public static String TEST_STRING = "Higher-for-Longer Interest Rate Environment" +
            " is Squeezing More Borrowers\n" +
            "The world’s central banks have unleashed the steepest series of interest-rate" +
            " increases in decades during their two-year drive to tame inflation—and they" +
            " may not be done yet. Policymakers have raised rates by about 400 basis points" +
            " on average in advanced economies since late 2021, and around 650 basis points" +
            " in emerging market economies.\n" +
            " Most economies are absorbing this aggressive policy tightening, showing" +
            " resilience over the past year, but core inflation remains elevated in several" +
            " of them, especially the United States and parts of Europe. Major central banks" +
            " therefore may need to keep interest rates higher for longer. ";

    public static void main(String[] args) {
        String input = getInput();
        if (input.equals("0")) {
            System.out.println("\nВы ввели 0, для демонстрации используется программно заданная строка:\n ");
            System.out.println(separateWords(TEST_STRING));
        }
        else if (validateHundredEnglishWords(input))
            System.out.println(separateWords(input));
        else {
            System.out.println("\nВведенный вами текст не валиден, для демонстрации используется программно заданная строка:\n ");
            System.out.println(separateWords(TEST_STRING));
        }
    }
    public static String getInput(){
        System.out.println("Пожалуйста, введите текст, состоящий из не менее 100 слов на " +
                "английском языке, закончив ввод словом STOP c новой строки, либо нажмите 0 для продолжения без ввода: ");
        StringBuilder string = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        if (scanner.next().equals("0"))
            return "0";
        else{
            while (scanner.hasNext() && !scanner.next().equals("STOP"))
                string.append(scanner.nextLine());
            return string.toString().trim();
        }
    }

    public static String separateWords (String input){
        String result = input.replaceAll("’s", " ");
        result = result.replaceAll("[\n,.;:’\"'!?%$@#^&*()-]", " ");
        result = result.replaceAll("\\d", "");
        result = result.replaceAll(" {2,}", " ");
        result = result.replaceAll("\\W", "\n");

        return result;
    }

    public static boolean validateHundredEnglishWords(String input){
        boolean isValid = input.matches("[\\dA-z\n,.;:’\"'!?%$@#^&*() -]*");
        input = input.replaceAll("[\\d\n,.;:’\"'!?%$@#^&*()-]+", " ");
        input = input.replaceAll(" {2,}", " ");

        int sum=0;
        for (int i=0; i<input.length();i++) {
            if (input.charAt(i) == ' ')
                sum++;
        }
        if (sum<99)
            isValid = false;
        System.out.println("\nКоличество слов во вводе: " + (sum+1));
        return isValid;
    }
}