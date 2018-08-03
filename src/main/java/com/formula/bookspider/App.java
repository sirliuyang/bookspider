package com.formula.bookspider;

import com.formula.bookspider.processor.JdProcessor;
import us.codecraft.webmagic.Spider;
import util.BookUrlGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Starter
 */
public class App {
    private static String b0_2 = "http://list.jd.com/list.html?tid=1000921";
    private static String b3_6 = "http://list.jd.com/list.html?tid=1000922";
    private static String b7_10 = "http://list.jd.com/list.html?tid=1000923";
    private static String b11_14 = "http://list.jd.com/list.html?tid=1000925";

    public static void main(String[] args) {
        List<String> urls = new ArrayList<>();
        urls = BookUrlGenerator.getChildren0_2();
        for (String url : urls) {
            Spider.create(new JdProcessor())
                    .addUrl(url)
                    .thread(1)
                    .run();
        }

    }
}
