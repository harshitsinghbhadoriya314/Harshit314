import java.util.HashMap;

class Romanconvert {
  int[] value = { 1, 5, 10, 50, 100, 500, 1000 };
  String[] symbol = { "I", "V", "X", "L", "C", "D", "M" };

  public String intToRoman(int num) {
    HashMap<Integer, String> val = new HashMap<>();
    for (int i = 0; i < value.length; i++) {
      val.put(value[i], symbol[i]);
    }
    int i = (int) Math.pow(10, String.valueOf(num).length() - 1);
    String output = "";
    while (i >= 1 && num>0) {
      int pr = num / i;
      int Quanteint = (num / i) * i;
      int rem = num % i;
      if (pr == 0){
        num = rem;
        i = i/10;
        continue;
      }
      if (pr == 4 || pr == 9) {
        int newpr = Quanteint + i;
        output += val.get(i);
        output += val.get(newpr);
      } else if (pr != 4 && pr != 9) {
        int count = 0;
        while(!val.containsKey(Quanteint)){
          count += i;
          Quanteint = Quanteint - i;
        }
        output += val.get(Quanteint);
        for (int k = 0; k <= (count/i)-1;k++){
          output += val.get(i);
        }
        // int count = 0;
        // if (val.containsKey(Quanteint)) {
        //   output += val.get(Quanteint);
        // } 
        // else if (!val.containsKey(Quanteint)){
        //   count += i;
        //   Quanteint = Quanteint - i;

        // }
        // for (int k = 0; k <= (count/i)-1; k++){
        //     output += val.get(i);
        // }
      }
      num = rem;
      i = i / 10;
    }
    return output;
  }

  public static void main(String[] args) {
    Romanconvert g = new Romanconvert();
    String ok = g.intToRoman(3547);
    System.out.println(ok);
  }
}
