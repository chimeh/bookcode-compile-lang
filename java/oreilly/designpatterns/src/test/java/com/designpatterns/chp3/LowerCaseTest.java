package com.designpatterns.chp3;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LowerCaseTest {

    @Test
    public void shouldConvertAllUpperCaseCharactersToLowerCase(){
        String result = LowerCase.getContents("sample.txt");
        assertThat(result.contains("the decorator pattern attaches additional responsibilities to an object dynamically."), is(true));
        assertThat(result.contains("decorators provide a flexible alternative to subclassing for extending functionality.!"), is(true));
    }
}
