//package com.sunyard.myproject.test;
//
//import com.sunyard.myproject.controller.DemoController;
//import org.junit.Test;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//
//import static
//        org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
///**
// * Created by Administrator on 2018/4/6.
// */
//public class ControllerTest {
//    @Test
//    public void testHomePage() throws Exception{
//        DemoController dc=new DemoController();
//        MockMvc mockMvc= MockMvcBuilders.standaloneSetup(dc).build();
//        mockMvc.perform(get("/"))
//                .andExpect(view().name("Hello"));
//    }
//}
