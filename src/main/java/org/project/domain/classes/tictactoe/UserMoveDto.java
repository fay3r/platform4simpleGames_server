package org.project.domain.classes.tictactoe;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserMoveDto {
    private String fieldX;
    private String fieldY;
    private Character mark;

    public String getFieldX() {
        return fieldX;
    }

    public String getFieldY() {
        return fieldY;
    }

    public Character getMark() {
        return mark;
    }
}
