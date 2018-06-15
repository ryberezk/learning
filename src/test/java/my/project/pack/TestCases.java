package my.project.pack;

import org.testng.annotations.Test;

public class TestCases extends TestBase {

    @Test
    public void createNewIssue() {
        app.getIssueHelper.chooseProject(new ProjectData().withProjectBlockName("project_id").withNameOfChoose("Lala"));
        app.getIssueHelper.openReportIssue();
        app.getIssueHelper.inputData("Text for block");
    }

    @Test
    public void createNewIssueWithEmptyDescription() {
        app.getIssueHelper.chooseProject(new ProjectData("project_id", "Lala"));
        app.getIssueHelper.openReportIssue();
        app.getIssueHelper.inputData("");
        app.getIssueHelper.checkErrorText();
    }
}
