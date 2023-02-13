package org.example;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
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

            p1.check1(ch,choice,inp,sym[0],str1);
            l.log(Level.INFO,()->"Matrix is");
            p1.display();
            cnt++;
            if(p1.checkHori(x,sym[0]) || p1.checkVerti(y,sym[0]) || p1.checkDiagonal(sym[0]) || p1.checkDiagonal1(sym[0]))
            {
                l.log(Level.INFO,()->"Player 1 is winner");
                break;
            }
            if(cnt==size*size)
            {
                l.log(Level.INFO,()->drw);
                break;

            }
            l.log(Level.INFO,()->str2);
            choice=sc.nextInt();
            x = (choice-1)/size;
            y = (choice-1)%size;
            p1.check(choice,inp,str2);
            ch=p1.set(inp[0],inp[1],sym[1]);
            p1.check1(ch,choice,inp,sym[1],str2);

            l.log(Level.INFO,()->"Matrix is");
            p1.display();
            cnt++;
            if(p1.checkHori(x,sym[1]) || p1.checkVerti(y,sym[1])|| p1.checkDiagonal(sym[1]) || p1.checkDiagonal1(sym[1])) {
                l.log(Level.INFO,()->drw);
            break;
            }
            if(cnt==size*size)
            {
                l.log(Level.INFO,()->"The match is DRAW");
                break;

            }
        }

    }
}
    class Game
    {
        Logger l=Logger.getLogger("com.api.jar");
        int size;
        String [][]mat;

        Game(int n)
        {
            size=n;
            mat=new String[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++) {
                    mat[i][j] = "-";
                }
            }
        }
        void check(int choi,int[] inp,String str)
        {
            Scanner sc=new Scanner(System.in);
            while(choi<1 || choi>size*size)
            {
                l.log(Level.INFO,()->"Invalid position");
                l.log(Level.INFO,()->str);
                choi=sc.nextInt();
                inp[0] = (choi-1)/size;
                inp[1] = (choi-1)%size;
            }
        }
        void check1(boolean ch,int cho,int[] inp,String a,String str)
        {
            Scanner sc=new Scanner(System.in);
            while(!ch)
            {
                l.log(Level.INFO,()->str);
                cho=sc.nextInt();
                inp[0]= (cho-1)/size;
                inp[1] = (cho-1)%size;
                ch=set(inp[0],inp[1],a);
            }
        }
        boolean set(int a,int b,String c)
        {
            if(mat[a][b].equals("-"))
            {
                mat[a][b]=c;
                return true;
            }
            else if(!mat[a][b].equals(c)){
                l.log(Level.INFO,()->"The other player already entered his coin there");
                l.log(Level.INFO,()->"Enter a valid position");
                return false;
            }
            else {
                l.log(Level.INFO,()->"You already entered your coin there");
                return false;
            }
        }
        boolean checkHori(int x,String a)
        {

            for(int i=0;i<size;i++)
            {
                if(!mat[x][i].equals(a))
                {
                    return false;

                }
            }
            return true;
        }
        boolean checkVerti(int y,String a)
        {
            for(int i=0;i<size;i++)
            {
                if(!mat[i][y].equals(a))
                {
                    return false;
                }

            }
            return true;
        }
        boolean checkDiagonal(String a)
        {

            for(int i=0;i<size;i++)
            {
                if(!mat[i][i].equals(a))
                {
                    return false;
                }

            }
            return true;
        }
        boolean checkDiagonal1(String a)
        {

            for(int i=0;i<size;i++)
            {
                if(!mat[i][size-i-1].equals(a))
                {
                    return false;
                }

            }
            return true;
        }
        void display()
        {
            for(int i=0;i<size;i++)
            {
                for(int j=0;j<size;j++) {
                    l.info(mat[i][j]);
                }
            }
        }
    }
