package objects;

import java.util.ArrayList;
import utility.Ink;

public class Shelter {

    private String address = "1234 Forever Furry Friends Lane";
    private String[] hours = {
        "Mon: 8am - 4pm",
        "Tues: 8am - 4pm",
        "Wed: 8am - 4pm",
        "Thurs: 8am - 4pm",
        "Fri: 8am - 4pm",
        "Sat/Sun: closed"
    };

    // composition: a class made up of other classes
    private ArrayList<Pet> pets = new ArrayList<>();

    public Shelter() {
        // do nothing
    }

    //=============>>
    // GETTERS
    public String getAddress() {
        return this.address;
    }

    public String[] getHours() {
        return this.hours;
    }

    public ArrayList<Pet> getPets() {
        return this.pets;
    }

    public Pet getPet(int idx) {
        return pets.get(idx);
    }

    //=============>>
    // SETTERS
    public void setAddress(String address) {
        this.address = address;
    }

    public void setHours(String[] hours) {
        this.hours = hours;
    }

    public void adopt(int idx, String owner) {
        pets.get(idx).setIsAdopted();
        pets.get(idx).setOwner(owner);
        System.out.println(Ink.ANSI_RED + "        .-\"\"\"-.    .-\"\"\"-." + Ink.ANSI_RESET);
        System.out.println(Ink.ANSI_RED + "       /       `..'       \\" + Ink.ANSI_RESET);
        System.out.println(Ink.ANSI_RED + "      |                    |" + Ink.ANSI_RESET);
        System.out.println(Ink.ANSI_RED + "      |                    |" + Ink.ANSI_RESET);
        System.out.println(Ink.ANSI_RED + "       \\                  /" + Ink.ANSI_RESET);
        System.out.println(Ink.ANSI_RED + "        \\                /" + Ink.ANSI_RESET);
        System.out.println(Ink.ANSI_RED + "         `\\            /'" + Ink.ANSI_RESET);
        System.out.println(Ink.ANSI_RED + "           `\\        /'" + Ink.ANSI_RESET);
        System.out.println(Ink.ANSI_RED + "             `\\    /'" + Ink.ANSI_RESET);
        System.out.println(Ink.ANSI_RED + "               `\\/'" + Ink.ANSI_RESET);      
        System.out.printf("%s%s is now yours!%s%n", Ink.ANSI_YELLOW, pets.get(idx).getName(), Ink.ANSI_RESET);        
        
        pets.remove(idx); // takes the pet from the shelter
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }
  
} // class