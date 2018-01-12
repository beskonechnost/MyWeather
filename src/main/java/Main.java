import myWeather.GetWeatherData;

import javax.swing.*;

/**
 * Created by Андрей on 12.01.2018.
 */
public class Main {
    public static void main(String[] args) {

        GetWeatherData.returnAndWrite();
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f.setDialogTitle("Select the path to save");

        f.showSaveDialog(null);

        System.out.println(f.getCurrentDirectory());
        System.out.println(f.getSelectedFile());
    }
}
