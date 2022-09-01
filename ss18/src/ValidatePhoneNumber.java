import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số điện thoại: ");
        String phoneNumber = scanner.nextLine();
        ValidatePhoneNumber validatePhoneNumber = new ValidatePhoneNumber();
        System.out.println(phoneNumber + " : "+validatePhoneNumber.validate(phoneNumber));
    }

    private static final String Phone_Number_REGEX  = "\\([0-9]{2}\\)-\\(0[0-9]{9}\\)";
    public ValidatePhoneNumber(){

    }

    public boolean validate(String regex){
        Pattern pattern = Pattern.compile(Phone_Number_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
