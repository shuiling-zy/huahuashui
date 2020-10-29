
import com.scuec.dao.VerficationCodeDaoImpl;
import com.scuec.dao.usersDaoImpl;
import com.scuec.entity.VerificationCode;
import com.scuec.entity.Users;

public class test {


    public static void main(String[] args) {
        usersDaoImpl udi = new usersDaoImpl();
        VerficationCodeDaoImpl vci = new VerficationCodeDaoImpl();
        Users user1 = new Users("110@qq.com","liuyuchen");
        VerificationCode v1 = new VerificationCode("999999","110@qq.com");
       // udi.add(user1);


        //vci.add(v1);
        //udi.getByEamil("110@qq.com");
        System.out.println(vci.getByEamil("110@qq.com"));

    }
}
