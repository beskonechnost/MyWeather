package myWeather;

import javax.usb.*;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 10.01.2018.
 */
public class Q {

    public static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q=Kiev,ua&units=metric&appid=2d9bde515aa3727f422e2037276b2490";


    public static void main(String[] args) {
        // создаем URL из строки
        /*
        URL url = GetWeatherData.createUrl(WEATHER_URL);

        // загружаем Json в виде Java строки
        String resultJson = GetWeatherData.parseUrl(url);
        //System.out.println("Полученный JSON:\n" + resultJson);

        // парсим полученный JSON и печатаем его на экран
        GetWeatherData.parseWeatherJson(resultJson);

        // формируем новый JSON объект из нужных нам погодных данных
        String json = GetWeatherData.buildWeatherJson();
        System.out.println("Созданный нами JSON:\n" + json);
        */

        File[] files = File.listRoots();

        for (File file : files) {
            System.out.println("file: " + file);
            System.out.println(file.canExecute());
            System.out.println(file.getParent());

        }

        try {
            List<UsbDevice> d = getDevices();
        } catch (UsbException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public static List<UsbDevice> getDevices()
            throws SecurityException, UsbException, UnsupportedEncodingException
    {
        ArrayList<UsbDevice> devices = new ArrayList<UsbDevice>();

        UsbServices services = UsbHostManager.getUsbServices();

        UsbHub root = services.getRootUsbHub();

        devices.add(root);

        return devices;
    }



}
