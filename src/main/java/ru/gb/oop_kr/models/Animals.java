package ru.gb.oop_kr.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public abstract class Animals {
    String name;
    String birth;
    List<String> commands;

    public Animals(String name, String birth, List<String> commands) {
        this.name = name;
        this.birth = birth;
        this.commands = commands;
    }

    public Animals() {

    }
}
