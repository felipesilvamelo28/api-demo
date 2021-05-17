package com.example.demo.Webscrapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Classe usada para converter os dados em JSON
class Passing{
    private String name;
    private String passYds;
    private String YdsAtt;
    private String Att;

    public Passing(String name, String passYds, String ydsAtt, String att) {
        this.name = name;
        this.passYds = passYds;
        YdsAtt = ydsAtt;
        Att = att;
    }

    public Passing() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassYds() {
        return passYds;
    }

    public void setPassYds(String passYds) {
        this.passYds = passYds;
    }

    public String getYdsAtt() {
        return YdsAtt;
    }

    public void setYdsAtt(String ydsAtt) {
        YdsAtt = ydsAtt;
    }

    public String getAtt() {
        return Att;
    }

    public void setAtt(String att) {
        Att = att;
    }

}


public class DemoWebScrapping {

    public static void main(String[] args) throws IOException {

        //URL do site a ser acessado
        String url = "https://www.nfl.com/stats/player-stats/";
        //Conectando e obtendo uma cópia do html inteiro da página
        Document doc = Jsoup.connect(url).get();
        //Obtendo a tabela através de sua classe
        Element table = doc.getElementsByClass("d3-o-table d3-o-table--detailed d3-o-player-stats--detailed d3-o-table--sortable").first();
        //Obtendo o corpo da tabela através da tag
        Element tbody = table.getElementsByTag("tbody").first();
        //Criando uma lista de todos os tr's do tbody obtido
        List<Element> players = tbody.getElementsByTag("tr");
        //Criando uma lista vazia para Guardar os dados dos tr's convertidos
        List<Passing> playersObjects = new ArrayList<>();
        //Iterando por cada tr e convertendo-o em um Passing. Em seguida inserindo-o na lista de Passings
        for (Element player: players) {
            //Listando todos os atributos do td em questão
            List<Element> attributes = player.getElementsByTag("td");
            //criando o objeto e inserindo nele os atributos extraidos do td
            Passing passing = new Passing(
                    attributes.get(0).text(),
                    attributes.get(1).text(),
                    attributes.get(2).text(),
                    attributes.get(3).text()
            );
            //adicionando o objeto na lista de objetos Passing
            playersObjects.add(passing);
        }
        //Por fim, convertendo os objetos do tipo Passing para Json, facilitando a leitura dos dados obtidos do site
        for (Passing passing: playersObjects) {
            converterToJson(passing);
        }
    }

    //Bonus: método para converter um objeto em um Json
    private static void converterToJson(Passing passing){
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(passing);
            System.out.println("Objeto em JSON: " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
