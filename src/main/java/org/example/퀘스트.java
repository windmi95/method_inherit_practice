package org.example;

import java.util.Random;

class 퀘스트 extends mission implements 랜덤_횟수_발생 {


    public 퀘스트() {
        set운동횟수_정하기(랜덤_횟수_생성());
    }

    @Override
    public void set운동횟수_정하기(int 운동_횟수) {
        super.set운동횟수_정하기(운동_횟수);
    }

    @Override
    public int get운동횟수_정하기() {
        return super.get운동횟수_정하기();
    }

    @Override
    public int 랜덤_횟수_생성() {
        return (new Random().nextInt(5)+1)*100;
    }

    public int 실행해야할_운동횟수_보여주기() {
        return get운동횟수_정하기();
    }
}