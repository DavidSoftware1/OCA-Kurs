import java.util.Random;

public class Figther {
    // Instanzattribute (Felder)
    String name;
    int str; // Stärke
    int agi; // Agilität
    int hp = 100; // Lebenspunkte
    Random rand = new Random();

    // Standardkonstruktor
    Figther() {
        this("Noname");
    }

    // KonstruktorÜberladen
    Figther(String name) {
        str = rand.nextInt(6) + 5; // Stärke zufällig zwischen 5 und 10
        agi = rand.nextInt(11);    // Agilität zufällig zwischen 0 und 10
        this.name = name;
    }

    // Methode für den Angriff
    public void punch(Figther opponent) {
        // Prüfe, ob der Gegner ausweicht
        if (opponent.dodged()) {
            System.out.println(opponent.name + " hat den Angriff ausgewichen!");
        } else {
            int dmg = calcDmg(); // Berechne den Schaden
            opponent.hp = opponent.hp - dmg; // Reduziere die HP des Gegners
            if (opponent.hp < 0) {
                opponent.hp = 0; // HP kann nicht unter 0 fallen
            }
            System.out.println("Treffer! " + opponent.name + " hat " + dmg + " Schaden erlitten.");
            System.out.println("Übrig sind noch " + opponent.hp + " HP.");
        }
    }

    // Methode zur Schadensberechnung
    public int calcDmg() {
        int dmg = str * 2 + rand.nextInt(5) + 5; // Berechnung des Schadens
        return dmg;
    }

    // Methode zur Ausweichchance basierend auf Agilität
    public boolean dodged() {
        int dodgeChance = agi * 10; // Jede Agilitätseinheit entspricht 10% Ausweichchance
        int randomValue = rand.nextInt(100); // Zufällige Zahl zwischen 0 und 99
        return randomValue < dodgeChance; // Erfolgreiches Ausweichen, wenn randomValue kleiner als dodgeChance ist
    }

    @Override // toString-Methode für die Ausgabe
    public String toString() {
        return "Fighter[name:" + name + ", str:" + str + ", agi:" + agi + ", hp:" + hp + "]";
    }
}
