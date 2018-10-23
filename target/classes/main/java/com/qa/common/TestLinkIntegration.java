package com.qa.common;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class TestLinkIntegration {

	public static String DEV_KEY  = "bec36578499c9670b8a6ceb6a46e2"; // Replace your TestLink API Key here
	public static String TESTLINK_URL = "http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php"; 
	// Replace your TestLink url 
	

	public static void reportResult(String TestProject, String TestPlan, String Testcase, String Build, String Notes, String Result) throws TestLinkAPIException {

		TestLinkAPIClient api = new TestLinkAPIClient(DEV_KEY , TESTLINK_URL);

		api.reportTestCaseResult(TestProject, TestPlan, Testcase, Build, Notes, Result);

	}
}




