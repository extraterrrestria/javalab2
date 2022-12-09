import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class lab2_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int indicator = 0;

        do {
            System.out.print("Дата: ");
            String date = input.nextLine();

            if (!lab2_1.formatCheck(date)) {
                System.out.print("Введеное выражение не соответствует заданному формату даты dd/mm/yyyy\n");

            } else if (!lab2_1.isDateValid(date)) {
                System.out.print("Введенное выражение не является датой\n");

            } else {
                System.out.print("Введенное выражение является датой");
                indicator++;
            }
        }
        while (indicator == 0);
    }



    static boolean formatCheck (String user){
        Pattern pat = Pattern.compile("\\d{2}/\\d{2}/\\d{4}" );
        Matcher match = pat.matcher(user);
        return match.matches();
    }

    public static boolean isDateValid(String dates) {
        boolean dateIsValid = true;
        try {
            int year =  Integer.parseInt(dates.substring(6,10));
            int month = Integer.parseInt(dates.substring(3,5));
            int day = Integer.parseInt(dates.substring(0, 2));
            LocalDate.of(year, month, day);

        } catch (DateTimeException e) {
            dateIsValid = false;
        }
        return dateIsValid;
    }

}
