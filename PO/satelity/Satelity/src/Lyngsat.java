import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Lyngsat extends WebPage {
    public Lyngsat(String url){
        super(url);
    }

    @Override
    public void DownloadPage() {
        Document document = null;

        try {
            document = Jsoup.connect(url).get();

            Element table = document.selectFirst("body > div > table > tbody > tr > td:nth-child(2) > table:nth-child(8) > tbody > tr");
            Elements records = table.select("tr");

            for (Element sat : records) {
                Elements fields = sat.select("td");

                if(fields.size() > 3 && fields.eq(0).text().length() < 10) {
                    String satName = fields.eq(1).text();
                    String satPos = fields.eq(0).text();
                    System.out.println(satName + " " + satPos);

                    float pos = 0;
                    String[] posString = satPos.split("°");
                    if (posString.length == 1) {
                        pos = 180;
                    }
                    else {
                        if (posString[1].contains("W")) {
                            pos = -Float.parseFloat(posString[0]);
                        } else {
                            pos = Float.parseFloat(posString[0]);
                        }
                    }
                    Satelite satelite = new Satelite(satName, pos);
                    satelites.add(satelite);
                }
                else if(fields.size() == 3){
                    String satName = fields.eq(0).text();
                }

            }
        }

        catch (Exception e) {
            System.out.println(e);
        }
    }
}
