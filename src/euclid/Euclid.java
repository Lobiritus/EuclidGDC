/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package euclid;

import javax.swing.JOptionPane;
import java.util.*;

/**
 *
 * @author Lobiritus
 */
public class Euclid {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        String numeric = JOptionPane.showInputDialog(null, "Введите 1 для нахождение НОД (А,B), \n Введите 2 для нахождения обратного элемента для e по составному модулю ф(n) \n Введите 3 для нахождения x и y из уравнения Ax+By=d");
        int point = Integer.parseInt(numeric);
        if (point == 1){
             String number1 = JOptionPane.showInputDialog(null,"Введите число A: ");
             String number2 = JOptionPane.showInputDialog(null,"Введите число B: ");
             int A = Integer.parseInt(number1);
             int B = Integer.parseInt(number2);
             JOptionPane.showMessageDialog(null,"НОД числа " + A + " и " + B + " Равен: " + gcd(A,B));
        }
        else if (point == 2){
             String number1 = JOptionPane.showInputDialog(null,"Введите модуль Ф: ");
             String number2 = JOptionPane.showInputDialog(null,"Введите число E: ");
             int B = Integer.parseInt(number1);
             int C = Integer.parseInt(number2);
             JOptionPane.showMessageDialog(null, "Обратный элемент числа: " + C + " Модуль Ф: " + B  + " Равен = " +  gcdxy(B,C));
        }
        else if (point == 3){
                 
            int a = Integer.parseInt(JOptionPane.showInputDialog(null,"Введите число A: ")), b = Integer.parseInt(JOptionPane.showInputDialog(null,"Введите число B: "));    
            int res[] = gcdextended(a,b);
            JOptionPane.showMessageDialog(null," X равняется = " + res[1] + "\n Y равняется = " + res[2] + "\n D равняется = " + res[0] + "\n В результате получаем: " + a + "*" + res[1] + "+" + b + "*" + res[2] + "=" + res[0]);
           
        }
    }
      public static int gcd(int m, int n) // Рекурсивный метод нахождения НОД
    {
        if(m % n == 0)
            return(n);
        else
            return(gcd(n,m % n));
    }
      public static int gcdxy(int b, int c) // Обратный элемент для e  по состаному модулю ф.
      {         
        int i,j,x,y,m;
        m=b;
        i=0;
        j=1;
        while (c !=0){
            x=b/c;
            y=b%c;
            b=c;
            c=y;
            y=j;
            j=i-j*x;
            i=y;
        }
        if(i<0){
            i=i+m;
        }
        return i;
      }
      
      public static int[] gcdextended (int a, int b) // Находим X и Y из уравнения Ax+By=d(GDC)
      {
          int res[] = new int [3]; // d,x,y
          if (b==0)
          {
              res[0]= a; res[1] =1 ; res [2] = 0 ;
              return res;
          }
          res = gcdextended(b,a%b);
          int s = res[2];
          res[2] = res[1]-(a/b)*res[2];
          res[1] = s;
          return res;
      }
}
