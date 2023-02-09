package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int size;
        int choice;
        int x;
        int y;
        int cnt=0;
        boolean ch;
        String[]sym={"x","o"};

        System.out.println("Enter the size of matrix");
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        game p1 = new game(size);
        game p2=p1;
        System.out.println("Initially the Matrix is");
        p1.display();
        while(true)
        {
            System.out.println("Enter the position-Player 1 (1 to "+size*size+")");
            choice=sc.nextInt();
            x = (choice-1)/size;
            y = (choice-1)%size;
            while(choice<1 || choice>size*size)
            {
                System.out.println("Invalid position");
                System.out.println("Enter the position-Player 1 (1 to "+size*size+")");
                choice=sc.nextInt();
                x = (choice-1)/size;
                y = (choice-1)%size;
            }
            ch=p1.set(x,y,sym[0]);
            while(!ch)
            {
                System.out.println("Enter the position-Player 1 (1 to "+size*size+")");
                choice=sc.nextInt();
                x = (choice-1)/size;
                y = (choice-1)%size;
                ch=p1.set(x,y,sym[0]);
            }
            System.out.println("Matrix is");
            p1.display();
            cnt++;
            if(p1.checkHori(x,sym[0]) || p1.checkVerti(y,sym[0]) || p1.checkDiagonal(sym[0]) || p1.checkDiagonal1(sym[0]))
            {
                System.out.println("Player 1 is winner");
                break;
            }
            if(cnt==size*size)
            {
                System.out.println("The match is DRAW");
                break;

            }
            System.out.println("Enter the position-Player 2 (1 to "+size*size+")");
            choice=sc.nextInt();
            x = (choice-1)/size;
            y = (choice-1)%size;
            while(choice<1 || choice>size*size)
            {
                System.out.println("Invalid position");
                System.out.println("Enter the position-Player 2 (1 to "+size*size+")");
                choice=sc.nextInt();
                x = (choice-1)/size;
                y = (choice-1)%size;

            }
            ch=p2.set(x,y,sym[1]);
            while(!ch)
            {
                System.out.println("Enter the position-Player 2 (1 to "+size*size+")");
                choice=sc.nextInt();
                x = (choice-1)/size;
                y = (choice-1)%size;
                ch=p2.set(x,y,sym[1]);
            }
            System.out.println("Matrix is");
            p2.display();
            cnt++;
            if(p2.checkHori(x,sym[1]) || p2.checkVerti(y,sym[1])|| p2.checkDiagonal(sym[1]) || p2.checkDiagonal1(sym[1])) {
                System.out.println("Player 2 is winner");
            break;
            }
            if(cnt==size*size)
            {
                System.out.println("The match is DRAW");
                break;

            }
        }

    }
}
    class game
    {
        int size;
        String [][]mat;
        game(game g)
        {
            this.size=g.size;
            this.mat=g.mat;
        }
        game(int n)
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
        boolean set(int a,int b,String c)
        {
            if(mat[a][b].equals("-"))
            {
                mat[a][b]=c;
                return true;
            }
            else if(!mat[a][b].equals(c)){
                System.out.println("The other player already entered his coin there");
                System.out.println("Enter a valid position");
                return false;
            }
            else {
                System.out.println("You already entered your coin there");
                return false;
            }
        }
        boolean checkHori(int x,String a)
        {
            //int cnt=0;
            for(int i=0;i<size;i++)
            {
                if(mat[x][i].equals(a))
                {
                    //cnt++;
                }
                else
                {
                    return false;
                }
            }
            return true;
        }
        boolean checkVerti(int x,String a)
        {
            //int cnt=0;
            for(int i=0;i<size;i++)
            {
                if(mat[i][x].equals(a))
                {
                    //cnt++;
                }
                else
                {
                    return false;
                }
            }
            return true;
        }
        boolean checkDiagonal(String a)
        {
            int cnt=0;
            for(int i=0;i<size;i++)
            {
                if(mat[i][i].equals(a))
                {
                    cnt++;
                }
                else
                {
                    return false;
                }
            }
            return true;
        }
        boolean checkDiagonal1(String a)
        {
            int cnt=0;
            for(int i=0;i<size;i++)
            {
                if(mat[i][size-i-1].equals(a))
                {
                    cnt++;
                }
                else
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
                for(int j=0;j<size;j++)
                {
                    System.out.print(mat[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
