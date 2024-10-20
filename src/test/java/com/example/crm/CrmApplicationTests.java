package com.example.crm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CrmApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {

    }

    @Test
    void test() throws Exception {
        mockMvc.perform(post("/seller/create")
                        .contentType("application/json")
                        .content("{\n" +
                                "    \"name\": \"Sasha\",\n" +
                                "    \"contactInfo\": \"dma@company.com\"\n" +
                                "}"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/seller"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/seller/1"))
                .andExpect(status().isOk());

        mockMvc.perform(patch("/seller/update/1")
                        .contentType("application/json")
                        .content("{\n" +
                                "    \"name\": \"Gorg6\"\n" +
                                "}"))
                .andExpect(status().isOk());

        mockMvc.perform(post("/transaction/create")
                        .contentType("application/json")
                        .content("{    \n" +
                                "    \"sellerId\": 1,\n" +
                                "    \"amount\": 10,\n" +
                                "    \"paymentType\": \"CASH\"\n" +
                                "}"))
                .andExpect(status().isOk());


        mockMvc.perform(get("/transaction")
                        .contentType("application/json"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/transaction/1")
                        .contentType("application/json"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/transaction/seller/1")
                        .contentType("application/json"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/seller//mostProductivity")
                        .contentType("application/json")
                        .content("{\n" +
                                "    \"startPeriod\": \"2024-10-19T07:44:03.533779\",\n" +
                                "    \"endPeriod\": \"2024-10-30T07:55:03.533779\"\n" +
                                "}"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/seller/withLessAmount")
                        .contentType("application/json")
                        .content("{\n" +
                                "    \"startPeriod\": \"2024-10-19T07:44:03.533779\",\n" +
                                "    \"endPeriod\": \"2024-10-30T07:55:03.533779\",\n" +
                                "    \"maxAmount\": 11\n" +
                                "}"))
                .andExpect(status().isOk());

    }


}
