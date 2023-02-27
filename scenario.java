package prj;

import java.io.IOException;
import java.util.Scanner;

public class scenario {

	public static void main(String[] args) throws IOException {
		
		// 스트리트 고양이 살려내기

		// 스캐너 객체 생성
		Scanner scan = new Scanner(System.in);
		// 사용자 입력값을 받는 변수
		int userInput;
		// 게임 진행 여부 (참일 경우 진행, 거짓일 경우 게임 오버)
		boolean go = true;

		// 시작
		start:
		while (go) {
			System.out.println("           ^  ^");
			System.out.println("   ┏━━━━━(= ･ω･ =)━━━━━━━━━━━━━━━┓  ╭ ╭ ");
			System.out.println("   ┃   스   ★       이    려    ★ ┃_ノ /");
			System.out.println("   ┃ ☆   트  트 ☆  양  ☆ 살    기   __ノ");
			System.out.println("   ┃   ★   리    고      ★  내    ┃");
			System.out.println("   ┗━━━━U━━━━U━━━━━━━━━━U━━━━U━━┛");
			System.out.println();
			
			System.out.println("평소 밥을 주던 야생의 스트리트 고양이가 아파 보인다.\n");

			// 1단계 고양이 포획할까 말까?
			step1 :
			while (true) {
				System.out.println("/ᐠ｡ꞈ｡ᐟ\\ 포획할까?");
				System.out.println("1. 응  2. 아니");
				userInput = scan.nextInt();
				System.out.println();

				switch (userInput) {
				// 포획 시 다음 단계 진행
				case 1:
					System.out.println("고양이 포획에 성공했다!\n");
					break step1;
				// 포획하지 않을 시 게임 오버
				case 2:
					System.out.println("병든 고양이를 지나쳤다. 고양이가 죽었다.");
					go = false;
					break step1;
				// 입력값 범위 벗어났을 때
				default:
					System.out.println("1 또는 2만 고를 수 있어. 다시 골라봐.");
				}
			} // step1: while

			// 2단계 고양이 어디로 데려가지?
			step2 :
			while (go) {
				System.out.println("/ᐠ｡ꞈ｡ᐟ\\ 고양이를 어디로 데려갈까?");
				System.out.println("1. 집  2. 병원");
				userInput = scan.nextInt();
				System.out.println();
				
				switch (userInput) {
				// 집에 데려갔을 때 게임 오버
				case 1:
					System.out.println("집에 데려갔더니 상태가 악화되어 고양이가 죽었다.");
					go = false;
					break step2;
				// 병원에 데려갔을 때 다음 단계 진행
				case 2:
					System.out.println("병원에 데려갔더니 귀 속에 진드기가 가득하다. 진드기를 죽이자!");
					break step2;
				default:
					System.out.println("1 또는 2만 고를 수 있어. 다시 골라봐.");
				}
			} // step2: while

			// 게임 성공 횟수
			int success = 0;
			// 게임 목숨
			int life = 3;

			// 3단계 진드기 죽이기 게임
			step3 :
			while (go) {
				System.out.println("\n	 ＿人人人人人人人人人人人＿");
				System.out.println("	＞　　 Game Start! 　 ＜");
				System.out.println("	 ￣Y^Y^Y^Y^Y^Y^Y^Y^￣");
				System.out.println();
				
				while (go) {
					System.out.print("몇 번째에 진드기(●)가 있는지 알려줘! Life: ");
					// 목숨 출력
					for (int count = 0; count < 3; count++) {
						if (count < life)
							System.out.print("♥︎")	;
						else
							System.out.print("♡︎")	;
					}
					System.out.println("");
					
					// 진드기 위치 (랜덤 1~10)
					int bug = (int)(Math.random()*10);
					
					// 진드기 출력
					for (int ear = 0; ear < 10; ear++)
						if (ear == bug)
							System.out.print("● ");
						else
							System.out.print("○ ");
	
					System.out.println();
					System.out.println("/ᐠ｡ꞈ｡ᐟ\\ 진드기 위치는? (1 ~ 10)");
					
					userInput = scan.nextInt();
					System.out.println();
					
					// 정답일 때 성공횟수 +1
					if (userInput == bug+1) {
						System.out.println("/ᐠ. ｡.ᐟ\\ᵐᵉᵒʷˎˊ˗\n진드기 발견! 성공적으로 진드기를 제거했다!");
						success++;
					}
					// 오답일 때 목숨 -1
					else {
						System.out.println("/ᐠ_ ꞈ _ᐟ\\ɴʏᴀ~\n앗! 진드기를 잡지 못했다!");
						life--;						
					}
					
					// 성공횟수 출력
					System.out.printf("\n>> 성공 횟수 : %d/3번, 남은 하트 수 : %d/3개 <<\n\n", success, life);
					
					// 성공횟수가 3일 때 다음 단계 진행
					if (success == 3) {
						System.out.println("진드기 제거 완료.");
						break step3;
					}
					// 목숨이 0 됐을 때 게임 오버
					if (life == 0) {
						System.out.println("진드기 제거 실패. 귓 속 상태가 악화되어 고양이가 죽었다.");
						go = false;
						break step3;
					}
					
				} // whiles
			} // step3: while

			// 4단계 치료비 벌기
//			step4 :
			while (go) {
				System.out.println("\n치료를 하고 나왔더니 30츄르가 나왔다. 급하게 오느라 수중에 츄르가 없다. 츄르를 벌자!\n");
				
				// 츄르 비용
				int cost = 30;
				// 츄르 벌기
				while (cost > 0) {
					System.out.printf("/ᐠ｡ꞈ｡ᐟ\\ 무슨 방법으로 츄르를 벌까? (현재 : %d츄르)\n", 30-cost);
					System.out.printf("1.        캔 따주기 (%2d 츄르)\n", 3);
					System.out.printf("2.  낚시대로 놀아주기 (%2d 츄르)\n", 6);
					System.out.printf("3. 맛동산과 감자 캐기 (%2d 츄르)\n", 10);
					userInput = scan.nextInt();
					
					switch (userInput) {
					case 1:
						System.out.println("");
						cost -= 3;
						break;
					case 2:
						System.out.println("	.　　　*,':");
						System.out.println("	　　,:\"\"\"\"");
						System.out.println("	　//");
						System.out.println("	`|｜");
						System.out.println("	｜ ､");
						System.out.println("	､＼ ヽ_");
						System.out.println("	　､＼　二_  ∧∞__∧");
						System.out.println("	　　 ｀-_ ￣(｀ ･ω ･)");
						System.out.println("	　　　　 ー(.. O┳O");
						System.out.println("	　　　　　 ◎ ) `J_))");
						System.out.println();
						System.out.println("즐겁게 놀아주었다. 6츄르 획득!\n");
						cost -= 6;
						break;
					case 3:
						System.out.println("");
						cost -= 10;
						break;
					default:
						System.out.println("1 ~ 3만 고를 수 있어. 다시 골라봐.");
					}
				}
				
				System.out.println("우와~ 30츄르를 다 모았다!");
				System.out.println("무사히 치료비를 지불했다.\n");
				break;
			}

			// 게임 오버
			if (!go) {
				System.out.println("\n	 ＿人人人人人人人人人＿");
				System.out.println("	＞　　 GameOver 　 ＜");
				System.out.println("	 ￣Y^Y^Y^Y^Y^Y^Y￣");
				System.out.println();
				System.out.println("/ᐠ｡ꞈ｡ᐟ\\ 다시 할래?\n1. 예  2. 아니오");
				userInput = scan.nextInt();
				System.out.println();

				switch (userInput) {
				// 게임 다시 시작
				case 1:
					go = true;
					break;
				// 게임 종료
				case 2:
					System.out.println("	⠀⠀|＼ 　　　／|");
					System.out.println("	⠀⠀|　ヽー-く |");
					System.out.println("	⠀⠀|　　　　　 |  흥");
					System.out.println("	⠀⠀|　 Ò　　Ó |  칫");
					System.out.println("	⠀⠀ ヽ\"　 ^　ノ  뿡");
					System.out.println("	⠀⠀ /⠀⠀⠀⠀⠀⠀\\\n");
					System.out.println("/ᐠ. ֑ .ᐟ\\ﾉ 그래. 잘가~");
					break;
				// 입력값 범위 벗어났을 때
				default:
					System.out.println("1 또는 2만 고를 수 있어. 다시 골라봐.");
				}
			}
			// 게임 엔딩
			else {
				System.out.println("건강해진 스트리트 고양이는 다시 야생으로 돌아갔다.");
				System.out.println("   。　　　　　　　 ＊");
				System.out.println("   　★ ★　 　 ★ ★ ");
				System.out.println("   ★　　 ★　 ★　　 ★");
				System.out.println("   ★　　　∧★ ∧　　 ★");
				System.out.println("   ｡★　　(´･ω･)　 ★");
				System.out.println("   　★　　| 二⊃==○★");
				System.out.println("   　＊★　|　 |　　　　＊");
				System.out.println("   　。　★(ノ Ｕ 。");
				System.out.println("   　　　　★　 ※");
				System.out.println("　   　　　　★　　°");
				System.out.println();
				System.out.println("/ᐠ｡ꞈ｡ᐟ\\ 스트리트 고양이를 치료해줘서 고마워~");
				System.out.println("~The END~");
				break start;
			}
		} // start: while
		
		scan.close();
	} // main
} // scenario
