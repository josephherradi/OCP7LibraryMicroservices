package com.batch;

import org.springframework.batch.item.ItemProcessor;

import java.util.Date;

public class PretItemProcessor implements ItemProcessor<Pret,Pret> {

    @Override
    public Pret process(Pret pret) throws Exception {
        if(pret.getDateRetour().after(new Date())){
        pret.setRetardPret(Boolean.TRUE);
        }

        return pret;
    }
}
