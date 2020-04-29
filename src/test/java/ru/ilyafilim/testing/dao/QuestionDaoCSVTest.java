package ru.ilyafilim.testing.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import ru.ilyafilim.testing.config.CSVSettings;
import ru.ilyafilim.testing.domain.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
class QuestionDaoCSVTest {

    @Qualifier("CSVSettings")
    @Autowired
    CSVSettings settings;
    private final String SEPARATOR = ",";

    @Test
    public void testReadFile() {
        InputStream in = getClass().getResourceAsStream(settings.getFile());
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        assertThat(br).isNotNull();
    }

    @Test
    public void testReadFirstRowFromFile() throws IOException {
        InputStream in = getClass().getResourceAsStream(settings.getFile());
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        br.readLine();
        String line = br.readLine();
        assertThat(line).isEqualTo("млекопитающее,слон – это млекопитающее или птица?");
    }

    @Test
    public void testCreateQuestionEntity() throws IOException {
        InputStream in = getClass().getResourceAsStream(settings.getFile());
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        br.readLine();
        String[] data = br.readLine().split(SEPARATOR);
        Question question = new Question(data[0], data[1]);
        assertEquals(question.getTerm(), "млекопитающее");
        assertEquals(question.getDefinition(), "слон – это млекопитающее или птица?");

    }



}