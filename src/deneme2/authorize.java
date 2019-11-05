
package deneme2;

import java.util.Scanner;

public class authorize {
  private String yetki = "ao";
  boolean onlyRead;
  boolean canWrite;
  boolean bothReadWrite;
  
  authorize(){
      onlyRead = false;
      canWrite = false;
      bothReadWrite = false;
  }
  
  String getYetki(){
      return yetki;
  }
  
  void setYetki(String gelen){
      yetki = gelen;
  }
  
  void printAuthorize(){
      System.out.print("Authorize: "+this.yetki+" "+ this.onlyRead +" " 
                       + this.canWrite +" "+ this.bothReadWrite+"\n");
  }
  authorize arrange(){  //both seceneğini daha yararlı bir hale getir
        Scanner obj = new Scanner(System.in);
        System.out.print("Do you want to arrange the person admin or not?(Y/N)\n");
        char ch = obj.next().charAt(0);
        if (ch == 'y' || ch == 'Y')
            setYetki("admin");

            //System.out.print(getYetki()); kontrol için eklendi kaldır


        if((getYetki() == "admin") || (getYetki() == "administrator"))//adminse ayarlamaya gerek yok her şeyi kontrol edebilir
            System.out.print("\n...It is arranged by using administrator info.\n");

        else{
            System.out.print("Can READ the data? (Y/N)\n");
            ch = obj.next().charAt(0);

            if (ch == 'y' || ch == 'Y')
                onlyRead = true;

            System.out.print("Can WRITE the Data? (Y/N)\n");
            ch = obj.next().charAt(0);

            if (ch == 'y' || ch == 'Y')
                canWrite = true;

            if (canWrite && onlyRead)
                bothReadWrite = true;
        }
        return this;

  }
}
