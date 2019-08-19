package com.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/OCP7DB2");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource;
    }
    @Bean
    public JdbcCursorItemReader<Pret> reader(){
        JdbcCursorItemReader<Pret> reader = new JdbcCursorItemReader<Pret>();
        reader.setDataSource(dataSource);
        reader.setSql("select a.id ,a.date_pret,a.date_retour,a.nom_livre,a.utilisateur, b.mail from " +
                "pret  a inner join utilisateur  b on a.utilisateur=b.identifiant where date_retour < CURDATE();");
        reader.setRowMapper(new PretRowMapper());

        return reader;
    }


    @Bean
    public PretItemProcessor processor(){
        return new PretItemProcessor();
    }

    @Bean
    public ItemWriter <Pret> writer(){
        return new ItemWriter<Pret>() {
            @Override
            public void write(List<? extends Pret> list) throws Exception {

            }
        };
    }


    @Bean
    public Step step1(ItemWriter <Pret> writer){
        return stepBuilderFactory.get("step1").<Pret,Pret> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }

    @Bean
    public Job retardTagUpdateJob(Step step1) {
        return jobBuilderFactory.get("retardTagUpdate")
                .incrementer(new RunIdIncrementer())
                .flow(step1)
                .end()
                .build();
    }




}
