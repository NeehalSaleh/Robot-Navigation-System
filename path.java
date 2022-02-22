

public class path {
    private static final Move[] DIRS_TO_EXPLORE = new Move[]{
        Move.LEFT,
        Move.UP,
        Move.DOWN,
        Move.RIGHT
    };

    public DLLPath pathNavigatorUsingStack(Chessboard chessboard) {
                 
        final ChessboardPosition initPos = new ChessboardPosition(0, 0, null);
        LinkedStack<ChessboardPosition> posToExplore = new LinkedStack<ChessboardPosition>();
        
        // Write your code here ..
        
       
               ChessboardPosition currentPosition=initPos;
        //طھط­ط¯ظٹط¯ ط§ظ„ظ…ط³ط§ط± ظ…ظ† ط§ظ„ط¨ط¯ط§ظٹط© ط§ظ„ظ‰ ظ†ظ‚ط·ط© ط§ظ„ط¬ظˆظ„
        while(currentPosition != null && chessboard.getPosStatus(currentPosition) != ChessboardStatus.GOAL) { 
           
            if(chessboard.getPosStatus(currentPosition) != ChessboardStatus.VISITED){
                chessboard.setPosStatus(currentPosition, ChessboardStatus.VISITED); 
                ChessboardPosition[] validNeighbours = GetValidNeighbours(chessboard, currentPosition);  
              //=====================ط§ظ„ط¬ظٹط±ط§ظ† ط§ظ„ظ…ط­طھظ…ظ„ ط²ظٹط§ط±طھظ‡ظ…=========================
                for (int i = 0; i < validNeighbours.length; i++) {
                    posToExplore.push(validNeighbours[i]);              
                } 
                           }   
              //=====================ظ†ظ‚ط·ط© ط§ظ†ط·ظ„ط§ظ‚ ط¬ط¯ظٹط¯ط©=========================

            currentPosition = posToExplore.pop();
        }
        //=============================================
                DLLPath path = new DLLPath();
        if(currentPosition != null && chessboard.getPosStatus(currentPosition) == ChessboardStatus.GOAL){
            ChessboardPosition pos = currentPosition;
           
            path.addFirst(pos.getCoords()[0], pos.getCoords()[1]);
           
            pos = currentPosition.from;
            
            
            while(pos != null){
                path.addFirst(pos.getCoords()[0], pos.getCoords()[1]);
                pos = pos.from;
            }            
        }
        
        return path; // TO DO: modify appropriately    


        // TO DO: modify appropriately
    
    }

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
        ChessboardPosition currentPosition = posToExplore.dequeue();
        while(currentPosition != null && chessboard.getPosStatus(currentPosition) != ChessboardStatus.GOAL) { 
            if(chessboard.getPosStatus(currentPosition) != ChessboardStatus.VISITED){
                chessboard.setPosStatus(currentPosition, ChessboardStatus.VISITED); 
                ChessboardPosition[] validNeighbours = GetValidNeighbours(chessboard, currentPosition);  
                for (int i = 0; i < validNeighbours.length; i++) {
                    posToExplore.enqueue(validNeighbours[i]);              
                } 
            }
            currentPosition = posToExplore.dequeue();
        }
     
        DLLPath path = new DLLPath();
        if(currentPosition != null && chessboard.getPosStatus(currentPosition) == ChessboardStatus.GOAL){
            ChessboardPosition pos = currentPosition;
            path.addFirst(pos.getCoords()[0], pos.getCoords()[1]);
            pos = currentPosition.from;
            while(pos != null){
                path.addFirst(pos.getCoords()[0], pos.getCoords()[1]);
                pos = pos.from;
            }            
        }
        
        return path; // TO DO: modify ap
  // TO DO: modify appropriately
        
    }
        
    
    private ChessboardPosition[] GetValidNeighbours(Chessboard chessboard, ChessboardPosition chessboardPosition) {
                
        ChessboardPosition[] neighbours = new ChessboardPosition[4];
        
//          neighbours[0] = chessboard.getNeighbour(chessboardPosition, Move.UP);        
//        neighbours[1] = chessboard.getNeighbour(chessboardPosition, Move.LEFT);
//        neighbours[2] = chessboard.getNeighbour(chessboardPosition, Move.RIGHT);
// neighbours[3] = chessboard.getNeighbour(chessboardPosition, Move.DOWN);
        //===================================================
//        neighbours[0] = chessboard.getNeighbour(chessboardPosition, DIRS_TO_EXPLORE[0]);        
//        neighbours[1] = chessboard.getNeighbour(chessboardPosition, DIRS_TO_EXPLORE[1]);
//        neighbours[2] = chessboard.getNeighbour(chessboardPosition, DIRS_TO_EXPLORE[2]);
//        neighbours[3] = chessboard.getNeighbour(chessboardPosition, DIRS_TO_EXPLORE[3]);
        
        for(int i=0;i<4;i++)
            neighbours[i]=chessboard.getNeighbour(chessboardPosition, DIRS_TO_EXPLORE[i]);
        
        LinkedQueue<ChessboardPosition> validNeighboursQueue = new LinkedQueue<ChessboardPosition>();
        for (int i = 0; i < 4; i++) {
            if(neighbours[i] != null && (chessboard.getPosStatus(neighbours[i]) == ChessboardStatus.OPEN || chessboard.getPosStatus(neighbours[i]) == ChessboardStatus.GOAL)){
                validNeighboursQueue.enqueue(neighbours[i]);
            }
        }          
      
        ChessboardPosition[] validNeighbours = new ChessboardPosition[validNeighboursQueue.length()];
        for (int i = 0; i < validNeighbours.length; i++) {
            validNeighbours[i] = validNeighboursQueue.dequeue();
        }
        return validNeighbours;
   }


}
