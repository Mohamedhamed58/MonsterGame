import java.util.Arrays;

public class Monster {
    private int health = 100;
    private int speed = 1;
    private int strength = 10;
    public int xpos = 0;
    public int ypos = 0;
    private boolean alive = true;
    public static int numOfMonsters = 0;
    public String name = "Big Monster";
    public char nameChar1 = 'A';

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getYpos() {
        return ypos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    public int getXpos() {
        return xpos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Monster(int health, int speed, int strength , String name) {
        this.health = health;
        this.speed = speed;
        this.strength = strength;
        this.name = name;

        int maxXBoardSpace = battleBoard.length-1;
        int maxYBoardSpace = battleBoard[0].length-1;

        int randNumY , randNumX;
        do {
            randNumY = (int) (Math.random() * maxYBoardSpace);
            randNumX = (int) (Math.random() * maxXBoardSpace);
        }while (battleBoard[randNumX][randNumY] != '*');
        this.xpos =randNumX;
        this.ypos = randNumY;

        this.nameChar1 = this.name.charAt(0);
        battleBoard[ypos][xpos] = this.nameChar1;
        numOfMonsters++;
    }

    public Monster() {
        numOfMonsters++;
    }

    static char [][] battleBoard = new char[10][10];
    public static void BuildGameboard() {
        for (char[] row : battleBoard) {
           Arrays.fill(row, '*');
        }

    }

    public static void redrawgame() {
        int k =1;
        while(k<=30){
            System.out.print('-');
            k++;
        }
        System.out.println();
        for(int i=0; i< battleBoard.length; i++){
            for(int j=0; j< battleBoard.length; j++){
                System.out.print("|"+battleBoard[i][j]+"|");
            }
            System.out.println();
        }

        k =1;
        while(k<=30){
            System.out.print('-');
            k++;
        }
        System.out.println();
    }
    public void moveMonster(Monster[] monster,int arrayItemIndex){
        boolean isSpaceOpen = true;
        int maxXBoardSpace = battleBoard.length-1;
        int maxYBoardSpace = battleBoard[0].length-1;

        while (isSpaceOpen){
            int randMoveDirection = (int) (Math.random() * 4);
            int randMoveDistance = (int) (Math.random() * (this.getSpeed()+1));

            System.out.println(randMoveDistance +" "+randMoveDirection);
            battleBoard[this.ypos][this.xpos] = '*';
            if (randMoveDirection == 0){
                if ((this.ypos - randMoveDistance)<0){
                    this.ypos= 0;
                }else {
                    this.ypos = this.ypos-randMoveDistance;
                }

            }else if (randMoveDirection == 1){
                if ((this.xpos + randMoveDistance)> maxXBoardSpace){
                    this.xpos= maxXBoardSpace;
                }else {
                    this.xpos = this.xpos + randMoveDistance;
                }
            }else if (randMoveDirection == 2){
                if ((this.ypos + randMoveDistance)> maxYBoardSpace){
                    this.ypos= maxYBoardSpace;
                }else {
                    this.ypos = this.ypos + randMoveDistance;
                }
            }else {
                if ((this.xpos - randMoveDistance)<0){
                    this.xpos= 0;
                }else {
                    this.xpos = this.xpos - randMoveDistance;
                }
                for (int i=0;i<monster.length;i++){
                    if (i==arrayItemIndex){
                        continue;
                    }

                    if (onMySpace(monster,i,arrayItemIndex)){
                        isSpaceOpen =true;
                        break;
                    }else {
                        isSpaceOpen=false;
                    }
                }
            }
        } //End of while
        battleBoard[this.ypos][this.xpos] = this.nameChar1;
    }

    public boolean onMySpace(Monster[] monster,int indexToChk1,int indexToChk2) throws NullPointerException {

        if((monster[indexToChk1].xpos)==(monster[indexToChk2].xpos)&&(monster[indexToChk1].ypos)==(monster[indexToChk2].ypos)){
            return true;
        }else {
            return false;
        }
    }
}
