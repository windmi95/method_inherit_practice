package org.example;

//중량을 선택할 수 있는 클래스
public class 체육관 {
    int 운동횟수 = 0;
    boolean 중량_선택_성공_여부 = true;
    int 초급_심사_중량 = 10;
    int 중급_심사_중량 = 50;
    int 고급_심사_중량 = 70;
    int 초월_심사_중량 = 100;


    public void 중량_선택(int 캐릭터_레벨, int 캐릭터_등급) {
        if (캐릭터_레벨 < 31 && 캐릭터_등급 == 1) {
            System.out.println("1 ~ 10의 중량을 입력해주세요.");
        } else if (캐릭터_레벨 < 51 && 캐릭터_등급 == 2) {
            System.out.println("1 ~ 50의 중량을 입력해주세요");
        } else if (캐릭터_레벨 < 71 && 캐릭터_등급 == 3) {
            System.out.println("1 ~ 70의 중량을 입력해주세요");
        } else if (캐릭터_레벨 <= 100 && 캐릭터_등급 == 4) {
            System.out.println("1 ~ 100의 중량을 입력해주세요");
        }
    }
    public boolean 선택할_수_있는_무게체크(int 들고자_하는_바벨_중량선택, int 캐릭터_레벨, int 캐릭터_등급) {
        if (들고자_하는_바벨_중량선택 > 10 && 캐릭터_레벨 < 31) {
            System.out.println("해당 중량은 사용할 수 없습니다.");
            return false;
        } else if (들고자_하는_바벨_중량선택 > 50 && 캐릭터_레벨 < 51 && 캐릭터_등급 < 2) {
            System.out.println("해당 중량은 사용할 수 없습니다.");
            return false;
        } else if (들고자_하는_바벨_중량선택 > 70 && 캐릭터_레벨 < 71 && 캐릭터_등급 < 3) {
            System.out.println("해당 중량은 사용할 수 없습니다.");
            return false;
        } else if (들고자_하는_바벨_중량선택 > 100 && 캐릭터_레벨 < 100 && 캐릭터_등급 < 4) {
            System.out.println("해당 중량은 사용할 수 없습니다.");
            return false;
        } else {
            return true;
        }
    }
    public void 승급_심사_운동_메뉴() {
       System.out.println();
       System.out.println("======================승급 심사 메뉴 선택======================");
       System.out.println("1.운동 실행 2.아이템 사용 3.게임에서 나가기");
       System.out.println("어떤 것을 선택하시겠습니까?");
    }
    public int 승급_심사_운동_메뉴_선택(int 승급_심사_메뉴_번호_선택) {
        switch (승급_심사_메뉴_번호_선택) {
            case 1:
                System.out.println("운동을 실행하겠습니다.");
                System.out.println("");
                System.out.println("============================================");
                break;
            case 2:
                System.out.println("아이템을 사용합니다.");
                System.out.println("============================================");
                break;
            case 3:
                System.out.println("승급 심사를 중단합니다.");
                System.out.println("============================================");
                break;
            default:
                System.out.println("");
                break;
        }
        return 승급_심사_메뉴_번호_선택;
    }
    public void 운동_메뉴() {
        System.out.println();
        System.out.println("======================운동 메뉴 선택======================");
        System.out.println("1.운동 실행 2.아이템 사용 3.중량 변경하기 4.게임에서 나가기");
        System.out.println("어떤 것을 선택하시겠습니까?");
    }
    public int 운동_메뉴_선택(int 운동_메뉴_선택지) {
        switch (운동_메뉴_선택지) {
            case 1:
                System.out.println("운동을 실행합니다.");
                System.out.println("");
                System.out.println("============================================");
                break;
            case 2:
                System.out.println("아이템 사용");
                System.out.println("");
                break;
            case 3:
                System.out.println("중량을 변경합니다.");
                System.out.println("");
                break;
            case 4:
                System.out.println("메뉴로 이동합니다.");
                System.out.println("");
                break;
            default:
                System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
                break;
        }
        return 운동_메뉴_선택지;
    }

}