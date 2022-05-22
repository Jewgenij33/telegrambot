package com.github.newstelegrambot.newstelegrambot.repository;

import com.github.newstelegrambot.newstelegrambot.repository.entity.TelegramUser;
import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class TelegramUserRepositoryIntegrationTest extends TestCase {

    @Autowired
    TelegramUserRepository telegramUserRepository;

    @Sql(scripts = {"/clearDbs.sql", "/telegram_user_test_db.sql"})
    @Test
    public void shouldProperlyFindAllActiveUsers() {
        List<TelegramUser> users = telegramUserRepository.findAllByActiveTrue();

        Assertions.assertEquals(5, users.size());
    }

    @Sql(scripts = {"/clearDbs.sql"})
    @Test
    public void shouldProperlySaveTelegramUser() {
        TelegramUser telegramUser = new TelegramUser();
        telegramUser.setChatId("2108199100");
        telegramUser.setActive(false);
        telegramUserRepository.save(telegramUser);

        Optional<TelegramUser> savedUser = telegramUserRepository.findById(telegramUser.getChatId());

        Assertions.assertTrue(savedUser.isPresent());
        Assertions.assertEquals(telegramUser, savedUser.get());
    }
}