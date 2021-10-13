package telran;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CompareFiles {
    public static boolean isTheSame(String path_1, String path_2){
        try(FileInputStream fn1 = new FileInputStream(path_1);
            FileInputStream fn2 = new FileInputStream(path_2)) {

            if (fn1.available() != fn2.available()){
                return false;
            }

            for (int i = 0; i < fn1.available(); i++){
                if (fn1.read() != fn2.read()){
                    return false;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
