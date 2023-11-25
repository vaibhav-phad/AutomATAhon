package Ata.JiraCh3;

public class ObjectRepository {
	String Username = "//input[@id='login-form-username']";
	String Passowrd = "//input[@id='login-form-password']";
	String Loginbtn = "//input[@id='login']";

	String ProjectTab = "//a[text()='Projects' and @id='browse_link']";
	String CrtProject = "//a[text()='Create project']";
	String ProjctType = "//div[text()='Kanban software development']";
	String NextBtn = "//button[text()='Next']";
	String SelctBtn = "//button[text()='Select']";
	String name = "//input[@id='name']";
	String SubmitBtn = "//Button[text()='Submit']";
	
	String CreateBtn = "//a[text()='Create']";
	String IssueType = "//input[@id='issuetype-field']";
	String Summary = "//input[@id='summary']";
	String Priority = "//input[@id='priority-field']";
	String Labels = "//*[@id='labels-textarea']";
	String issueCreatebtn = "//*[@id='create-issue-submit']";
}
