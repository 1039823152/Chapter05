import cn.bdqn.entity.Hosts;
import cn.util.HouseUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {

    }

    public  static List<Hosts>query (Hosts hosts){
        Session session = HouseUtil.openSession();
        Transaction transaction = session.beginTransaction();

      return  null;
    }
}
