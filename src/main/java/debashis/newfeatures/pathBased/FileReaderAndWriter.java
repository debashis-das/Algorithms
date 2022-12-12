package debashis.newfeatures.pathBased;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReaderAndWriter {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./resources/sample.txt");
        String fileContent = Files.readString(path);
        System.out.println(fileContent);
        String newFileCOntent = fileContent.replace("test2", "test123435");
        Path newPath = Paths.get("./resources/sample-new.txt");
        Files.writeString(newPath,newFileCOntent);
        System.out.println(Files.readString(newPath));
    }
}
