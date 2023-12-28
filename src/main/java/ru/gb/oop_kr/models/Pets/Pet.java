package ru.gb.oop_kr.models.Pets;

import lombok.Getter;
import lombok.Setter;
import ru.gb.oop_kr.models.Animals;

import java.util.List;

@Getter
@Setter
public class Pet extends Animals {
    int id;

    public Pet(int id, String name, String birth, List<String> commands) {
        super(name, birth, commands);
        this.id = id;
    }

    public Pet() {

    }
}
