package businessLogic;

import entity.Address;
import entity.Employee;
import entity.Project;
import org.hibernate.cfg.Configuration;

public class DefaultConfigurationHolder {

    private static Configuration configuration = new Configuration();

    static {
        configuration.setProperty("hibernate.bytecode.use_reflection_optimizer", "false");
        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:~/test");
        configuration.setProperty("hibernate.connection.username", "sa");
        configuration.setProperty("hibernate.connection.password", "");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.show_sql", "false");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");
//        configuration.setProperty("hibernate.connection.useSSL", "false");
//        configuration.setProperty("hibernate.enable_lazy_load_no_trans", "true");

        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Project.class);
    }

    public static Configuration getConfiguration() {
        return configuration;
    }
}