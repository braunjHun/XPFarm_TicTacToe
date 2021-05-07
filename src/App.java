import java.util.ArrayList;

public class App {
    
    private static Board gameBoard;
    private static final int TEST_CASE = 1;
    public static void main(String[] args) throws Exception {



        // SIMULATION:
        System.out.println("-------------T E S T   C A S E   >"+TEST_CASE+"<----------------");                 
        switch (TEST_CASE) {
            case 1:
                gameBoard = new Board("X");
                simulation(testCase1());
                break;
            case 2:
                gameBoard = new Board("O");
                simulation(testCase2());
                break;
            case 3:
                gameBoard = new Board("X");
                simulation(testCase3());
                break;
            case 4:
                gameBoard = new Board("X");
                simulation(testCase4());
                break;                                
        }
    }

    private static void simulation(ArrayList<Step> test){
        System.out.println();                 
        System.out.println("-------------SIMULATION----------------");                 
        System.out.println();   
        for (Step step : test) {
            System.out.println("Next PLAYER:"+step.getPlayer().getPlayerName());                 
            gameBoard.takeStep(step.getPlayer(), step.getxCo(), step.getyCo());
            char result = gameBoard.checkResult();
            if (result == ' ') {
                // do nothing
            } else if (result == '-') {
                System.out.println();
                System.out.println("GAME ENDS WITH A DRAW!");                 
                break;
           } else {
                 System.out.println();
                 System.out.println("PLAYER "+result+" WON!");                 
                 break;
            }
        }  
    }

    private static ArrayList<Step> testCase1() {
        Player playerX = new Player("X", 'X');
        Player playerO = new Player("O", 'O');
        ArrayList<Step> testSteps =  new ArrayList<Step>();
        Step nexStep = new Step(playerX,0,0);
        testSteps.add(nexStep);
        nexStep = new Step(playerO,1,1);
        testSteps.add(nexStep);
        nexStep = new Step(playerX,1,0);
        testSteps.add(nexStep);;
        nexStep = new Step(playerO,2,2);
        testSteps.add(nexStep);;
        nexStep = new Step(playerX,2,0);
        testSteps.add(nexStep);;
        return testSteps;
    }
    private static ArrayList<Step> testCase2() {
        Player playerX = new Player("X", 'X');
        Player playerO = new Player("O", 'O');
        ArrayList<Step> testSteps =  new ArrayList<Step>();
        Step nexStep = new Step(playerO,1,0);
        testSteps.add(nexStep);
        nexStep = new Step(playerX,0,0);
        testSteps.add(nexStep);;
        nexStep = new Step(playerO,1,1);
        testSteps.add(nexStep);;
        nexStep = new Step(playerX,0,2);
        testSteps.add(nexStep);;
        nexStep = new Step(playerO,1,2);
        testSteps.add(nexStep);;
        return testSteps;
    }

    private static ArrayList<Step> testCase3() {
        Player playerX = new Player("X", 'X');
        Player playerO = new Player("O", 'O');
        ArrayList<Step> testSteps =  new ArrayList<Step>();
        Step nexStep = new Step(playerX,0,0);
        testSteps.add(nexStep);
        nexStep = new Step(playerO,1,0);
        testSteps.add(nexStep);
        nexStep = new Step(playerX,1,1);
        testSteps.add(nexStep);;
        nexStep = new Step(playerO,2,0);
        testSteps.add(nexStep);;
        nexStep = new Step(playerX,2,2);
        testSteps.add(nexStep);;
        return testSteps;
    }
    private static ArrayList<Step> testCase4() {
        Player playerX = new Player("X", 'X');
        Player playerO = new Player("O", 'O');
        ArrayList<Step> testSteps =  new ArrayList<Step>();
        Step nexStep = new Step(playerX,0,0);
        testSteps.add(nexStep);
        nexStep = new Step(playerO,0,1);
        testSteps.add(nexStep);
        nexStep = new Step(playerX,0,2);
        testSteps.add(nexStep);;
        nexStep = new Step(playerO,1,0);
        testSteps.add(nexStep);;
        nexStep = new Step(playerX,1,2);
        testSteps.add(nexStep);;
        nexStep = new Step(playerO,1,1);
        testSteps.add(nexStep);;
        nexStep = new Step(playerX,2,0);
        testSteps.add(nexStep);;
        nexStep = new Step(playerO,2,2);
        testSteps.add(nexStep);;
        nexStep = new Step(playerX,2,1);
        testSteps.add(nexStep);;
        return testSteps;
    }

}
