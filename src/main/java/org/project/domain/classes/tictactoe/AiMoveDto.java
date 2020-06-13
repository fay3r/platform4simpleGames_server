package org.project.domain.classes.tictactoe;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class AiMoveDto {

        private Character mark;

        public Character getMark() {
                return mark;
        }


}
