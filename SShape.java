public class SShape {
  int colOrigin;  
  int rowOrigin;
  int col0;
  int row0;
  int col1;
  int row1;
  int col2;
  int row2;
  int direction; // 0: EAST 1: SOUTH 2: WEST 3: NORTH
  Grid grid;
  
  public void initPointsFromOrigin(int initCol, int initRow) {
    colOrigin = initCol;
    rowOrigin = initRow;
    col0 = initCol - 1;
    row0 = initRow;
    col1 = initCol;
    row1 = initRow - 1;
    col2 = initCol + 1;
    row2 = initRow - 1;
    direction = 0;
  }
  
  public boolean moveDown() {
    boolean left =
      grid.isEmpty(col0, row0 + 1) &&
      grid.isInBounds(col0, row0 + 1);
    boolean down =
      grid.isEmpty(colOrigin, rowOrigin + 1) &&
      grid.isInBounds(colOrigin, rowOrigin + 1);
    boolean right =
      grid.isEmpty(col2, row2 + 1) &&
      grid.isInBounds(col2, row2 + 1);
      
    if (left && down && right) {
      ++rowOrigin;
      ++row0;
      ++row1;
      ++row2;

      return true;
    }
      
    return false;
  }
  
  public boolean moveLeft() {
    
    if (direction == 0) {
    boolean left0 =
      grid.isEmpty(col0 - 1, row0) &&
      grid.isInBounds(col0 - 1, row0);
    boolean left1 =
    grid.isEmpty(col1-1,row1) &&
    grid.isInBounds(col1 - 1, row1);
    
    if (left0 && left1) {
      --colOrigin;
      --col0;
      --col1;
      --col2;
      
      return true;
     }
    } else if (direction == 1) {
      boolean left0 =
        grid.isEmpty(col0 - 1, row0) &&
        grid.isInBounds(col0 - 1, row0);
      boolean leftOrigin =
        grid.isEmpty(colOrigin - 1, rowOrigin) &&
        grid.isInBounds(colOrigin - 1, rowOrigin);
      boolean left2 = 
        grid.isEmpty(col2 - 1, row2) &&
        grid.isInBounds(col2 - 1, row2);
      if(left0 && leftOrigin && left2){
        --col0;
        --colOrigin;
        --col2;
        --col1;
        return true;
      }
      
    } else if (direction == 2) {
      boolean left2 = 
        grid.isEmpty(col2 -1, row2) &&
        grid.isInBounds(col2 -1, row2);
      boolean leftOrigin =
        grid.isEmpty(colOrigin - 1, rowOrigin) &&
        grid.isInBounds(colOrigin - 1, rowOrigin);
      if(left2 && leftOrigin){
        --col0;
        --colOrigin;
        --col2;
        --col1;
        return true;
      }
    } else if (direction == 3) {
      boolean left2 =
        grid.isEmpty(col2 - 1, row2) &&
        grid.isInBounds(col2 - 1, row2);
      boolean left1 =
        grid.isEmpty(col1 - 1, row1) &&
        grid.isInBounds(col1 - 1, row1);
      boolean left0 =
        grid.isEmpty(col0 - 1, row0)&&
        grid.isInBounds(col0 - 1, row0);
      if(left2 && left1 && left0){
        --col0;
        --colOrigin;
        --col2;
        --col1;
      return true;
      }
    }
    
    return false;
  }
  
  public boolean moveRight() {
  // ************Direction 0  ***************
    if (direction == 0) {
        boolean right2 =
          grid.isEmpty(col2 + 1, row2) &&
          grid.isInBounds(col2 + 1, row2);
        boolean rightOrigin =
          grid.isEmpty(colOrigin + 1,rowOrigin) &&
          grid.isInBounds(colOrigin + 1, rowOrigin);
        
        if (right2 && rightOrigin) {
          ++colOrigin;
          ++col0;
          ++col1;
          ++col2;
          
          return true;
         }
   // ************Direction 1  ***************

        } else if (direction == 1) {
          boolean right0 =
            grid.isEmpty(col0 + 1, row0) &&
            grid.isInBounds(col0 + 1, row0);
          boolean right1 =
            grid.isEmpty(col1 + 1, row1) &&
            grid.isInBounds(col1 + 1, row1);
          boolean right2 = 
            grid.isEmpty(col2 + 1, row2) &&
            grid.isInBounds(col2 + 1, row2);
          if(right0 && right1 && right2){
            ++col0;
            ++colOrigin;
            ++col2;
            ++col1;
          return true;
          }
      // ************Direction 2  ***************
      
        } else if (direction == 2) {
          boolean right0 = 
            grid.isEmpty(col0 + 1, row0) &&
            grid.isInBounds(col0 + 1, row0);
          boolean right1 =
            grid.isEmpty(col1 + 1, row1) &&
            grid.isInBounds(col1 + 1, row1);
          if(right0 && right1){
            ++col0;
            ++colOrigin;
            ++col2;
            ++col1;
          
            return true;
          }
        // ************Direction 3  ***************

        } else if (direction == 3) {
          boolean right2 =
            grid.isEmpty(col2 + 1, row2) &&
            grid.isInBounds(col2 + 1, row2);
          boolean rightOrigin =
            grid.isEmpty(colOrigin + 1, rowOrigin) &&
            grid.isInBounds(colOrigin + 1, rowOrigin);
          boolean right0 =
            grid.isEmpty(col0 + 1, row0)&&
            grid.isInBounds(col0 + 1, row0);
          if(right2 && rightOrigin && right0){
            ++col0;
            ++colOrigin;
            ++col2;
            ++col1;
          
            return true;
          }
        }
        
        return false;
      }
  
  public boolean rotate() {
    // TODO: do not allow the shape to rotate if the cells are not empty.
    // Use grid.isEmpty() and grid.isInBounds()
    
    if (direction == 0) {
      boolean rotate1 = 
        grid.isEmpty(col1 + 1, row1 - 1) &&
        grid.isInBounds(col1 + 1, row1 - 1);
      boolean rotate2 =
        grid.isEmpty(col2 , row2 +2) &&
        grid.isInBounds(col2 , row2 + 2); 
      if (rotate1 && rotate2){
        --row0;
        ++col0;
        ++row1;
        ++col1;
        row2 = row2 + 2;
        
        direction = 1;
      }
    } else if (direction == 1) {
      boolean rotate1 =
        grid.isEmpty(col1 - 1, row1 + 1) &&
        grid.isInBounds(col1 - 1, row1 + 1);
      boolean rotate2 =
        grid.isEmpty(col2 - 2, row2) &&
        grid.isInBounds(col2 - 2, row2);
      if (rotate1 && rotate2){
        ++row0;
        ++col0;
        --col1;
        ++row1;
        col2 = col2 - 2;
        
        direction = 2;
      }
    } else if (direction == 2) {
      boolean rotate1 =
        grid.isEmpty(col1 - 1, row1 - 1) &&
        grid.isInBounds(col1 - 1, row1 - 1);
      boolean rotate2 =
        grid.isEmpty(col2, row2 - 2) &&
        grid.isInBounds(col2, row2 - 2);
      if (rotate1 && rotate2){
        ++row0;
        --col0;
        --row1;
        --col1;
        row2 = row2 - 2;
        
        direction = 3;
      }
    } else if (direction == 3) {
      boolean rotate1 =
        grid.isEmpty(col1 + 1, row1 -1 ) &&
        grid.isInBounds(col1 + 1, row1 - 1);
      boolean rotate2 =
        grid.isEmpty(col2 + 2, row2);
        grid.isInBounds(col2 + 2, row2);
      if (rotate1 && rotate2){
        --row0;
        --col0;
        --row1;
        ++col1;
        col2 = col2 + 2;
        
        direction = 0;
      }
    }
    
    return true;
  }
}