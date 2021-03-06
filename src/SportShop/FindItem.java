package SportShop;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Decat on 04.05.2017.
 */
public class FindItem {

    public static Map<SportEquipment, Integer> createMapFromFile(String fileName) throws IOException {
        Map<SportEquipment, Integer> map = new HashMap<>();
        List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        for (String line : lines) {
            String[] split = line.split("\\s");
            map.put(new SportEquipment(Category.valueOf(split[0]), split[1], Integer.parseInt(split[2])),
                    Integer.parseInt(split[3]));
//            System.out.println(line);

        }

        return map;
    }

    public static void rentItem(SportEquipment sportEquipment,Shop shop, RentUnit rentUnit){

        // containsKey(Object key) — проверяет, существует ли в массиве элемент с ключом key;
        if (shop.getGoods().containsKey(sportEquipment)) {                                      // проверка на существование товара
            Integer quantityShop = shop.getGoods().get(sportEquipment);                         //получаем количество товара в магазине
            if (quantityShop != 0) {                                                            //проверяем наличие товара в магазине
                if (rentUnit.addItem(sportEquipment)) {                                         //проверяем наличие товара в аренде
                    shop.getGoods().replace(sportEquipment, --quantityShop);                    //уменьшаем кол-во в магазине
                    if (shop.getRentGoods().containsKey(sportEquipment)) {                  //проверяем товар в прокате
                        Integer quantityRent = shop.getRentGoods().get(sportEquipment);     //кол-во в прокате
                        shop.getRentGoods().put(sportEquipment, ++quantityRent);            //добавляем
                    } else {
                        shop.getRentGoods().put(sportEquipment, 1);                         //взяли впервые
                    }
                }
            }
        }

    }


    public static void printReport(Map<SportEquipment, Integer> map) {
        try{
            if (!map.isEmpty()) {
                map.forEach((key, value) -> System.out.printf("%29s |  quantity: %d\n", key.toString(),value));
            }
        }catch (NullPointerException e)
        {
            System.out.println("no rent items");
        }
    }
}

