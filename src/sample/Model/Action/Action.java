package sample.Model.Action;


public class Action {

    int time;
    int condition;

    public Action(int time, int condition) {
        this.time = time;
        this.condition = condition;
    }

    public Action() {
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

}
