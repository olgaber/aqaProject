package com.provectus.tests.session22;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.provectus.selenidePages.SelenideDownloadPage;
import com.provectus.selenidePages.SelenideUploadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class SelenideDownloadTest {

    @Test
    public void DownloadUploadTest() throws IOException, URISyntaxException, InterruptedException {

        SelenideDownloadPage sdp = new SelenideDownloadPage();
        SelenideUploadPage sup = new SelenideUploadPage();

        // Configuration.browser = "firefox";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.savePageSource = false;

        open("/download");

        String fileName = sdp.getFileName();
        String fileUrl = Configuration.baseUrl + "/download/" + fileName;

        File file = Selenide.download(fileUrl);

        System.out.println("FILE Path: " + file.getPath());

        //update file
        List<String> lines = new ArrayList<>();
        lines.add("Line1");
        lines.add("line2");
        lines.add("line3");
        Path path = Paths.get(file.getPath());
        Files.write(path, lines, StandardOpenOption.APPEND);

        open("/upload");

        sup.selectFile(file.getPath());
        TimeUnit.SECONDS.sleep(3);
        sup.uploadFile();
// ???? открывется страница This site can't be reached
        Assert.assertEquals(sup.getFeedback(), "File Uploaded!");
    }
}
