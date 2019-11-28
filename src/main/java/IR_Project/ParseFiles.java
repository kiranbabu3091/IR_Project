package IR_Project;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class ParseFiles {


    /**
     * Extracts content + name from txt file
     * @param path Parse Text
     * @return name + content in Array
     *
     */
    public static String[] parseText(String path){

        File f = new File(path);
        String name = f.getName().replaceFirst("[.][^.]+$", "");
        BufferedReader br;
        String[] text = new String[2];
        try {
            br = new BufferedReader(new FileReader(path));


            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String content = sb.toString();

            text[0] = name;
            text[1] = content;
            br.close();

        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return text;
    }

    /**
     * Extracts content + title form HTML file
     * @param path Parse HTML
     * @return title + content in Array
     */
    public  static String[] parseHTML(String path)  {
        File file = new File(path);
        String[] html = new String[2];
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));


            String st;
            String content="";
            while ((st = br.readLine()) != null) {

                content+=st;
            }
            Document doc = Jsoup.parse(content);

            String title = doc.title();
            if(title.equals("")) {
                title = file.getName().replaceFirst("[.][^.]+$", "");
            }
            String body = doc.body().text();
            html[0] = title;
            html[1] = body;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return html;

    }
}
