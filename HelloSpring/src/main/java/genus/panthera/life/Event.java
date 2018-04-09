package genus.panthera.life;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@EqualsAndHashCode(of = "time")
@ToString(of = "output")
@NoArgsConstructor
public class Event {
    private @Getter @Setter String cause;
    private @Getter @Setter long time;
    private @Getter @Setter String description;
    private @Getter String output;

    public void happen(String cause, String description, long time) {
        this.cause = cause;
        this.description = description;
        this.time = time;
        this.output = "It happened on " + millsToLocaleDateTime(time) +
                " I think that cause was " + cause +
                " I can describe it in the next way " + description;
    }

    private static LocalDateTime millsToLocaleDateTime(long millis) {
        Instant moment = Instant.ofEpochMilli(millis);
        return moment.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
