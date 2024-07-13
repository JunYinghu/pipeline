package payload;

import com.priortest.config.PTApiFieldSetup;

public class PayloadFieldSetup {

    public static void category(String category) {
        PTApiFieldSetup.setCategory(category);
    }

    public static void priority(String priority) {
        PTApiFieldSetup.setPriority(priority);
    }

    public static void severity(String priority) {
        PTApiFieldSetup.setSeverity(priority);
    }

    public static void testStatus(String status) {
        PTApiFieldSetup.setSeverity(status);
    }
}
