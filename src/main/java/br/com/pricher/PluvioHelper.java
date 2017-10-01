package br.com.pricher;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Jeferson Machado on 13/06/2017.
 */
public class PluvioHelper {

    public static String intToMonth(int mes) {
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril","Maio", "Junho", "Julho", "Agosto","Setembro", "Outubro", "Novembro", "Dezembro"};

        if(mes > 0 && mes <= 12) {
            return meses[mes - 1];
        }
        return null;
    }

    public static String formatarData(LocalDate data) {
        DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String resul = data.format(dataFormatter);

        return resul;
    }
}
