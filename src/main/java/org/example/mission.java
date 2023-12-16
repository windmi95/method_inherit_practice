package org.example;

// 인터페이스
interface 랜덤_횟수_발생 {
    public int 랜덤_횟수_생성();
}
interface 승급_심사_횟수 {
    public int 캐릭터_등급에_따른_지정(캐릭터 게임_캐릭터);
}

// 부모 클래스
public class mission {
    int 운동_횟수;

    public int get운동횟수_정하기() {
        return this.운동_횟수;
    }
    public void set운동횟수_정하기(int 운동_횟수) {
        this.운동_횟수 = 운동_횟수;
    }
}




