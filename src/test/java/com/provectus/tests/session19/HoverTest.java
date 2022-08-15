package com.provectus.tests.session19;

import com.provectus.pages.HoverPage;
import org.testng.annotations.Test;

public class HoverTest extends BaseTest{

    @Test
    public void hover() {

        HoverPage hoverPage = openApp().goToHoverPage();
        hoverPage.printNames();
    }

}
