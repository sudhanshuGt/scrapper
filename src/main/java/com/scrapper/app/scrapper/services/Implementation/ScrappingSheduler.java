package com.scrapper.app.scrapper.services.Implementation;



import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.scrapper.app.scrapper.Model.ProductModel;



@Component
public class ScrappingSheduler {
    
    @Autowired
    private ProductServiceImp productServiceImp;
    int page = 1;


public void scrapData() {
    System.out.println("page : " + page);
    String url = "https://www.flipkart.com/search?q=shirts&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off&p%5B%5D=facets.brand%255B%255D%3DAllen%2BSolly&page=" + page;
    try {
        Document doc = Jsoup.connect(url).timeout(10 * 1000).get();
        if (doc != null ) {
            Elements divsWithClassName = doc.select("div._1xHGtK");
            if(divsWithClassName.isEmpty()){
                System.out.println("doc is null or empty, waiting for 10 seconds before retrying...");
                Thread.sleep(10000); // wait for 10 seconds
                scrapData(); // call scrapData() function again
            }else{
                for (Element div : divsWithClassName) {

                    Element imageElement = div.selectFirst("img._2r_T1I");
                    String imageUrl = (imageElement != null) ? imageElement.absUrl("src") : "NA";
                    Element brandElement = div.selectFirst("div._2WkVRV");
                    String brandName = (brandElement != null) ? brandElement.text() : "NA";
                    Element productElement = div.selectFirst(".IRpwTa");
                    String productName = (productElement != null) ? productElement.text() : "NA";
                    Element priceElement = div.selectFirst("div._30jeq3");
                    String price = (priceElement != null) ? priceElement.text() : "NA";
                    productServiceImp.saveProduct(new ProductModel(null, productName, brandName, price, imageUrl));
                }
                page++;
            }
        } else {
            System.out.println("doc is null or empty, waiting for 10 seconds before retrying...");
            Thread.sleep(10000); // wait for 10 seconds
            scrapData(); // call scrapData() function again
        }
    } catch (IOException e) {
        System.out.println("IOException occurred, waiting for 10 seconds before retrying...");
        e.printStackTrace();
        try {
            Thread.sleep(10000); // wait for 10 seconds
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        scrapData(); // call scrapData() function again
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}    
}


