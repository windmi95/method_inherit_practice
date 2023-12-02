package org.example;

public class 리프팅웨어 extends 장비 {
    int 가격 = 5000;
    boolean 캐릭터한테_장착되어있는지_여부 = false;

    int 근력을_올려준다 = 20;

    String name = "리프팅웨어";

    리프팅웨어() {
        가격_설정(가격);
        set근력을_올려주는_효과_지정(근력을_올려준다);
    }

    public void set근력을_올려주는_효과_지정(int 근력을_올려주는_효과) {
        super.set근력을_을려주는_효과_지정(근력을_올려주는_효과);
    }
    public int get근력을_올려주는_효과_지정() {
        return get근력을_올려주는_효과_지정();
    }

    public void 가격_설정(int 가격) {
        super.가격_설정(가격);
    }
    public int 가격_정보_불러오기() {
        return super.가격_정보_가져오기();
    }

    public void 리프팅웨어_장착_효과_적용하기(캐릭터 게임_캐릭터) {
        게임_캐릭터.근력  = 게임_캐릭터.근력 + 20;
    }
    public void 리프팅웨어_장착_효과_제거하기(캐릭터 게임_캐릭터) {
        게임_캐릭터.근력  = 게임_캐릭터.근력 - 20;
    }


}

