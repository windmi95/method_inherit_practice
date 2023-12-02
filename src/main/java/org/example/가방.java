package org.example;

import java.awt.*;
import java.util.ArrayList;

public class 가방 {//아이템 관리하는 클래스
    int 보유한_bcaa_개수 = 5;
    int 보유한_탄수화물_보충제_개수 = 3;
    int 보유한_프로틴_개수 = 5;
    int 보유한_크레아틴_개수 = 3;
    boolean 가방_메뉴_진행중 = true;
    ArrayList<bcaa> bcaa_list;
    ArrayList 탄수화물_보충제_list;
    ArrayList 프로틴_list;
    ArrayList 크레아틴_list;
    손목보호대 손목보호대;
    리프팅웨어 리프팅웨어;
    역도화 역도화;
    복압_벨트 복압_벨트;
    bcaa bcaa;
    탄수화물_보충제 탄수화물_보충제;
    프로틴 프로틴;
    크레아틴 크레아틴;

    public 가방() {
        bcaa_list = new ArrayList<bcaa>();
        for (int i = 0; i < 보유한_bcaa_개수; i++) {
            bcaa_list.add(new bcaa());
        }
        탄수화물_보충제_list = new ArrayList<탄수화물_보충제>();
        for (int i = 0; i < 보유한_탄수화물_보충제_개수; i++) {
            탄수화물_보충제_list.add(new 탄수화물_보충제());
        }
        프로틴_list = new ArrayList<프로틴>();
        for (int i = 0; i < 보유한_프로틴_개수; i++) {
            프로틴_list.add(new 프로틴());
        }
        크레아틴_list = new ArrayList<크레아틴>();
        for (int i = 0; i < 보유한_크레아틴_개수; i++) {
            크레아틴_list.add(new 크레아틴());
        }
        손목보호대 손목보호대 = null;
        리프팅웨어 리프팅웨어 = null;
        역도화 역도화 = null;
        복압_벨트 복압벨트 = null;
        bcaa = new bcaa();
        탄수화물_보충제 = new 탄수화물_보충제();
        프로틴 = new 프로틴();
        크레아틴 = new 크레아틴();
    }
    public void 가방_메뉴() {
        System.out.println();
        System.out.println("============================================가방 메뉴 선택=======================================================");
        System.out.println("1.장비 장착하기 2.장비 장착 해제하기 3.착용한 장비 확인하기 4.소모품 사용하기 5.소모품 개수 확인 6.소모품 버리기 7.가방 메뉴에서 나가기");

    }
    public void 새로운_손목보호대를_가방에_넣는다(손목보호대 손목보호대) {
        this.손목보호대 = 손목보호대;
    }
    public void 새로운_리프팅웨어를_가방에_넣는다(리프팅웨어 리프팅웨어) {
        this.리프팅웨어 = 리프팅웨어;
    }
    public void 새로운_역도화를_가방에_넣는다(역도화 역도화) {
        this.역도화 = 역도화;
    }

    public void 새로운_복압_벨트를_가방에_넣는다(복압_벨트 복압벨트) {
        this.복압_벨트 = 복압벨트;
    }
    public boolean 장비상점에서_구매한_장비_목록보여주기() {

        if(this.손목보호대 == null && this.리프팅웨어 == null && this.역도화 == null && this.복압_벨트 == null){
            System.out.println("구매한 장비가 없습니다.");
            return false;
        }

        if (this.손목보호대 != null) {
            System.out.println("1.손목보호대");
        }

        if (this.리프팅웨어 != null) {
            System.out.println("2.리프팅웨어");
        }

        if (this.역도화 != null) {
            System.out.println("3.역도화");
        }

        if (this.복압_벨트 != null) {
            System.out.println("4.복압벨트");
        }
        return true;
    }
    public int 장착할_장비_번호_선택(int 장비_장착_번호_선택) {
        if (장비_장착_번호_선택 == 1) {
            System.out.println("손목보호대를 장착하시겠습니까?");
            System.out.println("1.장착한다 2.장착하지 않는다.");
        } else if (장비_장착_번호_선택 == 2) {
            System.out.println("리프팅웨어를 장착하시겠습니까?");
            System.out.println("1.장착한다 2.장착하지 않는다.");
        } else if (장비_장착_번호_선택 == 3) {
            System.out.println("역도화를 장착하시겠습니까?");
            System.out.println("1.장착한다 2.장착하지 않는다.");
        } else if (장비_장착_번호_선택 == 4) {
            System.out.println("복압벨트를 장착하시겠습니까?");
            System.out.println("1.장착한다 2.장착하지 않는다.");
        } else {
            System.out.println("잘 못 입력하셨습니다.");
        }
        return 장비_장착_번호_선택;
    }
    public int 가방_메뉴_선택(int 가방_메뉴_선택지) {
        switch (가방_메뉴_선택지) {
            case 1:
                System.out.println("어떤 장비를 장착하시겠습니까?");
                break;
            case 2:
                System.out.println("어떤 장비를 해체하시겠습니까?");
                break;
            case 3:
                System.out.println("어떤 장비를 확인하시겠습니까?");
                break;
            case 4:
                System.out.println("어떤 소모품을 사용하시겠습니까?");
                break;
            case 5:
                System.out.println("어떤 소모품의 개수를 확인하시겠습니까?");
                break;
            case 6:
                System.out.println("어떤 소모품을 버리시겠습니까?");
                break;
            case 7:
                System.out.println("가방 메뉴에서 나가겠습니다.");
                가방_메뉴_진행중 = false;
                break;
            default:
                System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
                가방_메뉴_진행중 = false;
                break;
        }
        return 가방_메뉴_선택지;
    }

