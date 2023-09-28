import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.util.Random;
import java.util.Scanner;

public class Game {
    static Boolean 게임_종료 = false;

    static int 현재_소지한_골드 = 5000;

    static int 현재_레벨 = 1;

    static int 체력 = 50;

    static int 근력 = 1;

    static int 메뉴_선택 = 0;

    static int 구매 = 0;

    static int 아이템_사용 = 0;

    static int bcaa = 500;

    static int 프로틴 = 500;

    static int 크레아틴 = 700;

    static int 탄수화물_보충제 = 700;

    static int 손목보호대 = 3000;

    static int 리프팅웨어 = 5000;

    static int 역도화 = 8000;

    static int 복압벨트 = 10000;

    static int 초급 = 0;

    static int 중급 = 0;

    static int 고급 = 0;

    static int 초월 = 0;

    static int 중량_선택 = 0;

    static int 경험치 = 0;

    static int 경험치양 = 0;

    static int 참여여부 = 0;

    static int 구매개수 = 0;

    public Game() {

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("");
        System.out.println("=======================프롤로그=============================");
        System.out.println("");
        System.out.println("한 날, 잠을 청하던 나는 꿈 속에서 헬스장에 도착했다.");
        System.out.println("호기심에 벨을 누르고 헬스장 안으로 들어갔다..... ");
        System.out.println("헬스장 안으로 들어가자 심상치 않은 느낌에 나가고자 했을 때 문이 잠기게 되었다.");
        System.out.println("");
        System.out.println("직원: 어서오세요. 처음 방문하시나요?");
        System.out.println("나: 네 헬스장 이용하려고 하는데 안내 부탁드립니다.");
        System.out.println("직원: 최종 승급 심사를 통과하지 못하면 여기서 빠져나올 수 없습니다.");
        System.out.println("직원: 계속 진행을 원하시면 계약서에 서명 부탁드립니다.");

        while(!게임_종료) {
            String 이름 = 계약서(scanner);
            if (!이름.equals("")) {
                System.out.println("계약서 서명 " + 이름);
                System.out.println("게임을 시작하겠습니다.");
                String 게임_메뉴 = 메뉴바();
                System.out.println(게임_메뉴);
                메뉴_선택();

            } else {
                System.out.println("게임을 종료하겠습니다.");
                break;
            }
        }
    }
    public static String 메뉴바() {
        System.out.println("");
        return ("============================게임 메뉴============================");
    }
    public static String 계약서(Scanner scanner) {
        String 서명 = scanner.nextLine();
        return 서명;
    }
    public static void 메뉴_선택() {
        System.out.println("");
        Scanner sc = new Scanner(System.in);
        System.out.println("1.운동하기 2.가방 3.의뢰 4.상점 5.퀘스트 현황 6.능력치 확인 7.장비 슬롯 8.설정 9.퀵슬롯");
        System.out.println("어떤 것을 선택하시겠습니까?");
        메뉴_선택 = sc.nextInt();
        if (메뉴_선택 == 1) {
            System.out.println("1번 운동하기를 선택하셨습니다.");
            운동하기();
        } else if (메뉴_선택 == 2) {
            System.out.println("2번 가방을 선택하셨습니다.");
        } else if (메뉴_선택 == 3) {
            System.out.println("3번 의뢰를 선택하셨습니다.");
            상점();
        } else if (메뉴_선택 == 4) {
            System.out.println("4번 상점을 선택하셨습니다.");
            퀘스트();
        } else if (메뉴_선택 == 5) {
            System.out.println("5번 퀘스트 현황을 선택하셨습니다.");
            능력치();
        } else if (메뉴_선택 == 6) {
            System.out.println("6번 능력치 확인을 선택하셨습니다.");
        } else if (메뉴_선택 == 7) {
            System.out.println("7번 장비 슬롯을 선택하셨습니다.");
        } else if (메뉴_선택 == 8) {
            System.out.println("8번 설정을 선택하셨습니다.");
        } else if (메뉴_선택 == 9) {
            System.out.println("9번 퀵슬롯을 선택하셨습니다.");
        } else {
            System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
        }
    }
    public static void 운동하기() {
        Scanner sc = new Scanner(System.in);
        중량();
        System.out.println("1.운동 실행 2.아이템 사용 3.중량 변경 4.게임에서 나가기");
        int 운동_메뉴_선택 = sc.nextInt();
        if (운동_메뉴_선택 == 1) {
            System.out.println("운동을 실행하겠습니다.");
            } else if (운동_메뉴_선택 == 2) {
                System.out.println("아이템을 사용합니다.");
                가방();
            } else if (운동_메뉴_선택 == 3) {
                System.out.println("중량을 변경합니다.");
                중량_선택 = sc.nextInt();
            } else if (운동_메뉴_선택 == 4) {
                System.out.println("게임플레이를 취소하였습니다.");
                메뉴_선택();
            } else {
                System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
            }
    }
    public static void 경험치_설정() {
        경험치 = 중량_선택 / 2;
        경험치양 = 경험치 + 경험치양;

    }
    public static void 레벨() {
        if (경험치양 > 현재_레벨 * 100) {
            현재_레벨 = 현재_레벨 + 1;
        }
    }
    public static void 이벤트() {
        Scanner sc = new Scanner(System.in);
        System.out.println("골드를 획득할 수 있는 깜짝 이벤트가 있습니다.참여를 하실 것인지 선택해주세요.");
        System.out.println("1.참여한다. 2.참가하지 않는다.");
        참여여부 = sc.nextInt();
        if (참여여부 == 1) {
            System.out.println("이벤트의 경우 랜덤으로 당첨 혹은 꽝 두 가지로 실행됩니다.");
        } else if (참여여부 == 2) {
            System.out.println("게임을 계속 진행하겠습니다.");
        } else {
            System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
        }
    }
    public static void 가방() {
        System.out.println("");
        Scanner sc = new Scanner(System.in);
        System.out.println("어떤 것을 선택하시겠습니까?");
        System.out.println("1.아이템 2.장비 착용");
        int 가방_선택 = sc.nextInt();
        if (가방_선택 == 1) {
            System.out.println("아이템을 선택하셨습니다.");
            System.out.println("1.bcaa 2.탄수화물 보충제 3.프로틴 4.크레아틴");
            아이템_사용 = sc.nextInt();
            if (아이템_사용 == 1) {
                System.out.println("bcaa를 선택하셨습니다.");
                System.out.println("체력+1이 회복되었습니다.");
                체력++;
            } else if (아이템_사용 == 2) {
                System.out.println("탄수화물 보충제를 선택하셨습니다.");
                System.out.println("체력+3이 회복되었습니다.");
                체력 = 체력+3;
            } else if (아이템_사용 == 3) {
                System.out.println("프로틴을 선택하셨습니다.");
                System.out.println("근력+1이 증가되었습니다.");
                근력 = 근력+1;
            } else if (아이템_사용 == 4) {
                System.out.println("크레아틴을 선택하셨습니다.");
                System.out.println("근력+3이 증가되었습니다.");
                근력 = 근력+3;
            } else {
                System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
            }
        } else if (가방_선택 == 2) {
            System.out.println("장비 착용을 선택하셨습니다.");
        } else {
            System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
        }
    }
    public static void 상점() {
        Scanner sc = new Scanner(System.in);
        System.out.println("어떤 것을 구매하시겠습니까?");
        System.out.println("1.bcaa 2.탄수화물 보충제 3.프로틴 4.크레아틴 5.손목 보호대 6.리프팅 웨어 7.역도화 8.복압 벨트");
        구매 = sc.nextInt();
        if (구매 == 1) {
            System.out.println("bcaa를 선택하셨습니다.");
            System.out.println("몇 개를 구매하시겠습니까?");
            구매개수 = sc.nextInt();
            int 총금액 = bcaa * 구매개수;
            if (현재_소지한_골드 > 총금액) {
                int 계산 = 현재_소지한_골드-(bcaa * 구매개수);
                System.out.println(계산);
            } else {
                System.out.println("골드가 부족합니다.");
            }
        } else if (구매 == 2) {
            System.out.println("탄수화물 보충제 몇 개를 구매하시겠습니까?");
            구매개수 = sc.nextInt();
            int 총금액 = 탄수화물_보충제 * 구매개수;
            if (현재_소지한_골드 > 총금액) {
                int 계산 = 현재_소지한_골드-(bcaa * 구매개수);
                System.out.println(계산);
            } else {
                System.out.println("골드가 부족합니다.");
            }
        } else if (구매 == 3) {
            System.out.println("프로틴을 구매하셨습니다.");
            구매개수 = sc.nextInt();
            int 총금액 = 프로틴 * 구매개수;
            if (현재_소지한_골드 > 총금액) {
                int 계산 = 현재_소지한_골드-(bcaa * 구매개수);
                System.out.println(계산);
            } else {
                System.out.println("골드가 부족합니다.");
            }
        } else if (구매 == 4) {
            System.out.println("크레아틴을 구매하셨습니다.");
            구매개수 = sc.nextInt();
            int 총금액 = 크레아틴 * 구매개수;
            if (현재_소지한_골드 > 총금액) {
                int 계산 = 현재_소지한_골드 - (bcaa * 구매개수);
                System.out.println(계산);
            } else {
                System.out.println("골드가 부족합니다.");
            }
        } else if (구매 == 5) {
            System.out.println("손목 보호대를 구매하셨습니다.");
            구매개수 = sc.nextInt();
            int 총금액 = 손목보호대 * 구매개수;
            if (현재_소지한_골드 > 총금액) {
                int 계산 = 현재_소지한_골드-(bcaa * 구매개수);
                System.out.println(계산);
            } else {
                System.out.println("골드가 부족합니다.");
            }
        } else if (구매 == 6) {
            System.out.println("리프팅 웨어를 구매하셨습니다.");
            구매개수 = sc.nextInt();
            int 총금액 = 리프팅웨어 * 구매개수;
            if (현재_소지한_골드 > 총금액) {
                int 계산 = 현재_소지한_골드-(bcaa * 구매개수);
                System.out.println(계산);
            } else {
                System.out.println("골드가 부족합니다.");
            }
        } else if (구매 == 7) {
            System.out.println("역도화를 구매하셨습니다.");
            구매개수 = sc.nextInt();
            int 총금액 = 역도화 * 구매개수;
            if (현재_소지한_골드 > 총금액) {
                int 계산 = 현재_소지한_골드-(bcaa * 구매개수);
                System.out.println(계산);
            } else {
                System.out.println("골드가 부족합니다.");
            }
        } else if (구매 == 8) {
            System.out.println("복압 벨트를 구매하셨습니다.");
            구매개수 = sc.nextInt();
            int 총금액 = 복압벨트 * 구매개수;
            if (현재_소지한_골드 > 총금액) {
                int 계산 = 현재_소지한_골드-(bcaa * 구매개수);
                System.out.println(계산);
            } else {
                System.out.println("골드가 부족합니다.");
            }
        } else {
            System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
        }
    }
    public static void 장비_슬롯() {//만약 아이템 ~을 소지하고 있을 경우 ~을 착용하고 있습니다

    }
    public static void 퀘스트() {
        System.out.println("");
    }
    public static void 승급심사() {
        if (30 <= 현재_레벨 && 현재_레벨 < 31) {
            System.out.println("중급 심사를 진행하실 수 있습니다.");
        } else if (50 <= 현재_레벨 && 현재_레벨 <51) {
            System.out.println("고급 심사를 진행하실 수 있습니다.");
        } else if (70 <= 현재_레벨 && 현재_레벨 <71) {
            System.out.println("초월 심사를 진행하실 수 있습니다.");
        }
    }

