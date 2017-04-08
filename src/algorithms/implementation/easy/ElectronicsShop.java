package algorithms.implementation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/* Created by toni on 07/04/2017. */

public class ElectronicsShop {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = ElectronicsShop.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        File file = new File(properties.getProperty("input.path") + "electronic_shop.txt");
        Scanner in = new Scanner(file);
        // Scanner in = new Scanner(System.in);
        int moneyAvailable = in.nextInt();
        int keyboardModelsCount = in.nextInt();
        int usbModelsCount = in.nextInt();
        List<Integer> keyboardModels = new ArrayList<>();
        List<Integer> usbModels = new ArrayList<>();
        for (int i = 0; i < keyboardModelsCount; i++) {
            keyboardModels.add(in.nextInt());
        }
        for (int i = 0; i < usbModelsCount; i++) {
            usbModels.add(in.nextInt());
        }
        int maxShop = -1;
        for (int i = 0; i < keyboardModels.size(); i++) {
            for (int j = 0; j < usbModels.size(); j++) {
                int possible = keyboardModels.get(i) + usbModels.get(j);
                if (possible<=moneyAvailable && possible>maxShop) {
                    maxShop = possible;
                }
            }
        }
        System.out.println(maxShop);
        in.close();
    }
}
