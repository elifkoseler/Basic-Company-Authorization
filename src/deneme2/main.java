
package deneme2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

public class main {
    public static void menu(){
    System.out.print("-----MENU-----\n");
    System.out.print("Select an operation:\n");
    System.out.print(" 1) ADD\n 2) FIND\n 3) DELETE\n 4) PRINT ALL LIST \n 5) ACCESS SERVICES \n 6) EXIT\n");
    System.out.print("--------------\n");

} 
    private static boolean operation(int op,List<person> liste){
        boolean end = true;
        Scanner obj = new Scanner(System.in);

        switch(op){
            case 1://add
                person kisi = new person();
                kisi.work_type(kisi);
                kisi = kisi.add_info(kisi);
                kisi.printPersonalInfo();
                liste.add(kisi);
                System.out.print(liste.size());

                break;

            case 2: //find
                System.out.print("Please enter the index of person that you want to find: \n");
                int idx = obj.nextInt();
                for(person aranan : liste) {
                    if(liste.indexOf(aranan) == idx){
                        System.out.print("FOUND!!\n");
                    aranan.printPersonalInfo();}
                    else //if(liste.contains(aranan))
                        System.out.print("NOT FOUND: The list does not contains the person.\n");
                }
                break;
            case 3://delete
                System.out.print("Please enter the index of person that you want to delete: \n");
                int idx1 = obj.nextInt();
                for(person silinecek : liste) {
                    if(liste.indexOf(silinecek) == idx1){
                        System.out.print("DELETED!!\n");
                        liste.remove(silinecek);
                        //silinecek.printPersonalInfo();
                    }
                    else //if(liste.contains(aranan))
                        System.out.print("NOT FOUND: The list does not contains the person.\n");
                }
                break;
            case 4://print
                for (person item: liste) {
                    item.printPersonalInfo();
                }
                break;
            case 5:
                //find eklenmesi gerekecek gibi duruyor çünkü hangi kişinin ulaşıp ulaşamayacağı belirsiz//eklendi
                //ayrıca başka bir yerde böyle bir hizmet suna bilirsin switch casede olmak zorunda değil
                System.out.print("\nPlease enter the index of person that you want to access the information: \n");
                int id = obj.nextInt();
                person yeni_kisi = null;
                for(person aranan : liste) {
                    if(liste.indexOf(aranan) == id) {
                        System.out.print("FOUND!!\n");
                        aranan.printPersonalInfo();
                        yeni_kisi = aranan;
                    }

                }
                if (yeni_kisi == null)
                    break;
                else{
                System.out.print("\nYENİ KİŞİ **\n");
                yeni_kisi.printPersonalInfo();

                System.out.print("\n\nWhich services do you want to access?\n A) Cloud B)Terminal C)Topology D)AoToplanti \n");
                char c = obj.next().charAt(0);
                if(c == 'A' || c == 'a') {
                    //kisi.group_name = "YGG";
                    yeni_kisi.erisim.cloud(yeni_kisi);
                }
                else if(c == 'B' || c == 'b'){
                    //kisi.group_name = "SDG";
                    yeni_kisi.erisim.terminal(yeni_kisi);
                }
                else if(c == 'C' || c == 'c') {
                    //kisi.group_name = "ADG";
                    yeni_kisi.erisim.topology(yeni_kisi);

                }
                else if(c == 'D' || c == 'd') {
                    //kisi.group_name = "ADG";
                    yeni_kisi.erisim.aotoplanti(yeni_kisi);

                }
                break;}
            case 6://exit
                end = false;
                break;
            default:
                System.out.print("TRY AGAIN\n");
                op = obj.nextInt();
                end = operation(op,liste);
                break;
        }
    return end;
    }
    public static void main(String[] args) {
        //function fonk = new function();
        List<person> liste = new ArrayList<>();
        person one = new person();
        person two = new person();

        one.name = "Elif";  // değerler atandı.
        one.surname = "Koseler";
        one.setIDnumber(15701);
        one.gender = 'f';
        one.birthyear = 1997;
        one.degree = "Comp. Eng.";
        one.setPhoneNumber(536);
        one.onlyRead = true;
        one.setYetki("local");
        one.job = "na";
        one.group_name = "YGG";

        two.name = "Ahmet";  // değerler atandı.
        two.surname = "Kose";
        two.setIDnumber(15701);
        two.gender = 'f';
        two.birthyear = 1997;
        two.degree = "Comp. Eng.";
        two.setPhoneNumber(536);
        one.onlyRead = true;
        two.setYetki("administrator");
        two.job = "ao";
        liste.add(one);
        liste.add(two);

        System.out.print(liste.size());

        Scanner obj = new Scanner(System.in);
        boolean end = true;
        while (end){
            menu();
            int op = obj.nextInt();
            end = operation(op, liste);
    }
}

}
