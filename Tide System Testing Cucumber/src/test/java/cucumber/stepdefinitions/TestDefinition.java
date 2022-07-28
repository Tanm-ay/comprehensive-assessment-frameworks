package cucumber.stepdefinitions;

import com.mindtree.pageobject.ChangeLanguagePageObject;
import com.mindtree.pageobject.HomePageObject;
import com.mindtree.pageobject.HowToWashPageObject;
import com.mindtree.pageobject.LiveChatPageObject;
import com.mindtree.pageobject.PowderFooterPageObject;
import com.mindtree.pageobject.SearchResultPageObject;
import com.mindtree.pageobject.SignUpFormPageObject;
import com.mindtree.pageobject.SignUpPageObject;
import com.mindtree.pageobject.TncFooterPageObject;
import com.mindtree.runner.Runner;
import com.mindtree.utilities.BaseClass;
import com.mindtree.utilities.FetchFromExcelFile;
import com.mindtree.utilities.IntegrateExtentReport;
import com.mindtree.utilities.OpenReportAtEnd;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestDefinition extends Runner
{
	Scenario scene;

	@Before("@first")
	public void extentReport()
	{

		BaseClass.ExecutionFlag = false;
		reportObject = new IntegrateExtentReport();
		reportPath = reportObject.addExtentReport(reportPath);
	}

	@Before
	public void initObjects(Scenario current)
	{
		this.scene = current;
		fetchCell = new FetchFromExcelFile();
		baseObject = new BaseClass();
		homeObject = new HomePageObject();
		liveObject = new LiveChatPageObject();
		tncObject = new TncFooterPageObject();
		washObject = new HowToWashPageObject();
		searchObject = new SearchResultPageObject();
		signObject = new SignUpPageObject();
		formObject = new SignUpFormPageObject();
		powderObject = new PowderFooterPageObject();
		langObject = new ChangeLanguagePageObject();
	}

	@After(order = 1)
	public void flushReport()
	{
		BaseClass.ExecutionFlag = false;
		BaseClass.ext.flush();
	}

	@After(value = "@last", order = 0)
	public void openReport()
	{
		driver = baseObject.initializeDriver(5, "Configure", "Chrome");
		openReport = new OpenReportAtEnd();
		openReport.reportOpen(driver, reportPath);
	}

	@Given("Website link is working")
	public void website_link_is_working()
	{
		BaseClass.ts = BaseClass.ext.createTest(scene.getName());
		driver = baseObject.initializeDriver(5, "Configure", "Chrome");

	}

	@When("I land on website")
	public void i_land_on_website()
	{
		baseObject.navigateToUrl(driver, "Configure", "Tide");
	}

	@Then("A promotional image should appear")
	public void a_promotional_image_should_appear()
	{
		homeObject.verifyPromoImg(driver);
	}

	@Given("I am on website's homepage")
	public void i_am_on_website_s_homepage()
	{
		BaseClass.ts = BaseClass.ext.createTest(scene.getName());
		driver = baseObject.initializeDriver(5, "Configure", "Chrome");
		baseObject.navigateToUrl(driver, "Configure", "Tide");
	}

	@When("I click on P&G icon")
	public void i_click_on_p_g_icon()
	{
		homeObject.clickPngIcon(driver);
	}

	@Then("I am redirected to P&G website")
	public void i_am_redirected_to_p_g_website()
	{
		homeObject.verifyPngRedirect(driver, fetchCell.fetchCellData(2, 'B'));
	}

	@When("I click on Live Chat")
	public void i_click_on_live_chat()
	{
		homeObject.clickLiveChat(driver);
	}

	@Then("REAL-TIME CHAT SUPPORT is displayed on page")
	public void real_time_chat_support_is_displayed_on_page()
	{
		liveObject.verifyLiveChatText(driver, fetchCell.fetchCellData(2, 'C'));
	}

	@When("I click Terms & Conditions footer link")
	public void i_click_terms_conditions_footer_link()
	{
		homeObject.clickFooterTncLink(driver);
	}

	@Then("Copyrights And Trademarks link should be present on screen")
	public void copyrights_and_trademarks_link_should_be_present_on_screen()
	{
		tncObject.verifyCntLink(driver, fetchCell.fetchCellData(2, 'D'));
	}

	@Then("P&G should be present on page")
	public void p_g_should_be_present_on_page()
	{
		homeObject.verifyPngHome(driver, fetchCell.fetchCellData(2, 'E'));
	}

	@When("I hover mouse over How to Wash Clothes")
	public void i_hover_mouse_over_how_to_wash_clothes()
	{
		homeObject.hoverHowToWashClothes(driver);
	}

	@And("Click Washing Machine {int}")
	public void click_washing_machine(Integer int1)
	{
		homeObject.clickWashingMachine101(driver);
	}

	@Then("How to Use a Washing Machine should be present on page")
	public void how_to_use_a_washing_machine_should_be_present_on_page()
	{
		washObject.verifyWashing101Text(driver, fetchCell.fetchCellData(2, 'F'));
	}

	@When("I click search box")
	public void i_click_search_box()
	{
		homeObject.clickSearchBox(driver);
	}

	@And("Enter text And press Enter")
	public void enter_text_and_press_enter()
	{
		homeObject.enterTextIntoSearchBox(driver, fetchCell.fetchCellData(2, 'G'));
	}

	@Then("That text should be present on top of the page")
	public void that_text_should_be_present_on_top_of_the_page()
	{
		searchObject.verifytResult(driver, fetchCell.fetchCellData(2, 'G'));
	}

	@When("I click Register link")
	public void i_click_register_link()
	{
		homeObject.clickRegister(driver);
	}

	@And("Click Sign up now")
	public void click_sign_up_now()
	{
		signObject.clickSignUp(driver);
	}

	@And("Enter the details")
	public void enter_the_details()
	{
		formObject.enterName(driver, fetchCell.fetchCellData(2, 'H'));
		formObject.enterEmail(driver, fetchCell.fetchCellData(2, 'I'));
		formObject.enterPassword(driver, fetchCell.fetchCellData(2, 'J'));
	}

	@Then("System should validate the details")
	public void system_should_validate_the_details()
	{
		formObject.verifyValidAccount(driver);
	}

	@And("Enter wrong details")
	public void enter_wrong_details()
	{
		formObject.enterName(driver, fetchCell.fetchCellData(2, 'K'));
		formObject.enterEmail(driver, fetchCell.fetchCellData(2, 'L'));
		formObject.enterPassword(driver, fetchCell.fetchCellData(2, 'M'));
	}

	@Then("System should invalidate wrong details")
	public void system_should_invalidate_wrong_details()
	{
		formObject.verifyInvalidAccount(driver);
	}

	@When("I click Powder footer link")
	public void i_click_powder_footer_link()
	{
		homeObject.clickFooterPowder(driver);
	}

	@Then("First displayed result should contain the word Powder")
	public void first_displayed_result_should_contain_the_word_powder()
	{
		powderObject.verifyFirstResult(driver, fetchCell.fetchCellData(2, 'N'));
	}

	@When("I click US-English")
	public void i_click_us_english()
	{
		homeObject.clickUsEnglish(driver);
	}

	@And("Click US-Spanish")
	public void click_us_spanish()
	{
		langObject.clickSpanish(driver);
	}

	@Then("Website's language should change to Spanish")
	public void website_s_language_should_change_to_spanish()
	{
		langObject.verifyWebsiteLanguage(driver, fetchCell.fetchCellData(2, 'O'));
	}

}
