import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Automat {
    private final ArrayList<Transition> transitions = new ArrayList<>();
    private final ArrayList<Integer> finalStates = new ArrayList<>();//финальные состояния
    private Integer state;
     private int statesCount;//колво состояний
    private int startState;//начальное состояние
    private int finalStatesCount;//колво финальных состояний
    public char[] w0;

    public Automat(String AutomatPath,char [] w0) {
        try {
            File file = new File(AutomatPath);
            Scanner sc = new Scanner(file);
            int alphabetCount = sc.nextInt();//колво букв алфавита
            this.statesCount = sc.nextInt();
            this.startState = sc.nextInt();
            sc.nextLine();
            this.finalStatesCount = sc.nextInt();//колво финальных состояний
            for (int i = 0; i < finalStatesCount; i++) {
                finalStates.add(sc.nextInt());
            }

            while (sc.hasNextLine()) {
                Transition temp = new Transition();
                temp.state1 = sc.nextInt();
                String tempo = sc.next();
                temp.symbol = tempo.charAt(0);
                temp.state2 = sc.nextInt();
                transitions.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.w0=w0;

        state = this.startState;
    }

    public Integer getState(char[] w0, int startState) {
        state = startState;
             for (char symbol: w0) {
            transitions.stream().filter(s -> (s.state1.equals(state) && s.symbol == symbol)).findFirst()
                    .ifPresentOrElse(s-> state = s.state2,() -> state = null);
        }
        return state;
    }

    private List<Integer> getStartsW0States() {
        List startsW0States = new ArrayList<Integer>();
        Integer state;
        for (int i = 0; i < statesCount; i++){
            state = getState(w0, i);
            if(state!=null) {
             startsW0States.add(state);
            }
        }
        return startsW0States;
    }
    private boolean getPathFromStartState(List<Integer> finalW0States){
        for (int j = 0; j < statesCount; j++) {
            for (int k=0;k<finalStatesCount;k++) {
                if (finalW0States.contains(finalStates.get(k))) {
                    return true;
                }
            }
        }
        return false;
    }

    public  boolean checkW0() {
        List<Integer> possibleFinalStates = getStartsW0States();
        return getPathFromStartState(possibleFinalStates);
    }
}