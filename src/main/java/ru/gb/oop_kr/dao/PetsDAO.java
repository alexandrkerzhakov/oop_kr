package ru.gb.oop_kr.dao;

import org.springframework.stereotype.Component;
import ru.gb.oop_kr.models.Pets.Cat;
import ru.gb.oop_kr.models.Pets.Dog;
import ru.gb.oop_kr.models.Pets.Hamster;
import ru.gb.oop_kr.models.Pets.Pet;

import java.util.ArrayList;
import java.util.List;

@Component
public class PetsDAO {

    private static int PETS_COUNT;
    private final List<Pet> petList;

    {
        petList = new ArrayList<>();
        petList.add(new Dog(++PETS_COUNT,"Fido", "2020-01-01", List.of("Sit", "Stay", "Fetch")));
        petList.add(new Cat(++PETS_COUNT,"Whiskers", "2019-05-15", List.of("Sit", "Pounce")));
        petList.add(new Hamster(++PETS_COUNT,"Hammy", "2021-03-10", List.of("Roll", "Hide")));
        petList.add(new Dog(++PETS_COUNT,"Buddy", "2018-12-10", List.of("Sit", "Paw", "Bark")));
        petList.add(new Cat(++PETS_COUNT,"Smudge", "2020-02-20", List.of("Sit", "Pounce", "Scratch")));
//        petList.forEach(pet -> System.out.println(pet.getClass().getName() + " " + pet.getId() + " " + pet.getName() + " " + pet.getBirth() + " " + pet.getCommands()));
    }

    public List<Pet> findAll() {
        return petList;
    }

    public Pet findById(int id) {
        return petList.
                stream().
                filter(pet -> pet.getId() == id).
                findAny().
                orElse(null);
    }

    public void save(Pet pet) {
        pet.setId(++PETS_COUNT);
        petList.add(pet);
    }

    public void update(int id, Pet updatedPet) {
        Pet petToBeUpdated = findById(id);
        petToBeUpdated.setName(updatedPet.getName());
        petToBeUpdated.setBirth(updatedPet.getBirth());
        petToBeUpdated.setCommands(updatedPet.getCommands());
    }

    public void delete(int id) {
        petList.removeIf(pet -> pet.getId() == id);
    }
}
