package com.gabrielittner.threetenbp;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import java.util.Locale;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class FormattingIssuesTest {

    private static Locale enLocale;

    @BeforeClass
    public static void init() throws Exception {
        LazyThreeTen.init(InstrumentationRegistry.getTargetContext());
        enLocale = new Locale("en");
    }

    @Test
    public void testThreeTenBp62() throws Exception {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2019, 3, 19, 0, 0, 0, 0, ZoneId.systemDefault());
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("EEEE, MMMM d", enLocale);
        String dateString = zonedDateTime.format(dateFormat);
        assertEquals("Tuesday, March 19", dateString);
    }
}