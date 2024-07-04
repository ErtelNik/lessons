import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Test16point2 extends Parent {

    private void switchToPayment() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Ожидание появления поля ввода телефона и суммы
        WebElement phone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PHONE_NUMBER_FIELD)));
        phone.click();
        phone.sendKeys(PHONE_NUMBER);

        WebElement sum = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SUM_NUMBER_FIELD)));
        sum.click();
        sum.sendKeys("3");
        sum.submit();

        // Ожидание появления iframe
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(IFRAME_PAYMENT)));
        driver.switchTo().frame(iframe);
    }

    @Test
    @DisplayName("Проверить корректность отображения суммы в окне (в том числе на кнопке)")
    public void checkSumCorrect() {
        switchToPayment();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement depositAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = '3.00 BYN']")));
        WebElement buttonDepositAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BUTTON_DEPOSIT_XPATH)));

        assertAll(
                () -> assertEquals("3.00 BYN", depositAmount.getText()),
                () -> assertEquals("Оплатить 3.00 BYN", buttonDepositAmount.getText()));
    }

    @Test
    @DisplayName("Отображение номера телефона")
    public void checkPhoneNumberCorrect() {
        switchToPayment();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement paymentInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay-description__text']/span")));
        String expected = "Оплата: Услуги связи Номер:375297777777";
        assertEquals(expected, paymentInfo.getText());
    }

    @Test
    @DisplayName("Надписи в незаполненных полях для ввода реквизитов карты")
    public void checkTextIBlankCard() {
        switchToPayment();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement cardNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Номер карты']")));
        WebElement durationPeriodField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Срок действия']")));
        WebElement holderNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Имя держателя (как на карте)']")));
        WebElement CVCField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='CVC']")));

        String expectedCardNumberField = "Номер карты";
        String expectedDurationPeriodField = "Срок действия";
        String expectedHolderNameField = "Имя держателя (как на карте)";
        String expectedCVCField = "CVC";

        assertAll(
                () -> assertEquals(expectedCardNumberField, cardNumberField.getText()),
                () -> assertEquals(expectedDurationPeriodField, durationPeriodField.getText()),
                () -> assertEquals(expectedHolderNameField, holderNameField.getText()),
                () -> assertEquals(expectedCVCField, CVCField.getText()));
    }

    @Test
    @DisplayName("Иконки платёжных систем")
    public void checkPaymentSystemIcon() {
        switchToPayment();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='header__container']")));
        List<WebElement> logoElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='icons-container ng-tns-c46-1']")));
        for (WebElement logo : logoElements) {
            assertTrue(logo.isDisplayed());
        }
    }
}
