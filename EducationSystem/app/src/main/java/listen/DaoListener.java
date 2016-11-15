package listen;

import dao.BaseDao;

/**
 * Created by tianyun chen on 2016/9/13.
 */
public interface DaoListener {
    public  void onDataLoaded(BaseDao dao);
    public  void onDataFailed(BaseDao dao);
}
