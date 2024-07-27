import java.util.Scanner;

public class Main {

    //public static final String VALID_STRING = " -АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя";


    public static void main(String[] args) {
        String input = getInput();
        if(validateInput(input)) printFIO(input);
    }

    public static String getInput(){
        System.out.println("Пожалуйста, введите свои фамилию, имя и отчество, разделенные пробелами: ");
        return new Scanner(System.in).nextLine().trim();
    }

    public static boolean validateInput (String input){
       boolean isValid = input.matches("([А-яёЁ-]+\\s){2}([А-яёЁ-]+)");
       if (!isValid)
            System.out.println("Введенная строка не является ФИО");
       return isValid;
    }

    public static void printFIO(String input){
        String[] fio = input.split(" ");
        System.out.println("Фамилия: " + fio[0] + "\nИмя: " + fio[1] + "\nОтчество: " + fio[2]);
    }
}