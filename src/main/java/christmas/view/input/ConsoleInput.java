package christmas.view.input;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput implements Input {
    @Override
    public String readDate() {
        return Console.readLine();
    }
}
