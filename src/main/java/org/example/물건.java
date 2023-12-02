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
        return 0;
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
class 손목_보호대 extends 물건 implements 근력을_올려주는_기능 {
    int 가격 = 3000;
    int 근력을_올려준다 = 10;
    private int 근력을_올려주는_효과_지정;

    손목_보호대() {
        가격_설정(가격);
        set근력을_올려주는_효과_지정(근력을_올려준다);
    }

    @Override
    public void 캐릭터_근력을_올려준다(캐릭터 게임_캐릭터) {
        게임_캐릭터.근력 = 게임_캐릭터.근력 + get근력을_올려주는_효과_지정();
    }

    @Override
    int 가격_정보_가져오기() {
        return super.가격_정보_가져오기();
    }

    @Override
    void 가격_설정(int 가격) {
        super.가격_설정(가격);
    }

    public void set근력을_올려주는_효과_지정(int 근력을_올려주는_효과_지정) {
        this.근력을_올려주는_효과_지정 = 근력을_올려주는_효과_지정;
    }

    public int get근력을_올려주는_효과_지정() {
        return 근력을_올려주는_효과_지정;
    }
}
class 리프팅_웨어 extends 물건 implements 근력을_올려주는_기능{
    int 가격 = 5000;

    int 근력을_올려준다 = 20;

    private int 근력을_올려주는_효과_지정;

    리프팅_웨어() {
        가격_설정(가격);
        set근력을_올려주는_효과_지정(근력을_올려준다);
    }

    private void set근력을_올려주는_효과_지정(int 근력을_올려준다) {
        this.근력을_올려주는_효과_지정 = 근력을_올려주는_효과_지정;
    }


    @Override
    public void 캐릭터_근력을_올려준다(캐릭터 게임_캐릭터) {
        게임_캐릭터.근력 = 게임_캐릭터.근력 + get근력을_올려주는_효과_지정();

    }

    @Override
    int 가격_정보_가져오기() {
        return this.가격;
    }

    @Override
    void 가격_설정(int 가격) {
        super.가격_설정(가격);
    }

    public int get근력을_올려주는_효과_지정() {
        return 근력을_올려주는_효과_지정;
    }
}
class 신발 extends 물건 implements 근력을_올려주는_기능 {
    int 가격 = 7000;

    int 근력을_올려준다 = 30;

    private int 근력을_올려주는_효과_지정;

    신발() {
        가격_설정(가격);
        set근력을_올려주는_효과_지정(근력을_올려준다);
    }
    @Override
    public void 캐릭터_근력을_올려준다(캐릭터 게임_캐릭터) {
        게임_캐릭터.근력 = 게임_캐릭터.근력 + get근력을_올려주는_효과_지정();
    }

    @Override
    void 가격_설정(int 가격) {
        super.가격_설정(가격);
    }

    public void set근력을_올려주는_효과_지정(int 근력을_올려주는_효과_지정) {
        this.근력을_올려주는_효과_지정 = 근력을_올려주는_효과_지정;
    }

    public int get근력을_올려주는_효과_지정() {
        return 근력을_올려주는_효과_지정;
    }
}
class 벨트 extends 물건 implements 근력을_올려주는_기능 {
    int 가격 = 10000;

    int 근력을_올려준다 = 50;

    private int 근력을_올려주는_효과_지정;

    벨트() {
        가격_설정(가격);
        set근력을_올려주는_효과_지정(근력을_올려준다);
    }

    @Override
    public void 캐릭터_근력을_올려준다(캐릭터 게임_캐릭터) {

    }

    @Override
    void 가격_설정(int 가격) {
        super.가격_설정(가격);
    }

    public void set근력을_올려주는_효과_지정(int 근력을_올려주는_효과_지정) {
        this.근력을_올려주는_효과_지정 = 근력을_올려주는_효과_지정;
    }

    public int get근력을_올려주는_효과_지정() {
        return 근력을_올려주는_효과_지정;
    }
}
