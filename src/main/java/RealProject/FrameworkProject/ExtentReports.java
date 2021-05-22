package RealProject.FrameworkProject;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReports {
ExtentReports extent;
	public  ExtentReports getReport() {
		String path = 	System.getProperty("user.dir")+"\\reports\\index.html" ;             //Here it will create a new file inside the our working directory
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		//To set reporter name
		
		reporter.config().setReportName("WebAutomation Result");
		reporter.config().setDocumentTitle("Test Result");
		
		//To drive reporting execution result
		 extent = new ExtentReports();
		//To attach the report
		extent.attachReporter(reporter);
		//To set tester name
		extent.setSystemInfo("Tester", "Prathap");
		return extent;
		
	}
	private void setSystemInfo(String string, String string2) {
		// TODO Auto-generated method stub
		
	}
	private void attachReporter(ExtentSparkReporter reporter) {
		// TODO Auto-generated method stub
		
	}
	
}



//When we are running in sequential mode it will run clearly
/*If we run in parallel then testcase may override will give test failure report inconsistantly...to overcome for this issue
--->ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
...
extentTest.set(test)
//T/o pull screenshot in extent report --->addscreencaptureFromPath()
*/