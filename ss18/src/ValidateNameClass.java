import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateNameClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào tên lớp học: ");
        String nameClass = scanner.nextLine();
        ValidateNameClass nameClassExample = new ValidateNameClass();
        System.out.println(nameClass + " : "+nameClassExample.validate(nameClass));
    }

    private static final String NAME_CLASE_REGEX  = "([P,A,C]{1})([0-9]{4})([G,H,I,K,L,M]{1})";
    public ValidateNameClass(){

    }

    public boolean validate(String regex){
        Pattern pattern = Pattern.compile(NAME_CLASE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
