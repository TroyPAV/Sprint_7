package order;

import courier.BaseClient;

import io.restassured.response.ValidatableResponse;

import java.util.HashMap;
import java.util.List;

public class OrderClient extends BaseClient {

    private final String ROOT = "/orders";
    private boolean listIsNotEmptyAndNotNull;


    public ValidatableResponse create(Order order) {
        return getSpec()
                .body(order)
                .when()
                .post(ROOT)
                .then().log().all();
    }

    public ValidatableResponse get() {
        return getSpec()
                .when()
                .get(ROOT)
                .then().log().all();
    }

    public boolean check(List<HashMap> ordersList) {
        ordersList.forEach(list -> {
            if (list != null && !list.isEmpty()) {
                listIsNotEmptyAndNotNull = true;
            }
        });
        return listIsNotEmptyAndNotNull;
    }
}
