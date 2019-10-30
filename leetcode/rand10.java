package leetcode;

public class rand10 {
    public int rand10() {
        while (true){
            int num = (rand7()-1)*7 + (rand7()-1);
            if (num<40){
                return num%10+1;
            }
        }
    }

    int rand7(){
        return 1;
    }
}
