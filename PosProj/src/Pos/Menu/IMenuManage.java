package Pos.Menu;

// Object형으로 0개 이상의 파라미터 사용
public interface IMenuManage {
	public Object Insert(Object...o);
	public Object Delete(Object...o);
	public Object Modify(Object...o);
	public Object Select(Object...o);

}
