package org.example;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TicTacToe {
    public static void main(String[] args) {
        int size;
        int choice;
        int x;
        int y;
        int cnt=0;
        boolean ch;
        String[]sym={"x","o"};
        Logger l=Logger.getLogger("com.api.jar");
        l.log(Level.INFO,()->"Enter the size of matrix");
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        Game p1 = new Game(size);
        String str1="Enter the position-Player 1 (1 to "+size*size+")";
        String str2="Enter the position-Player 2 (1 to "+size*size+")";
        String drw="The match is DRAW";
        int []inp=new int[2];
        l.log(Level.INFO,()->"Initially the Matrix is");
        p1.display();
        while(true)
        {
            l.log(Level.INFO,()->str1);
            choice=sc.nextInt();
            x = (choice-1)/size;
            y = (choice-1)%size;
            p1.check(choice,inp,str1);
            ch=p1.set(inp[0],inp[1],sym[0]);

            p1.check1(ch,inp,sym[0],str1);
            l.log(Level.INFO,()->"Matrix is");
            p1.display();
            cnt++;
            if(p1.checkHori(x,sym[0]) || p1.checkVerti(y,sym[0]) || p1.checkDiagonal(sym[0]) || p1.checkDiagonal1(sym[0]))
            {
                l.log(Level.INFO,()->"Player 1 is winner");
                System.exit(0);
            }
            if(cnt==size*size)
            {
                l.log(Level.INFO,()->drw);
                System.exit(0);

            }
            l.log(Level.INFO,()->str2);
            choice=sc.nextInt();
            x = (choice-1)/size;
            y = (choice-1)%size;
            p1.check(choice,inp,str2);
            ch=p1.set(inp[0],inp[1],sym[1]);
            p1.check1(ch,inp,sym[1],str2);

            l.log(Level.INFO,()->"Matrix is");
            p1.display();
            cnt++;
            if(p1.checkHori(x,sym[1]) || p1.checkVerti(y,sym[1])|| p1.checkDiagonal(sym[1]) || p1.checkDiagonal1(sym[1])) {
                l.log(Level.INFO,()->drw);
                System.exit(0);

            }
            if(cnt==size*size)
            {
                l.log(Level.INFO,()->"The match is DRAW");
                System.exit(0);


            }
        }

    }
}

