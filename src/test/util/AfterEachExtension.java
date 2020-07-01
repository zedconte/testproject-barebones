package test.util;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;


import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class AfterEachExtension implements AfterEachCallback {


    private static WebDriver driver;


    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void afterEach(ExtensionContext context) throws IOException {
        if (context.getExecutionException().isPresent()) {
            attachScreenshot();
        }
        String testMethodName = context.getTestMethod().orElseThrow().getName();

        driver.quit();
    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] attachScreenshot() throws IOException {
        BufferedImage image = Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).getImage();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);
        return outputStream.toByteArray();
    }
}