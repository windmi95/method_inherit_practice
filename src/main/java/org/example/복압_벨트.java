package org.example;

public class 복압_벨트 extends 장비 implements 근력을_올려주는_기능 {
    int 가격 = 10000;

    int 근력을_올려준다 = 50;

    boolean 캐릭터_장비_장착;


    복압_벨트() {
        가격_설정(가격);
        set근력을_올려주는_효과_지정(근력을_올려준다);
        set캐릭터한테_장비_장착_지정(캐릭터_장비_장착);
    }

    @Override
    public void set근력을_올려주는_효과_지정(int 근력을_올려주는_효과) {
        super.set근력을_올려주는_효과_지정(근력을_올려주는_효과);
    }

    @Override
    public int get근력을_올려주는_효과_지정() {
        return super.get근력을_올려주는_효과_지정();
    }
    public void set캐릭터한테_장비_장착_지정(boolean 캐릭터_장비_장착) {
        super.set캐릭터한테_장비_장착_지정(캐릭터_장비_장착);
    }
    public boolean get캐릭터한테_장비_장착_지정() {
        return super.get캐릭터한테_장비_장착_지정();
    }

    public void 가격_설정(int 가격) {
        super.가격_설정(가격);
    }

    public int 가격_정보_가져오기() {
        return super.가격_정보_가져오기();
    }

    public void 복압벨트_장착_효과_적용하기(캐릭터 게임_캐릭터) {
        게임_캐릭터.근력  = 게임_캐릭터.근력 + 50;
    }
    public void 복압벨트_장착_효과_제거하기(캐릭터 게임_캐릭터) {
        게임_캐릭터.근력  = 게임_캐릭터.근력 - 50;
    }

    @Override
    public void 캐릭터_근력을_올려준다(캐릭터 게임_캐릭터) {
        게임_캐릭터.근력 = 게임_캐릭터.근력 + get근력을_올려주는_효과_지정();
    }
}
