package com.pluralsight.springaop.flightsmanagement.dao;

import com.pluralsight.springaop.flightsmanagement.domain.Passenger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class PassengerDaoImpl implements PassengerDao{
    private static Map<Integer, Passenger> passengerMap = new HashMap<>();

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Passenger> rowMapper = (resultSet, rowNum) -> {
        Passenger passenger = new Passenger();
        passenger.setName(resultSet.getString("name"));
        passenger.setCountry(resultSet.getString("country"));
        return passenger;
    };

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    private Passenger getById(int id){
        String sql = "select * from passengers where id=?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public Passenger getPassenger(int id) {

        if (null!=passengerMap.get(id)) {
            return passengerMap.get(id);
        }

        Passenger passenger = getById(id);

        return passenger;
    }

    public static Map<Integer, Passenger> getPassengerMap() {
        return passengerMap;
    }

    public static void setPassengerMap(Map<Integer, Passenger> passengerMap) {
        PassengerDaoImpl.passengerMap = passengerMap;
    }
}
