
import SportShop.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Decat on 04.05.2017.
 */
public class Main {
    private static final String FILENAME = "src/shopbase.txt";

    public static void main(String[] args) {
        Map<SportEquipment, Integer> map;
        Shop shop;



        try {
            map = FindItem.createMapFromFile(FILENAME);
            shop = new Shop(map);
        } catch (IOException e) {
            e.printStackTrace();
            shop = new Shop();
        }

        RentUnit rentUnit = new RentUnit();
        RentUnit rentUnit2 = new RentUnit();

        SportEquipment sportEquipment1 = new SportEquipment(Category.BALLS,"FootBall", 5);
        SportEquipment sportEquipment2 = new SportEquipment(Category.BALLS,"Volleyball", 5);
        SportEquipment sportEquipment3 = new SportEquipment(Category.BICYCLES,"forMen", 10);
        SportEquipment sportEquipment4 = new SportEquipment(Category.SKIING,"Alpine", 12);

        FindItem.rentItem(sportEquipment1, shop, rentUnit);
        FindItem.rentItem(sportEquipment2, shop, rentUnit);
        FindItem.rentItem(sportEquipment4, shop, rentUnit2);
        FindItem.rentItem(sportEquipment3, shop, rentUnit2);
        FindItem.rentItem(sportEquipment4, shop, rentUnit2);
        FindItem.rentItem(sportEquipment2, shop, rentUnit2);
        FindItem.rentItem(sportEquipment4, shop, rentUnit2);
        FindItem.rentItem(sportEquipment3, shop, rentUnit2);


        System.out.println("All Goods in the shop");
        FindItem.printReport(shop.getGoods());
        System.out.println("Rent Goods");
        FindItem.printReport(shop.getRentGoods());
    }
}