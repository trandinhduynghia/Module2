package read_write_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static void main(String[] args) {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try{
            inputStream = new FileInputStream(new File("D:\\Module2\\ss16\\src\\read_write_file\\text"));
            outputStream = new FileOutputStream(new File("D:\\Module2\\ss16\\src\\read_write_file\\coppytext"));

            int length;
            byte[] buffer = new byte[1024];

            while ((length = inputStream.read(buffer)) > 0){
                outputStream.write(buffer, 0, length);
            }
            System.out.println("Coppy file thanh cong");
            inputStream.close();
            outputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
