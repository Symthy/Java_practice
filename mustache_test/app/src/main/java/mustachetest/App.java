/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package mustachetest;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.PosixFilePermissions;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;
import mustachetest.SampleContext;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new App().getGreeting());
        new App().invoke();
    }

    private void invoke() throws IOException {
        String templateText = getResourceText("sample.yaml.template");
        Template template = Mustache.compiler().compile(templateText);

        Path outFilePath = Paths.get("sample.yaml");
        createFile(outFilePath);
        try (BufferedWriter writer = Files.newBufferedWriter(outFilePath)) {
            SampleContext context = new SampleContext();
            template.execute(context, writer);
            //String out = template.execute(context);
            //System.out.println(out);
        }
    }

    private String getResourceText(String filePath) throws IOException {
        System.out.println(getClass().getClassLoader().getResource("sample.yaml.template"));
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(filePath)) {
            String templateText = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            System.out.println(templateText);
            return templateText;
        }
    }

    private void createFile(Path outFilePath) throws IOException {
        if (Files.exists(outFilePath)) {
            Files.delete(outFilePath);
        }
        Set<PosixFilePermission> perms = new HashSet<PosixFilePermission>();
        //add owners permission
        perms.add(PosixFilePermission.OWNER_READ);
        perms.add(PosixFilePermission.OWNER_WRITE);
        Files.createFile(outFilePath, PosixFilePermissions.asFileAttribute(perms));
    }
}
