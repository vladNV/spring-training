package genus.panthera.life;

import genus.panthera.TempMethod;

public interface Memory {

    void remember(Event event);

    void misrepresent();

    void forget(Event event);

    @TempMethod
    void display();

}
