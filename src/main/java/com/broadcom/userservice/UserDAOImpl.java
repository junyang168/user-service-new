package com.broadcom.userservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.dao.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

	Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);	

    private boolean isEmptyString(String s) {
        return s == null || s.trim().length() == 0 ;
    }

    @Override
    public List<User> getUsers(Filter[] filters,  String sortBy, String sortOrder) throws UserException  {
		String sql = "SELECT * FROM TEST_USER WHERE ROWNUM < 1000 " ;

        for(Filter filter : filters) {
            String filterName = filter.getName();
            switch( filterName ) {
                case "name":
                    sql  +=  " and lower(name) like '% " + filter.getValue().toLowerCase() + "' ";
                    break;
                case "age":
                    sql += " and age >= " + filter.getValue();
                    break;
                default:
                break;
            }
        }

        if( !isEmptyString( sortBy ) ) {
            sql = sql + " order by " + sortBy;
        }

        if( !isEmptyString( sortOrder)  ){
            sql += " ";
            sql += sortOrder;
        }


        logger.trace(sql);


        try {
            List<User> users =  jdbcTemplate.query(sql,
                    BeanPropertyRowMapper.newInstance(User.class));
            return users;    
        }
        catch( DataAccessException ex ) {
            logger.error("user dao error", ex);
            throw new UserException(ex);

        }        


    }

}