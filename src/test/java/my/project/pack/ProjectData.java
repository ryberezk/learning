package my.project.pack;

public class ProjectData {
    private String project;
    private String nameOfChoose;

    public ProjectData(String project, String nameOfChoose) {
        this.project = project;
        this.nameOfChoose = nameOfChoose;
    }

    public ProjectData() {
    }

    public ProjectData withProject (String project){
        this.project = project;
        return this;
    }

    public ProjectData withNameOfChoose (String nameOfChoose){

        this.nameOfChoose = nameOfChoose;
        return this;
    }

    public String getProject() {
        return project;
    }

    public String getNameOfChoose() {
        return nameOfChoose;
    }
}
