package sample.Arena;
/**
 * @author Yannick Brot Christensen
 * Class creates and contains a hexagonal grid in a 2dArray.
 */


public class Arena {

    private Hex[][] arena;

    //Creates double width hexagonal grid
    public void initArena(int width){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width/2; j++) {
                arena[i][j] = new Hex();
            }
        }
    }



}
