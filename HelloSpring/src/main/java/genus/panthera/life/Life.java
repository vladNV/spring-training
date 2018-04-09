package genus.panthera.life;


import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Life {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");


    }

    @SneakyThrows(value = {IOException.class, InterruptedException.class})
    public static void life(Person person) {
        person.see("Прибытие домой", "Наконец-то я пришле домой, трудный день");
        person.see("Нужно что то почитать", "Открою книгу");
        String book = "someBook";
        Files.lines(Paths.get(book)).forEach(s -> person.see("read book",s));
        person.see("Спать", "засыпаю");
        Thread.sleep(1000);
        person.notifyAllMemories();
        Thread.sleep(1000);
        person.notifyAllMemories();
        Thread.sleep(1000);
        person.notifyAllMemories();
        Thread.sleep(1000);
        person.see("Проснулся","Сегодня чудесный день!");
        person.see("Проверка","Что там с моей памятью");
        Memory memory = person.getMemoryList().get(0);
        memory.display();
    }

}
