import java.nio.file.Paths;
import java.util.Scanner;

public class Main {


    static String text;
    static String fileName;
    static String choice;


    public static void main(String[] args) {

        handleData();

    }

    private static void handleData() {

        getData();
        String strPath = Constants.BASE_PATH_IN + fileName;
        FileWriteService fws = new FileWriteService();
        if (Integer.parseInt(choice) == 1) {
            getOutput(createData(fws, strPath));
            getOutput(writeData(fws, strPath));
        } else {
            getOutput(readData(strPath));
        }
    }


    private static void getData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                What would you like to do:
                                
                1 - to create new file with info
                2 - to read the file
                                
                """
        );

        choice = sc.nextLine();

        if (Integer.parseInt(choice) == 1) {
            System.out.println("Enter your text");
            text = sc.nextLine().trim();
            System.out.println("Enter file name: ");
            fileName = sc.nextLine().trim();
        } else if (Integer.parseInt(choice) == 2) {
            System.out.println("Enter file name: ");
            fileName = sc.nextLine().trim();
        } else {
            System.out.println("Try again");
        }
        sc.close();
    }

    private static String createData(FileWriteService fws, String strPath) {
        return fws.createFile(strPath);
    }

    private static String writeData(FileWriteService fws, String strPath) {
        return fws.writeFile(Paths.get(strPath), text);
    }

    private static String readData(String strPath) {
        return new FileReadService().readFile(strPath);
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }
}
