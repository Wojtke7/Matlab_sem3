import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class Lyngsat extends WebPage{
    public Lyngsat(String url) {super(url);}

    @Override
    public void DownloadPage(){
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
            Element table = document.selectFirst("body > div > table > tbody > tr > td:nth-child(2) > table:nth-child(8) > tbody > tr");
            Elements records = table.select("tr");
            for (Element record : records){
                Elements data = record.select("td");
                if(data.size() > 3 && data.eq(0).text().length() < 10){
                    String position = data.eq(0).text();
                    String satName = data.eq(1).text();
                    float pos = 0;
                    String[] posString = position.split("°");
                    if(posString.length == 1) {
                        pos = 180;
                    } else {
                        if(posString[1].contains("W")){
                            pos = -Float.parseFloat(posString[0]);
                        } else {
                            pos = Float.parseFloat(posString[0]);
                        }
                    }
                    //System.out.println(pos);
                    Satelite satelite = new Satelite(satName,pos);
                    satelites.add(satelite);
                }
                else if(data.size() == 3) {
                    float prevPos = satelites.get(satelites.size() - 1).GetPosiiton();
                    String satName = data.eq(0).text();
                    Satelite satelite = new Satelite(satName,prevPos);
                    satelites.add(satelite);
                }
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}