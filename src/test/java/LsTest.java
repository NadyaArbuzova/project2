import com.example.project2.Ls;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class LsTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();


    @BeforeEach
    public void setOutput(){
        System.setOut(new PrintStream(output));
    }

    @Test
    void main1() throws IOException {
        Ls.main(new String[]{"-l", "-h", "directory_or_file"});
        assertEquals(new ArrayList<String>() {{
            add("1 111 1681471716574 18\n");
            add("1 rwx 0kb\n");
            add("ab 111 1681471716566 13\n");
            add("ab rwx 0kb\n");
            add("cvb 111 1681470635475 0\n");
            add("cvb rwx 0kb\n");
        }}.toString(), output.toString());
    }
    @Test
    void main2() throws IOException {
        Ls.main(new String[]{"-l", "directory_or_file"});
        assertEquals(new ArrayList<String>() {{
            add("1 111 1681471716574 18\n");
            add("ab 111 1681471716566 13\n");
            add("cvb 111 1681470635475 0\n");
        }}.toString(), output.toString());
    }

    @Test
    void main3() throws IOException {
        Ls.main(new String[]{"-l", "-r", "-o", "output", "directory_or_file"});
        File f = new File("output");
        String s = Files.readString(Paths.get(f.getPath()));
        assertEquals(new ArrayList<String>() {{
            add("cvb 111 1681470635475 0\n");
            add("ab 111 1681471716566 13\n");
            add("1 111 1681471716574 18\n");
        }}.toString(), s);
    }
}