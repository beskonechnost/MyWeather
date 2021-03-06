package myWeather;

import myWeather.binaryConverter.BinaryConverter;
import myWeather.writers.WriterBinaryInformation;
import myWeather.writers.WriterInFileProperties;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ������ on 10.01.2018.
 */
public class GetWeatherData {

    public static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q=Kiev,ua&units=metric&appid=2d9bde515aa3727f422e2037276b2490";

    public static URL createUrl(String link) {
        try {
            return new URL(link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String parseUrl(URL url) {
        if (url == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
    public static StringBuilder parseWeatherJson(String resultJson) {

        StringBuilder sb = new StringBuilder();
        try {
            JSONObject weatherJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);
            sb.append("�������� ������: ").append(weatherJsonObject.get("name")).append(System.getProperty("line.separator"));


            JSONObject main = (JSONObject) weatherJsonObject.get("main");
            sb.append("����������� �� ������ ������: ").append(main.get("temp")).append("C;").append(System.getProperty("line.separator"));
            sb.append("��������� �� ������ ������: ").append(main.get("humidity")).append("%;").append(System.getProperty("line.separator"));
            sb.append("�������� �� ������ ������: ").append(main.get("pressure")).append("��.�.�;").append(System.getProperty("line.separator"));

            JSONObject wind = (JSONObject) weatherJsonObject.get("wind");
            sb.append("�������� ����� �� ������ ������: ").append(wind.get("speed")).append("�/�;").append(System.getProperty("line.separator"));


        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return sb;
    }

    public static void returnAndWrite(String path){
        URL url = GetWeatherData.createUrl(WEATHER_URL);
        String resultJson = GetWeatherData.parseUrl(url);
        WriterInFileProperties.writerInFileProperties(GetWeatherData.parseWeatherJson(resultJson), path);
        WriterBinaryInformation.writerBinaryInformation(BinaryConverter.stringToBinary(resultJson));
    }

}
