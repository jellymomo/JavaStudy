package Moviepack;

import java.util.Scanner;

class Movie {
    private String title;
    private int availableSeats;
    private double ticketPrice;
    private char[][] seats;
    private String[] showTimes;
    private String selectedSeats;
    private double totalPrice;

    public Movie(String title, int numRows, int numCols, double ticketPrice, String[] showTimes) {
        this.title = title;
        this.availableSeats = numRows * numCols;
        this.ticketPrice = ticketPrice;
        this.showTimes = showTimes;

        seats = new char[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                seats[i][j] = 'O';
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public char[][] getSeats() {
        return seats;
    }

    public String[] getShowTimes() {
        return showTimes;
    }

    public void decreaseAvailableSeats(int numSeats) {
        availableSeats -= numSeats;
    }

    public String toAlphabet(int num) {
        return Character.toString((char) ('A' + num));
    }

    public void displaySeatsWithAlphabet() {
        System.out.println("=== " + title + " 좌석표 ===");
        char[][] seats = getSeats();

        System.out.print("  ");
        for (int j = 0; j < seats[0].length; j++) {
            System.out.print(j + 1 + " ");
        }
        System.out.println();

        char rowLabel = 'a';
        for (int i = 0; i < seats.length; i++) {
            System.out.print(rowLabel + " ");
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
            rowLabel++;
        }
        System.out.println("=================");
    }

    public boolean bookSeats(int numSeats, String selectedTime) {
        if (numSeats <= 0 || numSeats > availableSeats) {
            System.out.println("잘못된 인원 수를 입력하셨습니다. 다시 시도해주세요.");
            return false;
        }

        if (selectedTime.equals("8:00") || selectedTime.equals("23:30")) {
            ticketPrice -= 5000;
        }

        double totalPrice = numSeats * ticketPrice;
        this.totalPrice = totalPrice;

        for (int i = 0; i < numSeats; i++) {
            System.out.println((i + 1) + "번째 인원의 좌석을 선택하세요.");

            int row, col;
            do {
                System.out.print("예매할 행 번호를 입력하세요: ");
                String rowInput = scanner.next();
                row = rowToNumber(rowInput);

                System.out.print("예매할 열 번호를 입력하세요: ");
                col = scanner.nextInt();

                if (row < 1 || row > seats.length || col < 1 || col > seats[0].length) {
                    System.out.println("잘못된 좌석 번호를 입력하셨습니다. 다시 시도해주세요.");
                } else if (seats[row - 1][col - 1] == 'X') {
                    System.out.println("이미 예매된 좌석입니다. 다른 좌석을 선택해주세요.");
                } else {
                    break;
                }
            } while (true);

            seats[row - 1][col - 1] = 'X';
            decreaseAvailableSeats(1);

            if (i == 0) {
                selectedSeats = toAlphabet(row - 1) + col;
            } else {
                selectedSeats += ", " + toAlphabet(row - 1) + col;
            }
        }

        System.out.println("예매가 완료되었습니다.");
        System.out.println("선택한 좌석: " + selectedSeats);
        System.out.println("상영 시간: " + selectedTime);
        System.out.println("총 가격: " + totalPrice + "원");
        displaySeatsWithAlphabet();

        // Payment Method Selection
        System.out.println("결제 방법을 선택하세요:");
        System.out.println("1. 현금");
        System.out.println("2. 카드");
        System.out.println("3. 카카오페이");

        int paymentMethod;
        do {
            System.out.print("결제 방법 번호를 입력하세요: ");
            paymentMethod = scanner.nextInt();
            if (paymentMethod < 1 || paymentMethod > 3) {
                System.out.println("잘못된 결제 방법 번호를 입력하셨습니다. 다시 시도해주세요.");
            } else {
                break;
            }
        } while (true);

        String paymentType;
        switch (paymentMethod) {
            case 1:
                paymentType = "현금";
                break;
            case 2:
                paymentType = "카드";
                break;
            case 3:
                paymentType = "카카오페이";
                break;
            default:
                paymentType = "결제 방법을 선택하지 않았습니다.";
                break;
        }

        System.out.println("결제가 완료되었습니다.");
        System.out.println("영화 제목: " + title);
        System.out.println("선택한 좌석: " + selectedSeats);
        System.out.println("상영 시간: " + selectedTime);
        System.out.println("총 가격: " + totalPrice + "원");
        System.out.println("결제 방법: " + paymentType);

        resetTotalPrice(); // Reset the total price to 0.0 for the next movie booking
        return true;
    }

    private static Scanner scanner = new Scanner(System.in);

    private int rowToNumber(String rowInput) {
        rowInput = rowInput.toLowerCase();
        char c = rowInput.charAt(0);
        return c - 'a' + 1;
    }

    public void resetTotalPrice() {
        this.totalPrice = 0.0;
    }

    public static void closeScanner() {
        scanner.close();
    }
}

class MovieBookingSystem {
    private Movie[] movies;
    private int numOfMovies;
    private Scanner scanner;

    public MovieBookingSystem() {
        scanner = new Scanner(System.in);
        movies = new Movie[5];
        numOfMovies = 0;
    }

    public void addMovie(Movie movie) {
        if (numOfMovies < movies.length) {
            movies[numOfMovies] = movie;
            numOfMovies++;
        } else {
            System.out.println("더 이상 영화를 추가할 수 없습니다.");
        }
    }

    public void displayMovies() {
        System.out.println("====== 영화 목록 =======");
        for (int i = 0; i < numOfMovies; i++) {
            System.out.println(i + 1 + ". " + movies[i].getTitle());
        }
    }

    public void displaySeats(Movie movie) {
        movie.displaySeatsWithAlphabet();
    }

    public void startBookingSystem() {
        while (true) {
            System.out.println("\n==== 영화 예매 시스템 ====");
            displayMovies();
            System.out.print("예매할 영화 번호를 입력하세요 (종료: 0): ");
            int movieIndex = scanner.nextInt();
            scanner.nextLine();

            if (movieIndex == 0) {
                System.out.println("예매 시스템을 종료합니다.");
                break;
            }

            if (movieIndex >= 1 && movieIndex <= numOfMovies) {
                Movie selectedMovie = movies[movieIndex - 1];

                System.out.println("상영 시간 목록: ");
                String[] showTimes = selectedMovie.getShowTimes();
                for (int i = 0; i < showTimes.length; i++) {
                    System.out.println((i + 1) + ". " + showTimes[i]);
                }

                int timeIndex;
                do {
                    System.out.print("상영 시간 번호를 입력하세요: ");
                    timeIndex = scanner.nextInt();
                    if (timeIndex < 1 || timeIndex > showTimes.length) {
                        System.out.println("잘못된 시간 번호를 입력하셨습니다. 다시 시도해주세요.");
                    } else {
                        break;
                    }
                } while (true);
                String selectedTime = showTimes[timeIndex - 1];

                char[][] seats = selectedMovie.getSeats();
                displaySeats(selectedMovie);

                System.out.print("예매할 인원 수를 입력하세요: ");
                int numSeats = scanner.nextInt();

                boolean success = selectedMovie.bookSeats(numSeats, selectedTime);

                if (!success) {
                    System.out.println("예매를 취소합니다.");
                }
            } else {
                System.out.println("잘못된 영화 번호를 입력하셨습니다.");
            }
        }
    }
}

public class MovieBookingApp {
    public static void main(String[] args) {
        MovieBookingSystem bookingSystem = new MovieBookingSystem();

        // 예제를 위해 몇 개의 영화를 추가합니다. (동일한 상영 시간을 적용합니다.)
        String[] showTimes = {"8:00", "14:30", "23:30"};
        bookingSystem.addMovie(new Movie("스파이더맨: 노 웨이 홈", 5, 7, 15000, showTimes));
        bookingSystem.addMovie(new Movie("어벤져스: 엔드게임", 6, 8, 18000, showTimes));
        bookingSystem.addMovie(new Movie("인셉션", 4, 6, 12000, showTimes));

        bookingSystem.startBookingSystem(); // 영화 예매

        Movie.closeScanner();
    }
}


