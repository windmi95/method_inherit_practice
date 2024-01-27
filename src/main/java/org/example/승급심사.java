package org.example;

import java.util.Random;

class 승급심사 extends mission implements 승급_심사_횟수 {

    int 초급_승급_심사_해야할_운동횟수 = 100;
    int 중급_승급_심사_해야할_운동횟수 = 300;
    int 고급_승급_심사_해야할_운동횟수 = 400;
    int 초월_승급_심사_해야할_운동횟수 = 500;


    public 승급심사(캐릭터 게임_캐릭터) {
        set운동횟수_정하기(캐릭터_등급에_따른_지정(게임_캐릭터));
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
    public int 캐릭터_등급에_따른_지정(캐릭터 게임_캐릭터) {
        if (게임_캐릭터.등급 == 1 && 게임_캐릭터.레벨 >= 30) {
            System.out.println("승급 심사를 진행하겠습니다.");
            System.out.println("실행해야 하는 중량은 10kg로 실행하며");
            System.out.println("운동 횟수 "+this.초급_승급_심사_해야할_운동횟수+"개를 실행해야 하며 랜덤으로 체력이 -3 감소됩니다.");
            System.out.println("운동 횟수를 채우지 못할 경우 다시 도전해야 합니다.");
            return this.초급_승급_심사_해야할_운동횟수;
        } else if (게임_캐릭터.등급 == 2 && 게임_캐릭터.레벨 >= 50) {
            System.out.println("승급 심사를 진행하겠습니다.");
            System.out.println("실행해야 하는 중량은 50kg로 실행하며");
            System.out.println("운동 횟수 "+this.중급_승급_심사_해야할_운동횟수+"개를 실행해야 하며 랜덤으로 체력이 -3 감소됩니다.");
            System.out.println("운동 횟수를 채우지 못할 경우 다시 도전해야 합니다.");
            return this.중급_승급_심사_해야할_운동횟수;
        } else if (게임_캐릭터.등급 == 3 && 게임_캐릭터.레벨 >= 70) {
            System.out.println("승급 심사를 진행하겠습니다.");
            System.out.println("실행해야 하는 중량은 70kg로 실행하며");
            System.out.println("운동 횟수 "+this.고급_승급_심사_해야할_운동횟수+"개를 실행해야 하며 랜덤으로 체력이 -3 감소됩니다.");
            System.out.println("운동 횟수를 채우지 못할 경우 다시 도전해야 합니다.");
            return this.고급_승급_심사_해야할_운동횟수;
        } else if (게임_캐릭터.등급 == 4 && 게임_캐릭터.레벨 >= 100) {
            System.out.println("승급 심사를 진행하겠습니다.");
            System.out.println("실행해야 하는 중량은 100kg로 실행하며");
            System.out.println("운동 횟수 "+this.초월_승급_심사_해야할_운동횟수+"개를 실행해야 하며 랜덤으로 체력이 -3 감소됩니다.");
            System.out.println("운동 횟수를 채우지 못할 경우 다시 도전해야 합니다.");
            return this.초월_승급_심사_해야할_운동횟수;
        } else{
            System.out.println("운동 횟수 0개를 실행해야 하며 랜덤으로 체력이 -3 감소됩니다.");
            System.out.println("운동 횟수를 채우지 못할 경우 다시 도전해야 합니다.");
            return 0;
        }
    }

    public void 승급_심사_진행_시_랜덤으로_운동_실행_불가능(캐릭터 게임_캐릭터) {
        Random random = new Random();
        int 랜덤으로_몇_초간_운동_실행_불가능 = random.nextInt(10);
        if (게임_캐릭터.등급 == 1) {//초급 심사
            if (랜덤으로_몇_초간_운동_실행_불가능 < 2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1초 동안 운동을 실행할 수 없습니다.");
            }
        } else if (게임_캐릭터.등급 == 2) {//중급 심사
            if (랜덤으로_몇_초간_운동_실행_불가능 < 4) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2초 동안 운동을 실행할 수 없습니다.");
            }
        } else if (게임_캐릭터.등급 == 3) {//고급 심사
            if (랜덤으로_몇_초간_운동_실행_불가능 < 6) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("3초 동안 운동을 실행할 수 없습니다.");
            }
        } else if (게임_캐릭터.등급 == 4) {//초월 심사
            if (랜덤으로_몇_초간_운동_실행_불가능 < 8) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("5초 동안 운동을 실행할 수 없습니다.");
            }
        }
    }

}

