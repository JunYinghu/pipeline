package test.cicd.project.Utili;

import org.omg.CORBA.Environment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class CreateEnvFile {

    public void createFile(String Platform, String repo , String Version) {

        Properties properties = new Properties();
        properties.setProperty("Platform", Platform);
        properties.setProperty("Repo", repo);
        properties.setProperty("Version", Version);
        FileWriter writer = null;
        try {
            writer = new FileWriter("allure-results\\environment.properties");
            properties.store(writer, "Jiri Pinkas");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
