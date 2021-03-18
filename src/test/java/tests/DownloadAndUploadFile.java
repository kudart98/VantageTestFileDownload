package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DownloadAndUploadFile {


    String url = "https://the-internet.herokuapp.com";

    @Test
    void downloadTest() throws FileNotFoundException {
    //https://selenide.org/2019/12/10/advent-calendar-download-files/

        open(url);
        $(byText("File Download")).click();
        File f = $(byText("upload_file.xlsx")).download(1000);
        f.exists();
        String name = f.getName();
        $(byText("upload_file.xlsx")).shouldHave(Condition.text(name));
      //  sleep(5000);
    }

    @Test
    void uploadTest() {

        open(url);
        $(byText("File Upload")).click();
        $("#file-upload").uploadFile(new File("./src/test/resources/img/img1.jpg"));
        $("#file-submit").click();
        $(byText("File Uploaded!")).shouldHave(Condition.text("File Uploaded!"));


    }
}
