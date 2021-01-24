import java.util.Arrays;

public class ProblemSet8 {

    public boolean common(int[] a, int[] b) {
        if(a == null || b == null || a.length == 0 || b.length == 0){
            return false;
        }else {
            return a[0] == b[0] || a[a.length - 1] == b[b.length - 1];
        }
    }

    public int[] middleman(int[] a, int[] b) {
        if(a == null || b == null || a.length%2 == 0 || b.length%2 ==0){
            return null;
        }
        return new int[]{a[a.length/2], b[b.length/2]};
    }

    public int[] bigger(int[] a, int[] b) {
        if(a == null || b == null){
            return null;
        }
        int aSum = sum(a);
        int bSum = sum(b);
        if(bSum > aSum){
            return b;
        }
        return a;
    }

    public int[] doubleMiddle(int[] a, int[] b) {
        if(middleman(a, b) != null){
            return null;
        }
        return new int[]{a[a.length/2 - 1], a[a.length/2], b[b.length/2 - 1], b[b.length/2]};
    }

    public int[] swapMe(int[] a) {
        if (a == null){
            return null;
        }
        int first = a[0];
        a[0] = a[a.length - 1];
        a[a.length - 1] = first;
        return a;
    }

    public int[] threePoint(int[] a) {
        if(middleman(a, a) == null){
            return null;
        }
        return new int[]{a[0], a[a.length/2], a[a.length - 1]};
    }

    public int headHoncho(int[] a) {
        if(a == null || a.length == 0){
            return -1;
        }
        int max = 0;
        for(int i : a){
            if(i < 0){
                return -1;
            }
            max = Math.max(max, i);
        }
        return max;
    }

    public boolean tippingPoint(int[] a, int threshold) {
        return a != null && sum(a) >= threshold;
    }

    public String halfway(int[] a) {
        if(a == null || a.length == 0 || a.length%2 == 1){
            return null;
        }
        int leftSum = sum(Arrays.copyOfRange(a, 0, a.length/2-1));
        int rightSum = sum(Arrays.copyOfRange(a, a.length/2, a.length-2));
        if(leftSum > rightSum){
            return "LEFT";
        }
        return "RIGHT";
    }

    public int[] sequential(int[] a, int[] b) {
        if(a == null || b == null || a.length + b.length < 3){
            return null;
        }
        int x = 0;
        int[] returnArray = new int[3];
        for(int i = 0; i < 3; i ++){
            try{
                returnArray[x] = a[i];
                x++;
            }catch(IndexOutOfBoundsException e){
                break;
            }
        }
        int remainder = 3-x;
        for(int j = 0; j < remainder; j++){
            returnArray[x] = b[j];
            x++;
        }
        return returnArray;
    }

    private int sum(int[] a){
        if(a == null || a.length == 0){
            return 0;
        }
        int sum = 0;
        for(int i : a){
            sum+=i;
        }
        return sum;
    }
}
