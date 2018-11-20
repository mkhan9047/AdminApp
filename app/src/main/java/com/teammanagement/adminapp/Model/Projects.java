package com.teammanagement.adminapp.Model;

public class Projects {

    private String projectName;
    private String projectStatus;
    private String startDate;
    private String endDate;

    public Projects(String projectName, String projectStatus, String startDate, String endDate) {
        this.projectName = projectName;
        this.projectStatus = projectStatus;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    public String getProjectName() {
        return projectName;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
