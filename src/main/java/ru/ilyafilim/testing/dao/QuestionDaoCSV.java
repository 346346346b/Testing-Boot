package ru.ilyafilim.testing.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.ilyafilim.testing.config.CSVSettings;
import ru.ilyafilim.testing.domain.Question;

import javax.crypto.spec.PSource;
import java.io.*;

@Component
public class QuestionDaoCSV implements QuestionDao {

    private final String csvFile;
    private int currentRow = 0;

    public QuestionDaoCSV(@Qualifier("CSVSettings") CSVSettings settings) {
        this.csvFile = settings.getFile();
    }

    @Override
    public Question readRow() {
        try {
            currentRow++;
            //InputStream in = new FileInputStream(csvFile);
            InputStream in = getClass().getResourceAsStream(csvFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line; int c = 0;
            while ((line = br.readLine()) != null) {
                if (c == currentRow) {
                    return new Question(line.split(",", 2)[0], line.split(",", 2)[1]);
                }
                c++;
            }
        } catch (IOException io) {
            return null;
        }
        return null;
    }
}
