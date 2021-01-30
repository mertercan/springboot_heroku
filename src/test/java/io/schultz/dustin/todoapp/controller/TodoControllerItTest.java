package io.schultz.dustin.todoapp.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
@EnableAutoConfiguration(exclude = {
        SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class
})
@ExtendWith(SpringExtension.class)
@WebMvcTest(TodoController.class)
class TodoControllerItTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @WithMockUser (username = "user", password = "user", roles = "ADMIN")
    void hello() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/todo/hello");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Hello,World",result.getResponse().getContentAsString());
    }
}