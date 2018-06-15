package my.project.pack;

import org.testng.annotations.Test;

public class TestCases extends TestBase {

    @Test
    public void createNewIssue() {
        chooseProject(new ProjectData().withProjectBlockName("project_id").withNameOfChoose("Lala"));
        openReportIssue();
        inputData("Text for block");
    }

    @Test
    public void createNewIssueWithEmptyDescription() {
        chooseProject(new ProjectData("project_id", "Lala"));
        openReportIssue();
        inputData("");
        checkErrorText ();
    }
}
