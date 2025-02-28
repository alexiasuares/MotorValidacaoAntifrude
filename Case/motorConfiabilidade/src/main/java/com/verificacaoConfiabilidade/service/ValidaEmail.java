package com.verificacaoConfiabilidade.service;

import org.xbill.DNS.Lookup;
import org.xbill.DNS.Record;
import org.xbill.DNS.MXRecord;
import org.xbill.DNS.Type;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.springframework.stereotype.Service;

@Service

public class ValidaEmail {
    public boolean validarEmail(String email){
        // Validação de formato
        String emailRegex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            System.out.println("Email não segue o padrão.");
            return false;
        }

        // Extraindo o domínio do e-mail
        String domain = extractDomain(email);
        if (domain == null) {
            
            return false;
        }

        try {
            
            Record[] records = new Lookup(domain, Type.MX).run();

            if (records == null || records.length == 0) {
                
                return false;
            }

            
            
            boolean foundMX = false;  

            for (Record record : records) {
                if (record instanceof MXRecord) {  
                    MXRecord mx = (MXRecord) record;
                    
                    foundMX = true;
                }
            }

            return foundMX; 
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String extractDomain(String email) {
        int atIndex = email.lastIndexOf("@");
        return (atIndex != -1 && atIndex < email.length() - 1) ? email.substring(atIndex + 1) : null;
    }
}