    public void 소모품_목록() {
        System.out.println("");
        System.out.println("======================소모품 선택======================");
        System.out.println("1.bcaa 2.탄수화물 보충제 3.프로틴 4.크레아틴");
        System.out.println("어떤 소모품을 선택하시겠습니까?");
    }
    public void 소모품_사용 (int 사용할_아이템_번호_선택, 캐릭터 게임_캐릭터) {
        if (사용할_아이템_번호_선택 == 1) {
            System.out.println("bcaa를 선택하셨습니다.");
            System.out.println("");
            if (bcaa_list.isEmpty()) {
                System.out.println("bcaa가 부족하여 사용하실 수 없습니다.");
                return;
            } else {
                bcaa_list.remove(bcaa_list.size() - 1);
                bcaa.캐릭터_체력을_올려준다(게임_캐릭터);
                System.out.println("bcaa를 섭취하였습니다.");
                System.out.println("체력 +1 상승하였습니다.");
                System.out.println("현재 체력 -> "+ 게임_캐릭터.체력);
            }
            } else if (사용할_아이템_번호_선택 == 2) {
                System.out.println("탄수화물 보충제를 선택하셨습니다.");
                System.out.println("");
                if (탄수화물_보충제_list.isEmpty()) {
                    System.out.println("탄수화물 보충제가 부족하여 사용하실 수 없습니다.");
                    return;
                } else {
                    탄수화물_보충제_list.remove(탄수화물_보충제_list.size()-1);
                    탄수화물_보충제.캐릭터_체력을_올려준다(게임_캐릭터);
                    System.out.println("탄수화물 보충제를 섭취하였습니다.");
                    System.out.println("체력 +3 상승하였습니다.");
                    System.out.println("현재 체력 -> "+ 게임_캐릭터.체력);
                }
            } else if (사용할_아이템_번호_선택 == 3) {
                System.out.println("프로틴을 선택하셨습니다.");
                System.out.println("");
                if (프로틴_list.isEmpty()) {
                    System.out.println("프로틴이 부족하여 사용하실 수 없습니다.");
                    return;
                } else  {
                    프로틴_list.remove(프로틴_list.size()-1);
                    프로틴.캐릭터_근력을_올려준다(게임_캐릭터);
                    System.out.println("프로틴을 섭취하였습니다.");
                    System.out.println("근력 +1 상승하였습니다.");
                    System.out.println("현재 근력 -> "+ 게임_캐릭터.근력);
                }
            } else if (사용할_아이템_번호_선택 == 4) {
                System.out.println("크레아틴을 선택하셨습니다.");
                if (크레아틴_list.isEmpty()) {
                    System.out.println("크레아틴이 부족하여 사용하실 수 없습니다.");
                    return;
                } else {
                    크레아틴_list.remove(크레아틴_list.size()-1);
                    크레아틴.캐릭터_근력을_올려준다(게임_캐릭터);
                    System.out.println("크레아틴을 섭취하였습니다.");
                    System.out.println("근력 +3 상승하였습니다.");
                    System.out.println("현재 근력 -> "+ 게임_캐릭터.근력);
                }
            }  else {
                System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
                return;
            }
    }
    public void 소모품_체크() {
        System.out.println("남은 bcaa 개수: " + bcaa_list.size());
        System.out.println("남은 탄수화물 보충제 개수: " + 탄수화물_보충제_list.size());
        System.out.println("남은 프로틴 개수: " + 프로틴_list.size());
        System.out.println("남은 크레아틴 개수: " + 크레아틴_list.size());
    }
    public void 버릴_소모품_목록() {
        System.out.println("1.bcaa 2.탄수화물 보충제 3.프로틴 4.크레아틴");
        System.out.println("어떤 소품을 버리시겠습니까?");
    }
    public void 소모품_버리기(int 버릴_소모품_번호_선택) {
        if (버릴_소모품_번호_선택 == 1) {
            if (!bcaa_list.isEmpty()) {
                bcaa_list.remove(0);
                System.out.println("bcaa를 버렸습니다.");
            } else {
                    System.out.println("버릴 bcaa가 없습니다.");
            }
        } else if (버릴_소모품_번호_선택 == 2) {
            if (!탄수화물_보충제_list.isEmpty()) {
                탄수화물_보충제_list.isEmpty();
                System.out.println("탄수화물 보충제를 버렸습니다.");
            } else {
                System.out.println("버릴 탄수화물 보충제가 없습니다.");
            }
        } else if (버릴_소모품_번호_선택 == 3) {
            if (프로틴_list.isEmpty()) {
                System.out.println("프로틴을 버렸습니다.");
            }
            else {
                System.out.println("버릴 프로틴이 없습니다.");
            }
        } else if (버릴_소모품_번호_선택 == 4) {
            if (크레아틴_list.isEmpty()) {
                System.out.println("크레아틴을 버렸습니다.");
            }
            else {
                System.out.println("버릴 크레아틴이 없습니다.");
            }
        } else {
            System.out.println("번호를 잘 못 입력하셨습니다.");

        }
    }
}

