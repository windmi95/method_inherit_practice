
interface 랜덤_횟수_발생 {
    public void 랜덤_횟수_생성();
}
interface 승급_심사_횟수 {
    public void 승급_횟수_지정();
}
public class mission {// 운동횟수 -> 랜덤횟수
    int 운동_횟수;

    public int get운동횟수_정하기() {
        return this.운동_횟수;
    }
    public void set운동_횟수_정하기(int 운동_횟수) {
        this.운동_횟수 = 운동_횟수;
    }
}
class quest {
    int 랜덤_횟수;
    public int get랜덤_횟수가져오기() {
        return this.랜덤_횟수;
    }
    public void set랜덤_횟수(int 랜덤_횟수) {
        this.랜덤_횟수 = 랜덤_횟수;
    }
}
