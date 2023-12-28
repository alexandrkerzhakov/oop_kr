package ru.gb.oop_kr.models.Pets;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Cat extends Pet {
    public Cat(int id, String name, String birth, List<String> commands) {
        super(id, name, birth, commands);
    }
}
