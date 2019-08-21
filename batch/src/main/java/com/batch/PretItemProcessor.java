package com.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

public class PretItemProcessor implements ItemProcessor<Pret, MimeMessage> {
    @Autowired
    private JavaMailSender mailSender;

    private String sender;
    private String attachment;


    public PretItemProcessor(String sender, String attachment) {
        this.sender = sender;
        this.attachment = attachment;
    }

    @Override
    public MimeMessage process(Pret pret) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(sender);
        helper.setTo(pret.getMail());
        helper.setSubject("retard du prêt du livre "+pret.getNomLivre());
        helper.setText("Bonjour "+pret.getUtilisateur()+ ",vous n'avez pas rendu le livre "+ pret.getNomLivre()+" à la date de retour prévue "
                +pret.getDateRetour()+"."+"Veuillez procéder au retour du livre dans les plus brefs délais pour" +
                " éviter les pénalités. Cordialement");


        return message;
    }
}
