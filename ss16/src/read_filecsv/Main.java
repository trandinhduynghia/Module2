package read_filecsv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.readFile("D:\\Module2\\ss16\\src\\read_filecsv\\contries.csv");
        Country country = new Country(10, "DN", "Da nang");
        main.writeFile("D:\\Module2\\ss16\\src\\read_filecsv\\contries.csv", country);
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


    public void writeFile(String filePath, Country country1){
        List<Country> countrys = new ArrayList<>();
        countrys.add(country1);
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(filePath);
            for(Country country : countrys){
                fileWriter.append(String.valueOf(country.getId()));
                fileWriter.append(",");
                fileWriter.append(country.getCode());
                fileWriter.append(",");
                fileWriter.append(country.getName());
                fileWriter.append("\n");
            }
            System.out.println("ghi file thanh cong");
        }catch (Exception e){
            System.out.println("File không tồn tại hoặc nội dung có lỗi!");
        }finally {
            try{
                fileWriter.flush();
                fileWriter.close();
            }catch (IOException e){
                System.out.println("Loi khi dong file");
            }
        }
    }
}
