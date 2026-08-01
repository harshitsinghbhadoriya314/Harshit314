class Q11 {
    public int maxArea(int[] height) {
     int maxarea = 0;
     int left = 0,i = 0;
     System.out.println("left is " + left);
     int right = height.length-1;
      System.out.println("right is " + right);
     while(i< height.length){
        int min = min(height[left],height[right]);
         System.out.println("minimum" + min);
        
        int area = (right-left)*min;
         System.out.println("that is area" + area);
        if(area >= maxarea){
            maxarea = area;
             System.out.println("maxarea" + maxarea);
        }
        if(height[left] <= height[right]){
            left++;
          }
        else{
            right = height.length - i;
                  }
                  i++;
     }
    return maxarea;
    }
    public int min(int v1 , int v2){
        if (v1 <= v2){
            return v1;
        }
        return v2;
    }
    public static void main(String[] args){
      Q11 val  = new Q11();
      int[] height = {1,8,6,2,5,4,8,3,7};
      System.out.println(val.maxArea(height));
    }
}