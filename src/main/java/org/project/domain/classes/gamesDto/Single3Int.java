package org.project.domain.classes.gamesDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Single3Int {
    int x;
    int y;
    int mark;
}
