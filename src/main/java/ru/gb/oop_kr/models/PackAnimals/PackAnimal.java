package ru.gb.oop_kr.models.PackAnimals;


import ru.gb.oop_kr.models.Animals;

import java.util.List;

public abstract class PackAnimal extends Animals {
    public PackAnimal(String name, String birth, List<String> commands) {
        super(name, birth, commands);
    }
}
