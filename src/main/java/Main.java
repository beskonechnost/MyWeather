import myWeather.GetWeatherData;
import myWeather.usb.USBWorker;

import javax.swing.*;

/**
 * Created by Андрей on 12.01.2018.
 */
public class Main {
    public static void main(String[] args) {

        String nameFleshDiskFAT32 = USBWorker.usbWorker();
        if(nameFleshDiskFAT32 != null){
            GetWeatherData.returnAndWrite(nameFleshDiskFAT32);
            JDialog jd = new JDialog();
            JOptionPane.showMessageDialog(jd,
                    "Файл записан на диск "+nameFleshDiskFAT32,
                    "Файл записан!",
                    JOptionPane.INFORMATION_MESSAGE);

            jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            jd.setModal(false);
            jd.setVisible(false);
            jd.dispose();
            Runtime.getRuntime().exit(1);

        }else{
            JFileChooser f = new JFileChooser();
            f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            f.setDialogTitle("Select the path to save");
            int val = f.showOpenDialog(null);
            if (val == JFileChooser.APPROVE_OPTION) {
                GetWeatherData.returnAndWrite(f.getSelectedFile().toString());

            JDialog jd1 = new JDialog();
            JOptionPane.showMessageDialog(jd1,
                    "Файл записан в по выбранному пути "+f.getSelectedFile().toString(),
                    "Файл записан!",
                    JOptionPane.INFORMATION_MESSAGE);

            jd1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            jd1.setModal(false);
            jd1.setVisible(false);
            jd1.dispose();
            Runtime.getRuntime().exit(1);
            }
        }
    }
}
