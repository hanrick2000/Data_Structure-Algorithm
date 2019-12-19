package niuke;

public class JumpFloor {
    public int JumpFloor_1(int target) {
        if (target <= 1) {
            return 1;
        }

        return JumpFloor_1(target - 1) + JumpFloor_1(target - 2);
    }
}
