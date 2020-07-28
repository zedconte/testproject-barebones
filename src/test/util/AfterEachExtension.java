/*
 * testproject-challenge
 * Copyright (C) 2020  Raul Ortega
 *
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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