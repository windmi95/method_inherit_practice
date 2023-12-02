package org.example;

public class 복압_벨트 extends 장비 {
    int 가격 = 10000;
    boolean 캐릭터한테_장착되어있는지_여부 = false;

    int 근력을_올려준다 = 50;

    복압_벨트() {
        가격_설정(가격);
        set근력을_올려주는_효과_지정(근력을_올려준다);
    }

    @Override
    public void set근력을_올려주는_효과_지정(int 근력을_올려주는_효과) {
        super.set근력을_올려주는_효과_지정(근력을_올려주는_효과);
    }

    @Override
    public int get근력을_올려주는_효과_지정() {
        return super.get근력을_올려주는_효과_지정();
    }

    public void 가격_설정(int 가격) {
        super.가격_설정(가격);
    }

    public int 가격_정보_불러오기() {
        return 가격_정보_가져오기();
    }

    public void 복압벨트_장착_효과_적용하기(캐릭터 게임_캐릭터) {
        게임_캐릭터.근력  = 게임_캐릭터.근력 + 50;
    }
    public void 복압벨트_장착_효과_제거하기(캐릭터 게임_캐릭터) {
        게임_캐릭터.근력  = 게임_캐릭터.근력 - 50;
    }
}
