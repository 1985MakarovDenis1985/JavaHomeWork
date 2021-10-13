package telran;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CompareFiles {
    public static boolean isTheSame(String... paths) {
        try (FileInputStream fn1 = new FileInputStream(paths[0]);
             FileInputStream fn2 = new FileInputStream(paths[1])) {

            if (fn1.available() != fn2.available()) {
                return false;
            }

            int x = fn1.read();
            int y = fn2.read();
            while (x != -1) {
                if (x != y) return false;
                x = fn1.read();
                y = fn2.read();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
