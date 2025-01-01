package pageObjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;


public class PaginationPage extends PageObject {

    public static final By NEXT_PAGE = By.cssSelector("#root>div>div.products-wrapper>div>div>div>div>div>div.col-xs-8>ul>li:nth-child(7)>a");

    public static final By PREV_PAGE = By.cssSelector("#root>div>div.products-wrapper>div>div>div>div>div>div.col-xs-8>ul>li:nth-child(2)>a");

    public static final By FIRST_PAGE = By.cssSelector("#root>div>div.products-wrapper>div>div>div>div>div>div.col-xs-8>ul>li.active>a");
    public static final By SECOND_PAGE = By.cssSelector("#root>div>div.products-wrapper>div>div>div>div>div>div.col-xs-8>ul>li:nth-child(4)>a");

}