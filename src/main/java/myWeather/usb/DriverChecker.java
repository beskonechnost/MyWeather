package myWeather.usb;

import java.io.File;

/**
 * Created by Андрей on 11.01.2018.
 */
public class DriverChecker {
    private static boolean[] drivers = new boolean[26];

    private DriverChecker() {

    }

    public static boolean checkForDrive(String dir) {
        return new File(dir).exists();
    }

    public static void updateDriverInfo() {
        for (int i = 0; i < 26; i++) {
            drivers[i] = checkForDrive((char) (i + 'A') + ":/");
            if(drivers[i]){

            }
        }
    }

    public static boolean newDriverDetected() {
        for (int i = 0; i < 26; i++) {
            if (!drivers[i] && checkForDrive((char) (i + 'A') + ":/")) {
                return true;
            }
        }
        return false;
    }

    public static boolean driverRemoved() {
        for (int i = 0; i < 26; i++) {
            if (drivers[i] && !checkForDrive((char) (i + 'A') + ":/")) {
                return true;
            }
        }
        return false;
    }

    public static boolean driversChangedSinceLastUpdate() {
        for (int i = 0; i < 26; i++) {
            if (drivers[i] != checkForDrive((char) (i + 'A') + ":/")) {
                return true;
            }
        }
        return false;
    }

    public static void printInfo() {
        for (int i = 0; i < 26; i++) {
            System.out.println("Driver " + (char) (i + 'A') + ":/ "
                    + (drivers[i] ? "exists" : "does not exist"));
        }
    }

    /*
    public static String dumpDaplugWinUSB(Device device) {
        DeviceDescriptor des = new DeviceDescriptor();
        LibUsb.getDeviceDescriptor(device, des);
        String res = " vid                    : " + des.idVendor()
                + "\n pid                    : " + des.idProduct()
                + "\n Manufacturer           : " + des.iManufacturer()
                + "\n bcdevice               : " + des.bcdDevice()
                + "\n bcdUSB                 : " + des.bcdUSB()
                + "\n serial                 : " + des.iSerialNumber()
                + "\n bDescriptorType        : " + des.bDescriptorType()
                + "\n bDeviceClass           : " + des.bDeviceClass()
                + "\n bDeviceProtocol        : " + des.bDeviceProtocol()
                + "\n bDeviceSubClass        : " + des.bDeviceSubClass()
                + "\n bLength                : " + des.bLength()
                + "\n bMaxPacketSize0        : " + des.bMaxPacketSize0()
                + "\n bNumConfigurations     : " + des.bNumConfigurations()
                + "\n getBuffer              : " + des.getBuffer()
                + "\n getPointer             : " + device.getPointer()
                + "\n hashCode               : " + des.hashCode();
        return res;
    }
    */
}
