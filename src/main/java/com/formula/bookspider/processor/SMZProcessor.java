package com.formula.bookspider.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

public class SMZProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(5).setSleepTime(2000);

    @Override
    public void process(Page page) {
        List<String> products = page.getHtml().xpath("//div[@class='feed-block-ver']").xpath("//h5[@class='feed-ver-title']").links().all();
        for (String product : products) {
            System.out.println(product);
        }
        page.addTargetRequests(page.getHtml().xpath("//div[@class='feed-pagenation']").xpath("//div[@class='pagenation-list']").links().all());
    }

    @Override
    public Site getSite() {
        return site;
    }
}
