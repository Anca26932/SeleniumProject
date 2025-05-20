package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends CommonPage {
//    WebDriver driver;
//
//    ElementsMethods elementsMethods;
//
//    JavascriptHelpers javascriptHelpers;
//
//    Actions actions;
//
//    FramesMethods framesMethods;


//
//    public FramesPage(WebDriver driver, WebDriver driver1, ElementsMethods elementsMethods, JavascriptHelpers javascriptHelpers, Actions actions, FramesMethods framesMethods, WindowsMethods windowsMethods, WebElement frame1Element, WebElement sampleHeadingFrame1Element, WebElement frame2Element, WebElement sampleHeadingFromFrame2Element) {
//        super(driver);
//        this.driver = driver1;
//        this.elementsMethods = elementsMethods;
//        this.javascriptHelpers = javascriptHelpers;
//        this.actions = actions;
//        this.framesMethods = framesMethods;
//        this.frame1Element = frame1Element;
//        this.sampleHeadingFrame1Element = sampleHeadingFrame1Element;
//        this.frame2Element = frame2Element;
//        this.sampleHeadingFromFrame2Element = sampleHeadingFromFrame2Element;


//    public FramesPage(WebDriver driver, ElementsMethods elementsMethods, JavascriptHelpers javascriptHelpers, Actions actions, FramesMethods framesMethods,WindowsMethods) {
//        super();
//        this.driver = driver;
//        this.elementsMethods = elementsMethods;
//        this.javascriptHelpers = javascriptHelpers;
//        this.actions = actions;
//        this.framesMethods = framesMethods;
//
//        PageFactory.initElements(driver,this);

    // }
    @FindBy(id = "frame1")
    private WebElement frame1Element;

    @FindBy(id = "sampleHeading")
    private WebElement sampleHeadingFrame1Element;

    @FindBy(id = "frame2")
    private WebElement frame2Element;

    @FindBy(id = "sampleHeading")
    private WebElement sampleHeadingFromFrame2Element;

    public FramesPage(WebDriver driver) {
        super(driver);
    }


    public void interactWithFrame1() {
        framesMethods.switchToFrame(frame1Element);
        elementsMethods.displayContentOfElement(sampleHeadingFrame1Element);
        framesMethods.switchToMainContent();


    }

    public void interactWithFrame2() {
        framesMethods.switchToFrame(frame2Element);
        elementsMethods.displayContentOfElement(sampleHeadingFromFrame2Element);
        framesMethods.switchToMainContent();
    }

}












