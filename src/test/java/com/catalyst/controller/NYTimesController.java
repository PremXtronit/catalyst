package com.catalyst.controller;

import com.catalyst.dto.Response;
import com.catalyst.service.NYTimesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = NYTimesController.class, secure = false)
public class NYTimesController {


    private Response response;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NYTimesService nyTimesService;

    @Test
    public void getNyTimes() throws Exception {

        Mockito.when(nyTimesService.getNYTimesArticles()).thenReturn(response);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/nyTimesArticle/7")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse());
    }

}
