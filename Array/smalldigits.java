class smalldigits {
    public int smallestNumber(int n, int t) {
        for (int i =0; i<= 100;i++){
            int first = n/10;
            int sec = n%10;
            int product = first*sec;
            if (n < 10){
                product = n;
            }
            if (product % t == 0){
                return n;
            }
            else{
                n++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        smalldigits val = new smalldigits();
        System.out.println(val.smallestNumber(3, 4));
    }
}