package extend;
/**
 * 这是活动类
 * @author huangfei
 *
 */
public class Action {
	public int id;
	public int starttime;
	public int endtime;
	/**
	 * 这是活动类
	 * @param id
	 * 活动序号
	 * @param stattime
	 * 活动开始时间
	 * @param endtime
	 * 活动结束时间
	 */
	public Action(int id, int stattime,int endtime){
		this.id=id;
		this.starttime=stattime;
		this.endtime=endtime;
	}
	public String getinfo(){
		String result="action's id="+id+" starttime="+starttime+" endtime="+endtime+"\n";
		return result;
	}
}
