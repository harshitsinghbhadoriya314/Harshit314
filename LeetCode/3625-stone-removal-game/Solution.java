// class Solution {
//     public boolean canAliceWin(int n) {
//         int alice = 0; int bob = 1;
//         int max =10;
//         int count = 0;
//         boolean ans = false;
//         while(n >= max){
//             if (count % 2 == alice){
//                 count++;
//                 n -= max;
//                 ans = true;
//                 max--;
//             }
//             else if (count % 2 == bob){
//                 count++;
//                 n -= max;
//                 ans = false;
//                 max--;
//             }
//         }
//         return ans;
//     }
// } 
class Solution {
    public boolean canAliceWin(int n) {
        int max = 10;
        int count = 0;
        while (n >= max) {
            n -= max;
            max--;
            count++;
        }
        return count % 2 != 0;
    }
}