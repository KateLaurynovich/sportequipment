package SportShop;


/**
 * Created by Decat on 04.05.2017.
 */
public class RentUnit {
    private SportEquipment[] units;
    private static final int LIM = 3;


    public RentUnit() {
        units = new SportEquipment[LIM];
    }


    public boolean addItem(SportEquipment item){
        for (int i = 0; i < getUnits().length; i++) {
            if (getUnits()[i] == null) {
                getUnits()[i] = item;
                return true;
            }
        }
        return false;
    }

    public SportEquipment[] getUnits() {
        return units;
    }
}
