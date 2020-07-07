package com.bankofapis.web.controller;


import com.bankofapis.core.model.token.TokenResponse;
import com.bankofapis.remote.config.ClientConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class BaseControllerTestIT {

    public final String aispBasePath = "http://localhost:8081/open-banking/v3.1/aisp";
    public final String pispBasePath = "http://localhost:8081/open-banking/v3.1/pisp";
    public final String tokenBasePath = "http://localhost:8081";

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected ClientConfig clientConfig;




    protected TokenResponse getBearerToken(String scope) throws Exception {


        MvcResult result = this.mockMvc.perform(post(tokenBasePath+"/token")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("scope",scope)
                .param("client_id", clientConfig.getClientId())
                .param("grant_type", "client_credentials"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        return objectMapper.readValue(result.getResponse().getContentAsString(), TokenResponse.class);

    }

    public MvcResult performPost(String url, HttpEntity entity) throws Exception {
        ResultActions resultActions = this.mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .headers(entity.getHeaders())
                .content(objectMapper.writeValueAsString(entity.getBody())))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
        return resultActions.andReturn();
    }



    public Optional jsonToPojo(String contentAsString, Class classToCast) throws Exception{
        return Optional.of(objectMapper.readValue(contentAsString, classToCast));
    }





}