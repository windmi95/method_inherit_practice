package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Random;

public class 캐릭터 {

    int 근력_스탯_올리기_선택_경우= 1;//캐릭터 레벨이 올라갔을 때 근력 or 체력을 선택하여 스탯을 상승시킬 경우에 사용하는 멤버 변수
    int 체력_스탯_올리기_선택_경우= 2;//캐릭터 레벨이 올라갔을 때 근력 or 체력을 선택하여 스탯을 상승시킬 경우에 사용하는 멤버 변수
    @JsonProperty("체력")
    public int 체력 = 50;
    @JsonProperty("근력")
    public int 근력 = 1;
    @JsonProperty("등급")
    int 등급 = 1;
    int 경험치양 = 0;
    int 경험치 = 0;
    int 보유한_골드 = 5000;
    int 레벨 = 30;
    int 중량_선택 = 0;
    int 스탯_포인트 = 5;
    private 손목보호대 손목보호대 = null;
    private 리프팅웨어 리프팅웨어 = null;
    private 역도화 역도화 = null;
    private 복압_벨트 복압벨트 = null;
    boolean 캐릭터_메뉴_확인중 = true;

    boolean 스텟올리기_진행중_여부 = false;

    public void 손목보호대_장착(손목보호대 손목보호대, 가방 내가방) {
        this.손목보호대 = 손목보호대;
        this.손목보호대.캐릭터한테_장착되어있는지_여부 = true;
        this.손목보호대.손목보호대_장착_효과_적용하기(this);
    }
    public void 손목보호대_벗기() {
        this.손목보호대.손목보호대_효과_제거(this);
        this.손목보호대 = null;
    }
    public void 리프팅웨어_장착(리프팅웨어 리프팅웨어, 가방 내가방) {
        this.리프팅웨어 = 리프팅웨어;
        this.리프팅웨어.캐릭터한테_장착되어있는지_여부 = true;
        this.리프팅웨어.리프팅웨어_장착_효과_적용하기(this);
    }
    public void 리프팅웨어_벗기() {
        this.리프팅웨어.리프팅웨어_장착_효과_제거하기(this);
        this.리프팅웨어 = null;
    }
    public void 역도화_장착(역도화 역도화, 가방 내가방) {
        this.역도화 = 역도화;
        this.역도화.캐릭터한테_장착되어있는지_여부 = true;
        this.역도화.역도화_장착_효과_적용하기(this);
    }
    public void 역도화_벗기() {
        this.역도화.역도화_장착_효과_제거하기(this);
        this.역도화 = null;
    }
    public void 복압벨트_장착(복압_벨트 복압벨트, 가방 내가방) {
        this.복압벨트 = 복압벨트;
        this.복압벨트.set캐릭터한테_장비_장착_지정(복압벨트.캐릭터_장비_장착);
        this.복압벨트.복압벨트_장착_효과_적용하기(this);
    }
    public void 복압벨트_벗기() {
        this.복압벨트.복압벨트_장착_효과_제거하기(this);
        this.복압벨트 = null;
    }
    public boolean 캐릭터_장착한_장비_리스트_보여주기() {
        if(this.손목보호대 == null && this.리프팅웨어 == null && this.역도화 == null && this.복압벨트 == null) {
            System.out.println("아무것도 착용중인 장비가 없습니다.");
            캐릭터_메뉴_확인중 = false;
            return  false;
        }

        if (this.손목보호대 != null && this.손목보호대.캐릭터한테_장착되어있는지_여부) {
            System.out.println("손목보호대");
        }

        if (this.리프팅웨어 != null && this.리프팅웨어.캐릭터한테_장착되어있는지_여부) {
            System.out.println("리프팅웨어");
        }

        if (this.역도화 != null && this.역도화.캐릭터한테_장착되어있는지_여부) {
            System.out.println("역도화");
        }

        if (this.복압벨트 != null && this.복압벨트.캐릭터한테_장착되어있는지_여부) {
            System.out.println("복압벨트");
        }
        return  true;
    }

