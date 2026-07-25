package com.hardik.pagepulse.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Test {
    public static void main(String[] args) throws Exception {

        Document doc = Jsoup.connect("https://example.com")
                .userAgent("Mozilla/5.0")
                .timeout(10000)
                .get();

        System.out.println(doc.title());
    }
}
