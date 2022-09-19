package validate1;

import exception.UserException;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static Scanner scanner;

    public static boolean checkRegex(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static String inputPhoneNumber() {
        while (true) {
            scanner = new Scanner(System.in);
            String phoneNumber = scanner.nextLine();
            final String REGEX_PHONENUMBER = "^[(][0-9][1-9][)][-][(][0][0-9]{9}[)]$";
            boolean isCheckPhoneNumber = checkRegex(REGEX_PHONENUMBER, phoneNumber);
            if (isCheckPhoneNumber) {
                return phoneNumber;
            } else {
                System.out.println("Nhập số điện thoại theo dạng (84)-(0xxxxxxxxx)");
            }
        }
    }

    public static String inputEmail() {
        while (true) {
            scanner = new Scanner(System.in);
            String email = scanner.nextLine();
            final String REGEX_EMAIL = "^\\w+@\\w+(\\.\\w+){1,2}$";
            boolean isCheckEmail = checkRegex(REGEX_EMAIL, email);
            if (isCheckEmail) {
                return email;
            } else {
                System.out.println("Nhập email theo dạng trandinhduynghia@gmail.com");
            }
        }
    }

    public static String inputBirthday() {
        while (true) {
            scanner = new Scanner(System.in);
            String birthday = scanner.nextLine();
            final String REGEX_BIRTHDAY = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
            LocalDate date = LocalDate.now();
            boolean isCheckBirthday = checkRegex(REGEX_BIRTHDAY, birthday);
            if (isCheckBirthday) {
                String temp = "";
                for (int i = birthday.length() - 4; i < birthday.length(); i++) {
                    temp += birthday.charAt(i);
                }
                if (date.getYear() - new Integer(temp) >= 18) {
                    return birthday;
                } else {
                    System.out.println("Ngày sinh phải lớn hơn hoặc bằng 18");
                }
            } else {
                System.out.println("Nhập ngày sinh theo dạng dd/MM/yyyy");
            }
        }
    }

    public static String inputGender() {
        while (true) {
            scanner = new Scanner(System.in);
            String gender = scanner.nextLine();
            final String REGEX_GENDER = "^nam$|^nu$";
            boolean isCheckName = checkRegex(REGEX_GENDER, gender);
            if (isCheckName) {
                return gender;
            } else {
                System.out.println("Nhập giới tính không hợp lệ");
            }
        }
    }

    public static String inputName()  {
        while (true) {
            scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            final String REGEX_NAME = "^((\\p{Lu})(\\p{Ll}*))( (\\p{Lu})(\\p{Ll}*))*$";
            boolean isCheckName = checkRegex(REGEX_NAME, name);
            if (isCheckName) {
                return name;
            } else {
                System.out.println("Nhập tên theo dang Abc Abc");
            }
        }
    }

    public static Double validateArea()  {
        while (true) {
            try {
                scanner = new Scanner(System.in);
                Double area = scanner.nextDouble();
                if (area > 30) {
                    return area;
                } else {
                    System.out.println("Diện tích phải lớn hơn 30");
                }
            } catch (Exception e) {
                System.out.println("Nhập sai kiểu dữ liệu");
            }
        }
    }

    public static Double validateRentalCots() {
        while (true) {
            scanner = new Scanner(System.in);
            Double rentalCots = scanner.nextDouble();
            if (rentalCots > 0) {
                return rentalCots;
            } else {
                System.out.println("Chi phí phải lớn hơn 0");
            }
        }
    }

    public static Integer validateMaxNumberOfPeople()  {
        while (true) {
            try{
            scanner = new Scanner(System.in);
            int maxNumberOfPeople = scanner.nextInt();
            if (maxNumberOfPeople > 0 && maxNumberOfPeople < 20) {
                return maxNumberOfPeople;
            } else {
                System.out.println("Số lượng người phải lớn hơn 0 và bé hơn 20");
            }
            }catch (java.lang.Exception e){
                System.out.println("Nhập sai kiểu dữ liệu");
            }
        }
    }

    public static Integer validateNumberOfFloors()  {
        while (true) {
            try {
                scanner = new Scanner(System.in);
                int numberOfFloors = scanner.nextInt();
                if (numberOfFloors > 0) {
                    return numberOfFloors;
                } else {
                    System.out.println("Số tầng phải lớn hơn 0");
                }
            } catch (java.lang.Exception e) {
                System.out.println("Nhập sai kiểu dữ liệu");
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
                throw new UserException("Nhập tên theo dang Abc Abc");
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
                String temp = "";
                for (int i = birthday.length() - 4; i < birthday.length(); i++) {
                    temp += birthday.charAt(i);
                }
                if (date.getYear() - new Integer(temp) >= 18) {
                    return birthday;
                } else {
                    throw  new UserException("Ngày sinh phải lớn hơn hoặc bằng 18");
                }
            } else {
                throw new UserException("Nhập ngày sinh theo dạng dd/MM/yyyy");
            }
        }
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

    public static Double validateNumber() throws UserException{
        while (true) {
            scanner = new Scanner(System.in);
            Double number = scanner.nextDouble();
            if (number > 0) {
                return number;
            } else {
                throw new UserException("Phải lớn hơn 0!");
            }
        }
    }

    public static String idCardException() throws UserException {
        final String REGEX_IDCARD ="^\\d{3}\\s\\d{3}\\s\\d{3}$";
        scanner = new Scanner(System.in);
        String idCard = scanner.nextLine();
        boolean isCheckIdCard = checkRegex(REGEX_IDCARD, idCard);
        if (isCheckIdCard) {
            return idCard;
        } else {
            throw new UserException("ID Card không hợp lệ");
        }
    }
}
