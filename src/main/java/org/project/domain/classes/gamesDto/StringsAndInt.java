package org.project.domain.classes.gamesDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StringsAndInt {
    String gameName;
    String Login;
    int gameStatus;
}
