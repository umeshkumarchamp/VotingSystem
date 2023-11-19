package com.votersystem;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.votersystem.config.AppConfig;
import com.votersystem.model.Register;
import com.votersystem.service.RegisterServiceImpl;

/**
 * Project       =>   Voter System
 * Created On    =>   19-11-2023
 * Author        =>   Umesh Kumar 
 * Email         =>   ukm3423@gmail.com
 * Contact       =>   6201033951
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        System.out.println( "<===========================   V O T I N G    S Y S T E M   ===========================>\n" );

        AnnotationConfigApplicationContext con = new AnnotationConfigApplicationContext(AppConfig.class);
        RegisterServiceImpl registerService = con.getBean("registerService", RegisterServiceImpl.class);
        System.out.println(registerService);
        int choice = 0;
        do{
            System.out.println("\n1. Add a new Voter\n2. View All Voter Details\n3. Delete Voter By Id \n4. Update Voter By Id \n5. Search Voter By Id \n6. Exit");

            System.out.print("\nEnter Your Choice : ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("\n<------------------------- Registser Section ------------------------->\n");
                    System.out.print("Enter Your Name : ");
                    String name = sc.nextLine(); 
                    System.out.print("Enter Your Email-Id : ");
                    String email = sc.nextLine();
                    System.out.print("Enter Your Age : ");
                    int age = sc.nextInt(); 
                    System.out.print("Enter Your Mobile : ");
                    Long mobile = sc.nextLong();

                    Register reg = new Register();
                    reg.setEmail(email);
                    reg.setName(name);
                    reg.setAge(age);
                    reg.setContact(mobile);
                    boolean success = registerService.addVoter(reg); 
                    if(success){
                        System.out.println("\nVoter Added Successfully\n");
                    }else{
                        System.out.println("\nSomething went wrong !\n");
                    }
                    break;
                case 2: 
                    System.out.println("\n<------------------------- Voter List ------------------------->\n");
                    List<Register> list = registerService.getVoterList();
                    for (Register r : list){
                        System.out.println(r);
                    }
                    break; 
                case 3: 
                    System.out.println("\n<------------------------- Delete Section ------------------------->\n");
                    System.out.print("Enter Your Voter Id : ");
                    int id = sc.nextInt();
                    boolean res = registerService.deleteVoter(id);
                    if(res){
                        System.out.println("Successfully deleted");
                    }else{
                        System.out.println("Failed to delete !");
                    }
                    break; 
                case 4:
                    System.out.println("\n<------------------------- Update Section ------------------------->\n");
                    System.out.print("Enter Your Voter Id : ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Your Name : ");
                    name = sc.nextLine(); 
                    System.out.print("Enter Your Email-Id : ");
                    email = sc.nextLine();
                    System.out.print("Enter Your Age : ");
                    age = sc.nextInt(); 
                    System.out.print("Enter Your Mobile : ");
                    mobile = sc.nextLong();
                    
                    reg = new Register();
                    reg.setEmail(email);
                    reg.setName(name);
                    reg.setAge(age);
                    reg.setContact(mobile);
                    reg.setId(id);
                    success = registerService.updateVoter(reg);
                    if(success){
                        System.out.println("\nVoter updated successfully\n");
                    }else{
                        System.out.println("\nSomething went wrong !\n");
                    }
                    break; 
                case 5:
                    System.out.println("\n<------------------------- Searching Voter Detail ------------------------->\n");
                    System.out.print("Enter Your Voter Id : ");
                    id = sc.nextInt();
                    Register voter = registerService.getVoterDetail(id);
                    System.out.println(voter);
                    break; 
                case 6:
                    System.exit(0);
                    break; 
                default:
                    System.out.println("\nInvalid Choice, Please try again !");
                    break;
            }

        }while(choice !=6);


        sc.close();
        con.close();
    }
}
