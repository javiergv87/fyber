package com.pom.components;

import com.pom.abstracts.AbstractImdbPage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

/**
 * Created by Javi on 27/11/2016.
 */
@Component
public class GenrerMenuComponent extends AbstractImdbPage {

    final static By MENU_COMPONENT = By.cssSelector(".quicklinks");

    public void clickOnGenrer(final String genrer) {
        find(MENU_COMPONENT).findElement(By.partialLinkText(genrer)).click();
    }
}
