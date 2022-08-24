package com.provectus.tests.session21;
/*Написать тест, который будет скачивать файл с сервера, его модифицировать и потом загружать обратно.

Для скачивания - использовать страницу https://the-internet.herokuapp.com/download
Отсюда нужно скачать любой текстовый файл (при желании - можно усложнить, скачать рандомно любой из текстовых).
В этот файл записать несколько строк (содержимое строк - не важно)
Для загрузки файла на сервер - использовать страницу https://the-internet.herokuapp.com/upload
проверить, что файл загружается

Логику работы со страницами - вынести в классы PageObject
Логика работы с файлами должны быть в тесте*/

import com.provectus.pages.DownloadPage;
import com.provectus.pages.MainPage;
import com.provectus.pages.UploadPage;
import com.provectus.tests.session19.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


public class FileDownloadTest extends BaseTest {

    @Test
    public void downloadTest() throws IOException, InterruptedException {

        //download file
        DownloadPage downloadPage = openApp().goToDownloadPage();
        downloadPage.downloadFile();

        TimeUnit.SECONDS.sleep(3);

        // list files in the folder
/*        File dir = new File("target/downloads/");
        List<File> list = new ArrayList<>();
        for (File file : dir.listFiles()) {
            if (file.isFile())
                list.add(file);
        }
        System.out.println(list.toString());*/

        String fileName = downloadPage.getFileName();

        //update file
        List<String> lines = new ArrayList<>();
        lines.add("Line1");
        lines.add("line2");
        lines.add("line3");
        Path path = Paths.get("target/downloads/" + fileName);
        Files.write(path, lines, StandardOpenOption.APPEND);

        //upload file
        UploadPage uploadPage = openApp().goToUploadPage();
        uploadPage.selectFile(fileName);
        uploadPage.uploadFile();

       Assert.assertEquals(uploadPage.getFeedback(), "File Uploaded!");
    }
}
