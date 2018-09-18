package com.asignore.tos.controller;

import com.asignore.tos.utils.DateFormatter;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;


public class DateTest {

    @Ignore
    @Test
    public void test_date() {
        Assert.assertEquals("2018-05-29T10:00:000+0200", DateFormatter.toDate(10, 00));
    }
}
