package Pos.Menu;

public class DeleteMenu implements IMenuManage{

	@Override
	public Object Insert(Object... o) {
		return null;
	}

	@Override
	public Object Delete(Object... o) {
		return null;
	}

	@Override
	public Object Modify(Object... o) {
		return null;
	}

	@Override
	public Object Select(Object... o) {
		IMenuManage iMenu = new DataRepository();
		System.out.println("메뉴 삭제");
		System.out.println("=======================");
		System.out.println(iMenu.Select());
		System.out.println("=======================");
		System.out.println("삭제할 메뉴를 고르세요");
		
		return null;
	}

}
