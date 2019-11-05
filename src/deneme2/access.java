package deneme2;

public class access {

    void cloud(person kisi){
        if(kisi.group_name == "YGG")
            System.out.print("**Reached CLOUD**\n");
        else
            System.out.print("Sorry, You can not access cloud \n");

    }
    void terminal(person kisi){
        if(kisi.group_name == "SDG")
            System.out.print("**Reached TERMINAL SERVICE**\n");
        else
        System.out.print("Sorry, You can not access terminal \n");

    }
    private void topology_admin(){
        System.out.print("**Reached TOPOLOGY ADMIN**\n");
    }
    void topology(person kisi) {
        if (kisi.group_name == "ADG") {
            if (kisi.getYetki() == "admin") {
                System.out.print("Reaching topology admin...\n");
                topology_admin();
            } else
                System.out.print("Sorry, You can not access topology admin\n");
        }
        else
            System.out.print("Sorry, You can not access topology\n ");
    }

    void aotoplanti(person kisi){
        if(kisi.job == "ao"||kisi.job == "na")
            System.out.print("**Reached AO toplanti tutanaklari\n");
        else
            System.out.print("Sorry, You can not access AO toplanti tutanaklari\n ");
    }
}
