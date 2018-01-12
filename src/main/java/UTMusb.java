import javax.usb.*;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Андрей on 12.01.2018.
 */
public class UTMusb {
    public static void main(String[] args) throws UsbException, UnsupportedEncodingException {
        UsbServices services = UsbHostManager.getUsbServices();
        UsbHub root = services.getRootUsbHub();
        listPeripherique(root);
    }

    private static void listPeripherique(UsbHub hub) throws UnsupportedEncodingException, UsbException {
        List perepheriques = hub.getAttachedUsbDevices();
        Iterator iterator = perepheriques.iterator();
        while (iterator.hasNext()) {
            UsbDevice perepherique = (UsbDevice) iterator.next();
            System.out.println(perepherique.isUsbHub());

            System.out.println(perepherique);
            if (perepherique.isUsbHub()) {
                listPeripherique((UsbHub) perepherique);
            }
        }
    }

}
