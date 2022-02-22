
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * 
 */
public class PathsTree {

    private PathsTreeNode root;

    /**
     * Initializes an empty tree
     */
    public PathsTree() {
        this.root = null;
    }

    /**
     * Initializes a tree starting at position (0, 0) of Chessboard chessboard
     */
    public PathsTree(Chessboard chessboard) {
        this.root = new PathsTreeNode(chessboard, new ChessboardPosition(0, 0, null));
    }

    /**
     * Initializes a tree with root at position pos of Chessboard chessboard
     */
    public PathsTree(Chessboard chessboard, ChessboardPosition pos) {
        this.root = new PathsTreeNode(chessboard, pos);
    }

    public void print() {
        print(0);
    }

    private void print(int indent) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }

        System.out.println(root.pos);
        for (PathsTree node : root.children) {
            node.print(indent + 2);
        }
    }

    public ArrayList<DLLPath> findAllPaths() {
        ArrayList<DLLPath> paths = new ArrayList<DLLPath>();
        return findAllPaths(paths);
    }

   public ArrayList<DLLPath> findAllPaths(ArrayList<DLLPath> paths) {
       
        if (root != null) {
            if(root.children.size() == 0 && root.chessboard.getPosStatus(root.pos) == ChessboardStatus.GOAL){
                DLLPath dllPath = new DLLPath();
                dllPath.addFirst(root.pos.getCoords()[0], root.pos.getCoords()[1]);
                paths.add(dllPath);
            }
            for (PathsTree child : root.children) {                
                for (DLLPath newPath : child.findAllPaths()) {
                    DLLPath dllPath = new DLLPath();
                    dllPath.addFirst(root.pos.getCoords()[0], root.pos.getCoords()[1]);
                    while(newPath.size() > 0){
                        int[] cords = newPath.removeFirst();
                        dllPath.addLast(cords[0], cords[1]);
                    }
                    paths.add(dllPath);
                }
            }

        }        
        return paths;  // TO DO: modify appropriately       
    }
   
   
//    
    /**
     * Models each node in the paths tree Contains the position of the current
     * step and references to the next possible steps
     */
    private class PathsTreeNode {
        private Chessboard chessboard;
        private ChessboardPosition pos;
        private ArrayList<PathsTree> children;

        PathsTreeNode(Chessboard chessboard, ChessboardPosition pos) {
            this.chessboard = chessboard;
            this.pos = pos;
            this.children = new ArrayList<PathsTree>();
            this.exploreAllChildren();
        }

        void exploreAllChildren() {
            /*  Task #4a: Explore all children  
            * 
            * - This method should explore all children of a PathsTreeNode.
            * - Moves priority: {LEFT, UP, RIGHT, DOWN}
            * - You can use Move.values() to get the moves.
            * - This method will explore children and add them to 'children' ArrayList as a PathsTree.
            * - If the child is OPEN then you should explore its children
            * - If the child is GOAL then you should just add it to 'children' ArrayList as a PathsTree.
            * - You shouldn't add a child to 'children' ArrayList if it's OBSTACLE or NULL
            * - You shouldn't add a child to 'children' ArrayList if it's already added in the its parents path (You can use isAncestor() method to check)
            */
            
            
            // Write your code here..
            if(chessboard.getPosStatus(pos) != ChessboardStatus.GOAL){
                for (Move value : Move.values()) {
                    ChessboardPosition newPos = chessboard.getNeighbour(pos, value);
                    if(newPos != null && !isAncestor(newPos) && 
                            (chessboard.getPosStatus(newPos) == ChessboardStatus.OPEN
                            || chessboard.getPosStatus(newPos) == ChessboardStatus.GOAL)){
                        PathsTree pathTree = new PathsTree(chessboard, newPos);
                        children.add(pathTree);
                    }
                }
            }  
            if(chessboard.getPosStatus(pos) != ChessboardStatus.GOAL){
                for (int i = 0; i < Move.values().length; i++) {
                    ChessboardPosition newPos = chessboard.getNeighbour(pos, Move.values()[i]);
                    if(newPos != null && !isAncestor(newPos) && 
                            (chessboard.getPosStatus(newPos) == ChessboardStatus.OPEN
                            || chessboard.getPosStatus(newPos) == ChessboardStatus.GOAL)){
                        PathsTree pathTree = new PathsTree(chessboard, newPos);
                        children.add(pathTree);
                    }
                }
            } 
        }

        
        /**
         * Checks whether pos is an ancestor of this
         */
        boolean isAncestor(ChessboardPosition pos) { 

            boolean res = false;
            ChessboardPosition p = this.pos;
            while (p != null) {
                if (p.equals(pos)) {
                    return true;
                }
                p = p.getFrom();
            }
            return res;

        }

    }

}