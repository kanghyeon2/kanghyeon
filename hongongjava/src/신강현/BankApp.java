package 신강현;

import java.util.Scanner;

public class BankApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int cnt = 0;
		Account[] anos = new Account[100];

		while (run) {
			System.out.println("--------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("--------------------------------------------");
			System.out.print("선택>");
			int selNo = Integer.parseInt(sc.nextLine());

			switch (selNo) {
			case 1:
				System.out.println("--------------------------------------------");
				System.out.println("계좌생성");
				System.out.print("--------------------------------------------");
				System.out.print("\n계좌번호 : ");
				String ano = sc.nextLine();
				System.out.print("계좌주 : ");
				String owner = sc.nextLine();
				System.out.print("초기입금액 : ");
				int balance = Integer.parseInt(sc.nextLine());
				anos[cnt] = new Account(ano, owner, balance);
				System.out.println("계좌가 생성되었습니다.");
				cnt++;
				break;
				
//				for (int i = 0; i < cnt; i++) {				
//					if (anos[cnt].getAno().equals(ano)) {
//						System.out.println("중복된계좌");
//					
//					} else {
//						anos[i] = new Account(ano, owner, balance);
//						cnt++;
//						System.out.println("계좌가 생성되었습니다.");
//					}
//				}
//				
//				break;

			case 2:
				System.out.println("--------------------------------------------");
				System.out.println("계좌목록");
				System.out.println("--------------------------------------------");
				System.out.println();

				for (Account ele : anos) {
					if (ele != null) {
						System.out.printf("계좌 :%-20s\t|이름 :%-10s\t|잔액 :%d\t|\n", ele.getAno(), ele.getOwner(),
								ele.getBalance());
					}

				}
				break;
			case 3:
				System.out.print("계좌번호 : ");
				String ano1 = sc.nextLine();
				System.out.println("예금액 > ");
				int money = Integer.parseInt(sc.nextLine());
				for (Account ele : anos) {
					if (ele != null) {
						if (ano1.equals(ele.getAno())) {
							ele.setBalance(money + ele.getBalance());
						}
					}
				}
				System.out.println("예금에 성공");
				break;
			case 4:
				System.out.print("계좌번호 : ");
				String ano2 = sc.nextLine();
				System.out.println("출금액 > ");
				int money2 = Integer.parseInt(sc.nextLine());
				for (Account ele : anos) {
					if (ele != null) {
						if (ano2.equals(ele.getAno())) {
							if (ele.getBalance() >= money2) {
								ele.setBalance(ele.getBalance() - money2);
								System.out.println("출금 성공");
							} else if (ele.getBalance() < money2) {
								System.out.println("잔액부족");
								System.out.print("현재 잔액" + ele.getBalance());
								System.out.println();
							}
						}
					}
				}

				break;
			case 5:
				run = false;
				break;

			}
		}
		System.out.println("프로그램종료");
	}

}
