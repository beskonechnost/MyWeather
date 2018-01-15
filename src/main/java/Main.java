import myWeather.GetWeatherData;
import myWeather.usb.USBWorker;

import javax.swing.*;

/**
 * Created by ������ on 12.01.2018.
 */
public class Main {
    public static void main(String[] args) {

        String nameFleshDiskFAT32 = USBWorker.usbWorker();
        if(nameFleshDiskFAT32 != null){
            GetWeatherData.returnAndWrite(nameFleshDiskFAT32);
            JDialog jd = new JDialog();
            JOptionPane.showMessageDialog(jd,
                    "���� ������� �� ���� "+nameFleshDiskFAT32,
                    "���� �������!",
                    JOptionPane.INFORMATION_MESSAGE);
        }else{
            JFileChooser f = new JFileChooser();
            f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            f.setDialogTitle("Select the path to save");
            f.showSaveDialog(null);

            GetWeatherData.returnAndWrite(f.getSelectedFile().toString());

            JDialog jd1 = new JDialog();
            JOptionPane.showMessageDialog(jd1,
                    "���� ������� � �� ���������� ���� "+f.getSelectedFile().toString(),
                    "���� �������!",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
