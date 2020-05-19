package xyz.matve.spreparer;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
@Aspect
@ConditionalOnProperty(prefix = "connectionpreparer", value = "enabled", havingValue = "true")
public class DbSessionContextPreparer
{

    @AfterReturning(pointcut = "execution(* com.zaxxer.hikari.HikariDataSource.getConnection(..))", returning = "connection")
    public void prepare(Connection connection) throws SQLException {

        int userId = UserContext.getUserId();
        PreparedStatement preparedStatement = connection.prepareStatement("EXEC sp_set_session_context @key=N'UserId', @value=" + userId);
        preparedStatement.executeUpdate();

    }
}