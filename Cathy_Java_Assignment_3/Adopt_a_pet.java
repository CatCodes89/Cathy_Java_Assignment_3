import java.util.Scanner;
import objects.User;
import objects.Pet;
import objects.Shelter;
import utility.Ink;

public class Adopt_a_pet {
    private static final Scanner input = new Scanner(System.in);
    private static final Ink ink = new Ink();
    private static User user;
    private static final Shelter shelter = new Shelter();
    private static Pet pet;

    private static int choice;
    private static long longPhone;
    private static boolean isDone = false;
    private static boolean goBack = false;

    public static void main(String[] args) {

        ink.printWelcome(); // Print welcome message
        createUser(input); // create the user
        createPets(); // helper pets

        while (!isDone) {
            choice = ink.validateMainMenu();

            switch (choice) {
                case 1: // print available pets
                    System.out.println(Ink.ANSI_ORANGE +
                            "Welcome! Meet our pawsome pets waiting for furever homes!" 
                            + Ink.ANSI_RESET);
                    ink.printAvailablePets(shelter.getPets());
                    while (!goBack) {
                        int pick = input.nextInt();
                        if (pick != 0) {
                            ink.printPetDetails(shelter.getPet(pick - 1));
                            String answer = input.next();
                            if (answer.equalsIgnoreCase("Y")) {
                                shelter.adopt(pick - 1, user.getName());
                                goBack = true;
                            } else {
                                goBack = true;
                            }
                        } else {
                            goBack = true;
                        }
                    } // while
                    break;
                case 2: // print shelter details
                    ink.printShelterDetails(shelter);
                    int shelterChoice = input.nextInt();
                    if (shelterChoice == 0) {
                        // Go back to the main menu
                    }
                    break;
                case 3: // book an appointment menu
                    String appointmentDay = user.bookAppointment(input, ink); 
                    user.setBookAppointment(appointmentDay);
                    goBack = true; // To exit
                    break;
                case 4:
                    isDone = true;
                    break;
            } // switch
            goBack = false; // Reset goBack to false
        } // while(main)

        ink.printGoodday();
    } // main()

    // Meet the pets!
    public static void createPets() {
        pet = new Pet("Roger", "Dog",
                3, "Black", "Hound");
        shelter.addPet(pet);
        pet = new Pet("Mochi", "Dog",
                7, "Tan", "Pug");
        shelter.addPet(pet);
        pet = new Pet("Tiger", "Cat",
                1, "Black/Orange/White", "Calico");
        shelter.addPet(pet);
    } // createPets()

    public static void createUser(Scanner input) {
        String name, email;

        System.out.print(Ink.ANSI_YELLOW + "What is your name? " + Ink.ANSI_RESET);
        name = input.nextLine();
        System.out.print(Ink.ANSI_YELLOW + "What is your email? " + Ink.ANSI_RESET);
        email = input.nextLine();

        boolean validPhone = false;
        while (!validPhone) {
            System.out.print(Ink.ANSI_YELLOW + "What is your phone? " + Ink.ANSI_RESET);
            try {
                longPhone = Long.parseLong(input.nextLine());
                if (String.valueOf(longPhone).length() >= 10) {
                    validPhone = true;
                } else {
                    System.out.println(Ink.ANSI_RED + 
                    "This is not a 10 digit phone number.\nWould you like to proceed without a number? (Y/N)" 
                    + Ink.ANSI_RESET);
                    String choice = input.nextLine();
                    if (choice.equalsIgnoreCase("Y")) {
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println(Ink.ANSI_RED + 
                "Invalid input. Please enter a valid phone number." 
                + Ink.ANSI_RESET);
            }
        }

        user = new User(name, email, longPhone);
    } // createUser()

} // class