package app.Bimba.controller;

import app.Bimba.service.IuranService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class IuranControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private IuranService iuranService;

    @Test
    void create() {
    }
}