    public int 캐릭터_해제할_장비_선택(int 해제할_장비_번호_선택) {
        if (해제할_장비_번호_선택 == 1) {
            System.out.println("손목보호대를 장착하시겠습니까?");
            System.out.println("1.장착 해제한다 2.장착 해제하지 않는다.");
        } else if (해제할_장비_번호_선택 == 2) {
            System.out.println("리프팅웨어를 장착하시겠습니까?");
            System.out.println("1.장착 해제한다 2.장착 해제하지 않는다.");
        } else if (해제할_장비_번호_선택 == 3) {
            System.out.println("역도화를 장착하시겠습니까?");
            System.out.println("1.장착 해제한다 2.장착 해제하지 않는다.");
        } else if (해제할_장비_번호_선택 == 4) {
            System.out.println("복압벨트를 장착하시겠습니까?");
            System.out.println("1.장착 해제한다 2.장착 해제하지 않는다.");
        } else {
            System.out.println("잘 못 입력하셨습니다.");
        }
        return 해제할_장비_번호_선택;
    }

    public boolean 캐릭터_장비_해제할_수_있는_목록_출력() {
        if (this.손목보호대 == null && this.리프팅웨어 == null && this.역도화 == null && this.복압벨트== null) {
            System.out.println("해체할 수 있는 장비가 없습니다.");
            return false;
        }

        if (this.손목보호대 != null && this.손목보호대.캐릭터한테_장착되어있는지_여부) {
            System.out.println("1.손목보호대");
        }

        if (this.리프팅웨어 != null && this.리프팅웨어.캐릭터한테_장착되어있는지_여부){
            System.out.println("2.리프팅웨어");
        }

        if (this.역도화 != null && this.역도화.캐릭터한테_장착되어있는지_여부) {
            System.out.println("3.역도화");
        }

        if (this.복압벨트 != null && this.복압벨트.캐릭터한테_장착되어있는지_여부) {
            System.out.println("4.복압벨트");
        }
        return true;
    }

    public void 캐릭터_스탯(캐릭터 게임_캐릭터) {
        System.out.println("현재 체력 => " + 체력);
        System.out.println("현재 근력 => " + 근력);
    }
    public boolean 레벨업_했는지_여부_확인() {
        if (경험치양 >= 레벨 * 100) {
            System.out.println("레벨이 상승했습니다.");
            return true;
        }
        else {
            return false;
        }
    }
    public void 레벨_상승() {
        this.레벨 = 레벨 + 1;

    }
    public void 경험치_획득() {
        int 경험치 = 중량_선택 * 2;
        경험치양 = 경험치 + 경험치양;
        System.out.println("현재 경험치 -> " + 경험치양);

    }
    public void 체력_감소() {//객체 변수에 아무런 값이 없음
        int 운동실행중_차감될_체력 = 중량_선택 - 근력;
        this.체력 = 체력 - 운동실행중_차감될_체력;
        System.out.println("남은 체력 -> "+ 체력);
    }
    public boolean 승급심사_운동_진행중_체력이_부족한_경우_메인_메뉴로_이동(체육관 체육관, 헬스장_관장 퀘스트) {
        if (this.레벨 >= 30 && this.등급 == 1) {//초급 심사
            int 초급_심사_진행중_감소될_체력 = 체육관.초급_심사_중량 - this.근력;
            if (초급_심사_진행중_감소될_체력 <= 0) {
                System.out.println("체력이 부족으로 인해 메인 메뉴로 이동합니다.");
                System.out.println("============================================");
                퀘스트.승급심사_진행중 = false;
                return false;
            }
        } else if (this.레벨 >= 50 && this.등급 == 2) {//중급 심사
            int 중급_심사_진행중_감소될_체력 = 체육관.중급_심사_중량 - this.근력;
            if (중급_심사_진행중_감소될_체력 <= 0) {
                System.out.println("체력이 부족으로 인해 메인 메뉴로 이동합니다.");
                System.out.println("============================================");
                퀘스트.승급심사_진행중 = false;
            }
        } else if (this.레벨 >= 70 && this.등급 == 3) {//고급 심사
            int 고급_심사_진행중_감소될_체력 = 체육관.고급_심사_중량 - this.근력;
            if (고급_심사_진행중_감소될_체력 <= 0) {
                System.out.println("체력이 부족으로 인해 메인 메뉴로 이동합니다.");
                System.out.println("============================================");
                퀘스트.승급심사_진행중 = false;
            }
        } else if (this.레벨 >= 100 && this.등급 == 4) {//중급 심사
            int 초월_심사_진행중_감소될_체력 = 체육관.초월_심사_중량 - this.근력;
            if (초월_심사_진행중_감소될_체력 <= 0) {
                System.out.println("체력이 부족으로 인해 메인 메뉴로 이동합니다.");
                System.out.println("============================================");
                퀘스트.승급심사_진행중 = false;
            }
        }
        return true;
    }
    public void 승급심사_진행중_랜덤_체력_차감_실행() {
        Random 승급심사_랜덤_체력_차감= new Random();
        int 승급심사_랜덤으로_체력_감소되는_확률 = 승급심사_랜덤_체력_차감.nextInt(10);
        switch (this.등급) {
            case 1: //초급일 경우
                if (승급심사_랜덤으로_체력_감소되는_확률 < 2) {//랜덤으로 운동을 실행했을 때 2보다 작은 숫자가 나오면 체력 차감
                    this.체력 = 체력 - 3;
                    System.out.println("랜덤 확률로 인해 체력이 " + 체력 + "으로 감소되었습니다.");
                }
                break;
            case 2: //중급일 경우
                if (승급심사_랜덤으로_체력_감소되는_확률 < 3) {//랜덤으로 운동을 실행했을 때 3보다 작은 숫자가 나오면 체력 차감
                    this.체력 = 체력 - 5;
                    System.out.println("랜덤 확률로 인해 체력이 " + 체력 + "으로 감소되었습니다.");
                }
                break;
            case 3://고급일 경우
                if (승급심사_랜덤으로_체력_감소되는_확률 < 4) {//랜덤으로 운동을 실행했을 때 4보다 작은 숫자가 나오면 체력 차감
                    this.체력 = 체력 - 7;
                    System.out.println("랜덤 확률로 인해 체력이 " + 체력 + "으로 감소되었습니다.");
                }
                break;
            case 4://초월일 경우
                if (승급심사_랜덤으로_체력_감소되는_확률 < 6) {//랜덤으로 운동을 실행했을 때 5보다 작은 숫자가 나오면 체력 차감
                    this.체력 = 체력 - 10;
                    System.out.println("랜덤 확률로 인해 체력이 " + 체력 + "으로 감소되었습니다.");
                }
                break;
        }
    }

