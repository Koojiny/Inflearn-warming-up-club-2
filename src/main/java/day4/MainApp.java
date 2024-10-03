package day4;

import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item("사과", 2000),
                new Item("바나나", 3000),
                new Item("포도", 1500));

        Order order = new Order(items, "문석진");

        System.out.println(order.validateOrder());
    }
}
