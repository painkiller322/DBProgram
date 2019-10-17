package model;

import java.util.List;

public interface EmpService {
	// 사원등록
	public void input(Model board);

	// 사원이름조회
	public List<Model> search(String name);

	// 부서별조회
	public List<Model> look(String depart);

	// 부서변경
	public void update(Model board);

	// 퇴사처리
	public void delete(Model board);
}
