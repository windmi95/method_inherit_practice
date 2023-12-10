package org.example;

//소모품을 사고 팔 수 있는 클래스
public class 소모품_상점 {
    bcaa bcaa;
    탄수화물_보충제 탄수화물_보충제;
    프로틴 프로틴;
    크레아틴 크레아틴;
    boolean 소모품_상점_이용중 = true;

    public 소모품_상점 () {
        bcaa = new bcaa();
        탄수화물_보충제 = new 탄수화물_보충제();
        프로틴 = new 프로틴();
        크레아틴 = new 크레아틴();
    }
    public void 소모품_목록() {
        System.out.println("1.bcaa 2.탄수화물 보충제 3.프로틴 4.크레아틴");
        System.out.println("어떤 것을 구매하시겠습니까?");
    }
    public void 소모품_개수체크() {
        System.out.println("몇 개를 구매하시겠습니까?");
    }
    public void 소모품_구매(int 소모품_구매_선택_번호,int 소모품_구매_개수,캐릭터 게임_캐릭터,가방 내가방) {
        if (소모품_구매_선택_번호 == 1) {
            System.out.println("현재 소지하고 있는 골드 -> " + 게임_캐릭터.보유한_골드);
            int 총금액 = this.bcaa.가격 * 소모품_구매_개수;
            if (게임_캐릭터.보유한_골드 >= 총금액) {//구매가능
                System.out.println("필요한 골드 -> " + 총금액);
                //구매했으므로 차감
                게임_캐릭터.보유한_골드 = 게임_캐릭터.보유한_골드 - 총금액;
                System.out.println("현재 소지하고 있는 골드 -> " + 게임_캐릭터.보유한_골드);
                for (int i = 0; i < 소모품_구매_개수; i++) {
                    내가방.bcaa_list.add(new bcaa());
                }
            } else {//살 수 없을때
                System.out.println("골드가 부족합니다.");
                boolean 소모품_상점_이용중 = false;
            }
        } else if (소모품_구매_선택_번호 == 2) {
            System.out.println("현재 소지하고 있는 골드 -> " + 게임_캐릭터.보유한_골드);
            int 총금액 = this.탄수화물_보충제.가격 * 소모품_구매_개수;
            if (게임_캐릭터.보유한_골드 >= 총금액) {
                System.out.println("필요한 골드 -> " + 총금액);
                //구매했으므로 차감
                게임_캐릭터.보유한_골드 = 게임_캐릭터.보유한_골드 - 총금액;
                System.out.println("현재 소지하고 있는 골드 -> " + 게임_캐릭터.보유한_골드);
                for (int i = 0; i < 소모품_구매_개수; i++) {
                    내가방.탄수화물_보충제_list.add(new 탄수화물_보충제());
                }
            } else {
                System.out.println("골드가 부족합니다.");
                boolean 소모품_상점_이용중 = false;

            }
        } else if (소모품_구매_선택_번호 == 3) {
            System.out.println("현재 소지하고 있는 골드 -> " + 게임_캐릭터.보유한_골드);
            int 총금액 = this.프로틴.가격 * 소모품_구매_개수;
            if (게임_캐릭터.보유한_골드 >= 총금액) {
                System.out.println("필요한 골드 -> " + 총금액);
                //구매했으므로 차감
                게임_캐릭터.보유한_골드 = 게임_캐릭터.보유한_골드 - 총금액;
                System.out.println("현재 소지하고 있는 골드 -> " + 게임_캐릭터.보유한_골드);
                System.out.println("");
                for (int i = 0; i < 소모품_구매_개수; i++) {
                    내가방.프로틴_list.add(new 프로틴());
                }
            } else {
                System.out.println("골드가 부족합니다.");
                boolean 소모품_상점_이용중 = false;

            }
        } else if (소모품_구매_선택_번호 == 4) {
            System.out.println("현재 소지하고 있는 골드 -> " + 게임_캐릭터.보유한_골드);
            int 총금액 = this.크레아틴.가격 * 소모품_구매_개수;
            if (게임_캐릭터.보유한_골드 >= 총금액) {
                System.out.println("필요한 골드 -> " + 총금액);
                //구매했으므로 차감
                게임_캐릭터.보유한_골드 = 게임_캐릭터.보유한_골드 - 총금액;
                System.out.println("현재 소지하고 있는 골드 -> " + 게임_캐릭터.보유한_골드);
                for (int i = 0; i < 소모품_구매_개수; i++) {
                    내가방.크레아틴_list.add(new 크레아틴());
                }
            } else {
                System.out.println("골드가 부족합니다.");
            }
        } else {
            System.out.println("잘 못 입력하셨습니다.");
            boolean 소모품_상점_이용중 = false;
        }
    }
}