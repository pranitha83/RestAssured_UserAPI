package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//
//public class ExtentReportExample {
//	private ExtentReports extent;
//    private ExtentTest test;
//
//    @BeforeClass
//    public void setUp() {
//        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent-report.html");
//        extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
//    }
//
//    @AfterClass
//    public void tearDown() {
//        extent.flush();
//    }
//}




import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReportListener implements ITestListener {

    private ExtentReports extent = ExtentManager.createInstance("extent-report.html");
    private ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
