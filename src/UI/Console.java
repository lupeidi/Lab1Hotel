package UI;

import Domain.AverageRoomRating;
import Domain.Room;
import Service.RoomService;

import java.util.Scanner;

public class Console {
    private RoomService service;
    private Scanner scanner;

    public Console(RoomService service) {
        this.service = service;
        scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Check-in oaspeti");
        System.out.println("2. Check-out oaspeti");
        System.out.println("3. Raport rating camera");
        System.out.println("a. Afisare toate camerele");
        System.out.println("x. Iesire");
    }

    public void run() {

        while (true) {
            showMenu();
            String option = scanner.nextLine();
            if (option.equals("1")) {
                handleServiceEntry();
            } else if (option.equals("2")) {
                handleServiceExit();
            } else if (option.equals("3")) {
                handleRatingsReport();
            } else if (option.equals("a")) {
                handleShowAll();
            } else if (option.equals("x")) {
                break;
            }
        }
    }

    private void handleRatingsReport() {
        for (AverageRoomRating standAverage : service.getAverageRoomRating())
            System.out.println(standAverage);
    }

    private void handleServiceExit() {

        try {
            System.out.println("Ce camera?");
            int stand = Integer.parseInt(scanner.nextLine());
            System.out.println("Feedbackul oaspetilor");
            String feedback = scanner.nextLine();
            System.out.println("Ratingul oaspetilor");
            int rating = Integer.parseInt(scanner.nextLine());

            service.exitService(stand, feedback, rating);
        }

        catch (RuntimeException runtimeException) {
            System.out.println("Avem erori: " + runtimeException.getMessage());
        }
    }

    private void handleShowAll() {
        for (Room r : service.getAll())
            System.out.println(r);
    }

    private void handleServiceEntry() {

        try {
            System.out.println("Dati id-ul camerei:");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati numarul camerei:");
            int roomNumber = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati numarul oaspeti:");
            int guestNumber = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati numarul de zile:");
            int stayNumber = Integer.parseInt(scanner.nextLine());

            service.enterService(id, guestNumber, roomNumber, stayNumber);
        } catch (RuntimeException runtimeException) {
            System.out.println("Avem erori: " + runtimeException.getMessage());
        }
    }
}
