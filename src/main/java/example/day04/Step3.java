package example.day04;

public class Step3 {
    public static void main(String[] args) {
        String money = "123123123";
        String formattedMoney = insertCommas(money);
        System.out.println(formattedMoney);
    }

    public static String insertCommas(String money) {
        StringBuilder result = new StringBuilder();

        int length = money.length();
        int commaInterval = 3; // 쉼표를 삽입할 간격

        for (int i = 0; i < length; i++) {
            if (i > 0 && (length - i) % commaInterval == 0) {
                result.append(",");
            }
            result.append(money.charAt(i));
        }

        return result.toString();
    }
}
