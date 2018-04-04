import cn.bdqn.entity.Hosts;
import cn.util.HouseUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class Test01 {
    public static void main(String[] args) {
       List<Hosts>list = query("%中关村%",80);
       for (Hosts e:list){
           System.out.print(e);
       }
        //上机一查询所有数据
        /*Session session = HouseUtil.openSession();
        Transaction transaction = session.beginTransaction();*/

        /*String sql="from Hosts";
        Query query =session.createQuery(sql);
        List<Hosts>list =query.list();

       transaction.commit();
        session.close();
        for (Hosts e:list){
            System.out.print(e);
        }*/


    }

    public static List<Hosts> query(String title,int price){
        Session session = HouseUtil.openSession();
        Transaction transaction = session.beginTransaction();

        String sql="from Hosts where title like ? and price>?";
        Query query =session.createQuery(sql);
        query.setString(0,title);
        query.setInteger(1,80);

        List<Hosts>list=query.list();

        transaction.commit();
        session.close();
        return  list;
    }
}


