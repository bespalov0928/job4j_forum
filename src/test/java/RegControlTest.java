import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class RegControlTest {

    @MockBean
    UserService users;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageReg() throws Exception{
        this.mockMvc.perform(get("/reg"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("reg"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageRegSave() throws Exception{
        this.mockMvc.perform(post("/reg")
                        .param("username", "root1")
                        .param("password", "123")
                        .param("enabled", "true"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());

        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        ArgumentCaptor<String> role = ArgumentCaptor.forClass(String.class);
        verify(users).saveUser(argument.capture(), role.capture());
        assertThat(argument.getValue().getUsername(), is("root1"));


    }
}