    public static void 능력치() {
        Random 퀘스트_설정 = new Random();
        int 랜덤_퀘스트 = 퀘스트_설정.nextInt(2);

    }
    public static void 중량() {
        if(1 <= 현재_레벨 && 현재_레벨 < 11) {
            Scanner sc = new Scanner(System.in);
            System.out.println("중량 1 ~ 10를 입력해주세요.");
            중량_선택 = sc.nextInt();
            System.out.println(중량_선택+"kg를 선택하셨습니다.");
            System.out.println("운동 장소로 이동하겠습니다.");
        } else if (11 <= 현재_레벨 && 현재_레벨 < 51) {
            Scanner sc = new Scanner(System.in);
            System.out.println("중량 1 ~ 50을 입력해주세요.");
            중량_선택 = sc.nextInt();
            System.out.println(중량_선택+"kg를 선택하셨습니다.");
            System.out.println("운동 장소로 이동하겠습니다.");
        } else if (51 <= 현재_레벨 && 현재_레벨 < 71) {
            Scanner sc = new Scanner(System.in);
            System.out.println("중량 1 ~ 70을 입력해주세요.");
            중량_선택 = sc.nextInt();
            System.out.println(중량_선택+"kg를 선택하셨습니다.");
            System.out.println("운동 장소로 이동하겠습니다.");
        } else if (71 <= 현재_레벨 && 현재_레벨 < 100) {
            Scanner sc = new Scanner(System.in);
            System.out.println("중량 1 ~ 100을 입력해주세요.");
            중량_선택 = sc.nextInt();
            System.out.println(중량_선택+"kg를 선택하셨습니다.");
            System.out.println("운동 장소로 이동하겠습니다.");
        } else {
            System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
        }
    }
}