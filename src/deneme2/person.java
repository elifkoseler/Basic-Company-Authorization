
package deneme2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class person extends authorize{  //gruplar tam zamanlı yarı zamanlı gibi , ve access classı eklenecek gruba göre ayrım yapılacak
    String name;    //access kısmını interface olarak yaratmayı dene?
    String surname;
    private int IDnumber;
    String degree;  //department
    protected int birthyear;
    char gender; 
    private int phoneNumber;
    //String role; //authorizea taşındı.

    String job;
    protected String type;  //iş tipi
    protected String group_name = " - ";   //grubu

    access erisim = new access();   //erişim kısıtlamaları
    //authorize yet = new authorize();    //yetki düzenlemeleri/ gerek kalmadı zaten extend edilmiş!!



    person(String _name, String _surname,String _degree,
                int _birthyear, char _gender, int _phoneNumber, String _job){
    
        name = _name;
        surname = _surname;
        degree = _degree;
        birthyear = _birthyear;
       // birthdate = _birthdate;
        gender = _gender;
        job = _job;
        group_name = " ";
        
    }   //Constructor with parameter
  
    person(){} //const without parameter
    int getIDnumber(){
        return IDnumber; 
    }
    
    protected void setIDnumber(int _IDnumber){
        IDnumber = _IDnumber;
    }
    
    int getPhoneNumber(){
        return phoneNumber;
    }
    
    protected void setPhoneNumber(int _phoneNumber){
        phoneNumber = _phoneNumber;
    }
         
   public static person returnPerson(person kisi){
        return kisi;
    }

    public person add_info(person kisi){
        Scanner obj = new Scanner(System.in);
       
        System.out.print("Please enter name:\n");
        kisi.name = obj.nextLine();
      
        System.out.print("Enter surname:\n");
        kisi.surname = obj.nextLine();

        System.out.print("Enter the job of person: \n");
        kisi.job = obj.nextLine();

        System.out.print("Enter the degree of person: \n");
        kisi.degree = obj.nextLine();
      
        System.out.print("Enter birthyear: \n");
        kisi.birthyear = obj.nextInt();
        
        System.out.print("Enter the gender: (F/M)\n");
        kisi.gender = obj.next().charAt(0);

        System.out.print("Enter the ID number:\n");
        int ID = obj.nextInt();
        kisi.getIDnumber();
        kisi.setIDnumber(ID);
        
        System.out.print("Enter the phone number: \n");
        int phone = obj.nextInt();
        kisi.setPhoneNumber(phone);
        System.out.print("***JOB:"+kisi.job);
        if(!kisi.job.equalsIgnoreCase("ao")) {   //ao değilse grubu belli değilse gruba atanmalıdır
            System.out.print("Choose the group of person \n A)ADHPG B)SDG C)YGG\n ");
            char choice = obj.next().charAt(0);
            if (choice == 'A' || choice == 'a')
                kisi.group_name = "ADG";

            else if (choice == 'B' || choice == 'b')
                kisi.group_name = "SDG";

            else if (choice == 'C' || choice == 'c')
                kisi.group_name = "YGG";
        }else{
            System.out.print("AO !!!");
        }
        System.out.print("Do you want to arrange the authorize of person now ? (Y/N):\n");


        char opt = obj.next().charAt(0);
            if(opt == 'y' || opt == 'Y')
                kisi.arrange();
            else
                System.out.print("OKAY... It is arranged as default. \n");

        return kisi;
    }
    
   public void printPersonalInfo (){
        switch (this.gender) {
        //gender f ise female; m ise male; farklı bir harf ise Other
            case 'F':
            case 'f':
                System.out.print("----Personal Info---- \n"+this.group_name+" "+this.job+"\nName & Surname:  "+this.name+" "+this.surname+
                        "\nID Number: "+this.IDnumber+"\nBirthyear: "+this.birthyear +
                        " "+this.degree +"\nGender: "+ "Female "+"\nPhone Number: "+
                        this.phoneNumber+" " +
                        this.getYetki()+"\nCanWrite: "+this.canWrite+" CanRead: " +
                        this.onlyRead +" Both: "+this.bothReadWrite+"\n------------------------------------------------------");
                       
                break;
            case 'M':
            case 'm':
                System.out.print("----Personal Info----: \n"+this.group_name+" "+this.job+"\nName & Surname:  "+this.name+" "+this.surname+
                        "\nID Number: "+this.IDnumber+"\nBirthyear: "+this.birthyear +
                        "\n"+this.degree +"\n"+ "Gender: Male "+"\nPhone Number: "+
                        this.phoneNumber+"\n" +
                        this.getYetki()+"\nCanWrite: "+this.canWrite+" CanRead: " +
                        this.onlyRead +" Both: "+this.bothReadWrite+"\n-----------------------------------------------------");
                break;
            default:
                System.out.print("----Personal Info----: \n"+this.group_name+" "+this.job+"\nName & Surname:  "+this.name+" "+this.surname+
                        "\nID Number: "+this.IDnumber+"\nBirthyear: "+this.birthyear +
                        "\n"+this.degree +"\n"+ "Gender: Other "+"\nPhone Number: "+
                        this.phoneNumber+"\n" +
                        this.getYetki()+"\nCanWrite: "+this.canWrite+" CanRead: " +
                        this.onlyRead +" Both: "+this.bothReadWrite+"\n------------------------------------------------------");
                break;
        }
           
   }

   void work_type(person kisi) {    //yz ya da tz ataması

        if (kisi.job == "ao" || kisi.job == "na")
            kisi.type = "yz";
        else
            kisi.type = "tz";

   }
}
