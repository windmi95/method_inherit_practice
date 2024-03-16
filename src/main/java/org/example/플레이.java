package org.example;


import java.util.Scanner;



//게임을 진행하는 클래스
public class 플레이 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        게임운영 게임_진행 = new 게임운영();
        체육관 체육관 = new 체육관();
        캐릭터 게임_캐릭터 = new 캐릭터();
        이벤트 게임_이벤트 = new 이벤트();
        헬스장_관장 퀘스트 = new 헬스장_관장();
        소모품_상점 소모품상점 = new 소모품_상점();
        장비_상점 장비_상점 = new 장비_상점();
        가방 가방 = new 가방();
        게임_설정 게임설정 = new 게임_설정();
        물건 물건 = new 물건();
        퀘스트 퀘스트_1;




        //게임 시작
        게임_진행.프롤로그_타이핑_효과();

        System.out.println(게임_진행.캐릭터_이름_작성(scanner.next()) + "님 게임을 진행하겠습니다.");
        while (!게임_진행.게임_종료) {
            게임_진행.메인_메뉴();
            int 메인_메뉴_선택 = 게임_진행.메인_메뉴_선택(scanner.nextInt());
            if (메인_메뉴_선택 == 1) {//운동을 실행하고자 할 때 선택하는 메뉴
                if (게임_캐릭터.체력 <= 0) {
                    System.out.println("체력이 부족하기 때문에 운동을 실행할 수 없습니다.");
                    게임_진행.운동_진행중 = false;
                    continue;
                }
                int 들고자_하는_바벨_중량선택 = 0;
                boolean 중량들수_있는여부 = false;
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
                    }
                }
                게임_진행.운동_진행중 = true;
                while (게임_진행.운동_진행중) {

                    if (게임_캐릭터.체력 <= 0) {// 캐릭터 체력이 부족한 경우
                        게임_진행.운동_진행중 = false;
                        System.out.println("체력 부족으로 인해 메인 메뉴로 돌아갑니다.");
                        continue;
                    }
                    체육관.운동_메뉴();
                    int 운동_메뉴_선택 = 체육관.운동_메뉴_선택(scanner.nextInt());
                    if (운동_메뉴_선택 == 1) {//운동실행
                        체육관.운동횟수++;
                        System.out.println("운동횟수 -> " + 체육관.운동횟수);
                        게임_캐릭터.체력_감소();
                        게임_캐릭터.경험치_획득();
                        if (퀘스트.퀘스트_진행중) {
                            퀘스트.진행중인_퀘스트_운동_개수_올리기();
                            퀘스트.퀘스트_현황_보여주기();
                            퀘스트.퀘스트_통과했을_경우_메시지_출력(게임_진행);
                        }
                        boolean 레벨업_했는지_여부_체크 = 게임_캐릭터.레벨업_했는지_여부_확인();
                        if (레벨업_했는지_여부_체크) {
                            게임_캐릭터.레벨_상승();
                            if (게임_캐릭터.레벨 == 30 || 게임_캐릭터.레벨 == 50 || 게임_캐릭터.레벨 == 70 || 게임_캐릭터.레벨 == 100) {
                                퀘스트.승급_가능_메시지_출력(게임_캐릭터);
                            }
                            게임_캐릭터.스텟올리기_진행중_여부 = true;
                            while (게임_캐릭터.스텟올리기_진행중_여부) {
                                if (게임_캐릭터.스탯_포인트 <= 0) {
                                    System.out.println("스탯 입력이 끝났습니다. ");
                                    게임_캐릭터.스텟올리기_진행중_여부 = false;
                                    break;
                                }
                                게임_캐릭터.스탯_올리기_선택_메뉴판();
                                int 스탯_번호_선택 = scanner.nextInt();
                                게임_캐릭터.스탯_올리기(스탯_번호_선택);
                            }
                        } else {
                            int event = 게임_이벤트.이벤트_실행(게임_캐릭터, 게임_진행);
                        }

                    } else if (운동_메뉴_선택 == 2) {//아이템 사용
                        가방.소모품_목록();
                        가방.소모품_사용(scanner.nextInt(), 게임_캐릭터);
                    } else if (운동_메뉴_선택 == 3) {//중량 변경
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
                            }
                        }
                    } else if (운동_메뉴_선택 == 4) {//게임에서 나가기
                        게임_진행.운동_진행중 = false;
                    }
                }
            } else if (메인_메뉴_선택 == 2) {//가방에서 아이템을 관리

                //일단 실행하니까  -> 가방 메뉴 진행중은 true로 바꿔줌.
                가방.가방_메뉴_진행중 = true;

                while (가방.가방_메뉴_진행중) {
                    가방.가방_메뉴();
                    int 가방_메뉴_선택_번호 = 가방.가방_메뉴_선택(scanner.nextInt());

                    if (가방_메뉴_선택_번호 == 1) {//장비 선택을 골랐을 때

                        //장비가 있는지 여부 체크 해준다.  true면 하나라도 있는 것 / false면 아무 장비도 가방에 존재하지 않는다.
                        boolean 장비있는지_여부체크 = 가방.장비상점에서_구매한_장비_목록보여주기();

                        //가방 안에 아무것도 없을 때는 가방 메뉴로 다시 돌아가게
                        if (!장비있는지_여부체크) {
                            continue;
                        }

                        //장비가 있을 때 -> 장비번호 선택
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
                            }
                        } else if (가방.복압_벨트 != null && 장착할_장비_번호_선택 == 4) {
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
                            }
                        } else {
                            System.out.println("메뉴로 이동하겠습니다.");
                            break;
                        }

                    } else if (가방_메뉴_선택_번호 == 2) {//장착 해제하기

                        boolean 장착해제_진행중 = true;
                        while (장착해제_진행중) {

                            boolean 캐릭터_장비_보유_여부 = 게임_캐릭터.캐릭터_장비_해제할_수_있는_목록_출력();

                            //캐릭터가 장비를 보유한게 없다면 다시 진행한다.
                            if (!캐릭터_장비_보유_여부) {
                                break;
                            }
                            int 해제할_장비_번호_선택 = 게임_캐릭터.캐릭터_해제할_장비_선택(scanner.nextInt());
                            if (가방.손목보호대 == null && 해제할_장비_번호_선택 == 1) {
                                int 장비_해제_여부_선택 = scanner.nextInt();
                                if (장비_해제_여부_선택 == 1) {
                                    System.out.println("손목보호대 장착을 해제하겠습니다.");
                                    게임_캐릭터.손목보호대_벗기();
                                    가방.새로운_손목보호대를_가방에_넣는다(new 손목보호대());
                                    장착해제_진행중 = false;
                                } else if (장비_해제_여부_선택 == 2) {
                                    System.out.println("메뉴로 이동하겠습니다.");
                                    장착해제_진행중 = false;
                                } else {
                                    System.out.println("잘 못 입력하셨습니다.");
                                }
                            } else if (가방.리프팅웨어 == null && 해제할_장비_번호_선택 == 2) {
                                int 장비_해제_여부_선택 = scanner.nextInt();
                                if (장비_해제_여부_선택 == 1) {
                                    System.out.println("리프팅웨어 장착을 해제하겠습니다.");
                                    게임_캐릭터.리프팅웨어_벗기();
                                    가방.새로운_리프팅웨어를_가방에_넣는다(new 리프팅웨어());
                                    장착해제_진행중 = false;
                                } else if (장비_해제_여부_선택 == 2) {
                                    System.out.println("가방 메뉴로 이동하겠습니다.");
                                    장착해제_진행중 = false;
                                } else {
                                    System.out.println("잘 못 입력하셨습니다.");
                                }
                            } else if (가방.역도화 == null && 해제할_장비_번호_선택 == 3) {
                                int 장비_해제_여부_선택 = scanner.nextInt();
                                if (장비_해제_여부_선택 == 1) {
                                    System.out.println("역도화 장착을 해제하겠습니다.");
                                    게임_캐릭터.역도화_벗기();
                                    가방.새로운_역도화를_가방에_넣는다(new 역도화());
                                    장착해제_진행중 = false;
                                } else if (장비_해제_여부_선택 == 2) {
                                    System.out.println("가방 메뉴로 이동하겠습니다.");
                                    장착해제_진행중 = false;
                                } else {
                                    System.out.println("잘 못 입력하셨습니다.");
                                }
                            } else if (가방.복압_벨트 == null && 해제할_장비_번호_선택 == 4) {
                                int 장비_해제_여부_선택 = scanner.nextInt();
                                if (장비_해제_여부_선택 == 1) {
                                    System.out.println("복압벨트 장착을 해제하겠습니다.");
                                    게임_캐릭터.복압벨트_벗기();
                                    가방.새로운_복압_벨트를_가방에_넣는다(new 복압_벨트());
                                } else if (장비_해제_여부_선택 == 2) {
                                    System.out.println("가방 메뉴로 이동하겠습니다.");
                                } else {
                                    System.out.println("잘 못 입력하셨습니다.");
                                }
                            } else {
                                System.out.println("아무런 장비가 없습니다.");
                                장착해제_진행중 = false;
                            }
                        }
                    } else if (가방_메뉴_선택_번호 == 3) {//착용한 장비 확인하기
                        게임_캐릭터.캐릭터_장착한_장비_리스트_보여주기();
                        break;
                    } else if (가방_메뉴_선택_번호 == 4) {//소모품 사용하기
                        가방.소모품_목록();
                        가방.소모품_사용(scanner.nextInt(), 게임_캐릭터);
                    } else if (가방_메뉴_선택_번호 == 5) {//소모품 개수 학인
                        가방.소모품_체크();
                    } else if (가방_메뉴_선택_번호 == 6) {//소모품 버리기
                        가방.버릴_소모품_목록();
                        int 버릴_소모품_번호_선택 = scanner.nextInt();
                        가방.소모품_버리기(버릴_소모품_번호_선택);
                    } else if (가방_메뉴_선택_번호 == 7) {//가방 메뉴 나가기
                        가방.가방_메뉴_진행중 = false;
                    }
                }
            } else if (메인_메뉴_선택 == 3) {//퀘스트 의뢰(퀘스트, 승급심사) 받으러 가기
                퀘스트.퀘스트_메뉴_진행중 = true;
                while (퀘스트.퀘스트_메뉴_진행중) {
                    퀘스트.퀘스트_및_승급심사_메뉴();
                    int 퀘스트_번호_선택 = scanner.nextInt();
                    int 퀘스트_승낙_여부_선택 = 0;
                    if (퀘스트_번호_선택 == 1) { //퀘스트 1번을 실행했을 때
                        System.out.println("중량은 등급에 맞게 원하는 무게를 사용할 수 있으며, 운동 횟수는 랜덤으로 설정됩니다.");
                        퀘스트.퀘스트_진행_여부();
                        퀘스트_승낙_여부_선택 = scanner.nextInt();
                        if (퀘스트_승낙_여부_선택 == 1) {//1.퀘스트를 승낙한다.
                            퀘스트.퀘스트_유형_선택(퀘스트_번호_선택, 퀘스트_승낙_여부_선택, 게임_캐릭터);
                            break;
                        } else if (퀘스트_승낙_여부_선택 == 2) {//2번 거절했을 때
                            System.out.println("메뉴로 이동합니다.");
                            break;
                        } else {
                            System.out.println("잘 못 입력하셨습니다.");
                            break;
                        }
                    } else if (퀘스트_번호_선택 == 2) { //승급 심사
                        if (!퀘스트.승급심사_진행할_수_있는_단계가_아닌_경우_메뉴로_이동(게임_캐릭터)) {
                            break;
                        }
                        if (게임_캐릭터.체력 <= 0) {// 캐릭터 체력이 부족한 경우
                            게임_진행.운동_진행중 = false;
                            System.out.println("체력 부족으로 인해 메인 메뉴로 돌아갑니다.");
                            System.out.println("============================================");
                            break;
                        }
                        퀘스트.승급심사_진행중 = true;
                        퀘스트.퀘스트_진행_여부();
                        퀘스트_승낙_여부_선택 = scanner.nextInt();
                        퀘스트.퀘스트_유형_선택(퀘스트_번호_선택, 퀘스트_승낙_여부_선택, 게임_캐릭터); //1. 퀘스트 2.승급 심사 3.퀘스트 현황 4.퀘스트 보상
                        게임_진행.운동_진행중 = true;
                        while (게임_진행.운동_진행중) {
                            if (게임_캐릭터.체력 <= 0) {// 캐릭터 체력이 부족한 경우
                                게임_진행.운동_진행중 = false;
                                System.out.println("체력 부족으로 인해 메인 메뉴로 돌아갑니다.");
                                System.out.println();
                                break;
                            }
                            if (퀘스트_승낙_여부_선택 == 1) {//퀘스트 승낙 선택
                                체육관.승급_심사_운동_메뉴();
                                int 승급_심사_메뉴_선택 = 체육관.승급_심사_운동_메뉴_선택(scanner.nextInt());
                                if (승급_심사_메뉴_선택 == 1) {//운동 실행

                                    if(게임_캐릭터.isCharacterGroggy){//그로기 상태일때
                                        System.out.println("그로기 상태여서 운동을 할수 없습니다. ");
                                    }else {//그로기 상태가 아닐때
                                        퀘스트.진행중인_승급심사_랜덤_그로기_상태_실행(게임_캐릭터);
                                        퀘스트.진행중인_승급심사_운동_개수_올리기();
                                        퀘스트.승급_심사_남은_운동횟수_체크(게임_캐릭터);
                                        게임_캐릭터.승급_심사_진행중_체력_감소(체육관);
                                        게임_캐릭터.승급심사_진행중_랜덤_체력_차감_실행();
                                    }
                                    boolean 승급심사_체력이_부족한지_체크 = 게임_캐릭터.승급심사_운동_진행중_체력이_부족한_경우_메인_메뉴로_이동(체육관, 퀘스트);
                                    if (!승급심사_체력이_부족한지_체크) {
                                        break;
                                    }
                                    boolean 승급_통과 = 퀘스트.승급_심사_통과_체크(게임_캐릭터, 게임_진행);
                                    if (승급_통과) {
                                        게임_진행.운동_진행중 = false;
                                        퀘스트.승급심사_진행중 = false;
                                    }
                                } else if (승급_심사_메뉴_선택 == 2) {//아이템 사용
                                    가방.소모품_목록();
                                    가방.소모품_사용(scanner.nextInt(), 게임_캐릭터);
                                } else if (승급_심사_메뉴_선택 == 3) {//게임에서 나오기
                                    퀘스트.승급심사_진행중 = false;
                                    break;
                                } else {
                                    System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
                                }
                            } else if (퀘스트_승낙_여부_선택 == 2) {//2번 거절했을 때
                                System.out.println("메뉴로 이동합니다.");
                                System.out.println();
                                퀘스트.퀘스트_메뉴_진행중 = false;
                                break;
                            }
                        }
                    } else if (퀘스트_번호_선택 == 3) {//퀘스트 현황
                        if (퀘스트.퀘스트_진행중) {
                            퀘스트.퀘스트_현황_보여주기();
                        } else {
                            System.out.println("현재 진행중인 퀘스트가 없습니다.");
                            System.out.println();
                        }
                    } else if (퀘스트_번호_선택 == 4) {//퀘스트 보상 받기
                        if (퀘스트.퀘스트_진행중) {
                            퀘스트.퀘스트_진행상태_체크하기(게임_캐릭터);
                        } else {
                            System.out.println("현재 진행중인 퀘스트가 없습니다.");
                            System.out.println();
                        }
                    } else if (퀘스트_번호_선택 == 5) {//메뉴에서 나가기
                        퀘스트.퀘스트_메뉴_진행중 = false;
                    } else {
                        System.out.println("잘 못 입력하셨습니다.");
                        System.out.println();
                    }
                }
            } else if (메인_메뉴_선택 == 4) { //소모품 상점
                while (소모품상점.소모품_상점_이용중) {
                    소모품상점.소모품_목록();
                    int 소모품구매_선택_번호 = scanner.nextInt();
                    if (소모품구매_선택_번호 == 1) {
                        System.out.println("bcaa를 선택하셨습니다.");
                        소모품상점.소모품_개수체크();
                        int 소모품구매개수 = scanner.nextInt();
                        소모품상점.소모품_구매(소모품구매_선택_번호, 소모품구매개수, 게임_캐릭터, 가방);
                        break;
                    } else if (소모품구매_선택_번호 == 2) {
                        System.out.println("탄수화물 보충제를 선택하셨습니다.");
                        소모품상점.소모품_개수체크();
                        int 소모품구매개수 = scanner.nextInt();
                        소모품상점.소모품_구매(소모품구매_선택_번호, 소모품구매개수, 게임_캐릭터, 가방);
                        break;
                    } else if (소모품구매_선택_번호 == 3) {
                        System.out.println("프로틴을 선택하셨습니다.");
                        소모품상점.소모품_개수체크();
                        int 소모품구매개수 = scanner.nextInt();
                        소모품상점.소모품_구매(소모품구매_선택_번호, 소모품구매개수, 게임_캐릭터, 가방);
                        break;
                    } else if (소모품구매_선택_번호 == 4) {
                        System.out.println("크레아틴을 선택하셨습니다.");
                        소모품상점.소모품_개수체크();
                        int 소모품구매개수 = scanner.nextInt();
                        소모품상점.소모품_구매(소모품구매_선택_번호, 소모품구매개수, 게임_캐릭터, 가방);
                        break;
                    } else {
                        System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
                        break;
                    }

                }
            } else if (메인_메뉴_선택 == 5) { //장비 상점
                장비_상점.장비_목록();
                int 장비_구매_선택_번호 = scanner.nextInt();
                장비_상점.장비구매(장비_구매_선택_번호, 게임_캐릭터, 가방);
            } else if (메인_메뉴_선택 == 6) {//게임 캐릭터 능력치 확인
                게임_캐릭터.캐릭터_스탯(게임_캐릭터);
            } else if (메인_메뉴_선택 == 7) {//게임 설정
                게임설정.게임설정_메뉴_진행중 = true;
                while (게임설정.게임설정_메뉴_진행중) {
                    게임설정.게임_설정_메뉴_보여주기();
                    int 게임설정_메뉴_번호_선택 = scanner.nextInt();
                    if (게임설정_메뉴_번호_선택 == 1) {
                        게임설정.게임_bgm_여부_확인();
                        int 게임_bgm_여부_번호_선택 = scanner.nextInt();
                        if (게임_bgm_여부_번호_선택 == 1) {
                            게임설정.게임_bgm_틀기 = true;
                            게임설정.음악_재생();
                            게임설정.게임_bgm_효과_적용();
                            break;
                        } else if (게임_bgm_여부_번호_선택 == 2) {
                            break;
                        } else {
                            System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
                        }
                    } else if (게임설정_메뉴_번호_선택 == 2) {
                        System.out.println("게임 내용을 저장합니다.");
                        게임설정.게임_저장하기(게임_캐릭터);
                        break;
                    } else if (게임설정_메뉴_번호_선택 == 3) {
                        System.out.println("저장된 정보를 불러옵니다.");
                        게임설정.게임_정보_불러오기();
                        break;
                    } else if(게임설정_메뉴_번호_선택 == 4) {
                        System.out.println("메인 메뉴로 이동합니다.");
                        break;
                    } else {
                        System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
                    }
                }
            }
        }
    }
}