package com.example.palindrono;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.palindrono.model.ProductItem;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)

@SpringBootTest(classes = { ConfigServerWithMongoConfiguration.class }, properties = {
    "server.port=8980" }, webEnvironment = WebEnvironment.DEFINED_PORT)
   @AutoConfigureMockMvc
   @TestPropertySource(properties = { "spring.data.mongodb.database=product" })
   @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ProductControllerTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper jsonMapper;

    @BeforeEach
    public void setUp() {
        jsonMapper = new ObjectMapper();
    }

    @Test
    public void testGetProduct() throws Exception {
        ProductItem pdItem = new ProductItem();
        pdItem.setId(1);
        pdItem.setBrand("dsaasd");
        pdItem.setDescription("zlrwax bñyrh");
        mongoTemplate.createCollection("products");
        mongoTemplate.insert(pdItem);
        ResultActions resultAction = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8090/api/product/1"));
        resultAction.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
        MvcResult result = resultAction.andReturn();
        ProductItem pResponse = jsonMapper.readValue(result.getResponse().getContentAsString(), ProductItem.class);
        Assert.assertEquals(1, pdItem.getId());
        Assert.assertEquals("Name1", pdItem.getBrand());
        Assert.assertEquals("Address1", pdItem.getDescription());
        }

}