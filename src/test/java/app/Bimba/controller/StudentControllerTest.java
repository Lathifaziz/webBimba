package app.Bimba.controller;

import app.Bimba.model.Student;
import app.Bimba.repository.StudentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.WebAppRootListener;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private StudentRepository studentRepository;

    @Test
    void create() throws Exception {
        Student student = new Student();
        student.setName("test");
        student.setAddress("test");
        student.setNik("3322150105930003");

        mockMvc.perform(
                post("/datasiswa")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student))
        ).andExpectAll(status().isOk()
        ).andDo(result -> {
            Student response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            assertNotNull(response.getName());

            Student add = studentRepository.findById(response.getId()).orElseThrow();

            assertEquals("test",response.getName());
        });

    }

    @Test
    void findAll() throws Exception {


        Student student = new Student();
        student.setName("test");
        student.setNik("123456");
        student.setAddress("test");
        student.setBirthday(2001,01,01 );
        studentRepository.save(student);

        mockMvc.perform(
                get("/datasiswa")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student))
        ).andExpectAll(status().isOk()
        ).andDo(result -> {
            List<Student> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            assertEquals(student.getName(),response.getFirst().getName());
            assertEquals(student.getAddress(),response.getFirst().getAddress());
            assertEquals(student.getNik(),response.getFirst().getNik());
            assertEquals(student.getBirthday(),response.getFirst().getBirthday());

             });

    }
}
