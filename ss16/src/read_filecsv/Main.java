package read_filecsv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
//public List<String> readFile(String fiePath){
//        List<String> countrys = new ArrayList<>();
//       try{
//           File file = new File(fiePath);
//           if(!file.exists()){
//               throw new FileNotFoundException();
//            }
//            BufferedReader br = new BufferedReader(new FileReader(file));
//           String line = "";
//            while ((line = br.readLine()) != null){
//               countrys.add(line);
//           }
//            br.close();
//            for(int i = 0; i < countrys.size(); i++){
//               System.out.println(countrys.get(i));
//           }
//        }catch (Exception e){
//            System.out.println("File không tồn tại hoặc nội dung có lỗi!");
//        }
//       return countrys;
//    }
//public void writeFile(String filePath, Country country1) throws IOException {
//        List<Country> countrys = new ArrayList<>();
//        countrys.add(country1);
//        FileWriter fileWriter = null;
//        try{
//            fileWriter = new FileWriter(filePath,true);
//            for(Country country : countrys){
//                fileWriter.append(String.valueOf(country.getId()));
//                fileWriter.append(",");
//                fileWriter.append(country.getCode());
//                fileWriter.append(",");
//                fileWriter.append(country.getName());
//                fileWriter.append("\n");
//            }
//            System.out.println("Ghi file không thành công!");
//        }catch (Exception e){
//            System.out.println("File không tồn tại hoặc nội dung có lỗi!");
//        }finally{
//            try{
//                fileWriter.flush();
//                fileWriter.close();
//            }catch (IOException e){
//                System.out.println("Đóng file không thành công!");
//            }
//        }
//    }
public class Main {
    public static void main(String[] args) throws IOException {
        List<Country> countrys = new ArrayList<>();
        countrys.add(new Country(20,"HN","Ha Noi"));
        countrys.add(new Country(30, "HCM", "Ho Chi Minh"));
        Main main = new Main();
        main.readFile("D:\\Module2\\ss16\\src\\read_filecsv\\contries.csv");
        main.writeFile("D:\\Module2\\ss16\\src\\read_filecsv\\contries.csv",countrys,true);
    }
    public List<Country> readFile(String path){
        String DELIMITER = ",";
        String EMPTY = "";
        List<Country> countrys = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String temp;
            while ((temp = reader.readLine()) != null){
                if(EMPTY.equals(temp.trim())){
                    continue;
                }
                String[] result = temp.split(DELIMITER);
                if(result.length != 3){
                    continue;
                }
                int id = Integer.parseInt(result[0]);
                String code = result[1];
                String name = result[2];
                countrys.add(new Country(id, code, name));
            }
            for(int i = 0; i < countrys.size(); i++){
                System.out.println(countrys.get(i));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return countrys;
    }
    public void writeFile(String path, List<Country> coutrys, boolean append){
        String DELIMITER = ",";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path, append))){
            for(Country country: coutrys){
                writer.write(country.getId() + DELIMITER+country.getCode()+DELIMITER+country.getName());
                writer.newLine();
            }
            System.out.println("Ghi file thanh cong");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
