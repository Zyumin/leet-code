import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2021-01-18 9:11 上午
 */
public class HtmlParse {

//    public static void main1(String[] args) throws IOException {
//        Document doc = Jsoup.connect("https://m.jingxi.com/item/view?_fd=jx&sku=67719021825").get();
//
//        System.out.println(doc.title());
//
//
//    }

    public static void main(String[] args) throws IOException {
//        String source = "https://st.jingxi.com/pingou/one_dollar/index.html";
//        Document doc = Jsoup.connect(source).get();

        File input = new File("/Users/zhengyumin/Documents/git/leet-code/common/src/main/java/html");
        Document doc = Jsoup.parse(input, "UTF-8");

        for(Element element:doc.getElementsByClass("good-item")){
            //sku
            String sku = element.attributes().get("data-unionskuid");

            //商品名称
            Element nameEle =  element.getElementsByClass("good-item-title line1").get(0);
            String name = nameEle.html();


            //剩余数量
            Elements numEles =  element.getElementsByClass("process");
            if(numEles.isEmpty()){
                continue;
            }
            String num = numEles.get(0).html();
            if(!"剩余0件".equals(num)){
                continue;
            }

            //限量
            Elements limits =  element.getElementsByClass("badge");
            if(limits.isEmpty()){
                continue;
            }
            String limit = limits.get(0).html();

            limit = limit.replaceAll("限量","");


            /**
             * 抓取主站信息
             */
            Document classdoc = Jsoup.connect(String.format("https://item.jd.com/%s.html",sku)).get();

            Elements elements = classdoc.getElementsByClass("item first");
            String classN = elements.get(0).child(0).html();

            String shopName = classdoc.getElementsByClass("popbox-inner")
                    .get(0).child(0).child(0).child(0).attributes().get("title");

            String urlF = "https://m.jingxi.com/item/jxview?sku=";


//            System.out.println(String.format("%s,%s,%s,%s",sku,name,limit,classN));

//            System.out.println(String.format("%s %s%s 需补充%s",classN,urlF,sku,limit));
            System.out.println(String.format("%s,%s,%s,%s%s,需补充%s,%s",sku,name,classN,urlF,sku,limit,shopName));
        }
    }
}
