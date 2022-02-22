
/**
 * Class PathNavigator implements algorithms for finding a path using
 a Stack or a Queue
 */
public class PathNavigator {

    private static final Move[] DIRS_TO_EXPLORE = new Move[]{
        Move.LEFT,
        Move.UP,
        Move.DOWN,
        Move.RIGHT
    };

    public DLLPath pathNavigatorUsingStack(Chessboard chessboard) {
        /*  TO DO Task #2: Stack Path Finder
         * 
         * - Create an empty Stack to store chessboard positions for future visits.
         * You can use the LinkedStack class already implemented on ADT.
         * - Start at position (0, 0)
         * - Navigate the given chessboard using depth-first search and stack till reach the goal
         * - Return DLLPath
         */
        
        final ChessboardPosition initPos = new ChessboardPosition(0, 0, null);
        LinkedStack<ChessboardPosition> posToExplore = new LinkedStack<ChessboardPosition>();
        
        // Write your code here ..
        ChessboardPosition current=initPos;
        while(current!= null && chessboard.getPosStatus(current) != ChessboardStatus.GOAL){
    if(chessboard.getPosStatus(current) != ChessboardStatus.VISITED){
        chessboard.setPosStatus(current, ChessboardStatus.VISITED); 
        ChessboardPosition[] Neighbours = BringValidNeighbours(chessboard, current);  
        int size = Neighbours.length;
        for (int i = 0; i < size; i++) {
            posToExplore.push(Neighbours[i]);              
        } 
                   }   

                   current = posToExplore.pop();
}
DLLPath path = new DLLPath();
ChessboardPosition cell = current;
while(cell.getFrom()!=null){
    path.addFirst(cell.getCoords()[0],cell.getCoords()[1]);
    cell=cell.getFrom();
    }
    path.addFirst(0, 0);
    return path;
    
  }// TO DO: modify appropriately
    
    

    public DLLPath pathNavigatorUsingQueue(Chessboard chessboard) {
         /*  Task #3: Queue Path Finder
         * 
         * - Create an empty Stack to store chessboard positions for future visits.
         * You can use the LinkedStack class already implemented on ADT.
         * - Start at position (0, 0)
         * - Navigate the given chessboard using breadth-first search and stack till reach the goal
         * - Return DLLPath
         */

        final ChessboardPosition initPos = new ChessboardPosition(0, 0, null);

        LinkedQueue<ChessboardPosition> posToExplore = new LinkedQueue<ChessboardPosition>();
        
        // Write your code here ..


        posToExplore.enqueue(initPos);
        ChessboardPosition current = posToExplore.dequeue();
        while(current!= null && chessboard.getPosStatus(current) != ChessboardStatus.GOAL){
            if(chessboard.getPosStatus(current) != ChessboardStatus.VISITED){
                chessboard.setPosStatus(current, ChessboardStatus.VISITED); 
                ChessboardPosition[] Neighbours = BringValidNeighbours(chessboard, current);  
                int size = Neighbours.length;
                for (int i = 0; i < size; i++) {
                    posToExplore.enqueue(Neighbours[i]);              
                } 
                           }   
        
                           current = posToExplore.dequeue();
        }

        DLLPath path = new DLLPath();
        ChessboardPosition cell = current;
        while(cell.getFrom()!=null){
            path.addFirst(cell.getCoords()[0],cell.getCoords()[1]);
            cell=cell.getFrom();
            }
            path.addFirst(0, 0);
            return path;  // TO DO: modify appropriately
        
    }
   
        
    
    private ChessboardPosition[] BringValidNeighbours(Chessboard chboard, ChessboardPosition chessPosition) {
                    
        ChessboardPosition[] getneighbours = new ChessboardPosition[4];
        getneighbours[0] = chboard.getNeighbour(chessPosition, DIRS_TO_EXPLORE[0]);        
              getneighbours[1] = chboard.getNeighbour(chessPosition, DIRS_TO_EXPLORE[1]);
            getneighbours[2] = chboard.getNeighbour(chessPosition, DIRS_TO_EXPLORE[2]);
            getneighbours[3] = chboard.getNeighbour(chessPosition, DIRS_TO_EXPLORE[3]);
     
//-----------------------------------------------------------------------------------------------------
            LinkedQueue<ChessboardPosition> Queue = new LinkedQueue<ChessboardPosition>();
            for (int i = 0; i < 4; i++) {
               if(getneighbours[i] != null){
                    if(chboard.getPosStatus(getneighbours[i]) == ChessboardStatus.OPEN ){
                        Queue.enqueue(getneighbours[i]);
                    }
                    if( chboard.getPosStatus(getneighbours[i]) == ChessboardStatus.GOAL){
                Queue.enqueue(getneighbours[i]);
                }}
            }  
        ChessboardPosition[] validNeighbours = new ChessboardPosition[Queue.length()];
        for (int i = 0; i < validNeighbours.length; i++) {
            validNeighbours[i] = Queue.dequeue();
        }
    return validNeighbours;
}}
//**************************************************************************************************************************************** */
   
  