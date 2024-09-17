//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        // Create an instance of Figther
        Figther f1 = new Figther("Mad Max");
        Figther f2 = new Figther(); // f2 gets the default name "Noname"

      /*  f2.hp = f2.hp-f1.calcDmg();
        f1.hp = f1.hp-f2.calcDmg();*/
        while (f1.hp > 0 && f2.hp > 0){
            f1.punch(f2);
            f2.punch(f1);
            System.out.println("-----");
    }
        // Print out the names
        System.out.println("Hello, I am " + f1); // Prints "Mad Max"
        System.out.println("Hello, I am " + f2); // Prints "Noname"
    }

}