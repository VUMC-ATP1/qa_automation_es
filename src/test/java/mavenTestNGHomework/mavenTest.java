package mavenTestNGHomework;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;

public class mavenTest {

    public static void main(String[] args) throws IOException {
        String asciiArt = FigletFont.convertOneLine("Evita Savicka");
        System.out.println(asciiArt);
    }
}

