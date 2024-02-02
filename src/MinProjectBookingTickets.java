import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class MinProjectBookingTickets {
    public static void sms() {
        System.out.println("# INSTRUCTOR");
        System.out.println("# Single: C-1");
        System.out.println("# Multiple (Separate by Come):C-1,C-2");
    }

    public static void showTime() {
        System.out.println("**********************************************");
        System.out.println("******* Daily Show time of Angkor Movies *****");
        System.out.println("# A) Morning (10:00 AM TO 12:30PM)");
        System.out.println("# B) Afternoon (1:00 AM TO 5:30PM)");
        System.out.println("# C) Night (6:00 AM TO 10:30PM)");
        System.out.println("*******************************************************");

    }


    private static boolean isValidFormat(String userInput) {
        return userInput.matches("[A-Za-z]-\\d+");
    }

    private static void showTheHall(String[][] hall, String hallName, char[] letter) {
        System.out.println("# Hall " + hallName);
        for (int i = 0; i < hall.length; i++) {
            for (int j = 0; j < hall[i].length; j++) {
                String formatSeatString = String.format("|%s-%d::%s| ", letter[i], (j + 1), hall[i][j] == null ? "AV" : "BO");
                System.out.print(formatSeatString);
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void rebootHall(String[][] hall) {
        for (int i = 0; i < hall.length; i++) {
            for (int j = 0; j < hall[i].length; j++) {
                if (hall[i][j] != null) {
                    hall[i][j] = null;
                }
            }
        }
    }

    private static  void storeValuesWhenInput(String[][] hall){

        // customerChooseChair is A-1

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Date and Time: " + formattedDateTime);

        System.out.println("# NO 1 ");
        System.out.println("#Chair: ");
        System.out.println("#Hall : ");
        System.out.println("#STU.ID: ");

        System.out.println("#CREATED AT: "+formattedDateTime);

    }
    // new showHistory
    private static void showHistory(String[][] hall, String[][] hallTwo, String[][] hallThree) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> History <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<:");
        int customerId=0;
        displayHallHistory("Morning Hall", hall, customerId);
        displayHallHistory("Afternoon Hall", hallTwo, customerId);
        displayHallHistory("Night Hall ", hallThree, customerId);
    }

    private static void displayHallHistory(String hallName, String[][] hall, int customerId) {
        System.out.println("# Hall " + hallName);
        System.out.println("-------------------------------------------------------------");

        for (int i = 0; i < hall.length; i++) {
            for (int j = 0; j < hall[i].length; j++) {
                if ("BO".equals(hall[i][j])) {
                    int seatNumber = i * hall[i].length + j + 1;
                    System.out.println("# NO " + seatNumber);
                    System.out.println("# Hall: " + hallName);
                    System.out.println("# Chair: " + (char) ('A' + i) + "-" + (j + 1));
                    System.out.println("# STU.ID: " + customerId);
                    System.out.println("# CREATED AT: " + getFormattedDateTime());
                    System.out.println("-------------------------------------------------------------");
                }
            }
        }
    }

    private static String getFormattedDateTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return currentDateTime.format(formatter);
    }

    public static void main(String[] args) {
        //testing
        String regEx = "^-?\\d+$";
        // letter form A-Z
        char[] letter = new char[26];
        int index = 0;
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            letter[index] = ch;
            index++;
        }
//        System.out.println("Show "+letter[0]);
        Scanner input = new Scanner(System.in);
        // limit the hall row and column
        int option;
        int rowHall, chairHall;
        String[][] hall;
        String notNull = "";
        int customerId = 0;
        int customerChooseHall, customerChairId;
        String customerChooseChair;


        System.out.println("******************************************************");
        System.out.println("=========== Booking Movies Ticket Project ============");
        System.out.println("******************************************************");
        System.out.println("config the Total of row in Hall: ");
        rowHall = input.nextInt();
        System.out.println("Config the Total Chair per row: ");
        chairHall = input.nextInt();
        System.out.println("The Config is successfully!");
        System.out.println(" " + rowHall + " Row And Have " + chairHall + " Chair for a Row");
        int totalChair = rowHall * chairHall;
        System.out.println("And One Hall Have : " + totalChair + " Chairs");
        //
        hall = new String[rowHall][chairHall];
        String[][] hallTwo = new String[rowHall][chairHall];
        String[][] hallThree = new String[rowHall][chairHall];
        // get values from user input


        do {
            System.out.println("==============[[Application Menu]===================");
            System.out.println("1.Booking");
            System.out.println("2.Hall");
            System.out.println("3.Show Time");
            System.out.println("4.Reboot the Showtime");
            System.out.println("5.History");
            System.out.println("6.Exit");
            System.out.println("====== Please Enter your Option( 1-6):");
            option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.println(">>>>>>> You Choose Option 1.Booking Ticket:     ");
                    showTime();
                    System.out.println("************ Please select Available Chair( A : B :C ): ");
                    char showTimeOption = input.next().charAt(0);
                    System.out.println("*******************************************************");
                    sms();
                    // hall option :
                    // A
                    switch (Character.toUpperCase(showTimeOption)) {
                        case 'A':
                            showTheHall(hall, "A", letter);
                            System.out.println();
                            if (hall[rowHall - 1][chairHall - 1] == null) {
                                System.out.println("Please Enter Chair you Want(A-1): ");
                                input.nextLine();
                                customerChooseChair = input.nextLine();
                                if (isValidFormat(customerChooseChair)) {
                                    String[] parts = customerChooseChair.split("-");
                                } else {
                                    System.out.println("Please Input your Chair again(A-1): ");
                                    input.nextLine();
                                    customerChooseChair = input.nextLine();
                                }
                                String inputChair = customerChooseChair;
                                int[] indices = Main.convertInputToIndices(inputChair);
                                // change a b c to index [0, 0 ]
                                if (indices != null && indices.length == 2) {
                                    int row = indices[0];
                                    int col = indices[1];
                                    if (hall[row][col] == null) {
                                        // hall is the morning hall
                                        hall[row][col] = "BO";
                                    } else {
                                        System.out.println("Cannot buy this cause it not avariable!");
                                    }
                                }
                                System.out.println("Enter your your ID: ");
                                customerId = input.nextInt();
                                System.out.println("Booking Successfully!");

                            } else {
                                System.out.println("Sorry! This Chair Have been Booked!!!");
                            }
                            break;
                        case 'B':
                            showTheHall(hallTwo, "B",letter);
                            System.out.println();
                            if (hallTwo[rowHall - 1][chairHall - 1] == null) {
                                System.out.println("Please Enter Chair you Want(A-1): ");
                                input.nextLine();
                                customerChooseChair = input.nextLine();
                                if (isValidFormat(customerChooseChair)) {
                                    String[] parts = customerChooseChair.split("-");
                                } else {
                                    System.out.println("Please Input your Chair again(A-1): ");
                                    input.nextLine();
                                    customerChooseChair = input.nextLine();
                                }
                                String inputChair = customerChooseChair;
                                int[] indices = Main.convertInputToIndices(inputChair);
                                // [0, 0 ]
                                if (indices != null && indices.length == 2) {
                                    int row = indices[0];
                                    int col = indices[1];
                                    if (hallTwo[row][col] == null) {
                                        // hall is the morning hall
                                        hallTwo[row][col] = "BO";
                                    } else {
                                        System.out.println("Cannot buy this cause it not avaiable!");
                                    }
                                }
                                System.out.println("Enter your your ID: ");
                                customerId = input.nextInt();
                                System.out.println("Booking Successfully!");

                            } else {
                                System.out.println("Sorry! This Chair Have been Booked!!!");
                            }
                            break;
                        case 'C':
                            showTheHall(hallThree, "C", letter);
                            System.out.println();
                            if (hallThree[rowHall - 1][chairHall - 1] == null) {
                                System.out.println("Please Enter Chair you Want(A-1): ");
                                input.nextLine();
                                customerChooseChair = input.nextLine();
                                if (isValidFormat(customerChooseChair)) {
                                    String[] parts = customerChooseChair.split("-");
                                } else {
                                    System.out.println("Please Input your Chair again(A-1): ");
                                    input.nextLine();
                                    customerChooseChair = input.nextLine();
                                    // new line code testing
                                    System.out.println("Enter your your ID: ");
                                    customerId = input.nextInt();
                                    System.out.println("Booking Successfully !!");
                                }
                                String inputChair = customerChooseChair;
                                int[] indices = Main.convertInputToIndices(inputChair);
                                // [0, 0 ]
                                if (indices != null && indices.length == 2) {
                                    int row = indices[0];
                                    int col = indices[1];
                                    if (hallThree[row][col] == null) {
                                        // hall is the morning hall
                                        hallThree[row][col] = "BO";
                                    } else {
                                        System.out.println("Cannot buy this cause it not avariable!");
                                    }
                                }else {
//                                    System.out.println("Enter your your ID: ");
//                                    customerId = input.nextInt();
//                                    System.out.println("Booking Successfully!");
                                }


                            } else {
                                System.out.println("Sorry! This Chair Have been Booked!!!");
                            }
                            break;
                        default:
                            System.out.println("Please Enter :(A | B | C)!:");
                    }
                    break;
                case 2:
                    showTheHall(hall, "A", letter);
                    System.out.println();
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    showTheHall(hallTwo, "B", letter);
                    System.out.println();
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    showTheHall(hallThree, "C", letter);
                    System.out.println();
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    break;
                case 3:
                    System.out.println(">>>>>>>>>>>> You Choose Option 3.Show Time:   ");
                    showTime();
                    break;
                case 4:
                    System.out.println(">>>>>>> You Choose Option 4.Reboot The Showtime: ");
                    rebootHall(hall);
                    rebootHall(hallTwo);
                    rebootHall(hallThree);
                    System.out.println(">>>>>>> Reboot Successfully!!!!");
                    break;
                case 5:
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> History <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<:");
                    showHistory(hall, hallTwo, hallThree);
//                    storeValuesWhenInput(hall);
                    break;
                case 6:
                    System.out.println("Exit The Program!!!");
                    break;
                default:
                    System.out.println("====== Please Enter your Option again( 1-6)!:");
            }
        } while (option != 6);

    }

//    private static String getInputChair(String inputChair) {
//        return inputChair;
}


