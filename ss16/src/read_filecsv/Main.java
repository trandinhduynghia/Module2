package read_filecsv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
//public static void printCountry(List<String> coutry){
//        System.out.println("id: "+ coutry.get(0)+" code: "+ coutry.get(1)+" name: "+ coutry.get(2));
//    }
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.readFile("D:\\Module2\\ss16\\src\\read_filecsv\\contries.csv");
    }
    public List<String> readFile(String fiePath){
        List<String> countrys = new ArrayList<>();
        try{
            File file = new File(fiePath);

            if(!file.exists()){
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null){
                countrys.add(line);
            }
            br.close();
            for(int i = 0; i < countrys.size(); i++){
                System.out.println(countrys.get(i));
            }
        }catch (Exception e){
            System.out.println("File không tồn tại hoặc nội dung có lỗi!");
        }
        return countrys;
    }
}
