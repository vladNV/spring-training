package genus.panthera.life;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

public class Person {
    private @Getter List<Memory> memoryList = new LinkedList<>();

    public void see(String cause, String desc) {
        Event event = new Event();
        event.happen(cause, desc, System.currentTimeMillis());
        memoryList.forEach(memory -> memory.remember(event));
    }

    public void notifyAllMemories() {
        memoryList.forEach(Memory::misrepresent);
    }



}
