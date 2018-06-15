package my.project.pack;

import org.testng.annotations.Test;

public class TestCases extends TestBase {

    @Test
    public void createNewIssue() {
        chooseProject("project_id");
        openReportIssue();
        inputData("Text for block");
    }

    @Test
    public void createNewIssueWithEmptyDescription() {
        chooseProject("project_id");
        openReportIssue();
        inputData("");
        checkErrorText ();
    }
}
