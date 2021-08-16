package com.example.demo.Webscrapping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DemoWebScrappingHref {

    public static void main(String[] args) throws IOException, InterruptedException {

        //1 - URL do site a ser acessado
        String url = "https://jovemnerd.com.br/";
        //2 - Conectando e obtendo uma cópia do html inteiro da página
        Document doc = Jsoup.connect(url).get();
        //3 - Obtendo os artigos por classe
        List<Element> artigos = doc.getElementsByClass("info");

        List<Element> as = new ArrayList<>();
        List<String> hrefs = new ArrayList<>();

        //4 - Obtendo as tags "a" dos artigos
        artigos.forEach(element -> {
            as.add(element.getElementsByTag("a").first());
        });

        //5 - Obtendo as urls das tags a
        as.forEach(element -> {
            hrefs.add(element.attr("href"));
        });
        //6 - Imprimindo os links
       hrefs.forEach(s -> {
           System.out.println("URL: "  + s);
       });
    }

}
