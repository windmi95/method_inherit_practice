package org.example;

public class 손목보호대 extends 장비 implements 근력을_올려주는_기능 {
    int 가격 = 3000;
    boolean 캐릭터한테_장착되어있는지_여부 = false;
    String name = "손목보호대";
    int 근력을_올려준다 = 10;

    boolean 캐릭터_장비_장착;

    손목보호대() {
        가격_설정(가격);
        set근력을_올려주는_효과_지정(근력을_올려준다);
        set캐릭터한테_장비_장착_지정(캐릭터_장비_장착);
    }

    public void set근력을_올려주는_효과_지정(int 근력을_올려주는_효과) {
        super.set근력을_올려주는_효과_지정(근력을_올려주는_효과);
    }
    public int get근력을_올려주는_효과_지정() {
        return get근력을_올려주는_효과_지정();
    }

    public void 가격_설정 (int 손목보호대_가격) {
        super.가격_설정(손목보호대_가격);
    }

    public int 가격_정보_가져오기() {
        return super.가격_정보_가져오기();
    }

    public void set캐릭터한테_장비_장착_지정(boolean 캐릭터_장비_장착) {
        super.set캐릭터한테_장비_장착_지정(캐릭터_장비_장착);
    }
    public boolean get캐릭터한테_장비_장착_지정() {
        return super.get캐릭터한테_장비_장착_지정();
    }

    public void 손목보호대_장착_효과_적용하기(캐릭터 게임_캐릭터) {
        게임_캐릭터.근력  = 게임_캐릭터.근력 + 10;
    }

    public void 손목보호대_효과_제거(캐릭터 게임_캐릭터) {
        게임_캐릭터.근력  = 게임_캐릭터.근력 - 10;
    }

    @Override
    public void 캐릭터_근력을_올려준다(캐릭터 게임_캐릭터) {
        게임_캐릭터.근력  = 게임_캐릭터.근력 + get근력을_올려주는_효과_지정();
    }
}
