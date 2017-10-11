package mymap.my_aipai.payler;

/**
 * Created by Veigar on 16/8/16.
 */
public class ButtonIcon {

    public static final int FLOWER = 1;
    public static final int REWARD = 2;
    public static final int GIFT = 3;
    public static final int SHARE = 4;
    public static final int CACH = 5;
    public static final int SPREAD = 7;
    public static final int COLLECTION = 8;
    public static final int COMMENT = 9;

    public String name;
    public String picUrl;
    public int type;
    public double total;
    public String textColor;

    public double getDoubleTotal() {
        return total;
    }

    public int getIntTotal() {
        return (int) total;
    }

    public String getTextColor() {
        return textColor;
    }

    public void addDoubleTotal(double addNum) {
        total += addNum;
    }

    public void addIntTotal(int addNum) {
        total += addNum * 1.0;
    }
}
