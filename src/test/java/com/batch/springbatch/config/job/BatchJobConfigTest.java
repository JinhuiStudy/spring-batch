package com.batch.springbatch.config.job;

import com.batch.springbatch.config.dominio.Bill;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class BatchJobConfigTest {

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setup() {
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    @DisplayName("Bill Job 성공")
    @Test
    public void testBillJobResults() {
        var billStatements = this.jdbcTemplate.query(
                "SELECT id, first_name, last_name, minutes, data_usage, bill_amount " +
                      "FROM bill_statements " +
                     "ORDER BY id",
                (rs, rowNum) -> new Bill(
                                    rs.getLong("id"),
                                    rs.getString("FIRST_NAME"),
                                     rs.getString("LAST_NAME"),
                                    rs.getLong("DATA_USAGE"),
                                    rs.getLong("MINUTES"),
                                    rs.getDouble("bill_amount")));


        assertThat(billStatements.size()).isEqualTo(5);

        var billStatement = billStatements.get(0);
        assertThat(billStatement.getBillAmount()).isEqualTo(6.0);
        assertThat(billStatement.getFirstName()).isEqualTo("jane");
        assertThat(billStatement.getLastName()).isEqualTo("doe");
        assertThat(billStatement.getId()).isEqualTo(1);
        assertThat(billStatement.getMinutes()).isEqualTo(500);
        assertThat(billStatement.getDataUsage()).isEqualTo(1000);

    }

}