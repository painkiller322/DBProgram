package control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import impl.EmpServiceImpl;
import model.EmpService;
import model.Model;

public class EmpProc {
	Scanner sc = new Scanner(System.in);
	EmpService service = new EmpServiceImpl();

	public void execute() {
		while (true) {
			int menu = 0;
			System.out.println("1.사원 등록|2.사원 조회|3.부서별 조회|4.부서변경|5.퇴사처리|6.종료");

			menu = sc.nextInt();
			sc.nextLine();
			if (menu == 1) {
				System.out.println("1.사원 등록");
				input();
			} else if (menu == 2) {
				System.out.println("2.사원이름 조회");
				search();
			} else if (menu == 3) {
				System.out.println("3.부서별 조회");
				look();
			} else if (menu == 4) {
				System.out.println("4.부서변경");
				update();
			} else if (menu == 5) {
				System.out.println("5.퇴사처리");
				delete();
			} else if (menu == 6) {
				System.out.println("6.종료");
				break;
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}

//	1.게시글 작성
	public void input() {

		System.out.println("사원명");
		String name = sc.nextLine();
		System.out.println("부서");
		String depart = sc.nextLine();
		System.out.println("급여");
		String salary = sc.nextLine();
		System.out.println("입사일");
		String hire_date = sc.nextLine();

		Model board = new Model();// 보드 생성

		board.setName(name);
		board.setDepart(depart);
		board.setSalary(salary);
		board.setHire_date(hire_date);
		service.input(board);// 보드로 보내기
	}

	// 2.사원조회
	public void search() {
		System.out.println("사원 이름 입력: ");
		String name = sc.nextLine();
		List<Model> resultAry = new ArrayList<>();
		resultAry =service.search(name);
	
		for (Model board : resultAry) {
			if (board != null)
				System.out.println(board);
		}
	}
	
//	3.부서별 조회
	public void look() {
		System.out.println("부서별 조회: ");
		String depart = sc.nextLine();
		
		List<Model> resultAry = new ArrayList<>();
		resultAry =service.look(depart);
	
		for (Model board : resultAry) {
			if (board != null)
				System.out.println(board);
		}
	}
//	4.부서변경
	public void update() {
		System.out.println("사원 번호: ");
		int id_num = sc.nextInt();
		sc.nextLine();
		System.out.println("변경할 부서명: ");
		String depart = sc.nextLine();
		
		Model board = new Model();
		board.setId_num(id_num);
		board.setDepart(depart);
			

		service.update(board);
	}
//	5.퇴사처리
	public void delete() {
		System.out.println("삭제할 사원번호:");
		int id_num = sc.nextInt();
		
		Model board = new Model();
		board.setId_num(id_num);

		service.delete(board);
	}
	
	
	
}
