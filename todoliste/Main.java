import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    static Scanner sc = new Scanner(System.in); // Weil die main-Methode static ist, muss auch der Scanner in diesem Fall static sein.
    static ArrayList<Todo> todolist = new ArrayList<>();
    static File file = new File("src/data.txt");
    final static String OPTIONS = "--------\n" +
            "new: neue Todo erstellen\n" +
            "delete: löscht eine Todo\n" +
            "list: zeigt alle Todos an\n" +
            "exit: beendet das Programm\n" +
            "--------" ;


    public static void main(String[] args) {

        readFromFile();
        System.out.println(OPTIONS);

        boolean exit = false;
        while(!exit) {
            String input = Helper.getStringInput("Geben Sie einen Befehl ein:").toLowerCase();// statischer Methodenaufruf aus der Helper-Klasse
            switch(input) {
                case "new":
                    Todo t = new Todo(Helper.getStringInput("Geben Sie an was zu tun ist:"));
                    todolist.add(t);
                    System.out.println("Todo erstellt!");
                    saveToFile(); // speichert die ArrayList in eine Textdatei
                    break;
                case "delete":
                    {
                        int index = Helper.getIntInput("Geben Sie den Index der zur löschenden Todo an:");
                        Todo to = todolist.remove(index);
                        System.out.println("Die Todo(" + to.getSubject() + ") wurde gelöscht");
                        saveToFile();
                    }
                    break;
                case "check":
                    {
                        int index = Helper.getIntInput("Geben Sie den Index der erledigten Todo an:");
                        todolist.get(index).setChecked(true);
                        saveToFile();
                    }
                    break;
                case "list":
                    //System.out.println(todolist); // zeigt alle Todos in einer Zeile an
                    int index = 0;
                    if(!todolist.isEmpty()) {
                        for(Todo todo:todolist) {
                            System.out.println(index++ +": "+todo);
                        }
                    } else {
                        System.out.println("Keine Einträge vorhanden!");
                    }
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Unbekannter Befehl!");
                    break;
            }

        }



    }

    /**
     * Hinterlegt die ganze ArrayList(todolist) in eine Textdatei
     */
    static public void saveToFile() {

        try {

            if(!file.exists()) {
                file.createNewFile();
            }
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(todolist);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    static public void readFromFile() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            todolist = (ArrayList<Todo>) in.readObject();
        } catch(IOException|ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

        /*// final bewirkt, dass die Variable auf kein neues Objekt oder Wert zeigen darf.
        // Sofern die Attribute des Objektes aber selbst nicht final sind, dürfen wir sie verändern.
        int[] zahlen = {0,0,0};
        zahlen[1] = 7; // {0,7,0};

        // Wir dürfen den index 1 verändern, obwohl die Variable final ist.
        final int[] zahlen2 = {0,0,0};
        zahlen2[1] = 7;
        // wir dürfen der Variable aber nichts neues zuweisen
        zahlen2 = new int[]{1,2,3};*/