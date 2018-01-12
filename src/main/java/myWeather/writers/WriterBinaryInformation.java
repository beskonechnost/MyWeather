package myWeather.writers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Андрей on 11.01.2018.
 */
public class WriterBinaryInformation {
    public static void writerBinaryInformation(String binaryString){
        StringBuilder sb = new StringBuilder();
        Date date = new Date();
        sb.append(date.getDate()).append(".").append(date.getMonth()+1).append("-").append(date.getHours()).append(".").append(date.getMinutes())
                .append("_").append(" WeatherBinary");
        try(FileWriter writer = new FileWriter(sb.toString(), false))
        {
            writer.write(binaryString.toString());
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
