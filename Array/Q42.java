import java.util.Arrays;
public class Q42 {
    public void trap(int[] height) {
      Arrays.sort(height);
      for (int i = 0;i < height.length;i++){
        System.out.println(height[i]);
      }    
    }    
    public static void main(String[] args) {
        Q42 nna= new Q42();
        int [] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        nna.trap(arr);
    }
}
