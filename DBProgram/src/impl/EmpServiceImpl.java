package impl;

import java.util.List;

import model.EmpService;
import model.Model;

public class EmpServiceImpl implements EmpService {
	EmpDAO dao = new EmpDAO();

	@Override
	public void input(Model board) {
		dao.input(board);

	}

	@Override
	public List<Model> search(String name) {
		List<Model> board = dao.search(name);
		return board;

	}

	@Override
	public List<Model> look(String depart) {
		List<Model> board = dao.look(depart);
		return board;

	}

	@Override
	public void update(Model board) {
		dao.update(board);

	}

	@Override
	public void delete(Model board) {
		dao.delete(board);

	}

}
