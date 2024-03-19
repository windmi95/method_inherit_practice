package org.example;//게임 전반적인 운영을 담당하는 클래스


import javax.swing.*;

public class 게임운영 {
    boolean 게임_종료 = false;
    boolean 운동_진행중 = true;

    String 프롤로그;

    JFrame frame;
    JProgressBar progressBar;
    JButton starButton;






    public 게임운영 () {
        this.프롤로그 = "\n\n"
                +"=======================프롤로그=============================\n"
                + "한 날, 잠을 청하던 나는 꿈 속에서 헬스장에 도착했다.\n"
                + "호기심에 벨을 누르고 헬스장 안으로 들어갔다..... \n"
                + "헬스장 안으로 들어가자 심상치 않은 느낌에 나가고자 했을 때 문이 잠기게 되었다.\n"
                + "직원: 어서오세요. 처음 방문하시나요?\n"
                + "나: 네 헬스장 이용하려고 하는데 안내 부탁드립니다.\n"
                + "직원: 최종 승급 심사를 통과하지 못하면 여기서 빠져나올 수 없습니다.\n"
                + "직원: 계속 진행을 원하시면 계약서에 서명 부탁드립니다.\n"
                + "캐릭터 이름을 입력해주세요 이름: ";
    }

    public void 프롤로그_타이핑_효과() {
        for (int i = 0; i < 프롤로그.length(); i++) {
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(프롤로그.charAt(i));
        }
    }

    public void 게임로딩() {
        String 로딩_표시 = "██████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████\n";
        for(int i = 0;i<로딩_표시.length();i++) {
           try {
               Thread.sleep(10);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println(로딩_표시);
        }
    }
    /*public void 게임로딩_UI() {
        JFrame jFrame = new JFrame("게임 로딩 중 입니다....");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JProgressBar jProgressBar = new JProgressBar();
        jProgressBar.setStringPainted(true);
        frame.add(jProgressBar, BorderLayout.CENTER);

    }*/



    public String 캐릭터_이름_작성(String 캐릭터_이름) {

        return 캐릭터_이름;
    }
    public void 메인_메뉴() {
        System.out.println("");
        System.out.println("========================================메뉴 선택========================================");
        System.out.println("");
        System.out.println("1.운동하기 2.가방 3.의뢰 4.소모품 상점 5.장비 상점 6.캐릭터 스탯 7.게임 설정");
        System.out.println("어떤 것을 선택하시겠습니까?");
    }
    public int 메인_메뉴_선택(int 메인_메뉴_선택지) {
        switch (메인_메뉴_선택지) {
            case 1:
                System.out.println("1번 운동을 진행하러 이동하겠습니다.");
                break;
            case 2:
                System.out.println("2번 가방을 선택하셨습니다.");
                break;
            case 3:
                System.out.println("3번 의뢰를 받으러 이동하겠습니다.");
                break;
            case 4:
                System.out.println("4번 소모품 상점을 선택하셨습니다.");
                break;
            case 5:
                System.out.println("5번 장비 상점을 선택하셨습니다.");
                break;
            case 6:
                System.out.println("6번 캐릭터 스탯을 선택하셨습니다.");
                break;
            case 7:
                System.out.println("7번 게임 설정을 선택하셨습니다.");
                break;
            default:
                System.out.println("잘 못 입력하셨습니다.");
                break;
        }
        return 메인_메뉴_선택지;
    }
}