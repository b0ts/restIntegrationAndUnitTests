package com.sls;

// sample collaborator to use with MySystemUnderTest - for mockery
public class Collaborator {
    public boolean doStuff(String withArgument) {
        return withArgument.contains("some-thing");
    }
}

