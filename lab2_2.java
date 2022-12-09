import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lab2_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean valid;
        boolean strong;
        boolean includes_d;
        boolean lo_case;
        boolean up_case;
        boolean indicator;

        do {
            System.out.print("Пароль: ");
            String password = input.nextLine();

            valid = validPass(password);
            strong = numPass(password);
            includes_d = dPass(password);
            lo_case = lcPass(password);
            up_case = ucPass(password);

            System.out.println(valid + " " + strong + " " + includes_d + " " + lo_case + " " + up_case);

            indicator = valid && strong && includes_d && lo_case && up_case;
            if (!indicator) {
                System.out.println("Пароль ненадежен. Повторите ввод");
            }

        }while (!indicator);

        System.out.print("Пароль надежен");
    }

    static boolean validPass(String pass) {
        Pattern invalid = Pattern.compile("\\W+");
        Matcher match1 = invalid.matcher(pass);
        return !match1.matches();
    }

    static boolean numPass(String pass) {
        Pattern num = Pattern.compile("^\\w{8,}$");
        Matcher match2 = num.matcher(pass);
        return match2.matches();
    }

    static boolean dPass(String pass) {
        Pattern dij = Pattern.compile(".*\\d.*");
        Matcher match3 = dij.matcher(pass);
        return match3.matches();
    }

    static boolean lcPass(String pass) {
        Pattern lower = Pattern.compile(".*[a-z].*");
        Matcher match4 = lower.matcher(pass);
        return match4.matches();
    }

    static boolean ucPass(String pass) {
        Pattern upper = Pattern.compile(".*[A-Z].*");
        Matcher match5 = upper.matcher(pass);
        return match5.matches();
    }

}

