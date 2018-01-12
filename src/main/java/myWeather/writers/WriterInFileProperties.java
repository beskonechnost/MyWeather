package myWeather.writers;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by ������ on 11.01.2018.
 */
public class WriterInFileProperties {
    public static void writerInFileProperties(StringBuilder sb){
        try(FileWriter writer = new FileWriter("weather.properties", false))
        {
            writer.write(sb.toString());
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
