package page_object_model.testData;

import org.testng.annotations.DataProvider;
import page_object_model.utilities.ExcelUtils;

import java.io.IOException;

public class DataProviderClass {

    @DataProvider(name = "searchData")
    public static Object[][] searchData() throws IOException {
        return ExcelUtils.getTestData("C:\\Users\\user\\Documents\\testData.xlsx", "TestData");
    }
    @DataProvider(name = "SearchRefNo")
    public static Object[][] SearchRefNo() throws IOException {
        return ExcelUtils.getOrderReference("C:\\Users\\user\\Documents\\testData.xlsx", "OrderReference");
    }
}
