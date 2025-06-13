package com.rwz.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class UserApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void createTable() {
        String SQL = "CREATE TABLE `user_%d` (\n" +
                "                  `user_id` bigint NOT NULL,\n" +
                "                  `username` varchar(50) DEFAULT NULL,\n" +
                "                  `password` varchar(255) DEFAULT NULL,\n" +
                "                  `email` varchar(100) DEFAULT NULL,\n" +
                "                  `phone` varchar(20) DEFAULT NULL,\n" +
                "                  `create_time` datetime DEFAULT NULL,\n" +
                "                  PRIMARY KEY (`user_id`)\n" +
                "                ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;\n" +
                "                ";

        for (int i = 0; i < 16; i++) {
            System.out.printf((SQL) + "%n", i);
        }
    }

}
