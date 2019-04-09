import java.io.*;

public class Main {

    public static void main(String[] args) {

        Adventurer adventurer = new Adventurer("Nick", "Fury", "Fury", 39);
        Adventurer adventurer1 = new Adventurer("Arthur", "Saber ", "Pendragon", 21);
        Adventurer adventurer2 = new Adventurer("Clark", "Merlin", "Kovac", 29);

        Adventurer.showAdvExtent();
        System.out.println();

        Weapon weapon = new Weapon("Fists", null);
        Weapon weapon1 = new Weapon("Othbringer", 1500, 305, 1.5);
        Weapon weapon2 = new Weapon("Excalibur", 50000, 450, 2, adventurer1);

        System.out.println("Extent class Weapon:");
        Weapon.printWeapons(null);
        System.out.println();

        try {
            ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("file")));
            Adventurer.writeAdvExtent(out);
            Weapon.writeWeaponExtent(out);
            out.close();

            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("file")));
            Adventurer.readAdvxtent(in);
            Weapon.readWeaponxtent(in);
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println();

        weapon1.setUser(adventurer);
        System.out.println("Complex attribute: " + weapon1.getUser());
        System.out.println();


        System.out.println("Multi-value attribute: ");
        adventurer2.addRetainer(adventurer);
        adventurer2.addRetainer(adventurer1);

        System.out.println("Retainers of adventurer " + adventurer2.getNick() + ":");

        for (Adventurer a : adventurer2.getRetainer()) {
            System.out.println(a.toString());
        }
        System.out.println();

        Weapon.setWeaponType("Sword");
        System.out.println("Class attribute: " + Weapon.getWeaponType());
        System.out.println();

        System.out.println("Derived attribute: " + weapon2.getCritDamage());
        System.out.println();

    }
}
