package org.example;

interface 체력을_올려주는_기능 {
    public void 캐릭터_체력을_올려준다(캐릭터 게임_캐릭터);
}

interface 근력을_올려주는_기능 {
    public void 캐릭터_근력을_올려준다(캐릭터 게임_캐릭터);
}

public class 물건 {
    int 가격;

    int 가격_정보_가져오기() {
        return this.가격;
    }

    void 가격_설정(int 가격){
        this.가격 = 가격;
    }
}

class 물약 extends 물건 {
    int 근력을_올려주는_효과 = 0;
    int 체력을_올려주는_효과 = 0;


    public void set근력을_올려주는_효과_지정(int 근력을_올려주는_효과) {
        this.근력을_올려주는_효과 = 근력을_올려주는_효과;
    }

    public void set체력을_올려주는_효과_지정(int 체력을_올려주는_효과) {
        this.체력을_올려주는_효과 = 체력을_올려주는_효과;
    }

    public int get근력을_올려주는_효과_지정() {
        return 근력을_올려주는_효과;
    }

    public int get체력을_올려주는_효과_지정() {
        return 체력을_올려주는_효과;
    }

    @Override
    int 가격_정보_가져오기 () {
        return this.가격;
    }

    @Override
    void 가격_설정(int 가격) {
        this.가격 = 가격;
    }
}

class 장비 extends 물건 {
    int 근력을_올려주는_효과 = 0;

    public void set근력을_올려주는_효과_지정 (int 근력을_올려주는_효과) {
        this.근력을_올려주는_효과 = 근력을_올려주는_효과;
    }
    public int get근력을_올려주는_효과_지정() {
        return 근력을_올려주는_효과;
    }

    @Override
    int 가격_정보_가져오기 () {
        return this.가격;
    }

    @Override
    void 가격_설정(int 가격) {
        this.가격 = 가격;
    }

}



