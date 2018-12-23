package test.cicd.project.Utili;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class CreateEnvFile {

    public void createFile(String platForm, String buildUrl, String testUrl) {

        Properties properties = new Properties();
        properties.setProperty("Platform", platForm);
        properties.setProperty("BuildUrl", buildUrl);
        properties.setProperty("TestUrl", testUrl);
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
