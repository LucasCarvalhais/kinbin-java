package com.kinbin.kinbin.loader;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TransitionParserTest {

    @Test
    public void shouldParseColumnHeaders() {
        String line = "ID,Link,Name,New,In Analysis,Ready,In Progress,Waiting,Accepted,Done,Type,";
        TransitionParser transitionParser = new TransitionParser();

        transitionParser.parseColumnHeaders(line);

        assertThat(transitionParser.getColumnsHeaders().size(), is(11));
    }

    

}
