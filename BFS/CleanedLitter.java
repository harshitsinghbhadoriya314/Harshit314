
// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

class CleanedLitter {
    class State {
        int row;
        int col;
        int energy;
        int mark;
        int moves;

        public State(int row, int col, int energy, int mark, int moves) {
            this.moves = moves;
            this.row = row;
            this.col = col;
            this.energy = energy;
            this.mark = mark;
        }
    }

    public int CountL(String[] classroom) {
        int i = 0;
        int j = 0;
        int Count = 0;
        while (i < classroom.length) {
            j = 0;
            while (j < classroom[i].length()) {
                if (classroom[i].charAt(j) == 'L') {
                    Count++;
                }
                j++;
            }
            i++;
        }
        return Count;
    }

    public Queue<State> intial(String[] classroom, int E) {
        Queue<State> ans = new LinkedList<>();
        int i = 0;
        int j = 0;
        while (i < classroom.length) {
            j = 0;
            while (j < classroom[i].length()) {
                if (classroom[i].charAt(j) == 'S') {
                    State start = new State(i, j, E, 0, 0);
                    ans.add(start);
                    return ans;
                }
                j++;
            }
            i++;
        }
        return ans;
    }

    public int minMoves(String[] classroom, int energy) {
        int N = CountL(classroom);
        int[][] index = new int[classroom.length][classroom[0].length()];
        int count = 0;
        boolean[][][][] Visit = new boolean[classroom.length][classroom[0].length()][energy + 1][1 << N];

        for (int i = 0; i < classroom.length; i++) {
            for (int j = 0; j < classroom[i].length(); j++) {
                if (classroom[i].charAt(j) == 'L') {
                    index[i][j] = count;
                    count++;
                }
            }
        }
        int all = (1 << N) - 1;
        Queue<State> process = intial(classroom, energy);

        while (!process.isEmpty()) {
            State Real = process.poll();
            Visit[Real.row][Real.col][Real.energy][Real.mark] = true;
            if (Real.row < 0 || Real.row >= classroom.length) {
                continue;
            }
            if (Real.col < 0 || Real.col >= classroom[Real.row].length()) {
                continue;
            }
            if (classroom[Real.row].charAt(Real.col) == 'R') {
                Real.energy = energy;
            } else if (classroom[Real.row].charAt(Real.col) == 'L') {
                Real.mark = Real.mark | (1 << index[Real.row][Real.col]);
            } else if (classroom[Real.row].charAt(Real.col) == 'X') {
                continue;
            }
            if (Real.mark == all) {
                return Real.moves;
            }
            if (Real.energy == 0) {
                continue;
            }
            State up = new State(Real.row - 1, Real.col, Real.energy - 1, Real.mark, Real.moves + 1);
            if (up.row >= 0 &&
                    up.row < classroom.length &&
                    up.col >= 0 &&
                    up.col < classroom[up.row].length() &&
                    classroom[up.row].charAt(up.col) != 'X' &&
                    !Visit[up.row][up.col][up.energy][up.mark]) {

                Visit[up.row][up.col][up.energy][up.mark] = true;
                process.add(up);
            }
            State down = new State(Real.row + 1, Real.col, Real.energy - 1, Real.mark, Real.moves + 1);
            if (down.row >= 0 &&
                    down.row < classroom.length &&
                    down.col >= 0 &&
                    down.col < classroom[down.row].length() &&
                    classroom[down.row].charAt(down.col) != 'X' &&
                    !Visit[down.row][down.col][down.energy][down.mark]) {

                Visit[down.row][down.col][down.energy][down.mark] = true;
                process.add(down);
            }
            State left = new State(Real.row, Real.col - 1, Real.energy - 1, Real.mark, Real.moves + 1);
            if (left.row >= 0 &&
                    left.row < classroom.length &&
                    left.col >= 0 &&
                    left.col < classroom[left.row].length() &&
                    classroom[left.row].charAt(left.col) != 'X' &&
                    !Visit[left.row][left.col][left.energy][left.mark]) {

                Visit[left.row][left.col][left.energy][left.mark] = true;
                process.add(left);
            }
            State Right = new State(Real.row, Real.col + 1, Real.energy - 1, Real.mark, Real.moves + 1);
            if (Right.row >= 0 &&
                    Right.row < classroom.length &&
                    Right.col >= 0 &&
                    Right.col < classroom[Right.row].length() &&
                    classroom[Right.row].charAt(Right.col) != 'X' &&
                    !Visit[Right.row][Right.col][Right.energy][Right.mark]) {

                Visit[Right.row][Right.col][Right.energy][Right.mark] = true;
                process.add(Right);
            }
        }
        return -1;
    }
}