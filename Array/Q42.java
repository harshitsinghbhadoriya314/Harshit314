public class Q42 {
    public int trap(int [] height){
      int LeftMax = 0;
      int area = 0;
      int RightMax = 0;
      int start = 0;
      int Last = height.length-1;
      while (start < Last) {
        if(height[start] <= height[Last]){
          LeftMax = Math.max(LeftMax, height[start]);
          area += LeftMax - height[start];
          System.out.println(area);
          start++;
        }
        else{
          System.out.println(Last);
          RightMax = Math.max(RightMax, height[Last]);
          area += RightMax - height[Last];
          System.out.println("str" + area);
          Last--;
        }
      }
      return area;
    }
    public static void main(String[] args) {
    Q42 n = new Q42();
    System.out.println(n.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
   }
}
