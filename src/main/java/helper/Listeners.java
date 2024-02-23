package helper;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listeners implements ITestListener {
    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        String testName = iTestResult.getMethod().getMethodName();
        System.out.println("Test Case Started: " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logResult("PASSED");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logResult("FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logResult("SKIPPED");
    }

    @Step("{0}")
    private void logResult(String status) {
        System.out.println("Test Case Result: " + status);
    }

    @Attachment(value = "Test Failure Screenshot", type = "image/png")
    private byte[] captureScreenshot() {
        return null;
    }

    @Description("Failure Details:")
    private String logFailureDetails(ITestResult iTestResult) {
        return null;
    }
}
