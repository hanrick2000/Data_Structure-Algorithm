package niuke;

public class JumpFloorII {
    public int JumpFloorII_1(int target) {
        if (target <= 0){
            return -1;
        }else if (target == 1){
            return 1;
        }else {
            return 2*JumpFloorII_1(target-1);
        }
    }
}
