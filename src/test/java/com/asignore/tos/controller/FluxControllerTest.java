package com.asignore.tos.controller;


import com.asignore.tos.client.FlightDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class FluxControllerTest {

    public static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=UTF-8";
    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_retrieve_flightplan() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(
                get("/flightplan")
                        .contentType(MediaType.parseMediaType(APPLICATION_JSON_CHARSET_UTF_8))
                        .accept(MediaType.parseMediaType(APPLICATION_JSON_CHARSET_UTF_8)))
                .andExpect(status().isOk()).andReturn();

        String contentResponse = mvcResult.getResponse().getContentAsString();
        log.debug("contentResponse = " + contentResponse);

        final List<FlightDTO> flightDTOS = objectMapper.readValue(contentResponse, new TypeReference<List<FlightDTO>>() {
        });
        Assert.assertEquals("[{\"origin\":\"TXL\",\"destination\":\"MUC\",\"departure\":\"2018-05-29T10:00:000+0200\",\"arrival\":\"2018-05-29T11:00:000+0200\",\"equipment\":\"737\"},{\"origin\":\"TXL\",\"destination\":\"MUC\",\"departure\":\"2018-05-29T03:00:000+0200\",\"arrival\":\"2018-05-29T04:00:000+0200\",\"equipment\":\"737\"},{\"origin\":\"TXL\",\"destination\":\"MUC\",\"departure\":\"2018-05-29T04:00:000+0200\",\"arrival\":\"2018-05-29T05:00:000+0200\",\"equipment\":\"737\"},{\"origin\":\"TXL\",\"destination\":\"MUC\",\"departure\":\"2018-05-29T06:00:000+0200\",\"arrival\":\"2018-05-29T07:00:000+0200\",\"equipment\":\"737\"},{\"origin\":\"TXL\",\"destination\":\"HAM\",\"departure\":\"2018-05-29T09:00:000+0200\",\"arrival\":\"2018-05-29T09:40:000+0200\",\"equipment\":\"737\"},{\"origin\":\"MUC\",\"destination\":\"LHR\",\"departure\":\"2018-05-29T10:00:000+0200\",\"arrival\":\"2018-05-29T12:00:000+0200\",\"equipment\":\"A321\"},{\"origin\":\"MUC\",\"destination\":\"TXL\",\"departure\":\"2018-05-29T03:00:000+0200\",\"arrival\":\"2018-05-29T04:00:000+0200\",\"equipment\":\"A321\"},{\"origin\":\"MUC\",\"destination\":\"TXL\",\"departure\":\"2018-05-29T04:00:000+0200\",\"arrival\":\"2018-05-29T05:00:000+0200\",\"equipment\":\"A321\"},{\"origin\":\"MUC\",\"destination\":\"LHR\",\"departure\":\"2018-05-29T06:00:000+0200\",\"arrival\":\"2018-05-29T08:00:000+0200\",\"equipment\":\"A321\"},{\"origin\":\"MUC\",\"destination\":\"HAM\",\"departure\":\"2018-05-29T09:00:000+0200\",\"arrival\":\"2018-05-29T10:00:000+0200\",\"equipment\":\"A321\"},{\"origin\":\"MUC\",\"destination\":\"LHR\",\"departure\":\"2018-05-29T10:00:000+0200\",\"arrival\":\"2018-05-29T12:30:000+0200\",\"equipment\":\"A321\"},{\"origin\":\"MUC\",\"destination\":\"LHR\",\"departure\":\"2018-05-29T03:00:000+0200\",\"arrival\":\"2018-05-29T05:00:000+0200\",\"equipment\":\"A321\"},{\"origin\":\"MUC\",\"destination\":\"TXL\",\"departure\":\"2018-05-29T04:00:000+0200\",\"arrival\":\"2018-05-29T05:00:000+0200\",\"equipment\":\"A321\"},{\"origin\":\"LHR\",\"destination\":\"HAM\",\"departure\":\"2018-05-29T09:00:000+0200\",\"arrival\":\"2018-05-29T11:30:000+0200\",\"equipment\":\"747-400\"},{\"origin\":\"LHR\",\"destination\":\"TXL\",\"departure\":\"2018-05-29T10:00:000+0200\",\"arrival\":\"2018-05-29T12:00:000+0200\",\"equipment\":\"747-400\"},{\"origin\":\"LHR\",\"destination\":\"TXL\",\"departure\":\"2018-05-29T03:00:000+0200\",\"arrival\":\"2018-05-29T05:00:000+0200\",\"equipment\":\"747-400\"},{\"origin\":\"LHR\",\"destination\":\"MUC\",\"departure\":\"2018-05-29T04:00:000+0200\",\"arrival\":\"2018-05-29T06:00:000+0200\",\"equipment\":\"747-400\"},{\"origin\":\"HAM\",\"destination\":\"HAM\",\"departure\":\"2018-05-29T10:00:000+0200\",\"arrival\":\"2018-05-29T11:00:000+0200\",\"equipment\":\"A320\"},{\"origin\":\"HAM\",\"destination\":\"HAM\",\"departure\":\"2018-05-29T03:00:000+0200\",\"arrival\":\"2018-05-29T04:00:000+0200\",\"equipment\":\"A320\"},{\"origin\":\"HAM\",\"destination\":\"HAM\",\"departure\":\"2018-05-29T04:00:000+0200\",\"arrival\":\"2018-05-29T05:00:000+0200\",\"equipment\":\"A320\"}]", contentResponse);
        Assert.assertEquals(20, flightDTOS.size());
    }

    @Test
    public void should_retrieve_flightplan_per_airport() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(
                get("/flightplan?airport=MUC")
                        .contentType(MediaType.parseMediaType(APPLICATION_JSON_CHARSET_UTF_8))
                        .accept(MediaType.parseMediaType(APPLICATION_JSON_CHARSET_UTF_8)))
                .andExpect(status().isOk()).andReturn();

        String contentResponse = mvcResult.getResponse().getContentAsString();
        log.debug("contentResponse = " + contentResponse);

        final List<FlightDTO> flightDTOS = objectMapper.readValue(contentResponse, new TypeReference<List<FlightDTO>>() {
        });
        Assert.assertEquals("[{\"origin\":\"MUC\",\"destination\":\"LHR\",\"departure\":\"2018-05-29T10:00:000+0200\",\"arrival\":\"2018-05-29T12:00:000+0200\",\"equipment\":\"A321\"},{\"origin\":\"MUC\",\"destination\":\"TXL\",\"departure\":\"2018-05-29T03:00:000+0200\",\"arrival\":\"2018-05-29T04:00:000+0200\",\"equipment\":\"A321\"},{\"origin\":\"MUC\",\"destination\":\"TXL\",\"departure\":\"2018-05-29T04:00:000+0200\",\"arrival\":\"2018-05-29T05:00:000+0200\",\"equipment\":\"A321\"},{\"origin\":\"MUC\",\"destination\":\"LHR\",\"departure\":\"2018-05-29T06:00:000+0200\",\"arrival\":\"2018-05-29T08:00:000+0200\",\"equipment\":\"A321\"},{\"origin\":\"MUC\",\"destination\":\"HAM\",\"departure\":\"2018-05-29T09:00:000+0200\",\"arrival\":\"2018-05-29T10:00:000+0200\",\"equipment\":\"A321\"},{\"origin\":\"MUC\",\"destination\":\"LHR\",\"departure\":\"2018-05-29T10:00:000+0200\",\"arrival\":\"2018-05-29T12:30:000+0200\",\"equipment\":\"A321\"},{\"origin\":\"MUC\",\"destination\":\"LHR\",\"departure\":\"2018-05-29T03:00:000+0200\",\"arrival\":\"2018-05-29T05:00:000+0200\",\"equipment\":\"A321\"},{\"origin\":\"MUC\",\"destination\":\"TXL\",\"departure\":\"2018-05-29T04:00:000+0200\",\"arrival\":\"2018-05-29T05:00:000+0200\",\"equipment\":\"A321\"}]", contentResponse);
        Assert.assertEquals(8, flightDTOS.size());
    }

    @Test
    public void should_retrieve_operation_per_registration() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(
                get("/operationsplan?registration=FL-0001")
                        .contentType(MediaType.parseMediaType(APPLICATION_JSON_CHARSET_UTF_8))
                        .accept(MediaType.parseMediaType(APPLICATION_JSON_CHARSET_UTF_8)))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        String contentResponse = mvcResult.getResponse().getContentAsString();
        log.debug("contentResponse = " + contentResponse);

        final List<FlightDTO> flightDTOS = objectMapper.readValue(contentResponse, new TypeReference<List<FlightDTO>>() {
        });
        Assert.assertEquals("[{\"origin\":\"TXL\",\"destination\":\"MUC\",\"departure\":\"2018-05-29T10:00:000+0200\"},{\"origin\":\"TXL\",\"destination\":\"MUC\",\"departure\":\"2018-05-29T03:00:000+0200\"},{\"origin\":\"TXL\",\"destination\":\"MUC\",\"departure\":\"2018-05-29T04:00:000+0200\"},{\"origin\":\"TXL\",\"destination\":\"MUC\",\"departure\":\"2018-05-29T06:00:000+0200\"},{\"origin\":\"TXL\",\"destination\":\"HAM\",\"departure\":\"2018-05-29T09:00:000+0200\"}]", contentResponse);
        Assert.assertEquals(5, flightDTOS.size());

    }

    @Test(expected = org.springframework.web.util.NestedServletException.class)
    public void should_retrieve_operation_per_registration_no_params() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(
                get("/operationsplan")
                        .contentType(MediaType.parseMediaType(APPLICATION_JSON_CHARSET_UTF_8))
                        .accept(MediaType.parseMediaType(APPLICATION_JSON_CHARSET_UTF_8)))
                .andDo(print()).andExpect(status().isOk()).andReturn();
    }

}
