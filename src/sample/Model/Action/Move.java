package sample.Model.Action;

import sample.Arena.Arena;
import sample.Arena.Point;
import sample.Model.Gladiator.Gladiator;

import java.util.HashMap;

public class Move extends Action{

    public void move(Gladiator gladiator, Arena arena, int direction){
        HashMap<String, Point> possibleMoves = arena.getAdjacent(gladiator.getPosition());
        switch(direction) {
            // northEast
            case 1:
                if(possibleMoves.get("northEast") != null)
                    gladiator.setPositionPoint(possibleMoves.get("northEast"));
                break;

            // east
            case 2:
                if(possibleMoves.get("east") != null)
                    gladiator.setPositionPoint(possibleMoves.get("east"));
                break;

            // southEast
            case 3:
                if(possibleMoves.get("southEast") != null)
                    gladiator.setPositionPoint(possibleMoves.get("southEast"));
                break;
            // southWest
            case 4:
                if(possibleMoves.get("southWest") != null)
                    gladiator.setPositionPoint(possibleMoves.get("southWest"));
                break;

            // west
            case 5:
                if(possibleMoves.get("west") != null)
                    gladiator.setPositionPoint(possibleMoves.get("west"));
                break;

            // northWest
            case 6:
                if(possibleMoves.get("northWest") != null)
                    gladiator.setPositionPoint(possibleMoves.get("northWest"));
                break;

            default:
                System.err.println("Not a valid move");


        }
    }



}
