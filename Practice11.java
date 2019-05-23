import java.util.*;

//  Arraylist övningar
public class Practice11 {
    Scanner sc = new Scanner(System.in, "utf-8");

    Practice11() {

    }

    public static void main(String[] args) {

        // Create object
        Practice11 practice = new Practice11();

        ArrayList<Person> myList = new ArrayList<>();
        String textinput = new String();


        //Fill ArrayList with name and age input

        boolean stopinput = false;
        while (!stopinput) {

            Person newPerson = practice.createPerson();


            if (newPerson.getName().equals("STOPP")) {
                stopinput = true;
            } else {

                myList.add(newPerson);

            }

        }

        practice.listPeopleByAge(myList);  //Practice 11

    }

    // List people from ArrayList with filter of age
    public void listPeopleByAge(ArrayList<Person> args) {

        //Get age from user
        int searchAge = 0;
        System.out.println("Ange en ålder : ");
        searchAge = sc.nextInt();

        sc.nextLine();

//  Check if searchAge exist in ArrayList
        boolean writeHeader = true;
        for (int i = 0; i < args.size(); i++) {

            Person personInfo = args.get(i);
            int intAnswer = personInfo.getAge();
            if (intAnswer == searchAge) {
                if (writeHeader) {
                    System.out.println("Personerna som är " + searchAge + " år gamla:");  //Write header
                    writeHeader = false;
                }
                System.out.println(personInfo);

            }

        }

    }

    // Create person
    public Person createPerson() {

        String inputName = "";
        int inputAge = 0;


        System.out.println("Namn : ");
        inputName = sc.nextLine();

        if (inputName.equals("STOPP")) {

            return new Person(inputName, 0);
        }

        System.out.println("Ålder : ");
        inputAge = sc.nextInt();
//Clean buffer
        sc.nextLine();

        Person newperson = new Person(inputName, inputAge);

        return newperson;


    }


}

class Person {
    private String name;
    private int age;


    Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}







