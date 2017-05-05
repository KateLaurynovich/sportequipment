package SportShop;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Decat on 04.05.2017.
 */
public class Shop {
    private Map<SportEquipment, Integer> goods;
    private Map<SportEquipment, Integer> rentGoods;

    public Shop() {
        goods = new HashMap<>();
        rentGoods = new HashMap<>();
    }

    public Shop(Map<SportEquipment, Integer> goods) {
        this.goods = goods;
        rentGoods = new HashMap<>();
    }

    public Map<SportEquipment, Integer> getGoods() {
        return goods;
    }

    public Map<SportEquipment, Integer> getRentGoods() {
        return rentGoods;
    }

}
