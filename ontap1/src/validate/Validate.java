package validate;

import exception.UserException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validate {
    public static Scanner scanner;

    public static boolean checkRegex(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static String validatePhoneNumber() throws UserException {
        while (true) {
            scanner = new Scanner(System.in);
            String phoneNumber = scanner.nextLine();
            final String REGEX_PHONENUMBER = "^[(][0-9][1-9][)][-][(][0][0-9]{9}[)]$";
            boolean isCheckPhoneNumber = checkRegex(REGEX_PHONENUMBER, phoneNumber);
            if (isCheckPhoneNumber) {
                return phoneNumber;
            } else {
                throw new UserException("Nhập số điện thoại theo dạng (84)-(0xxxxxxxxx)!");
            }
        }
    }

    public static String validateEmail() throws UserException {
        while (true) {
            scanner = new Scanner(System.in);
            String email = scanner.nextLine();
            final String REGEX_EMAIL = "^\\w+@\\w+(\\.\\w+){1,2}$";
            boolean isCheckEmail = checkRegex(REGEX_EMAIL, email);
            if (isCheckEmail) {
                return email;
            } else {
                throw new UserException("Nhập email theo dạng trandinhduynghia@gmail.com!");
            }
        }
    }

    public static String validateGender() throws UserException {
        while (true) {
            scanner = new Scanner(System.in);
            String gender = scanner.nextLine();
            final String REGEX_GENDER = "^nam$|^nữ$";
            boolean isCheckName = checkRegex(REGEX_GENDER, gender);
            if (isCheckName) {
                return gender;
            } else {
                throw new UserException("Nhập giới tính không hợp lệ!");
            }
        }
    }

    public static String validateName() throws UserException {
        while (true){
            scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            final String REGEX_NAME = "^((\\p{Lu})(\\p{Ll}*))( (\\p{Lu})(\\p{Ll}*))*$";
            boolean isCheckName = checkRegex(REGEX_NAME, name);
            if (isCheckName) {
                return name;
            } else {
                throw new UserException("Nhập tên theo dang Abc Abc!");
            }
        }
    }

    public static Integer validateNumber()  {
        while (true) {
            try{
                scanner = new Scanner(System.in);
                int number = scanner.nextInt();
                    return number;
            }catch (java.lang.Exception e){
                System.out.println("Nhập sai kiểu dữ liệu!");
            }
        }
    }
}
