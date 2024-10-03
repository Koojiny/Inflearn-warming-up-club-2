package day4;

import java.util.List;
import java.util.logging.Logger;

public class Order {

    private final List<Item> items;
    private final String customerInformation;

    private final Logger log = Logger.getLogger(this.getClass().getName());

    public Order(List<Item> items, String customerInformation) {
        this.items = items;
        this.customerInformation = customerInformation;
    }

    public boolean validateOrder() {
        try {
            checkOrderStatus();
            return true;
        } catch (OrderException e) {
            log.info(e.getMessage());
        } catch (Exception e) {
            log.info("프로그램에 문제가 발생했습니다.");
        }

        return false;
    }

    private void checkOrderStatus() throws OrderException {
        validateCustomerInformation();
        validateItem();
        validatePrice();
    }

    private void validatePrice() throws OrderException {
        if (isInvalidPrice()) {
            throw new OrderException("올바르지 않은 총 가격입니다.");
        }
    }

    private boolean isInvalidPrice() {
        return calculateTotalPrice() <= 0;
    }

    private int calculateTotalPrice() {
        int sum = 0;
        for (Item item : this.items) {
            int price = item.getPrice();
            sum += price;
        }
        return sum;
    }

    private void validateItem() throws OrderException {
        if (hasNotItem()) {
            throw new OrderException("주문 항목이 없습니다.");
        }
    }

    private boolean hasNotItem() {
        return this.items.isEmpty();
    }

    private void validateCustomerInformation() throws OrderException {
        if (hasCustomerInfo()) {
            throw new OrderException("사용자 정보가 없습니다.");
        }
    }

    private boolean hasCustomerInfo() {
        return this.customerInformation.isEmpty();
    }
}
