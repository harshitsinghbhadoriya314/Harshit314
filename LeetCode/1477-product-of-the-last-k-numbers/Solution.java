class ProductOfNumbers {
    List<Integer> prefix;
    public ProductOfNumbers() {
        this.prefix = new ArrayList<>();
        prefix.add(1);
    }
    
    public void add(int num) {
        if (num == 0){
            this.prefix = new ArrayList<>();
            prefix.add(1);
        }
        else {
            int pr = prefix.get(prefix.size()-1);
            int npr = pr * num;
            prefix.add(npr);
        }
    }
    
    public int getProduct(int k) {
        int n = prefix.size() -1;
        if (k > n){
            return 0;
        }
        else {
            return prefix.get(n)/prefix.get(n-k);
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */