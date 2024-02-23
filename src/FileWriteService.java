import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriteService {

    public String createFile(String strPath) {
        Path newFile;
        try {
            newFile = Files.createFile(Path.of(strPath));
        } catch (FileAlreadyExistsException e) {
            return "File already exists";
        } catch (IOException e) {
            return "Something wrong " + e.getMessage();
        }
        return newFile + " created!";
    }

    public String writeFile(Path path, String content) {
        try {
            Files.writeString(path, content);
        } catch (IOException e) {
            return e.getMessage();
        }
        return "recorded in " + path;
    }
}
