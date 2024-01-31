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
        int[] array = new int[2];
        for(int i = 0;i<n;i++){
            fightUntilTheDeathHelper(opponent);
            if(hitPoints==0){
                array[0]++;
            }
            else if(opponent.hitPoints==0){
                array[1]++;
            }
            senzuBean();
            opponent.senzuBean();
        }
        return array;
    }

    public String nFightsToTheDeath (Hero opponent, int n){
        int[] arr = nFightsToTheDeathHelper(opponent,n);
            if(arr[0]>arr[1]){
                return name+": "+ arr[0] +" wins\n" + opponent.getName() + ": "+arr[1] + " wins\n" + name + " wins!";//?????
            }
            else if(arr[0]<arr[1]){
                return name+": "+ arr[1] +" wins\n" + opponent.getName() + ": "+arr[1] + " wins\n" + opponent.name + " wins!";//?????
            }

            //do it
            return name+": "+ arr[0] +" wins\n" + opponent.getName() + ": "+arr[0] + " wins\n OMG! It was actually a draw!";//?????
    }
    public void dramaticFightToTheDeath (Hero opponent){
        senzuBean();
        fightUntilTheDeathHelper(opponent);
        System.out.print( name +": " + hitPoints + opponent.name + "     : " + opponent.hitPoints);
    }


}
