
import java.util.Scanner;
/**
 * ChessboardProjectTest class of the Java program.
 */
public class ChessboardProjectTest {

    public static void main(String[] args) {
        
        Chessboard chessboard;
        Scanner in = new Scanner(System.in);
        int task = in.nextInt();
        int testCase = in.nextInt();
        if(task == 0){
            switch (testCase) {
                case 1:
                    // Task #0: Test Chessboard: Creating empty chessboards and print it
                    chessboard = new Chessboard(4, 3);
                    System.out.println(chessboard.toString());
                    break;
                case 2:
                    // Task #0: Test Chessboard: Converting string to chessboard and print it
                    String sampleChesssboard1
                            = " #########\n"
                            + "         #\n"
                            + "#        #\n"
                            + "#        #\n"
                            + "#       G#\n"
                            + "##########\n";
                    chessboard = new Chessboard(sampleChesssboard1);
                    System.out.println(chessboard.toString());
                    break;
                case 3:
                    // Task #0: Test Chessboard: print chessboard from ChessboardSamples class
                    chessboard = new Chessboard(ChessboardSamples.sChessboard3);
                    System.out.println(chessboard.toString());
                    break;
                default:
                    break;
            }
        }else if(task == 1){
            switch (testCase) {
                case 1:
                    {
                        // Task #1: DLLPath addLast() to empty list
                        DLLPath path = new DLLPath();
                        path.addLast(0, 0);
                        System.out.println(path.toString());
                        break;
                    }
                case 2:
                    {
                        // Task #1: DLLPath addLast() to a one node list
                        DLLPath path = new DLLPath();
                        path.addFirst(0, 0);
                        path.addLast(1, 0);
                        System.out.println(path.toString());
                        break;
                    }
                case 3:
                    {
                        // Task #1: DLLPath addLast() to more than one node list
                        DLLPath path = new DLLPath();
                        path.addFirst(1, 2);
                        path.addFirst(1, 1);
                        path.addFirst(1, 0);
                        path.addFirst(0, 0);
                        path.addLast(1, 2);
                        System.out.println(path.toString());
                        break;
                    }
                case 4:
                    {
                        // Task #1: DLLPath removeFirst() from an empty list
                        DLLPath path = new DLLPath();
                        path.removeFirst();
                        System.out.println(path.toString());
                        break;
                    }
                case 5:
                    {
                        // Task #1: DLLPath removeFirst() from one node list
                        DLLPath path = new DLLPath();
                        path.addFirst(0, 0);
                        path.removeFirst();
                        System.out.println(path.toString());
                        break;
                    }
                case 6:
                    {
                        // Task #1: DLLPath removeFirst() from more than one node list
                        DLLPath path = new DLLPath();
                        path.addFirst(1, 2);
                        path.addFirst(1, 1);
                        path.addFirst(1, 0);
                        path.addFirst(0, 0);
                        path.removeFirst();
                        System.out.println(path.toString());
                        break;
                    }
                case 7:
                    {
                        // Task #1: DLLPath removeLast() from an empty list
                        DLLPath path = new DLLPath();
                        path.removeLast();
                        System.out.println(path.toString());
                        break;
                    }
                case 8:
                    {
                        // Task #1: DLLPath removeLast() from one node list
                        DLLPath path = new DLLPath();
                        path.addFirst(0, 0);
                        path.removeLast();
                        System.out.println(path.toString());
                        break;
                    }
                case 9:
                    {
                        // Task #1: DLLPath removeLast() from more than one node list
                        DLLPath path = new DLLPath();
                        path.addFirst(1, 2);
                        path.addFirst(1, 1);
                        path.addFirst(1, 0);
                        path.addFirst(0, 0);
                        path.removeLast();
                        System.out.println(path.toString());
                        break;
                    }
                case 10:
                    {
                        // Task #1: Building a DLLPath A
                        DLLPath path;

                        chessboard = new Chessboard(ChessboardSamples.sChessboard1);
                        path = buildPath(chessboard, PathSamples.movsPath1a);
                        System.out.println(path.toString());
                        chessboard.followPath(path);
                        System.out.println(chessboard.toString());

                        break;
                    }
                case 11:
                    {
                        // Task #1: Building a DLLPath B
                        DLLPath path;
                        chessboard = new Chessboard(ChessboardSamples.sChessboard1);
                        path = buildPath(chessboard, PathSamples.movsPath1b);
                        System.out.println(path.toString());
                        chessboard.followPath(path);
                        System.out.println(chessboard.toString());


                        break;
                    }
                default:
                    break;
            }
            
            
        }else if(task == 2){
            switch (testCase) {
                case 1:
                    {
                        // Task #2: Test pathNavigatorUsingStack with sample chessboard 1
                        DLLPath path;
                        PathNavigator pf = new PathNavigator();

                        chessboard = new Chessboard(ChessboardSamples.sChessboard1);
                        path = pf.pathNavigatorUsingStack(chessboard);
                        System.out.println(path.toString());
                        chessboard.followPath(path);
                        System.out.println(chessboard.toString());
                    }
                    break;
                case 2:
                    {
                        // Task #2: Test pathNavigatorUsingStack with sample chessboard 2
                        DLLPath path;
                        PathNavigator pf = new PathNavigator();

                        chessboard = new Chessboard(ChessboardSamples.sChessboard2);
                        path = pf.pathNavigatorUsingStack(chessboard);
                        System.out.println(path.toString());
                        chessboard.followPath(path);
                        System.out.println(chessboard.toString());
                    }
                    break;
                case 3:
                    {
                        // Task #2: Test pathNavigatorUsingStack with sample chessboard 3
                        DLLPath path;
                        PathNavigator pf = new PathNavigator();

                        chessboard = new Chessboard(ChessboardSamples.sChessboard3);
                        path = pf.pathNavigatorUsingStack(chessboard);
                        System.out.println(path.toString());
                        chessboard.followPath(path);
                        System.out.println(chessboard.toString());
                    }
                    break;
                case 4:
                    {
                        // Task #2: Test pathNavigatorUsingStack with sample chessboard 4
                        DLLPath path;
                        PathNavigator pf = new PathNavigator();

                        chessboard = new Chessboard(ChessboardSamples.sChessboard4);
                        path = pf.pathNavigatorUsingStack(chessboard);
                        System.out.println(path.toString());
                        chessboard.followPath(path);
                        System.out.println(chessboard.toString());
                    }
                    break;
                case 5:
                    {
                        // Task #2: Test pathNavigatorUsingStack with sample chessboard 5
                        DLLPath path;
                        PathNavigator pf = new PathNavigator();

                        chessboard = new Chessboard(ChessboardSamples.sChessboard5);
                        path = pf.pathNavigatorUsingStack(chessboard);
                        System.out.println(path.toString());
                        chessboard.followPath(path);
                        System.out.println(chessboard.toString());
                    }
                    break;
                case 6:
                    {
                        // Task #2: Test pathNavigatorUsingStack with sample chessboard 6
                        DLLPath path;
                        PathNavigator pf = new PathNavigator();

                        chessboard = new Chessboard(ChessboardSamples.sChessboard6);
                        path = pf.pathNavigatorUsingStack(chessboard);
                        System.out.println(path.toString());
                        chessboard.followPath(path);
                        System.out.println(chessboard.toString());
                    }
                    break;
                default:
                    break;
            }
        }else if(task == 3){
            switch (testCase) {
                case 1:
                    {
                        // Task #3: Test pathNavigatorUsingQueue with sample chessboard 1
                        DLLPath path;
                        PathNavigator pf = new PathNavigator();

                        chessboard = new Chessboard(ChessboardSamples.sChessboard1);
                        path = pf.pathNavigatorUsingQueue(chessboard);
                        System.out.println(path.toString());
                        chessboard.followPath(path);
                        System.out.println(chessboard.toString());
                    }
                    break;
                case 2:
                    {
                        // Task #3: Test pathNavigatorUsingQueue with sample chessboard 2
                        DLLPath path;
                        PathNavigator pf = new PathNavigator();

                        chessboard = new Chessboard(ChessboardSamples.sChessboard2);
                        path = pf.pathNavigatorUsingQueue(chessboard);
                        System.out.println(path.toString());
                        chessboard.followPath(path);
                        System.out.println(chessboard.toString());
                    }
                    break;
                case 3:
                    {
                        // Task #3: Test pathNavigatorUsingQueue with sample chessboard 3
                        DLLPath path;
                        PathNavigator pf = new PathNavigator();

                        chessboard = new Chessboard(ChessboardSamples.sChessboard3);
                        path = pf.pathNavigatorUsingQueue(chessboard);
                        System.out.println(path.toString());
                        chessboard.followPath(path);
                        System.out.println(chessboard.toString());
                    }
                    break;
                case 4:
                    {
                        // Task #3: Test pathNavigatorUsingQueue with sample chessboard 4
                        DLLPath path;
                        PathNavigator pf = new PathNavigator();

                        chessboard = new Chessboard(ChessboardSamples.sChessboard4);
                        path = pf.pathNavigatorUsingQueue(chessboard);
                        System.out.println(path.toString());
                        chessboard.followPath(path);
                        System.out.println(chessboard.toString());
                    }
                    break;
                case 5:
                    {
                        // Task #3: Test pathNavigatorUsingQueue with sample chessboard 5
                        DLLPath path;
                        PathNavigator pf = new PathNavigator();

                        chessboard = new Chessboard(ChessboardSamples.sChessboard5);
                        path = pf.pathNavigatorUsingQueue(chessboard);
                        System.out.println(path.toString());
                        chessboard.followPath(path);
                        System.out.println(chessboard.toString());
                    }
                    break;
                case 6:
                    {
                        // Task #3: Test pathNavigatorUsingQueue with sample chessboard 6
                        DLLPath path;
                        PathNavigator pf = new PathNavigator();

                        chessboard = new Chessboard(ChessboardSamples.sChessboard6);
                        path = pf.pathNavigatorUsingQueue(chessboard);
                        System.out.println(path.toString());
                        chessboard.followPath(path);
                        System.out.println(chessboard.toString());
                    }
                    break;
                default:
                    break;
            }

        }
        
        
        
        
        
    }

