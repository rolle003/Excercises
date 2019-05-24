import java.util.*;

//
public class Practice12_1 {
    static Scanner sc = new Scanner(System.in, "utf-8");

    public static void main(String[] args) {

// Create object
        Practice12_1 practice = new Practice12_1();

        ArrayList<Myra> myrstack = new ArrayList<Myra>();

        boolean stopinput = false;
        while (!stopinput) {
            System.out.print("1-Skapa myra\n2-Ändra barr\n" +
                    "3-Giftermål\n4-Skriv ut alla\n" +
                    "5-Avsluta\nAnge kommando: ");
            int selection = sc.nextInt();
//Clean buffer
            sc.nextLine();

            switch (selection) {
                case 1:   //Create Myra
                    Myra newMyra = practice.createMyra();
                    System.out.println("Myra " + newMyra.getName());
                    myrstack.add(newMyra);
                    break;
                case 2:   //Change Myra
                    practice.changeMyra(myrstack);
                    break;
                case 3:   //Get married
                    practice.getMarried(myrstack);
                    break;
                case 4:   //Print all Myra
                    practice.printAllMyra(myrstack);
                    break;
                case 5:   //Exit
                    System.exit(0);
                default:
                    System.out.println("Felaktigt kommando");

            }    //switch
        }
    } //main

    // Create Myra
    public Myra createMyra() {
        String namn = "";
        int barr = 0;


        System.out.println("Myranamn : ");
        namn = sc.nextLine();

        System.out.println("Antal barr : ");
        barr = sc.nextInt();
        //Clean buffer
        sc.nextLine();

        return new Myra(namn, barr);

    }

    // Change Myra
    public void changeMyra(ArrayList<Myra> args) {

        String namn = "";
        int barr = 0;

        System.out.println("Vilken Myra : ");
        namn = sc.nextLine();

        Myra valdMyra = null;
        for (Myra m : args) {
            if (m.getName().equals(namn)) {
                valdMyra = m;
            }
            ;

        }
        if (valdMyra != null) {
            System.out.print("Antal nya barr: ");
            barr = sc.nextInt();
            valdMyra.changeBarr(barr);
        } else {
            System.out.println("Den Myran fanns ej i stacken.");
        }

//Clean buffer
        sc.nextLine();

    }

    // Print all Myra
    public void printAllMyra(ArrayList<Myra> args) {


        for (Myra m : args) {

            System.out.println(m);
        }
    }

    // Get married
    public void getMarried(ArrayList<Myra> args) {

        String namn1 = "";
        String namn2 = "";

        System.out.println("Myra som vill gifta sig : ");
        namn1 = sc.nextLine();

        System.out.println("Med : ");
        namn2 = sc.nextLine();


        Myra valdMyra1 = null;
        Myra valdMyra2 = null;

        for (Myra m : args) {
            if (m.getName().equals(namn1)) {
                valdMyra1 = m;

            }
            if (m.getName().equals(namn2)) {
                valdMyra2 = m;

            }
        }
// Does Myra1 and Myra2 exist ?
        if (valdMyra1 == null || valdMyra2 == null) {
            System.out.println("En eller båda myrorna existerar ej");

        } else {
            updateMarried(valdMyra1, valdMyra2);
        }

    }

    public void updateMarried(Myra m1, Myra m2) {

//  Someone already married ?
        if (m1.getPartner() == null && m2.getPartner() == null) {
//No, do update
            m1.addPartner(m2.getName());
            m2.addPartner(m1.getName());
        } else {
            if (m1.getPartner() != null) {
//Yes
                System.out.println("Ej tillåtet, Myra " + m1.getName() + " redan gift");
            }
            if (m2.getPartner() != null) {
                System.out.println("Ej tillåtet, Myra " + m2.getName() + " redan gift");
            }

        }
    }
}


class Myra {
    private String namn;
    private int barr;
    private boolean married;
    private String partnerMyra;

    Myra(String namn, int barr) {
        this.namn = namn;
        this.barr = barr;

    }

    public int getBarr() {
        return barr;
    }

    public void changeBarr(int x) {
        barr += x;
        if (barr < 0)
            barr = 0;
    }

    public void addPartner(String namn) {
        partnerMyra = namn;
    }

    public String getName() {
        return namn;

    }

    public String getPartner() {
        return partnerMyra;

    }

    public String toString() {
        if (partnerMyra == null)
            return namn + " har " + barr + " barr, ogift";
        else
            return namn + " har " + barr + " barr, gift med " + partnerMyra;
    }

}