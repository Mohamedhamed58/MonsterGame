import org.apache.commons.lang3.*;
public class Main {
    public static void main(String[] args) {

        Monster.BuildGameboard();

        Monster[] Monsters = new Monster[4];

        Monsters[0] = new Monster(100, 20, 1, "Somaa");
        Monsters[1] = new Monster(100, 20, 1, "Taher");
        Monsters[2] = new Monster(100, 20, 2, "Amr");
        Monsters[3] = new Monster(100, 20, 1, "Honda");

        Monster.redrawgame();

        for (Monster m : Monsters)
        {
            if(m.isAlive())
            {
                int arrayItemIndex = ArrayUtils.indexOf(Monsters, m);
                m.moveMonster(Monsters, arrayItemIndex);
            }
        }
        Monster.redrawgame();
    }
}