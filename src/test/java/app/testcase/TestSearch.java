package app.testcase;

import app.page.App;
import app.page.SearchPage;
import org.junit.BeforeClass;
import org.junit.Test;
import java.net.MalformedURLException;

public class TestSearch {
    private static SearchPage searchPage;

    @BeforeClass
    public static void beforeAll() throws MalformedURLException {
        App app=new App();
        app.start();
        searchPage=app.toSearch("");
    }
    @Test
    public void search(){

    }
}
