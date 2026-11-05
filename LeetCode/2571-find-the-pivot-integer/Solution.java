class Solution {
    public int pivotInteger(int n) {
        int[] pref = new int[n];
        int[] suff = new int[n];
        pref[0] = 1;
        suff[n - 1] = n;
        for (int i = 1; i < pref.length; i++) {
            pref[i] = pref[i-1] + (i+1);
        }
        for (int i = n - 2; i > 0; i--) {
            suff[i] = suff[i + 1] + (i + 1);
        }
        for (int j = 0; j < suff.length; j++) {
            if (suff[j] == pref[j]) {
                return j+1;
            }
        }
        return -1;
    }
}