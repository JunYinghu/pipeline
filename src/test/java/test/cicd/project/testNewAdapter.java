package test.cicd.project;

import com.priortest.api.PTAPIAdapter;
import com.priortest.model.Config;
import org.junit.BeforeClass;

public class testNewAdapter {

    @BeforeClass
    public void setUp() {
        Config config = new Config("your_project_id", "http://43.139.159.146:8082", "your_user_token", "your_email");

        PTAPIAdapter adapter = new PTAPIAdapter();

    }
}
