package org.agile.automationdemo;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import junit.framework.Assert;
import junit.framework.TestCase;

public class HomePageOnFirefoxTest extends TestCase {

	final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_24);
	final String serverIp = System.getProperty("serverIp");
	final String pageURL = "http://" + serverIp + ":8080/cidemo";

	public void testApplicationDeployed() throws Exception {
		final HtmlPage page = webClient.getPage(pageURL);

		Assert.assertTrue(page.isDisplayed());
		
		Assert.assertEquals("CI Demo", page.getTitleText());
		
		webClient.closeAllWindows();
	}

	public void testWelcomeText() throws Exception {
		final HtmlPage page = webClient.getPage(pageURL);

		final String pageAsText = page.asText();
		Assert.assertTrue(pageAsText.contains("CONTINUOUS INTEGRATION"));

		webClient.closeAllWindows();
	}

	public void testDescriptionText() throws Exception {
		final HtmlPage page = webClient.getPage(pageURL);

		final String pageAsXml = page.asXml();
		Assert.assertTrue(pageAsXml.contains("<div class=\"col-12 font-thin\">"));

		webClient.closeAllWindows();
	}

}
