package gpa_calculator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author a
 */
import java.util.Scanner;
import java.util.Map;

import java.util.*;
public class GPA_Calculator {

    /**
     * @param args the command line arguments
     */
    static class Student
    {
        String course;
        int hours;
        String grade;
    }
    public static void CalcGPA(HashMap<String, Student> Data)
    {
        double sum=0;
        double res=0;
        double sub=0;
        String Temp;
        int H=0;        
        for (String key: Data.keySet())
        {
            Temp=Data.get(key).grade;
            
            if("A+".equals(Temp) || "a+".equals(Temp))
            {
                sub=(double)Data.get(key).hours*4;
              
            }
            else if("A".equals(Temp) || "a".equals(Temp))
            {
                sub=(double)Data.get(key).hours*3.7;
                
            }
            else if("B+".equals(Data.get(key).grade) || "b+".equals(Data.get(key).grade))
            {
                sub=(double)Data.get(key).hours*3.3;
            }
            else if("B".equals(Data.get(key).grade) || "b".equals(Data.get(key).grade))
            {
                sub=(double)Data.get(key).hours*3;
            }
            else if("C+".equals(Data.get(key).grade) || "c+".equals(Data.get(key).grade))
            {
                sub=(double)Data.get(key).hours*2.7;
            }
            else if("C".equals(Data.get(key).grade) || "c".equals(Data.get(key).grade))
            {
                sub=(double)Data.get(key).hours*2.4;
            }
            else if("D+".equals(Data.get(key).grade) || "d+".equals(Data.get(key).grade))
            {
                sub=(double)Data.get(key).hours*2.2;
            }
            else if("D".equals(Data.get(key).grade) || "d".equals(Data.get(key).grade))
            {
                sub=(double)Data.get(key).hours*2;
            }
            else if("F".equals(Data.get(key).grade) || "f".equals(Data.get(key).grade))
            {
                sub=(double)Data.get(key).hours*0;
            }
            sum+=sub;
            H+=Data.get(key).hours;
         
       
        }
        res=sum/H;
        System.out.println("GPA = "+res);
        
    }
    public static void search( HashMap<String, Student> Data)
    {
        String c;
        System.out.println("Enter Code of Course");
        Scanner sc=new Scanner(System.in);
        c=sc.next();
        if(Data.containsKey(c))
        {
            System.out.println(Data.get(c).course+"  "+Data.get(c).hours+"  "+Data.get(c).grade);
        }
        else
        {
            System.out.println("Course Not Found");
        }
        
        
    }
    public static void print( HashMap<String, Student> Data)
    {
         
        System.out.print(String.format("%-15s","Code"));
        System.out.print(String.format("%-15s","Course Name"));
        System.out.print(String.format("%-15s","Hours"));
        System.out.print(String.format("%-15s","Grade"));
        System.out.println();
        
                   
        for (String key: Data.keySet())
        {
            System.out.print(String.format("%-15s",key));
            System.out.print(String.format("%-15s",Data.get(key).course));
            System.out.print(String.format("%-15s",Data.get(key).hours));
            System.out.print(String.format("%-15s",Data.get(key).grade));
            System.out.println();
           
        }
    }
    public static void main(String[] args) 
    {
        HashMap<String, Student> Data = new HashMap<String, Student>();
        String input;
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            String Code;
            String Course;
            int Houres;
            String Grade;
            
            Student S1=new Student();
            System.out.println("Enter Code OF Course");
            Code=sc.next();
            System.out.println("Enter Course Name");
            Course=sc.next();
             System.out.println("Enter Course hours");
            Houres=sc.nextInt();
             System.out.println("Enter Grade");
            Grade=sc.next();
            
            S1.course=Course;
            S1.grade=Grade;
            S1.hours=Houres;
            
            Data.put(Code, S1);
            
             System.out.println("Do You need to add more Courses?");
             input=sc.next();
             
             if("NO".equals(input) || "no".equals(input))
             {
                 
                 break;
             }
             
        
     
        }
        int num;
        while(true)
        {    
            System.out.println("IF You Need To Calc GPA Press 1 ,TO Print Student Cources Press 2,To Search Press 3,To Exit Press 4");
            num=sc.nextInt();
            if(num==1)
            {
                 CalcGPA(Data);
            }
            else if(num==2)
            {
                print(Data);
            }
            else if(num==3)
            {
                search(Data);
            }
            else if(num==4)
            {
                break;
            }    
        }    
       
        
        
        
      
 }
        
      
}  
