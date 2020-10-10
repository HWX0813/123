import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//  Send messages to each other （the sender ID，the receiver ID，message，state）
//  Ask the receiver ID,
//  Check to see if the receiver exists,
//  The sender sends a message,
//  Receiver receives message
//  Read message
//  Displays all unread messages ,the sender ID, the receiver ID
//  The unread message changes to read

class customer{
    private String id;
    private String name;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
//zhushi
class  Message{
    private String  sid;
    private String fid;
    private String node;
    private String state;
    public String getSid() {
        return sid;
    }
    public void setSid(String sid) {
        this.sid = sid;
    }
    public String getFid() {
        return fid;
    }
    public void setFid(String fid) {
        this.fid = fid;
    }
    public String getNode() {
        return node;
    }
    public void setNode(String node) {
        this.node = node;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
}


public class CustomerMessage {

    private static List<customer> list1 = new ArrayList<customer>();
    private static List<Message> list2 = new ArrayList<Message>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = 0;
        do {
            System.out.println("Please enter your operation!");
            System.out.println("1.Registered customers");
            System.out.println("2.Read my message");
            System.out.println("3.send message");
            x = scan.nextInt();
            switch (x) {
                case 1:
                    Registered();
                    break;
                case 2:
                    readmyMessage();
                    break;
                case 3:
                    findsendmessage();
                    break;

                default:
                    break;
            }

        } while (x != 0);
    }

    public static void Registered() {
        //Register the sender ID and name
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input customer id :");
        String custid = scan.nextLine();
        System.out.println("Please input customer name :");
        String custname = scan.nextLine();
        customer cus = new customer();
        cus.setId(custid);
        cus.setName(custname);
        list1.add(cus);
        System.out.println("Registered\n");

    }

    public static void findsendmessage() {
        int tocustid1 = 0;
        int tocustid2 = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the ID of the message you want to send :");
        String custid1 = scan.nextLine();

        for (customer cus : list1) {
            if (cus.getId().equals(custid1)) {
                System.out.println("Customer information has been found");
                System.out.println("Customer ID :" + cus.getId());
                System.out.println("Customer ID :" + cus.getName());
                tocustid1 = 1;
            }
        }

        if (tocustid1 == 0) {
            System.out.println("Customer information not find");
            return;
        }


        System.out.println("Please enter your own ID :");
        String custid2 = scan.nextLine();

        if (custid2.equals(custid1)) {
            System.out.println("The sender and the receiver cannot be the same");
            return;
        } else {
            for (customer cus : list1){
                if (cus.getId().equals(custid2)) {
                    System.out.println("Customer information has been found");
                    System.out.println("Customer ID :" + cus.getId());
                    System.out.println("Customer ID :" + cus.getName());
                    tocustid2 = 1;
                }
            }
        }
        if (tocustid2 == 0) {
            System.out.println("Customer information not find");
            return;
        }
        System.out.println("Please enter what you want to send :");
        String message = scan.nextLine();

        String message1 = "unread" ;

        Message mes = new Message();
        mes.setSid(custid1);
        mes.setFid(custid2);

        mes.setNode(message);
        mes.setState(message1);
        list2.add(mes);



    }


    public static void readmyMessage(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input customer id");
        String custid = scan.nextLine();


        int tocustid = 0;
        System.out.println("check number\tthe sender ID\tthe receiver ID\t\tmessage\t\t\tstate");


        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i).getSid().equals(custid)) {
                System.out.printf("<" + i + ">\t\t\t\t");
                System.out.printf("<" + list2.get(i).getSid() + ">\t\t\t\t");
                System.out.printf("<" + list2.get(i).getFid() + ">\t\t\t");
                System.out.printf("<" + list2.get(i).getNode() + ">\t\t");
                System.out.printf("<" + list2.get(i).getState() + ">\t\t\n");
                tocustid = 1;
            }
        }

        System.out.println("Please enter the check number :");
        int checkNum = scan.nextInt();
        if (checkNum >= list2.size()) {
            System.out.println("check number did not find");
        } else {
            System.out.printf("check number:<" + list2.get(checkNum).getSid() + ">\n");
            System.out.printf("the sender ID:<" + list2.get(checkNum).getFid() + ">\n");
            System.out.printf("message:<" + list2.get(checkNum).getNode() + ">\n");
            list2.get(checkNum).setState("read");
            System.out.printf("state:<" + list2.get(checkNum).getState() + ">\n");
        }

        if (tocustid == 0) {
            System.out.println("no message");
        }
    }


}




