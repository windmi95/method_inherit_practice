import java.util.Scanner;
//게임을 진행하는 클래스
public class 플레이 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        게임운영 게임_진행 = new 게임운영();
        체육관 체육관 = new 체육관();
        캐릭터 게임_캐릭터 = new 캐릭터();
        이벤트 게임_이벤트 = new 이벤트();
        헬스장_관장 퀘스트 = new 헬스장_관장();
        소모품_상점 소모품상점 = new 소모품_상점();
        장비_상점 장비_상점 = new 장비_상점();
        가방 가방 = new 가방();

        게임_진행.프롤로그();
        System.out.println(게임_진행.캐릭터_이름_작성(scanner.next()) + "님 게임을 진행하겠습니다.");

        while (!게임_진행.게임_종료) {
            게임_진행.메인_메뉴();
            int 메인_메뉴_선택 = 게임_진행.메인_메뉴_선택(scanner.nextInt());
            if (메인_메뉴_선택 == 1) {
                체육관.운동_메뉴();
                int 운동_메뉴_선택 = 체육관.운동_메뉴_선택(scanner.nextInt());
                while (!게임_진행.운동_종료) {
                    if (운동_메뉴_선택 == 1) {
                        int 들고자_하는_바벨_중량선택 = scanner.nextInt();
                        boolean 중량들수_있는여부 = 체육관.선택할_수_있는_무게체크(들고자_하는_바벨_중량선택, 게임_캐릭터.레벨, 게임_캐릭터.등급);
                        if (중량들수_있는여부) {
                            게임_캐릭터.중량_선택 = 들고자_하는_바벨_중량선택;
                        } else {
                            System.out.println("들 수 없는 중량을 선택하셨습니다.");
                        }
                        게임_이벤트.이벤트_실행();
                        게임_캐릭터.경험치_설정();
                        게임_캐릭터.체력_설정();
                    } else if (운동_메뉴_선택 == 2) {
                        가방.아이템_목록();
                        int 사용할_아이템_선택 = scanner.nextInt();

                    } else if (운동_메뉴_선택 == 3) {
                        int 들고자_하는_바벨_중량선택 = scanner.nextInt();
                        boolean 중량들수_있는여부 = 체육관.선택할_수_있는_무게체크(들고자_하는_바벨_중량선택, 게임_캐릭터.레벨, 게임_캐릭터.등급);
                        if (중량들수_있는여부) {
                            게임_캐릭터.중량_선택 = 들고자_하는_바벨_중량선택;
                        } else {
                            System.out.println("들 수 없는 중량을 선택하셨습니다.");
                        }
                        게임_이벤트.이벤트_실행();
                        게임_캐릭터.경험치_설정();
                        게임_캐릭터.체력_설정();
                    } else if (운동_메뉴_선택 == 4) {
                        System.out.println("메인 메뉴로 이동하겠습니다.");
                        break;
                    }
                }
            } else if (메인_메뉴_선택 == 2) {
                가방.아이템_목록();
                int 사용할_아이템_번호_선택 = scanner.nextInt();
                가방.아이템_사용(사용할_아이템_번호_선택);

            } else if (메인_메뉴_선택 == 3) {
                퀘스트.의뢰();
                퀘스트.승급심사();
            } else if (메인_메뉴_선택 == 4) {
                소모품상점.소모품_목록();
                int 소모품구매_선택_번호 = scanner.nextInt();
                소모품상점.소모품_개수체크();
                int 소모품구매개수 = scanner.nextInt();
                소모품상점.소모품_구매(소모품구매_선택_번호, 소모품구매개수, 게임_캐릭터, 가방);
            } else if (메인_메뉴_선택 == 5) {
                장비_상점.장비_목록();
                int 장비_구매_선택_번호 = scanner.nextInt();
                장비_상점.장비구매(장비_구매_선택_번호,게임_캐릭터.등급,게임_캐릭터);
            } else if (메인_메뉴_선택 == 6) {

            } else if (메인_메뉴_선택 == 7) {

            } else if (메인_메뉴_선택 == 8) {

            } else if (메인_메뉴_선택 == 9) {

            }
        }
    }
}