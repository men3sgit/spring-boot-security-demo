package com.menes.security.repositories;

import com.menes.security.models.Role;
import com.menes.security.models.User;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckIfUserByEmailDoesExist() {
        // given
        String email = "menes@gmail.com";
        User user = User.builder()
                .email(email)
                .role(Role.USER)
                .password("12345")
                .firstName("Men")
                .lastName("Duong Duy")
                .build();
        underTest.save(user);

        // when
        boolean expected = underTest.findUserByEmail(email).isPresent();

        // then
        assertThat(expected).isTrue();
    }
    @Test
    void itShouldCheckIfUserByEmailDoesNotExist() {
        // given
        String email = "menes@gmail.com";

        // when
        boolean expected = underTest.findUserByEmail(email).isPresent();

        // then
        assertThat(expected).isFalse();
    }

}