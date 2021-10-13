package telran;

public class CompareFilesApp {
    public static void main(String[] args) {
        boolean myCompare = CompareFiles.isTheSame("src/telran/first.txt",  "src/telran/second.txt");
        System.out.println(myCompare);
    }
}
