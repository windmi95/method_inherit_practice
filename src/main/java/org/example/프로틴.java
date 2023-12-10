package org.example;

public class 프로틴 extends 물약 implements 근력을_올려주는_기능 {
    int 가격 = 500;

    int 근력_올려주기 = 1;

    프로틴() {
        가격_설정(가격);
        set근력을_올려주는_효과_지정(근력_올려주기);
    }

    public void set근력을_올려주는_효과_지정(int 근력_올려주는_효과) {
        super.set근력을_올려주는_효과_지정(근력_올려주는_효과);
    }

    public int get근력을_올려주는_효과_지정() {
        return super.get근력을_올려주는_효과_지정();
    }

    int 가격_정보_가져오기() {
        return super.가격_정보_가져오기();
    }

    public void 가격_설정(int 프로틴_가격) {
        super.가격_설정(가격);
    }

    @Override
    public void 캐릭터_근력을_올려준다(캐릭터 게임_캐릭터) {
        게임_캐릭터.근력  = 게임_캐릭터.근력 + get근력을_올려주는_효과_지정();
    }
}
