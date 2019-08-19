package com.batch;

import org.springframework.batch.item.ItemProcessor;

import java.util.Date;

public class PretItemProcessor implements ItemProcessor<Pret,Pret> {

    @Override
    public Pret process(Pret pret) throws Exception {


        return pret;
    }
}
