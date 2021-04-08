//package com.learnist.controller;
//
//import com.learnist.database.service.UserService;
//import com.learnist.domain.User;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//
//import static org.mockito.Mockito.*;
//
//@ContextConfiguration(classes = {UserController.class})
//@ExtendWith(SpringExtension.class)
//public class UserControllerTest {
//    @Autowired
//    private UserController userController;
//
//    @MockBean
//    private UserService userService;
//
//    @Test
//    public void testAddUserAccount() throws Exception {
//        doNothing().when(this.userService).addUser((com.learnist.domain.UserDTO) any());
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/add");
//        MockMvcBuilders.standaloneSetup(this.userController)
//                .build()
//                .perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isFound())
//                .andExpect(MockMvcResultMatchers.model().size(1))
//                .andExpect(MockMvcResultMatchers.model().attributeExists("user"))
//                .andExpect(MockMvcResultMatchers.view().name("redirect:/users/user/add?success"))
//                .andExpect(MockMvcResultMatchers.redirectedUrl("/users/user/add?success"));
//    }
//
//    @Test
//    public void testDisableUser() throws Exception {
//        doNothing().when(this.userService).checkUserAvailability((Long) any(), (Boolean) any());
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/disable/{id}", 1L);
//        MockMvcBuilders.standaloneSetup(this.userController)
//                .build()
//                .perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isFound())
//                .andExpect(MockMvcResultMatchers.model().size(0))
//                .andExpect(MockMvcResultMatchers.view().name("redirect:/user/list"))
//                .andExpect(MockMvcResultMatchers.redirectedUrl("/user/list"));
//    }
//
//    @Test
//    public void testDisableUser2() throws Exception {
//        doNothing().when(this.userService).checkUserAvailability((Long) any(), (Boolean) any());
//        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/user/disable/{id}", 1L);
//        getResult.contentType("Not all who wander are lost");
//        MockMvcBuilders.standaloneSetup(this.userController)
//                .build()
//                .perform(getResult)
//                .andExpect(MockMvcResultMatchers.status().isFound())
//                .andExpect(MockMvcResultMatchers.model().size(0))
//                .andExpect(MockMvcResultMatchers.view().name("redirect:/user/list"))
//                .andExpect(MockMvcResultMatchers.redirectedUrl("/user/list"));
//    }
//
//    @Test
//    public void testEnableUser() throws Exception {
//        doNothing().when(this.userService).checkUserAvailability((Long) any(), (Boolean) any());
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/enable/{id}", 1L);
//        MockMvcBuilders.standaloneSetup(this.userController)
//                .build()
//                .perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isFound())
//                .andExpect(MockMvcResultMatchers.model().size(0))
//                .andExpect(MockMvcResultMatchers.view().name("redirect:/user/list"))
//                .andExpect(MockMvcResultMatchers.redirectedUrl("/user/list"));
//    }
//
//    @Test
//    public void testEnableUser2() throws Exception {
//        doNothing().when(this.userService).checkUserAvailability((Long) any(), (Boolean) any());
//        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/user/enable/{id}", 1L);
//        getResult.contentType("Not all who wander are lost");
//        MockMvcBuilders.standaloneSetup(this.userController)
//                .build()
//                .perform(getResult)
//                .andExpect(MockMvcResultMatchers.status().isFound())
//                .andExpect(MockMvcResultMatchers.model().size(0))
//                .andExpect(MockMvcResultMatchers.view().name("redirect:/user/list"))
//                .andExpect(MockMvcResultMatchers.redirectedUrl("/user/list"));
//    }
//
//    @Test
//    public void testGetUserList() throws Exception {
//        when(this.userService.getAllUsers()).thenReturn(new ArrayList<User>());
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/list");
//        MockMvcBuilders.standaloneSetup(this.userController)
//                .build()
//                .perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.model().size(1))
//                .andExpect(MockMvcResultMatchers.model().attributeExists("users"))
//                .andExpect(MockMvcResultMatchers.view().name("users/list"))
//                .andExpect(MockMvcResultMatchers.forwardedUrl("users/list"));
//    }
//
//    @Test
//    public void testGetUserList2() throws Exception {
//        when(this.userService.getAllUsers()).thenReturn(new ArrayList<User>());
//        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/user/list");
//        getResult.contentType("Not all who wander are lost");
//        MockMvcBuilders.standaloneSetup(this.userController)
//                .build()
//                .perform(getResult)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.model().size(1))
//                .andExpect(MockMvcResultMatchers.model().attributeExists("users"))
//                .andExpect(MockMvcResultMatchers.view().name("users/list"))
//                .andExpect(MockMvcResultMatchers.forwardedUrl("users/list"));
//    }
//}
//
