package com.product.user;


import com.product.AcceptanceTest;
import com.product.fixture.UserFactory;
import com.product.user.domain.User;
import com.product.user.dto.UserRequest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserControllerTest extends AcceptanceTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("사용자를 등록할 수 있다.")
    void insert() {
        // when
        insertUser(UserFactory.createRequest("서정국"));

        // then
        List<User> products = userRepository.findAll();
        assertThat(products.get(0).getName()).isEqualTo("서정국");
    }

    private void insertUser(UserRequest request) {
        RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when().post("/users")
                .then().log().all()
                .extract();
    }
}
