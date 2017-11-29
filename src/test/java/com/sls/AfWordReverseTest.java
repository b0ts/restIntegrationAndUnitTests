package com.sls;

import java.util.*;
import org.junit.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.BDDMockito.given;

public class AfWordReverseTest {
    class TestData {
        String input;
        String expected;
        TestData(String input, String expected) {
            this.input = input;
            this.expected = expected;
        }
    }

    @Test
    public void wordReverseTest() throws Exception {
        System.out.println("wordReverseHappyTest activated");
        AfWordReverse wr = new AfWordReverse();
        //AfWordReverse wr = mock(AfWordReverse.class); // mocked CUT

        ArrayList<TestData> testData = new ArrayList<TestData>();
        testData.add(new TestData("",""));
        testData.add(new TestData("One", "One"));
        testData.add(new TestData("One Two", "Two One"));
        testData.add(new TestData("The Quick Brown Fox",
                "Fox Brown Quick The"));
        testData.add(new TestData("The Quick Brown Fox jumped over the stream.",
                "stream the over jumped Fox Brown Quick The."));
        for (TestData td: testData) {
            //given(wr.wordReverse(td.input)).willReturn(td.expected); // mocked results

            String results = wr.wordReverse(td.input);
            Assert.assertEquals("wordReverseTest - Match failure", td.expected, results);
        }
    }
}
