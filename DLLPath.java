
public class DLLPath {

   private PathStepNode head;
   private PathStepNode tail;
   private int size;

   public DLLPath() {
       this.head = null;
       this.tail = null;
       this.size = 0;
   }

   public int size() {
       return size;
   }

   public void addFirst(int row, int col) {
       PathStepNode n = new PathStepNode(row, col);
       if (this.head == null) {  // empty list
           this.head = n;
           this.tail = n;
       } else {  // non-empty list
           n.setNext(head);
           head.setPrev(n);
           head = n;
       }
       size++;
   }

   public void addLast(int row, int col) {
       // TO DO (Task #1 - c)
       // Adding last node in DLL
       
       // Write your code here ..
       PathStepNode n = new PathStepNode(row, col);
       if (this.head == null) {  // empty list
        this.head = n;
        this.tail = n;
    } else {  // non-empty list
        head.setPrev(tail);
        tail.setNext(n);
        tail = n;
    }
    size++;
}
       
   

   public int[] removeFirst() {
       // TO DO (Task #1 - d)
       // Removing first node in DLL
       
       int[] coords = null;

       // Write your code here ..
       if(size!=0){
        PathStepNode cur =head;
        if(head.getNext()==null){
            head=null;
            tail=null;}
            else{
                head=head.getNext();
                head.setPrev(null);
            }
            size--;
            coords = new int[2];
            coords[0]= cur.getRow() ;
           coords[1]= cur.getCol();
        }
       
       return coords;
   }

   public int[] removeLast() {
       // TO DO (Task #1 - d)
       // Removing last node in DLL
       
       int[] coords = null;

       // Write your code here ..
       if(size!=0){
        PathStepNode cur =tail;
        if(head.getNext()==null){
            head=null;
            tail=null;}
            else{
                tail=tail.getPrev();
                tail.setNext(null);
            }
            size--;
            coords = new int[2];
            coords[0]= cur.getRow() ;
           coords[1]= cur.getCol();
        }
       
       return coords;
   }

  

   /**
    * Text-based representation of DLLPath.
    * with the format: (row1, col1), (row2, col2), ..., (rowN, colN)
    */
   public String toString() {

       String sPath = "";
       PathStepNode s = null;

       if (head != null) {
           sPath = "(" + head.getRow() + ", " + head.getCol() + ")";
           s = head.getNext();
       }
       while (s != null) {
           sPath = sPath + ", " + "(" + s.getRow() + ", " + s.getCol() + ")";
           s = s.getNext();
       }

       return sPath;
   }


   /* 
    * Compares two DLLPaths.
    * Two DLLPaths are equals if they containing the same sequence of steps. 
    */
   public boolean equals(Object o) {

       DLLPath otherPath = (DLLPath) o;

       if (this.size != otherPath.size) {
           return false;
       }

       PathStepNode s = head;
       PathStepNode os = otherPath.head;

       while ((s != null) && (os != null)) {
           if ((s.getRow() != os.getRow()) || (s.getCol() != os.getCol())) {
               return false;
           }
           s = s.getNext();
           os = os.getNext();
       }

       return s == os;

   }

}