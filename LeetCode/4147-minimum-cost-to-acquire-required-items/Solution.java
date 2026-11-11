class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long left = 0;
        long totalcost = (long) cost1 * need1 + (long) cost2 * need2;
        long bothcost = costBoth * (long) Math.max(need1, need2);
        if (need2 > need1) {
           left = costBoth * (long) Math.min(need1, need2) + cost2 * (long) Math.max(0, need2 - need1);
        } else {
            left = costBoth * (long) Math.min(need1, need2) + cost1 * (long) Math.max(0, need1 - need2);
        }
        totalcost = (long) Math.min(totalcost, bothcost);
        totalcost = (long) Math.min(left, totalcost);
        return totalcost;
    }
}