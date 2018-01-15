package myWeather.usb;

import java.io.File;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;

/**
 * Created by Андрей on 11.01.2018.
 */
public class USBWorker {

    private static final String FILE_SYSTEM = "FAT32";

    public static String usbWorker(){

        File[] files = File.listRoots();
        String nameFleshDiskFAT32 = null;
        for (FileStore store: FileSystems.getDefault().getFileStores()) {
            for(File file : files){
                if(store.toString().contains(file.toString().substring(0,2))){
                    if(store.type().toString().equals(FILE_SYSTEM)){
                        nameFleshDiskFAT32 = file.toString();
                    }
                }
            }
        }
       return nameFleshDiskFAT32;
    }

}
