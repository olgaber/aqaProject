package com.provectus.tests.session19;

import com.provectus.pages.ChallengingDomPage;
import org.testng.annotations.Test;

import java.util.List;

public class ChallengingDomTest extends BaseTest{

    @Test
    public void interactWithElements(){

        ChallengingDomPage challengingDomPage = openApp().goToChallengingDomPage();
        challengingDomPage.clickButtons();

        List<String> values = challengingDomPage.getValues();
        challengingDomPage.printValues(values);
    }
}
