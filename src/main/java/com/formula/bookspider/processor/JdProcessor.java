package com.formula.bookspider.processor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

public class JdProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {
        List<String> books = page.getHtml().xpath("//div[@id='J_main']").xpath("//div[@id='J_main']").xpath("//div[@id='plist']").xpath("//li[@class='gl-item']").all();
        parseBooks(books);
    }

    @Override
    public Site getSite() {
        return site;
    }

    private void parseBooks(List<String> books){
        for(String book : books){
            Document document = Jsoup.parse(book);
            Element element = document.getElementsByClass("gl-item").get(0).child(0);
            Element img = element.getElementsByClass("p-img").get(0).child(0).child(0);
            String path = img.attr("src");
            System.out.println(path);
        }
    }

    private void assembleBook(){

    }
}
