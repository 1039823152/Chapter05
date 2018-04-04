import cn.bdqn.entity.Hosts;
import cn.bdqn.entity.Pager;
import cn.util.HouseUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        Pager<Hosts> pager = queryEmps(2, 5, new Hosts( ));
        System.out.println("第"+pager.getPageNo() +"页,每页"+ pager.getPageSize()+"行,总页数:"
                +pager.getTotalPage() +" ,总行数:"+pager.getTotalRows());
        for (Hosts e:pager.getDatas()          ) {
            System.out.println(e);
        }
    }
    public static Pager<Hosts> queryEmps(int pageNo, int pageSize,Hosts hosts){
        Session session = HouseUtil.openSession();
        Transaction transaction = session.beginTransaction();

        Pager<Hosts> pager = new Pager<Hosts>();
        pager.setPageNo(pageNo);
        pager.setPageSize(pageSize);

        Criteria criteria = session.createCriteria(Hosts.class);
        //  select * from emp where ename like '%fdsa%'
        if(hosts.getContact() != null && !"".equals(hosts.getContact())) {
            criteria.add(Restrictions.ilike("contact", hosts.getContact(), MatchMode.ANYWHERE));
        }
        //select count(empno) from emp where ename like '%fdsa%'
        criteria.setProjection(Projections.count("id"));
        pager.setTotalRows( ((Long)criteria.uniqueResult()).intValue());  //设置总行数

        //  (总行数+每页行数-1)/每页行数
        pager.setTotalPage( (pager.getTotalRows()+pageSize-1)/pageSize );

        //select * from emp where ename like '%fdsa%'
        criteria.setProjection(null);
        criteria.setFirstResult( (pageNo-1)*pageSize ).setMaxResults(pageSize);
        pager.setDatas(criteria.list());
        return pager;
    }
    }

