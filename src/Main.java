import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Medlems medlems = new Medlems();
        Scanner sc = new Scanner(System.in);
        System.out.println("Skriv in kundens för-och efter namn eller personnummer: ");
        String input = sc.nextLine();
        int check = medlems.isMedlem(input);
        switch (check) {
            case 0 -> System.out.println("Är medlem och avgfiten är betald");
            case 1 -> System.out.println("is medlem but did not pay the fee");
            default -> System.out.println("Is not medlem");
        }

    }

}
