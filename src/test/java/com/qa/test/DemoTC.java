package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.common.BaseTest;
import com.qa.common.Retry;
import com.qa.common.TestLinkIntegration;

import testlink.api.java.client.TestLinkAPIResults;

public class DemoTC extends BaseTest {

	String testProject = "DemoProject";  // Provide Project Name form TestLink
	String testPlan = "Demo Test Plan";  // Provide Test Plan Name form TestLink
	String TC_Name = "ValidLogin";       // Provide Test case Name form TestLink
	String build = "Demo Build V1";      // Provide Build Name form TestLink
	String notes = null;
	String result = null;

	@Test(retryAnalyzer = Retry.class)
	public void DemoMethod() throws Exception {

		try {

			WebElement avatar = driver.findElement(By.className("figure"));
			Actions builder = new Actions(driver);
			builder.moveToElement(avatar).build().perform();

			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("figcaption")));

			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

		} catch (Exception e) {

			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();

		} catch (AssertionError e) {

			String message = e.getMessage();
			System.out.println(message);
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();

		} finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, TC_Name, build, notes, result);

		}

	}
}
