package utilities;

import org.testng.annotations.DataProvider;
import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {

        String path = ".\\testData\\login_test_data.xlsx";

        ExcelUtility xlutil = new ExcelUtility(path);

        int totalrows = xlutil.getRowCount("Sheet1");
        int totalcols = xlutil.getCellCount("Sheet1", 1);

        String[][] logindata = new String[totalrows][totalcols];  // cleaner

        for (int i = 1; i <= totalrows; i++) {
            for (int j = 0; j < totalcols; j++) {
                logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
            }
        }

        return logindata;
    }
        @DataProvider(name = "searchData")
        public Object[][] getSearchData(){
            return new Object[][]{
                    {"XYZ123"},
                    {"@@@###"},
                    {"123456"},
                    {"invalidproduct"}
            };
        }
    }
