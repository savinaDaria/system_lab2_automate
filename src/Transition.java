public class Transition {
    Integer state1;
    char symbol;
    Integer state2;

    Transition(Integer state1, Character symbol, Integer state2) {
        this.state1 = state1;
        this.symbol = symbol;
        this.state2 = state2;
    }
    Transition(){ }
}