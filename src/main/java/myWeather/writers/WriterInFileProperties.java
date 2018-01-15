package myWeather.writers;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Андрей on 11.01.2018.
 */
public class WriterInFileProperties {
    public static void writerInFileProperties(StringBuilder sb, String path){
        try(FileWriter writer = new FileWriter(path+"weather.properties", false))
        {
            writer.write(sb.toString());
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