    public void 승급_심사_진행중_체력_감소(체육관 체육관) {
        if (this.레벨 >= 30 && this.등급 == 1) {
            this.체력 = 체력 - (체육관.초급_심사_중량 - 근력);
            System.out.println("남은 체력 -> "+ 체력);
        } else if (this.레벨 >= 50 && this.등급 == 2) {
            this.체력 = 체력 - (체육관.중급_심사_중량 - 근력);
            System.out.println("남은 체력 -> "+ 체력);
        } else if (this.레벨 >= 70 && this.등급 == 3) {
            this.체력 = 체력 - (체육관.고급_심사_중량 - 근력);
            System.out.println("남은 체력 -> "+ 체력);
        } else if (this.레벨 >= 100 && this.등급 == 4) {
            this.체력 = 체력 - (체육관.초월_심사_중량 - 근력);
            System.out.println("남은 체력 -> "+ 체력);
        } else {
            System.out.println("체력이 부족하여 메인 메뉴로 이동하겠습니다.");
            System.out.println("");
        }
    }
    public void 스탯_올리기_선택_메뉴판() {
        System.out.println("남은 스탯포인트: " + this.스탯_포인트);
        System.out.println("1.근력 2.체력");
        System.out.println("어떤 스탯을 올릴 것인지 선택하세요.");
    }

    public void 스탯_올리기(int 스탯_번호_선택){
        if(스탯_번호_선택 == this.근력_스탯_올리기_선택_경우){
            System.out.println("근력 +1이 상승했습니다.");
            this.근력 = this.근력 + 1;
        } else if (스탯_번호_선택 == this.체력_스탯_올리기_선택_경우) {
            System.out.println("체력 +10이 상승했습니다.");
            this.체력 = this.체력 + 10;
        }
        this.스탯_포인트 = this.스탯_포인트 -1;
    }
    }
