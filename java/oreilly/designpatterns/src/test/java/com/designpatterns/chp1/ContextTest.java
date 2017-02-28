package com.designpatterns.chp1;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ContextTest {

    @Test
    public void shouldAdd(){
        Context context = new Context(new Add());
        int result = context.executeStrategy(5,10);
        assertThat(result, is(15));
    }

    @Test
    public void shouldSubtract(){
        Context context = new Context(new Subtract());
        int result = context.executeStrategy(10, 5);
        assertThat(result, is(5));
    }

    @Test
    public void shouldMultiply(){
        Context context = new Context(new Multiply());
        int result = context.executeStrategy(5, 5);
        assertThat(result, is(25));
    }
}
