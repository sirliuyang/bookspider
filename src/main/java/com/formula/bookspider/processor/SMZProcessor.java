package com.formula.bookspider.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

public class SMZProcessor implements PageProcessor {

    public int count = 0;
    private boolean addTop = false;

    private Site site = Site.me().setRetryTimes(5).setSleepTime(2000);

    @Override
    public void process(Page page) {
        List<String> products = page.getHtml().xpath("//div[@class='feed-block-ver']").xpath("//h5[@class='feed-ver-title']").links().all();
        count += products.size();
        System.out.println(count);
        /*
        for (String product : products) {
            System.out.println(product);
        }
        */
        if(addTop == false){
            addTop = true;
            page.addTargetRequests(page.getHtml().xpath("//div[@id='content']").xpath("//div[@id='filter-block']").xpath("//div[@class='filter-items J_filter_items']").links().all());
            System.out.println("***********Add top once**********");
        }
        page.addTargetRequests(page.getHtml().xpath("//div[@class='feed-pagenation']").xpath("//ul[@class='pagenation-list']").links().all());
    }

    @Override
    public Site getSite() {
        return site;
    }
}
