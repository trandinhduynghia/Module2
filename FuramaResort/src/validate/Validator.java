package validate;

import exception.UserException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validator {
    public static Date validateBirthday(String birthdayAsString) throws UserException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        Date birthday = null;
        try {
            birthday = format.parse(birthdayAsString);
            Date now = new Date();
            if (now.getYear() - birthday.getYear() < 18) {
                throw new UserException("Tuổi phải lớn hơn hoặc bằng 18!");
            }
            return birthday;
        } catch (ParseException e) {
            throw new UserException("Ngày sinh không đúng định dạng!");
        }
    }

    public static boolean validateName(String name) throws UserException {
        char begin = name.charAt(0);
        if (begin < 65 || begin > 90) {
            throw new UserException("Chữ cái đầu tiên của tên phải viết hoa!");
        }
        return true;
    }
}
