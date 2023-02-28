package org.example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    void check1(boolean ch,int[] inp,String a,String str)
    { int cho;
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
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }
}
