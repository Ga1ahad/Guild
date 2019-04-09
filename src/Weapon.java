import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Weapon implements Serializable {
    private String name;
    private ArrayList<Weapon> type;
    private double damage;
    private double critP;
    private double critDamage;
    private Integer cost;
    private Adventurer user;
    private ArrayList<Weapon> attributs;

    private static ArrayList<Weapon> weapons = new ArrayList<>();
    private static String weaponType;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDamage() {
        return this.damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double setCritP() {
        return this.critP;
    }

    public void setCritDaname(double critP, double damage) {
        this.critP = critP;
        this.damage = damage;
        this.critDamage = critP * damage;
    }

    public double getCritDamage() {
        return this.critDamage;
    }


    public Integer getCost() {
        return this.cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Adventurer getUser() {
        return this.user;
    }

    public void setUser(Adventurer adventurer) {
        this.user = adventurer;
    }

    public static String getWeaponType() {
        return weaponType;
    }

    public static void setWeaponType(String wt) {
        weaponType = wt;
    }

    private static void addWeapon(Weapon weapon) {
        if (weapons == null) {
            weapons = new ArrayList<Weapon>();
        }
        weapons.add(weapon);
    }


    public static void removeWeapon(Weapon weapon) {
        if (weapons != null) {
            weapons.remove(weapon);
        }
    }

    public static void printWeapons(String param) {
        if (param == null) {
            for (Weapon w : weapons) {
                System.out.println(w.toString());
            }
        } else if (param == "name") {
            for (Weapon w : weapons) {
                System.out.println(w.getName());
            }
        } else if (param == "damage") {
            for (Weapon w : weapons) {
                System.out.println(w.getDamage());
            }
        }


    }

    public static void writeWeaponExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(weapons);
    }


    public static void readWeaponxtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        weapons = (ArrayList<Weapon>) stream.readObject();
    }


    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Weapon  " + getName() + ", ");
        result.append(" damage: " + getDamage());

        if (getCritDamage() != 0) {
            result.append(" critical damage " + getCritDamage());
        }
        if (getUser() != null) {
            result.append(" user of this weapon is " + getUser().toString());
        }
        return result.toString();
    }

    public Weapon(String name, Integer cost) {
        setName(name);
        setUser(null);
        this.attributs = new ArrayList<Weapon>();
        addWeapon(this);
    }

    public Weapon(String name, Integer cost, double damage, double critP) {
        setName(name);
        setDamage(damage);
        setCritDaname(critP, damage);
        setUser(null);
        this.attributs = new ArrayList<Weapon>();
        addWeapon(this);
    }

    public Weapon(String name, Integer cost, double damage, double critP, Adventurer adventurer) {
        setName(name);
        setDamage(damage);
        setCritDaname(critP, damage);
        setUser(adventurer);
        this.attributs = new ArrayList<Weapon>();
        addWeapon(this);
    }
}

