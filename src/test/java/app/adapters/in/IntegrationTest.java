package app.adapters.in;

import app.adapters.in.dto.PasswordRequest;
import app.adapters.in.dto.PasswordResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc //need this in Spring Boot test
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldReturn200() throws Exception {
        PasswordRequest passwordRequest = new PasswordRequest();
        passwordRequest.setPassword("AbTp!f1oa");
        mockMvc.perform(MockMvcRequestBuilders.post("/validate/password")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(passwordRequest)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.isPasswordValid").exists());;
    }
    @Test
    public void shouldReturn400() throws Exception {
        PasswordRequest passwordRequest = new PasswordRequest();
        passwordRequest.setPassword("aa");
        mockMvc.perform(MockMvcRequestBuilders.post("/validate/password")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(passwordRequest)))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.list_of_errors").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.error_message").exists());
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
