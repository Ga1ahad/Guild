import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Adventurer implements Serializable {
    private String name;
    private String nick;
    private String surname;
    private int age;

    private ArrayList<Adventurer> retainers;

    private static ArrayList<Adventurer> adventurers = new ArrayList<>();

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return this.nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public ArrayList<Adventurer> getRetainer() {
        return this.retainers;
    }

    public void addRetainer(Adventurer adventurer) {
        if (retainers == null) {
            retainers = new ArrayList<>();
        }
        this.retainers.add(adventurer);
    }

    public void removeRetainer(Adventurer adventurer) {
        if (retainers != null) {
            this.retainers.remove(adventurer);
        }
    }


    public String toString() {
        return name + " " + nick + " " + surname;
    }

    private static void addAdventurer(Adventurer adventurer) {
        if (adventurers == null) {
            adventurers = new ArrayList<>();
        }
        adventurers.add(adventurer);
    }

    public static void removeAdventurer(Adventurer adventurer) {
        if (adventurers != null) {
            adventurers.remove(adventurer);
        }
    }

    public static void showAdvExtent() {
        System.out.println("Extent of the class: " + Adventurer.class.getName());
        for (Adventurer a : adventurers) {
            System.out.println(a.toString());
        }
    }

    public static void writeAdvExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(adventurers);
    }

    public static void readAdvxtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        adventurers = (ArrayList<Adventurer>) stream.readObject();
    }

    public Adventurer(String name, String nick, String surname, int age) {
        setName(name);
        setNick(nick);
        setSurname(surname);
        setAge(age);
        this.retainers = new ArrayList<Adventurer>();
        addAdventurer(this);

    }

}
