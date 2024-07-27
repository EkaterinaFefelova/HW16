import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String input = getInput();
        if(validateInput(input))
            System.out.println("\n" + formatNumber(input));
    }

    public static String getInput(){
        System.out.println("Пожалуйста, введите российский номер телефона: ");
        return new Scanner(System.in).nextLine().trim();
    }

    public static boolean validateInput (String input){
        String result = input.replaceAll("[., +()-]", "");
        if(result.length()==10)
            result = "7" + result;
        boolean isValid = result.matches("[7-8](9)[0-9]{9}+");
        if (!isValid)
            System.out.println("Неверный ввод");
        return isValid;
    }

    public static String formatNumber (String number){
        String result = number.replaceAll("[., +()-]", "");
        if(result.length()==10) result = "7" + result;
        if (result.startsWith("8")) result = result.replaceFirst("8", "7");
        result = result.replaceAll("(\\d)(\\d{3})(\\d{3})(\\d{2})(\\d{2})", "+$1 ($2) $3 $4-$5");
        return result;
    }
}