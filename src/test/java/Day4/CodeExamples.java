package Day4;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CodeExamples {

    @DataProvider(name= "string")
    public Object[][] createData1(){
        return new Object[][]{
                {"madam"},
                {"jubkbj"},
        };

    }


    @Test(dataProvider = "strings")
    public void testIsPalindrome(String parameter){
        String input = parameter;
        String reversed = "";
        input = input.toLowerCase();
        Assert.assertEquals(input,reversed);
    }
    
    public String reverseString(String input) {
        return new StringBuffer(input).reverse().toString(); 
    }

}

