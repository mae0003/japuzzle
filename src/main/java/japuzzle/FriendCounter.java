package japuzzle;

import java.util.Scanner;

public class FriendCounter {

    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        String line;
        for(;scanner.hasNext();){
            line=scanner.nextLine();
            System.out.println(line.toUpperCase());
        }
    }
}
