package leetcode;

public class day12整数转罗马数字 {
    public String intToRoman(int num) {
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rom={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<values.length;i++){
           while(num>=values[i]){
               sb.append(rom[i]);
               num=num-values[i];
           }
            if (num == 0) {//相当于剪枝操作。num为0后续循环不再执行
                break;
            }
        }

        return sb.toString();
    }
}
