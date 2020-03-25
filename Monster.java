public class Monster {

    // Attibuts
    private String nameMonster;
    private int damage;
    private int intelligence;
    private int life;
    private String element;

    

    // constructeur monstre
    public Monster(String nameMonster, int damage, int intelligence, String element){
        this.nameMonster = nameMonster;
        this.damage = damage;
        this.intelligence = intelligence;
        this.life = 200;
        this.element = element;
    }


    // constructeur adversaire
    public Monster(String nameMonster, int damage, String element, int life) {
        this.nameMonster = nameMonster;
        this.damage = damage;
        this.element = element;
        this.life = life;
    }

        
    // getters
    public String getNameMonster(){
        return this.nameMonster;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public String getElement() {
        return this.element;
    }
    
    public int getLife() {
        return this.life;
    }

    // setters 
    public void setNameMonster(String name) {
        this.nameMonster = name;
    }
    
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    
    /* le feu est efficace contre l'air
    l'air est efficace contre l'eau
    l'eau est efficace contre le feu */

    //attack (va attaquer l'adversaire)
    public void attack(Monster opponent){
        System.out.println(this.nameMonster + " attack!!!");
        if( this.getElement().equals("fire") && opponent.getElement().equals("air")  ){
            opponent.setLife(opponent.getLife() - ((this.damage + 1) * 2));
        }
        else if ( this.getElement().equals("air") && opponent.getElement().equals("water")) {
            opponent.setLife(opponent.getLife() - ((this.damage + 1) * 2));
        }
        else if ( this.getElement().equals("water") && opponent.getElement().equals("fire")) {
            opponent.setLife(opponent.getLife() - ((this.damage + 1) * 2));
        } 
        else if( this.getElement().equals("air") && opponent.getElement().equals("fire")  ){
            opponent.setLife(opponent.getLife() - ((this.damage + 1) / 2));
        }
        else if ( this.getElement().equals("water") && opponent.getElement().equals("air")) {
            opponent.setLife(opponent.getLife() - ((this.damage + 1) / 2));
        }
        else if ( this.getElement().equals("fire") && opponent.getElement().equals("water")) {
            opponent.setLife(opponent.getLife() - ((this.damage + 1) / 2));
        } 
        else {
            opponent.setLife(opponent.getLife() - (this.damage + 1));
        }

        if( opponent.getLife() > 0) {
            System.out.println(opponent.getNameMonster() + " has " + opponent.getLife() + " points remaning. \n");
        } else {
            System.out.println(opponent.getNameMonster() + " is KO!");
        }
    }

    
    //Heal
    public void heal(){
        this.life = this.life + this.getIntelligence() + 1;
    }


    
}