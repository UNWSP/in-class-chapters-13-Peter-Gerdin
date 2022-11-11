import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class InClass {
    public static void main(String[] arg){
        String home = System.getProperty("user.home");
        Path wordFile = Paths.get(home, "Downloads", "example.docx");
        Path notesFile =  Paths.get(home, "Downloads", "example.pages");

        try{
            BasicFileAttributes attrword = Files.readAttributes(wordFile, BasicFileAttributes.class);
            long wordSize = attrword.size();
            BasicFileAttributes attrnotes = Files.readAttributes(notesFile, BasicFileAttributes.class);
            long notesSize = attrnotes.size();
            double ratio = notesSize * 100 / wordSize;

            System.out.println("The word document is " + wordSize + " bytes long");
            System.out.println("The pages document is " + notesSize + " bytes long");
            System.out.println("the Pages file is " + ratio + "% the size of the word file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
