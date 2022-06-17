package ru.itis.diplom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@SpringBootApplication
public class DiplomaApplication {

    public static void main(String[] args){
        /*
        try {
            //вне проекта создаем файл
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:/jacoco-test/command.bat"));
            String someHashOrNum = "aboba";
            //файл будет копировать папку проекта в новую
            writer.write("xcopy \"junit-demo\" \"D:/jacoco-test/junit-demo-" + someHashOrNum + "\" /e" + "/i");
            writer.close();
            //Runtime.getRuntime().exec("cmd /c C:/Users/PC/command.bat");
            //Runtime.getRuntime().exec("cmd D:/jacoco-test/command.bat");
            BufferedWriter writer1 = new BufferedWriter(new FileWriter("D:/jacoco-test/junit-demo-" + someHashOrNum + "/src/test/java/ru/itis/junitdemo/service/SimpleServiceImplTest.java"));
            writer1.write("package ru.itis.junitdemo.service;\n" +
                    "\n" +
                    "import org.junit.Before;\n" +
                    "import org.junit.Test;\n" +
                    "import static org.junit.jupiter.api.Assertions.assertEquals;\n" +
                    "\n" +
                    "public class SimpleServiceImplTest {\n" +
                    "    SimpleServiceImpl simpleService;\n" +
                    "\n" +
                    "    @Before\n" +
                    "    public void setup(){\n" +
                    "        simpleService = new SimpleServiceImpl();\n" +
                    "    }\n" +
                    "\n" +
                    "    @Test\n" +
                    "    public void getMessageTest(){\n" +
                    "        assertEquals(\"Message\", simpleService.getMessage());\n" +
                    "    }\n" +
                    "}\n");
            writer1.close();
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("D:/jacoco-test/junit-demo-" + someHashOrNum + "/maven-instructions.bat"));
            writer2.write("mvn clean test jacoco:report");
            writer2.close();
            Runtime.getRuntime().exec("cmd /c D:/jacoco-test/junit-demo-\" + someHashOrNum + \"/maven-instructions.bat");
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
             */
        SpringApplication.run(DiplomaApplication.class, args);
    }

}
