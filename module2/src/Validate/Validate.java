package Validate;

import exception.UserException;

import java.time.LocalDate;
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

    public static String validateMaSTK() throws UserException {
        while (true){
            scanner = new Scanner(System.in);
            String maSTK = scanner.nextLine();
            final String REGEX_NAME = "STK-[0-9]{4}";
            boolean isCheck = checkRegex(REGEX_NAME, maSTK);
            if (isCheck) {
                return maSTK;
            } else {
                throw new UserException ("Không được bỏ trống - Nhập theo dạng STK-xxxx");
            }
        }
    }

    public static String validateBirthday() throws UserException {
        while (true) {
            scanner = new Scanner(System.in);
            String birthday = scanner.nextLine();
            final String REGEX_BIRTHDAY = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
            LocalDate date = LocalDate.now();
            boolean isCheckBirthday = checkRegex(REGEX_BIRTHDAY, birthday);
            if (isCheckBirthday) {
                    return birthday;
            } else {
                throw new UserException("Nhập ngày sinh theo dạng dd/MM/yyyy");
            }
        }
    }

    public static Double validateSoTien() {
        while (true) {
            scanner = new Scanner(System.in);
            Double soTien = scanner.nextDouble();
            if (soTien > 1000000) {
                return soTien;
            } else {
                System.out.println("Số tiền phải lớn hơn 1000000");
            }
        }
    }

    public static int validateKyHan() {
        while (true) {
            scanner = new Scanner(System.in);
            int kyHan = scanner.nextInt();
            if (kyHan == 3 || kyHan == 5 ) {
                return kyHan;
            } else {
                System.out.println("Kỳ hạn phải là 3 năm hoặc 5 năm");
            }
        }
    }
}
