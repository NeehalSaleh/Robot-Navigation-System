public class path2 {
    
/**
 * Class PathNavigator implements algorithms for finding a path using a Stack or
 * a Queue
 */


/* Class PathNavigator implements algorithms for finding a path using
a Stack or a Queue
*/


private static final Move[] DIRS_TO_EXPLORE = new Move[]{
Move.LEFT,
Move.UP,
Move.DOWN,
Move.RIGHT
};

public DLLPath pathNavigatorUsingStack(Chessboard chessboard) {
/* TO DO Task #2: Stack Path Finder
*
* - Create an empty Stack to store chessboard positions for future visits.
* You can use the LinkedStack class already implemented on ADT.
* - Start at position (0, 0)
* - Navigate the given chessboard using depth-first search and stack till reach the goal
* - Return DLLPath
*/

final ChessboardPosition initPos = new ChessboardPosition(0, 0, null);
LinkedStack<ChessboardPosition> posToExplore = new LinkedStack<ChessboardPosition>();

posToExplore.push(initPos);

ChessboardPosition initPos2=initPos;

while(!posToExplore.isEmpty()){

if(chessboard.getNeighbour(initPos2, Move.RIGHT)!=null &&chessboard.getPosStatus(chessboard.getNeighbour(initPos2, Move.RIGHT))!=ChessboardStatus.OBSTACLE &&
chessboard.getPosStatus(chessboard.getNeighbour(initPos2, Move.RIGHT))!=ChessboardStatus.VISITED){
if(chessboard.getPosStatus(chessboard.getNeighbour(initPos2, Move.RIGHT))!=ChessboardStatus.GOAL)
{ posToExplore.push(chessboard.getNeighbour(initPos2, Move.RIGHT));
initPos2=chessboard.getNeighbour(initPos2,Move.RIGHT);
chessboard.setPosStatus(initPos2, ChessboardStatus.VISITED);

}else{
posToExplore.push(chessboard.getNeighbour(initPos2, Move.RIGHT));
break;
}


}else if(chessboard.getNeighbour(initPos2, Move.DOWN)!=null &&chessboard.getPosStatus(chessboard.getNeighbour(initPos2, Move.DOWN))!=ChessboardStatus.OBSTACLE &&
chessboard.getPosStatus(chessboard.getNeighbour(initPos2, Move.DOWN))!=ChessboardStatus.VISITED){
if(chessboard.getPosStatus(chessboard.getNeighbour(initPos2, Move.DOWN))!=ChessboardStatus.GOAL)
{ posToExplore.push(chessboard.getNeighbour(initPos2, Move.DOWN));
initPos2=chessboard.getNeighbour(initPos2,Move.DOWN);
chessboard.setPosStatus(initPos2, ChessboardStatus.VISITED);
}
else{
posToExplore.push(chessboard.getNeighbour(initPos2, Move.DOWN));
break;
}
} else if(chessboard.getNeighbour(initPos2, Move.LEFT)!=null &&chessboard.getPosStatus(chessboard.getNeighbour(initPos2, Move.LEFT))!=ChessboardStatus.OBSTACLE &&
chessboard.getPosStatus(chessboard.getNeighbour(initPos2,Move.LEFT))!=ChessboardStatus.VISITED){
if(chessboard.getPosStatus(chessboard.getNeighbour(initPos2, Move.LEFT))!=ChessboardStatus.GOAL)
{ posToExplore.push(chessboard.getNeighbour(initPos2, Move.LEFT));
initPos2=chessboard.getNeighbour(initPos2,Move.LEFT);
chessboard.setPosStatus(initPos2, ChessboardStatus.VISITED);}
else{
posToExplore.push(chessboard.getNeighbour(initPos2, Move.LEFT));
break;
}
} else if(chessboard.getNeighbour(initPos2, Move.UP)!=null && chessboard.getPosStatus(chessboard.getNeighbour(initPos2, Move.UP))!=ChessboardStatus.OBSTACLE &&
chessboard.getPosStatus(chessboard.getNeighbour(initPos2, Move.UP))!=ChessboardStatus.VISITED){
if(chessboard.getPosStatus(chessboard.getNeighbour(initPos2, Move.UP))!=ChessboardStatus.GOAL)
{ posToExplore.push(chessboard.getNeighbour(initPos2, Move.UP));
initPos2=chessboard.getNeighbour(initPos2,Move.UP);
chessboard.setPosStatus(initPos2, ChessboardStatus.VISITED);
}
else{
posToExplore.push(chessboard.getNeighbour(initPos2, Move.UP));
break;
}


} else{
if(!posToExplore.isEmpty())
initPos2=posToExplore.pop();
else
break;

}

}
DLLPath path = new DLLPath();
ChessboardPosition cell = initPos2;
if(initPos2 != null && chessboard.getPosStatus(initPos2) == ChessboardStatus.GOAL){

path.addFirst(cell.getCoords()[0], cell.getCoords()[1]);
   
cell = initPos2.from;


while(cell != null){
path.addFirst(cell.getCoords()[0], cell.getCoords()[1]);
cell = cell.from;
}            
}

return path;}

public DLLPath pathNavigatorUsingQueue(Chessboard chessboard) {
/* Task #3: Queue Path Finder
*
* - Create an empty Stack to store chessboard positions for future visits.
* You can use the LinkedStack class already implemented on ADT.
* - Start at position (0, 0)
* - Navigate the given chessboard using breadth-first search and stack till reach the goal
* - Return DLLPath
*/

final ChessboardPosition initPos = new ChessboardPosition(0, 0, null);

LinkedQueue<ChessboardPosition> posToExplore = new LinkedQueue<ChessboardPosition>();

posToExplore.enqueue(initPos);
DLLPath dl=new DLLPath();
ChessboardPosition initPos2=initPos;

while(!posToExplore.isEmpty()){
initPos2=posToExplore.dequeue();

if(chessboard.getPosStatus(initPos2)==ChessboardStatus.GOAL)
{
break;
}else{
chessboard.setPosStatus(initPos2, ChessboardStatus.VISITED);
}


if(chessboard.getNeighbour(initPos2, Move.DOWN)!=null&&chessboard.getPosStatus(chessboard.getNeighbour(initPos2, Move.DOWN))!=ChessboardStatus.OBSTACLE &&
chessboard.getPosStatus(chessboard.getNeighbour(initPos2, Move.DOWN))!=ChessboardStatus.VISITED)

{
posToExplore.enqueue(chessboard.getNeighbour(initPos2,Move.DOWN));

}

if(chessboard.getNeighbour(initPos2, Move.RIGHT)!=null&&chessboard.getPosStatus(chessboard.getNeighbour(initPos2, Move.RIGHT))!=ChessboardStatus.OBSTACLE &&
chessboard.getPosStatus(chessboard.getNeighbour(initPos2, Move.RIGHT))!=ChessboardStatus.VISITED)

{
posToExplore.enqueue(chessboard.getNeighbour(initPos2, Move.RIGHT));


}
if(chessboard.getNeighbour(initPos2, Move.LEFT)!=null&&chessboard.getPosStatus(chessboard.getNeighbour(initPos2, Move.LEFT))!=ChessboardStatus.OBSTACLE &&
chessboard.getPosStatus(chessboard.getNeighbour(initPos2,Move.LEFT))!=ChessboardStatus.VISITED)

{ posToExplore.enqueue(chessboard.getNeighbour(initPos2, Move.LEFT));

}
if(chessboard.getNeighbour(initPos2, Move.UP)!=null&&chessboard.getPosStatus(chessboard.getNeighbour(initPos2, Move.UP))!=ChessboardStatus.OBSTACLE &&
chessboard.getPosStatus(chessboard.getNeighbour(initPos2, Move.UP))!=ChessboardStatus.VISITED)

{ posToExplore.enqueue(chessboard.getNeighbour(initPos2, Move.UP));

initPos2=chessboard.getNeighbour(initPos2,Move.UP);

}






}

DLLPath path = new DLLPath();
ChessboardPosition cell = initPos2;
if(initPos2 != null && chessboard.getPosStatus(initPos2) == ChessboardStatus.GOAL){

path.addFirst(cell.getCoords()[0], cell.getCoords()[1]);
   
cell = initPos2.from;


while(cell != null){
path.addFirst(cell.getCoords()[0], cell.getCoords()[1]);
cell = cell.from;
}            
}

return path;}
}
