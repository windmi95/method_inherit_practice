package org.example;

public class bcaa extends 물약 implements 체력을_올려주는_기능 {
    int 가격 = 500;

    int 체력_올려주기 = 1;

    bcaa() {
        가격_설정(가격);
        set체력을_올려주는_효과_지정(체력_올려주기);
    }

    public int get체력을_올려주는_효과_지정() {
        return super.get체력을_올려주는_효과_지정();
    }
    public void set체력을_올려주는_효과_지정(int 체력_올려주는_효과) {
        super.set체력을_올려주는_효과_지정(체력_올려주는_효과);
    }

    int 가격_정보_가져오기() {
        return super.가격_정보_가져오기();
    }

    void 가격_설정(int bcaa_가격) {
        super.가격_설정(가격);
    }
    @Override
    public void 캐릭터_체력을_올려준다(캐릭터 게임_캐릭터) {
        게임_캐릭터.체력 = 게임_캐릭터.체력 + 1;
    }
}
