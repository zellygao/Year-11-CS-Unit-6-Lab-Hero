public class Hero {
    private String name;
    private int hitPoints;
    public Hero (String name){
        this.name = name;
        hitPoints = 100;
    }
    public String getName (){
        return name;
    }
    public int getHitPoints (){
        return hitPoints;
    }
    public String toString(){
        return "Hero{name='"+name+"', hitPoints="+hitPoints+"}";
    }
    public void attack(Hero opponent){
        double random = Math.random();
        //range?
        if (random<0.5){
            hitPoints+=10;
        }
        else if(random>=0.5){
            hitPoints-=10; //BOTH?
        }
    }
    public void senzuBean(){
        this.hitPoints=100;
    }
    private void fightUntilTheDeathHelper (Hero opponent){
        while(hitPoints>0 && opponent.hitPoints>0){
            attack(opponent);
            //?
        }
    }

    public String fightUntilTheDeath(Hero opponent){
        senzuBean();
        fightUntilTheDeathHelper(opponent);
        return name +": " + hitPoints + opponent.name + "     : " + opponent.hitPoints;
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n){
        for(int i = 0;i<n;i++){
            fightUntilTheDeathHelper(opponent);
            //senzuBean(); //move after
        }
        return new int[0];
    }

    public String nFightsToTheDeath (Hero opponent, int n){
        nFightsToTheDeathHelper(opponent,n);
        if(n%2==1){ //odd number
            return name+": "+ n +" wins\n" + opponent.getName() + ": "+n + " wins\n" + name + " wins!";//?????
        }
        else{
            //do it
            return name+": "+ n +" wins\n" + opponent.getName() + ": "+n + " wins\n OMG! It was actually a draw!";//?????

        }
    }
    public void dramaticFightToTheDeath (Hero opponent){
        senzuBean();
        fightUntilTheDeathHelper(opponent);
        System.out.print( name +": " + hitPoints + opponent.name + "     : " + opponent.hitPoints);
    }


}
