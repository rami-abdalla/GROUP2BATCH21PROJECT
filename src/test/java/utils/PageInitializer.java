package utils;


import pages.DashboardPage;
import pages.LanguageProficiencyPage;
import pages.LoginPage;
import pages.myInfo.EmployeeDependentsPage;
import pages.myInfo.MyInfoPage;

import pages.*;


public class PageInitializer {

    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static LanguageProficiencyPage LanguageProficiencyPage;

    public static MyInfoPage myInfoPage;
    public static EmployeeDependentsPage employeeDependentsPage;

    public static EmployeeSearchPage employeeSearchPage;
    public static LogInDetailsforEmployeePage detailsforEmployeePage;
    public static AddEmployee addEmployeePage;
    public static ESSPersonalInfoPage essPersonalInfoPage;
    public static AddJobDetailsPage addJobDetailsPage;
    public static ProfilePicturePage profilePicturePage;






    public static void initializePageObjects(){

        loginPage =new LoginPage();
        dashboardPage = new DashboardPage();
        LanguageProficiencyPage = new LanguageProficiencyPage();
        myInfoPage=new MyInfoPage();
        employeeDependentsPage=new EmployeeDependentsPage();
        employeeSearchPage = new EmployeeSearchPage();
        detailsforEmployeePage = new LogInDetailsforEmployeePage();
        addEmployeePage =new AddEmployee();
        essPersonalInfoPage = new ESSPersonalInfoPage();
        addJobDetailsPage = new AddJobDetailsPage();
        profilePicturePage =new ProfilePicturePage();


    }
}
