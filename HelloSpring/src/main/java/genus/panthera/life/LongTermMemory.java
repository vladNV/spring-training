package genus.panthera.life;

import lombok.Getter;
import lombok.NonNull;

import java.util.*;

public class LongTermMemory implements Memory {
    private @Getter List<Event> memories = new ArrayList<>();
    private final Random random = new Random();
    private final static double UPPER_TIME = 1.03;
    private final static double LOWER_TIME = 0.96;
    private final static String DELIMITER = " ";
    private final static int MEMORY_MAINTAINABILITY = 10;

    @Override
    public void remember(Event event) {
        memories.add(event);
    }

    @Override
    public void misrepresent() {
        if (memories.size() <= MEMORY_MAINTAINABILITY) return;
        Event event = memories
                .get(random.nextInt(memories.size() - MEMORY_MAINTAINABILITY));
        forget(event);
        event.setTime(shiftTime(event.getTime()));
        event.setDescription(shuffleWords(event.getDescription()));
        event.setCause(forgetWords(event.getCause()));
        remember(event);
    }

    @Override
    public void forget(Event event) {
        memories.remove(event);
    }

    @Override
    public void display() {
        memories.forEach(System.out::println);
    }

    private long shiftTime(long time) {
        return (long)(time * (LOWER_TIME + random.nextDouble()
                * (UPPER_TIME - LOWER_TIME)));
    }

    private String forgetWords(@NonNull  String cause) {
        String[] words = cause.split(DELIMITER);
        int index = random.nextInt(words.length);
        words[index] = "";
        return String.join(DELIMITER, words);
    }

    private String shuffleWords(@NonNull  String description) {
        String[] words = description.split(DELIMITER);
        if (words.length <= 2) return String.join(DELIMITER, words);
        int size = words.length / 3;
        for (int i = 0; i < size; i++) {
            int index1 = random.nextInt(words.length);
            int index2 = random.nextInt(words.length);
            swap(words, index1, index2);
        }
        return String.join(DELIMITER, words);
    }

    private void swap(String[] words, int i, int j) {
        String tmp = words[i];
        words[i] = words[j];
        words[j] = tmp;
    }
}
