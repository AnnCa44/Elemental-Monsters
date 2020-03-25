import java.util.Random;
import java.util.Scanner;


public class Arena {

    public static void main(String[] args) {
        
        System.out.println("what is the name of your monster?");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        
        Monster monsterPlayer = new Monster(name, randomFI(), randomFI(),randomEl());
        System.out.println("The powers of " + monsterPlayer.getNameMonster() + " are :");
        System.out.println(">Element: " + monsterPlayer.getElement());
        System.out.println(">Strength: " + monsterPlayer.getDamage());
        System.out.println(">Intelligence: " + monsterPlayer.getIntelligence());
        System.out.println(">Life: " + monsterPlayer.getLife());
        String[] nameMonsters = {"Casimir", "Godzilla", "Alf"};
        int count = 0;
        int coupC;
        int tour;
        int damage;
        
        for (int i = 0; i < 3; i++) {
            coupC = 0;
            tour = randomCC();
            System.out.println("\nBattle number " + (i+1) + " starts\n");

            Monster monsterOpponent = new Monster(nameMonsters[i],randomFI(), randomEl(), randomL());
            System.out.println(nameMonsters[i] + " is of the element " + monsterOpponent.getElement() + "\n");
            
            System.out.println(nameMonsters[i] + " has " +  monsterOpponent.getLife() + " of points");
            System.out.println(monsterPlayer.getNameMonster() + " has " +  monsterPlayer.getLife() + " of points");
            
            monsterPlayer.attack(monsterOpponent);
            if (monsterOpponent.getLife() > 0) {
                monsterOpponent.attack(monsterPlayer);
            } else {
                count++;
                System.out.println("********************");
            }

            while(monsterPlayer.getLife() > 0 && monsterOpponent.getLife() > 0) {
                coupC++;
                System.out.println("Do you want to heal or to attack?");
                String answer = sc.nextLine();
                
                while (!answer.equals("heal") && !answer.equals("attack")) {
                    System.out.println("Try again!");
                    answer = sc.nextLine();
                }
                
                if (answer.equals("heal")) {
                    monsterPlayer.heal();
                } else if (answer.equals("attack")) { 
                    if (coupC == tour) {
                        System.out.println("\n*****    CRITICAL STRIKE!!! x2    *****\n");
                        damage = monsterPlayer.getDamage();
                        monsterPlayer.setDamage(damage * 2);
                        monsterPlayer.attack(monsterOpponent);
                        monsterPlayer.setDamage(damage);
                    } else {
                        monsterPlayer.attack(monsterOpponent);
                    }
                    
                }

                if (monsterOpponent.getLife() > 0) {
                    monsterOpponent.attack(monsterPlayer);
                } else {
                    count++;
                    System.out.println("*******************************");
                }
                
            }
                if (monsterPlayer.getLife() <= 0) {
                    break;
                }
        }
        System.out.println(monsterPlayer.getNameMonster() + " has won " + count + "/3 battles" );
    }

    // random force et random intelligence
    public static int randomFI() {
        Random random = new Random();
        int number = random.nextInt(10);
        
        return number;
    }
    
    // random life
    public static int randomL() {
        Random random = new Random();
        int number = 10 + random.nextInt(21);

        return number;
    }
    
    // random element
    public static String randomEl() {
        String[] elements = {"air", "fire", "water"};
        Random random = new Random();
        int indexElement = random.nextInt(3);
        
        return elements[indexElement];
    }

    
    //  Random coup critique
    public static int randomCC() {
        Random random = new Random();
        int number = random.nextInt(4) + 1;
        return number;
    }



}