import com.zjh.demo.dao.IStudentDao;
import com.zjh.demo.dao.IUserDao;
import com.zjh.demo.domain.Student;
import com.zjh.demo.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    public static void main(String[] args)  {

        try {
            student();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 这种是通过注解方式
     * @throws IOException
     */
    private static void student() throws IOException{
        /**
         * 1、读取配置文件
         * 2、创建sqlsessinFactory工厂
         * 3、使用工厂创建SqlSeesion对象
         * 4使用SqlSeesion 创建接口dao的代理对象
         * 5、使用代理方法
         * 6、释放资源
         */

        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder  builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        SqlSession session = factory.openSession();

        IStudentDao userDao = session.getMapper(IStudentDao.class);
        List<Student> students =  userDao.findAll();
        for (Student student:students){
            System.out.println(student);
        }

        session.close();
        in.close();
    }

    /**
     * 基于xml配置的方式
     * @throws IOException
     */
    private static void user() throws IOException{
        /**
         * 1、读取配置文件
         * 2、创建sqlsessinFactory工厂
         * 3、使用工厂创建SqlSeesion对象
         * 4使用SqlSeesion 创建接口dao的代理对象
         * 5、使用代理方法
         * 6、释放资源
         */

        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder  builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        SqlSession session = factory.openSession();

        IUserDao userDao = session.getMapper(IUserDao.class);
        List<User> users =  userDao.findAll();
        for (User user:users){
            System.out.println(user);
        }

        session.close();
        in.close();
    }
}
