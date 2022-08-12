package tim_gia_tri_lon_nhat_va_ghi_ra_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadAndWrieFile {
    public static void main(String[] args) {
        ReadAndWrieFile readAndWrieFile = new ReadAndWrieFile();
        List<Integer> numbers = readAndWrieFile.readFile("D:\\Module2\\ss16\\src\\tim_gia_tri_lon_nhat_va_ghi_ra_file\\numbers");
        int max = findMax(numbers);
        readAndWrieFile.writeFile("D:\\Module2\\ss16\\src\\tim_gia_tri_lon_nhat_va_ghi_ra_file\\text",max);
    }
    public List<Integer> readFile(String fiePath) {
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(fiePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("File không tồn tại hoặc nội dung có lỗi!");
        }
        return numbers;
    }

    public void writeFile(String filePath, int max) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Gia tri lon nhat la:" + max);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }
}


