package me.ronyvidaur.runescape;

import me.ronyvidaur.runescape.controller.ScoreboardController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private ScoreboardController sampleScoreboardController;



    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void scoreboardsAreUp() throws Exception {
        this.mockMvc.perform(get("/scoreboards").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

    }


    @Test
    public void testScoreboardService() {
        assertEquals("class me.ronyvidaur.runescape.controller.ScoreboardController", this.sampleScoreboardController.getClass().toString());
    }



    @Test
    public void contentLoads() {

    }

}
