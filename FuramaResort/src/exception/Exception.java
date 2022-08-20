package exception;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exception {
    public static Scanner scanner;
    public boolean checkRegex(String regex, String input){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
    public  String inputPhoneNumber(){
        while (true){
            scanner = new Scanner(System.in);
            String phoneNumber = scanner.nextLine();
            final String REGEX_PHONENUMBER = "^[(][0-9][1-9][)][-][(][0][0-9]{9}[)]$";
            boolean isCheckPhoneNumber = checkRegex(REGEX_PHONENUMBER, phoneNumber);
            if(isCheckPhoneNumber){
                return phoneNumber;
            }else{
                System.out.println("Nhập số điện thoại theo dạng (84)-(0xxxxxxxxx)");
            }
        }
    }
    public  String inputEmail(){
        while (true){
            scanner = new Scanner(System.in);
            String email = scanner.nextLine();
            final String REGEX_EMAIL = "^\\w+@\\w+(\\.\\w+){1,2}$";
            boolean isCheckEmail = checkRegex(REGEX_EMAIL, email);
            if(isCheckEmail){
                return email;
            }else {
                System.out.println("Nhập email theo dạng trandinhduynghia@gmail.com");
            }
        }
    }
    public String inputBirthday(){
        while (true){
            scanner = new Scanner(System.in);
            String birthday = scanner.nextLine();
            final String REGEX_BIRTHDAY = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
            LocalDate date = LocalDate.now();
            boolean isCheckBirthday = checkRegex(REGEX_BIRTHDAY, birthday);
            if(isCheckBirthday){
                String temp = "";
                for(int i = birthday.length() - 4; i < birthday.length(); i++){
                    temp += birthday.charAt(i);
                }
                if(date.getYear() - new Integer(temp) >= 18){
                    return birthday;
                }else{
                    System.out.println("Ngày sinh phải lớn hơn hoặc bằng 18");
                }
            }else{
                System.out.println("Nhập ngày sinh theo dạng dd/MM/yyyy");
            }
        }
    }
    public String inputGender(){
        while(true){
            scanner = new Scanner(System.in);
            String gender = scanner.nextLine();
            final String REGEX_GENDER = "^nam$ | ^nu$";
            boolean isCheckName = checkRegex(REGEX_GENDER, gender);
            if(isCheckName){
                return gender;
            }else{
                System.out.println("Nhập giới tính không hợp lệ");
            }
        }
    }
    public String inputName(){
        while(true){
            scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            final String REGEX_NAME = "^((\\\\p{Lu})(\\\\p{Ll}*))( (\\\\p{Lu})(\\\\p{Ll}*))*$";
            boolean isCheckName = checkRegex(REGEX_NAME, name);
            if(isCheckName){
                return name;
            }else{
                System.out.println("Nhập tên theo dang Abc Abc");
            }
        }
    }
    public Double inputArea(){
        while (true){
            try{
                scanner = new Scanner(System.in);
                Double area = scanner.nextDouble();
                if(area > 30){
                    return area;
                }else {
                    System.out.println("Diện tích phải lớn hơn 30");
                }
            }catch (java.lang.Exception e){
                System.out.println("Nhập sai kiểu dữ liệu");
            }
        }
    }
    public Double inputRentalCots(){
        while (true){
            try{
                scanner = new Scanner(System.in);
                Double rentalCots = scanner.nextDouble();
                if(rentalCots > 0){
                    return rentalCots;
                }else {
                    System.out.println("Chi phí phải lớn hơn 0");
                }
            }catch (java.lang.Exception e){
                System.out.println("Nhập sai kiểu dữ liệu");
            }
        }
    }
    public Integer inputMaxNumberOfPeople(){
        while (true){
            try{
                scanner = new Scanner(System.in);
                int maxNumberOfPeople = scanner.nextInt();
                if(maxNumberOfPeople > 0 && maxNumberOfPeople < 20){
                    return maxNumberOfPeople;
                }else {
                    System.out.println("Số lượng người phải lớn hơn 0 và bé hơn 20");
                }
            }catch (java.lang.Exception e){
                System.out.println("Nhập sai kiểu dữ liệu");
            }
        }
    }
    public Integer inputNumberOfFloors(){
        while (true){
            try{
                scanner = new Scanner(System.in);
                int numberOfFloors = scanner.nextInt();
                if(numberOfFloors > 0 ){
                    return numberOfFloors;
                }else {
                    System.out.println("Số tầng phải lớn hơn 0");
                }
            }catch (java.lang.Exception e){
                System.out.println("Nhập sai kiểu dữ liệu");
            }
        }
    }
}
