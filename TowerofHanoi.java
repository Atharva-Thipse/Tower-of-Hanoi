import java.util.*;

class Tower extends Stack<Integer>{
    //contains disks
    public int noOfDisks;
    public char name;
    public Tower(int noOfDisks, char name){
        //constuctor
        this.noOfDisks = noOfDisks;
        this.name = name;
        for (int i = noOfDisks; i>0;i--){
            //initialize the tower
            push(i);
        }
    }
    public Tower(char name){
        this.name = name;
    }
    public char getName(){
        //returns name of the tower
        return name;
    }
}

class Player{
    public Tower fromTower;
    public Tower toTower;
    public Tower medianTower;
    public int numberOfDisks;
    public void moveDisk(int numberOfDisks,Tower fromTower, Tower toTower, Tower medianTower){
        //Moves disk from one tower to another
        if (numberOfDisks==1){
            //Move a single disk from fromTower to toTower
            System.out.println("Move Disk 1 from " + fromTower.getName() + " to " + toTower.getName());
            int disk = fromTower.pop();
            toTower.push(disk);
        }
        else{
            //Move numberOfDisks-1 disks from fromTower to medianTower
            moveDisk(numberOfDisks-1, fromTower, medianTower, toTower);
            System.out.println("Move Disk " + numberOfDisks + " from " + fromTower.getName() + " to " + toTower.getName());
            int disk = fromTower.pop();
            toTower.push(disk);
            //Move back the numberOfDisks-1 disks from medianTower to toTower
            moveDisk(numberOfDisks-1, medianTower, toTower, fromTower);
        }
    }
}

public class TowerofHanoi {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int numberOfDisks = sc.nextInt();
        Tower A = new Tower(numberOfDisks, 'A');
        Tower B = new Tower('B');
        Tower C = new Tower('C');
        System.out.println("\nBefore:");
        System.out.println("Tower A: " + A);
        System.out.println("Tower B: " + B);
        System.out.println("Tower C: " + C);
        Player player = new Player();
        System.out.println("\nPlayer plays:");
        player.moveDisk(numberOfDisks, A, C, B);
        System.out.println("\nAfter:");
        System.out.println("Tower A: " + A);
        System.out.println("Tower B: " + B);
        System.out.println("Tower C: " + C);
        sc.close();
    }   
}