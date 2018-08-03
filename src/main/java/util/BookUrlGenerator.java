package util;

import java.util.ArrayList;
import java.util.List;

public class BookUrlGenerator {

    public static List<String> getChildren0_2(){
        List<String> list = new ArrayList<>();
        for(int i = 2; i<101; i++){
            list.add("http://list.jd.com/list.html?tid=1000921&page="+i+"&sort=sort_rank_asc&trans=1&JL=6_0_0#J_main");
        }
        return list;
    }
}
