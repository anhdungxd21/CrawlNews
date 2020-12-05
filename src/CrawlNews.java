import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlNews {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://dantri.com.vn/the-gioi.htm");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("something.txt"));
            String context = scanner.next();
            bufferedWriter.append(context);
            scanner.close();

            context = context.replaceAll("\\n+","");

            Pattern pattern = Pattern.compile("title=\"(.*?)>");
            Matcher matcher = pattern.matcher(context);
            while(matcher.find()){
                System.out.println(matcher.group(1));
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