    public static DLLPath buildPath(Chessboard chessboard, Move[] movs) {

        DLLPath path = new DLLPath();

        int[] currentCoords = new int[]{0, 0};  // (row, col)
        int[] nextCoords;

        path.addLast(currentCoords[0], currentCoords[1]);

        for (int i = 0; i < movs.length; i++) {
            nextCoords = chessboard.getNeighbourCoords(currentCoords[0], currentCoords[1], movs[i]);
            if (nextCoords != null) {
                path.addLast(nextCoords[0], nextCoords[1]);
            } else {
                // invalid movement: stop here
                break;
            }
            currentCoords = nextCoords;
        }

        return path;

    }
    Chessboard ch=new Chessboard(ChessboardSamples.sChessboard2);
HashTable<ChessboardStatus,ChesspoardPosition> hash=new hash<>();
ChessboardPosition ch2=new ChessboardPosition(0,0);
int i =0;
while(ch2!=null){
ChessboardStatus ch3=ch.getPosStatus(ch2);
Hashtable.add(ch3,ch2);
ch2=ch.getNeighbour(ch2,Move.RIGHT);
if(ch2==null){
    ch.getNeighbour(new ChessboardPosition(i,0), Move.DOWN);
    i++;
}
System.out.print(hash.get(ChessboardStatus.GOAL.ToString()));
}

Chessboard board = new Chessboard(ChessboardSamples.sChessboard2);
HashTable<ChessboardStatus,ChessboardPosition> hash=new Hash<>();
ChessboardPosition pos = new ChessboardPosition(0, 0);
int i=0;
while (pos!=null){
    ChessboardStatus see=board.getPosStatus(pos);
    hash.add(see,pos);
    pos=board.getNeighbour(pos, Move.Right);
    if(pos==null){
        board.getNeighbour(new ChessboardPosition(i,0,Move.DOWN);
    }
Hash.get(ChessboardStatus.GOAL.toString());
}
}
