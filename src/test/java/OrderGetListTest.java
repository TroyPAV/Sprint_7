import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import order.OrderClient;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class OrderGetListTest {
    OrderClient orderClient;

    @Before
    public void setUp() {
        orderClient = new OrderClient();
    }

    @Test
    @DisplayName("Возвращается список заказов при успешном запросе")
    @Description("Проверка возвращения списка заказов в теле ответа при успешном запросе на получение списка заказов")
    public void responseBodyContainsListOfOrders(){
        List<HashMap> ordersList = orderClient.get()
                .statusCode(200)
                .extract()
                .path("orders");
        boolean checkList = orderClient.check(ordersList);
        assertTrue(checkList);
    }
}
