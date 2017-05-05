package SportShop;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Decat on 04.05.2017.
 */
public class SportEquipment {
    private Category category;
    private String title;
    private int price;
//    private int quantity;

    public SportEquipment(Category category, String title, int price) {
        this.category = category;
        this.title = title;
        this.price = price;

    }
    public static Map<SportEquipment, Integer> createMapFromFile(String fileName) throws IOException {
        Map<SportEquipment, Integer> map = new HashMap<>();
        List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        for (String line : lines) {
            String[] split = line.split("\\s");
            map.put(new SportEquipment(Category.valueOf(split[0]), String.valueOf(split[1]), Integer.parseInt(split[2])),
                    Integer.parseInt(split[3]));
//            System.out.println(line);

        }

        return map;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        SportEquipment that = (SportEquipment) obj;

        if (getPrice() != that.getPrice()) return false;
        if (getCategory() != that.getCategory()) return false;
        return getTitle() != null ? getTitle().equals(that.getTitle()) : that.getTitle() == null;
    }

    @Override
    public int hashCode() {
        int hash = getCategory() != null ? getCategory().hashCode() : 0;
        hash = hash * (getTitle() != null ? getTitle().hashCode() : 0);
        hash = hash * getPrice();
        return hash;
    }

    @Override
    public String toString() {
        return category  +"  "+ title+" " + "price = "+price;
    }
    public Category getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }
}
