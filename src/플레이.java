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
            if (메인_메뉴_선택 == 1) {//운동을 실행하고자 할 때 선택하는 메뉴
                int 들고자_하는_바벨_중량선택 = 0;
                boolean 중량들수_있는여부 = false;
                while (체육관.중량_선택_성공_여부) {
                    체육관.중량_선택(게임_캐릭터.레벨, 게임_캐릭터.등급);
                    들고자_하는_바벨_중량선택 = scanner.nextInt();
                    중량들수_있는여부 = 체육관.선택할_수_있는_무게체크(들고자_하는_바벨_중량선택, 게임_캐릭터.레벨, 게임_캐릭터.등급);
                    if (중량들수_있는여부) {
                        게임_캐릭터.중량_선택 = 들고자_하는_바벨_중량선택;
                        System.out.println(들고자_하는_바벨_중량선택 + "kg를 선택하셨습니다.");
                        체육관.중량_선택_성공_여부 = false;
                    } else {
                        System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요");
                    }
                }
                while (게임_진행.운동_진행중) {
                    체육관.운동_메뉴();
                    int 운동_메뉴_선택 = 체육관.운동_메뉴_선택(scanner.nextInt());
                    if (운동_메뉴_선택 == 1) {
                        체육관.운동횟수 ++;
                        System.out.println("운동횟수 => "+ 체육관.운동횟수);
                        게임_캐릭터.체력_감소();
                        게임_캐릭터.경험치_획득();
                        int event = 게임_이벤트.이벤트_실행(게임_캐릭터, 게임_진행);
                    } else if (운동_메뉴_선택 == 2) {
                        가방.소모품_목록();
                        가방.소모품_사용(scanner.nextInt());
                    } else if (운동_메뉴_선택 == 3) {
                        들고자_하는_바벨_중량선택 = 0;
                        중량들수_있는여부 = false;
                        체육관.중량_선택_성공_여부 = true;
                        while (체육관.중량_선택_성공_여부) {
                            체육관.중량_선택(게임_캐릭터.레벨, 게임_캐릭터.등급);
                            들고자_하는_바벨_중량선택 = scanner.nextInt();
                            중량들수_있는여부 = 체육관.선택할_수_있는_무게체크(들고자_하는_바벨_중량선택, 게임_캐릭터.레벨, 게임_캐릭터.등급);
                            if (중량들수_있는여부) {
                                게임_캐릭터.중량_선택 = 들고자_하는_바벨_중량선택;
                                System.out.println(들고자_하는_바벨_중량선택 + "kg를 선택하셨습니다.");
                                체육관.중량_선택_성공_여부 = false;
                            } else {
                                System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요");
                                continue;
                            }
                        }
                    } else if (운동_메뉴_선택 == 4) {
                        게임_진행.운동_진행중 = false;
                    }
                }
            } else if (메인_메뉴_선택 == 2) {//가방에서 아이템을 관리
                가방.가방_메뉴();
                int 가방_메뉴_선택_번호 = 가방.가방_메뉴_선택(scanner.nextInt());
                while (가방.가방_메뉴_진행중) {
                    if (가방_메뉴_선택_번호 == 1) {//장비 선택을 골랐을 때
                        가방.장비상점에서_구매한_장비_목록보여주기();
                        int 장착할_장비_번호_선택 = 가방.장착할_장비_번호_선택(scanner.nextInt());
                        if (가방.손목보호대 != null && 장착할_장비_번호_선택 == 1) {
                            int 장비_장착_선택_여부_선택 = scanner.nextInt();
                            if (장비_장착_선택_여부_선택 == 1) {
                                System.out.println("손목보호대를 장착하겠습니다.");
                                게임_캐릭터.손목보호대_장착(가방.손목보호대, 가방);
                                가방.손목보호대 = null;
                                break;
                            } else if (장비_장착_선택_여부_선택 == 2) {
                                System.out.println("가방 메뉴로 이동하겠습니다.");
                                break;
                            } else {
                                System.out.println("잘 못 입력하셨습니다.");
                                continue;
                            }
                        } else if (가방.리프팅웨어 != null && 장착할_장비_번호_선택 == 2) {
                            int 장비_장착_선택_여부_선택 = scanner.nextInt();
                            if (장비_장착_선택_여부_선택 == 1) {
                                System.out.println("리프팅웨어를 장착하겠습니다.");
                                게임_캐릭터.리프팅웨어_장착(가방.리프팅웨어, 가방);
                                가방.리프팅웨어 = null;
                                break;
                            } else if (장비_장착_선택_여부_선택 == 2) {
                                System.out.println("가방 메뉴로 이동하겠습니다.");
                                break;
                            } else {
                                System.out.println("잘 못 입력하셨습니다.");
                                continue;
                            }
                        } else if (가방.역도화 != null && 장착할_장비_번호_선택 == 3) {
                            int 장비_장착_선택_여부_선택 = scanner.nextInt();
                            if (장비_장착_선택_여부_선택 == 1) {
                                System.out.println("역도화를 장착하겠습니다.");
                                게임_캐릭터.역도화_장착(가방.역도화, 가방);
                                가방.역도화 = null;
                                break;
                            } else if (장비_장착_선택_여부_선택 == 2) {
                                System.out.println("가방 메뉴로 이동하겠습니다.");
                                break;
                            } else {
                                System.out.println("잘 못 입력하셨습니다.");
                                continue;
                            }
                        } else if (가방.복압_벨트 != null && 장착할_장비_번호_선택  == 4) {
                            int 장비_장착_선택_여부_선택 = scanner.nextInt();
                            if (장비_장착_선택_여부_선택 == 1) {
                                System.out.println("복압벨트를 장착하겠습니다.");
                                게임_캐릭터.복압벨트_장착(가방.복압_벨트, 가방);
                                가방.복압_벨트 = null;
                                break;
                            } else if (장비_장착_선택_여부_선택 == 2) {
                                System.out.println("가방 메뉴로 이동하겠습니다.");
                                break;
                            } else {
                                System.out.println("잘 못 입력하셨습니다.");
                                continue;
                            }
                        } else {
                            System.out.println("잘 못 입력하셨습니다.");
                            break;
                        }
                    } else if (가방_메뉴_선택_번호 == 2) {
                        while(가방.가방_메뉴_진행중) {
                            게임_캐릭터.캐릭터_장비_해제할_수_있는_목록_출력();
                            int 해제할_장비_번호_선택 = 게임_캐릭터.캐릭터_해제할_장비_선택(scanner.nextInt());
                            if (해제할_장비_번호_선택 == 1) {
                                int 장비_해제_여부_선택 = scanner.nextInt();
                                if (장비_해제_여부_선택 == 1) {
                                    System.out.println("손목보호대 장착을 해제하겠습니다.");
                                    게임_캐릭터.손목보호대_벗기();
                                } else if (장비_해제_여부_선택 == 2) {
                                    System.out.println("가방 메뉴로 이동하겠습니다.");
                                } else {
                                    System.out.println("잘 못 입력하셨습니다.");
                                    continue;
                                }
                            } else if (해제할_장비_번호_선택 == 2) {
                                int 장비_해제_여부_선택 = scanner.nextInt();
                                if (장비_해제_여부_선택 == 1) {
                                    System.out.println("리프팅웨어 장착을 해제하겠습니다.");
                                    게임_캐릭터.리프팅웨어_벗기();
                                } else if (장비_해제_여부_선택 == 2) {
                                    System.out.println("가방 메뉴로 이동하겠습니다.");
                                } else {
                                    System.out.println("잘 못 입력하셨습니다.");
                                    continue;
                                }
                            } else if (해제할_장비_번호_선택 == 3) {
                                int 장비_해제_여부_선택 = scanner.nextInt();
                                if (장비_해제_여부_선택 == 1) {
                                    System.out.println("역도화 장착을 해제하겠습니다.");
                                    게임_캐릭터.역도화_벗기();
                                } else if (장비_해제_여부_선택 == 2) {
                                    System.out.println("가방 메뉴로 이동하겠습니다.");
                                } else {
                                    System.out.println("잘 못 입력하셨습니다.");
                                    continue;
                                }
                            } else if (해제할_장비_번호_선택 == 4) {
                                int 장비_해제_여부_선택 = scanner.nextInt();
                                if (장비_해제_여부_선택 == 1) {
                                    System.out.println("복압벨트 장착을 해제하겠습니다.");
                                    게임_캐릭터.복압벨트_벗기();
                                } else if (장비_해제_여부_선택 == 2) {
                                    System.out.println("가방 메뉴로 이동하겠습니다.");
                                } else {
                                    System.out.println("잘 못 입력하셨습니다.");
                                    continue;
                                }
                            }
                        }
                    } else if (가방_메뉴_선택_번호 == 3) {
                        게임_캐릭터.캐릭터_장착한_장비_리스트_보여주기();
                        break;
                    } else if (가방_메뉴_선택_번호 == 4) {
                        가방.소모품_목록();
                        가방.소모품_사용(scanner.nextInt());
                    } else if (가방_메뉴_선택_번호 == 5) {
                        가방.소모품_체크();
                    } else if (가방_메뉴_선택_번호 == 6) {
                        가방.버릴_소모품_목록();
                        int 버릴_소모품_번호_선택 = scanner.nextInt();
                        가방.소모품_버리기(버릴_소모품_번호_선택);
                    } else if (가방_메뉴_선택_번호 == 7) {
                        가방.가방_메뉴_진행중 = false;
                    }
                }
            } else if (메인_메뉴_선택 == 3) {//퀘스트 의뢰 받으러 가기
                퀘스트.퀘스트_목록();
                int 퀘스트_번호_선택 = scanner.nextInt();
                퀘스트.퀘스트_유형_선택(퀘스트_번호_선택,게임_캐릭터.레벨,게임_캐릭터.등급);
                if (퀘스트_번호_선택 == 1) {//퀘스트
                    int 들고자_하는_바벨_중량선택 = 0;
                    boolean 중량들수_있는여부 = false;
                    while (체육관.중량_선택_성공_여부) {
                        체육관.중량_선택(게임_캐릭터.레벨, 게임_캐릭터.등급);
                        들고자_하는_바벨_중량선택 = scanner.nextInt();
                        중량들수_있는여부 = 체육관.선택할_수_있는_무게체크(들고자_하는_바벨_중량선택, 게임_캐릭터.레벨, 게임_캐릭터.등급);
                        if (중량들수_있는여부) {
                            게임_캐릭터.중량_선택 = 들고자_하는_바벨_중량선택;
                            System.out.println(들고자_하는_바벨_중량선택 + "kg를 선택하셨습니다.");
                            체육관.중량_선택_성공_여부 = false;
                        } else {
                            System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요");
                        }
                    }
                    while (게임_진행.운동_진행중) {
                        체육관.운동_메뉴();
                        int 운동_메뉴_선택 = 체육관.운동_메뉴_선택(scanner.nextInt());
                        if (운동_메뉴_선택 == 1) {
                            체육관.운동횟수++;
                            System.out.println("운동횟수 => " + 체육관.운동횟수);
                            게임_캐릭터.체력_감소();
                            게임_캐릭터.경험치_획득();
                            int event = 게임_이벤트.이벤트_실행(게임_캐릭터, 게임_진행);
                        } else if (운동_메뉴_선택 == 2) {
                            가방.소모품_목록();
                            가방.소모품_사용(scanner.nextInt());
                        } else if (운동_메뉴_선택 == 3) {
                            들고자_하는_바벨_중량선택 = 0;
                            중량들수_있는여부 = false;
                            체육관.중량_선택_성공_여부 = true;
                            while (체육관.중량_선택_성공_여부) {
                                체육관.중량_선택(게임_캐릭터.레벨, 게임_캐릭터.등급);
                                들고자_하는_바벨_중량선택 = scanner.nextInt();
                                중량들수_있는여부 = 체육관.선택할_수_있는_무게체크(들고자_하는_바벨_중량선택, 게임_캐릭터.레벨, 게임_캐릭터.등급);
                                if (중량들수_있는여부) {
                                    게임_캐릭터.중량_선택 = 들고자_하는_바벨_중량선택;
                                    System.out.println(들고자_하는_바벨_중량선택 + "kg를 선택하셨습니다.");
                                    체육관.중량_선택_성공_여부 = false;
                                } else {
                                    System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요");
                                    continue;
                                }
                            }
                        } else if (운동_메뉴_선택 == 4) {
                            게임_진행.운동_진행중 = false;
                        }
                    }
                } else if (퀘스트_번호_선택 == 2) { //승급 심사

                }
                게임_캐릭터.체력_감소();
            } else if (메인_메뉴_선택 == 4) { //소모품 상점
                소모품상점.소모품_목록();
                while (소모품상점.소모품_상점_이용중) {
                    int 소모품구매_선택_번호 = scanner.nextInt();
                    if (소모품구매_선택_번호 == 1) {
                        소모품상점.소모품_개수체크();
                        int 소모품구매개수 = scanner.nextInt();
                        소모품상점.소모품_구매(소모품구매_선택_번호, 소모품구매개수, 게임_캐릭터, 가방);
                        break;
                    } else if (소모품구매_선택_번호 == 2) {
                        소모품상점.소모품_개수체크();
                        int 소모품구매개수 = scanner.nextInt();
                        소모품상점.소모품_구매(소모품구매_선택_번호, 소모품구매개수, 게임_캐릭터, 가방);
                        break;
                    } else if (소모품구매_선택_번호 == 3) {
                        소모품상점.소모품_개수체크();
                        int 소모품구매개수 = scanner.nextInt();
                        소모품상점.소모품_구매(소모품구매_선택_번호, 소모품구매개수, 게임_캐릭터, 가방);
                        break;
                    } else if (소모품구매_선택_번호 == 4) {
                        소모품상점.소모품_개수체크();
                        int 소모품구매개수 = scanner.nextInt();
                        소모품상점.소모품_구매(소모품구매_선택_번호, 소모품구매개수, 게임_캐릭터, 가방);
                        break;
                    } else {
                        System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
                        continue;
                    }

                }
            } else if (메인_메뉴_선택 == 5) { //장비 상점
                장비_상점.장비_목록();
                int 장비_구매_선택_번호 = scanner.nextInt();
                장비_상점.장비구매(장비_구매_선택_번호, 게임_캐릭터.등급, 게임_캐릭터, 가방);
            } else if (메인_메뉴_선택 == 6) { //퀘스트 현황

            } else if (메인_메뉴_선택 == 7) {//능력치 확인
                게임_캐릭터.캐릭터_스탯();
            } else if (메인_메뉴_선택 == 8) {//게임 설정

            }
        }
    }
}