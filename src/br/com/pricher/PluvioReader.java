package br.com.pricher;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class PluvioReader {

    private final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    private int counter = 0;
    private long inicioLeitura;

    public Pluvio[] readAsArray(String pathName) throws IOException {
        System.out.println("INICIANDO LEITURA DO ARQUIVO");
        inicioLeitura = System.currentTimeMillis();

        Stream<String> lines = Files.lines(Paths.get(pathName));
        Pluvio[] pluvios = new Pluvio[(int) lines.count()];

        lines = Files.lines(Paths.get(pathName));
        lines.forEach(line -> {
                if(!line.startsWith("\"TOA5") && !line.startsWith("\"TIMESTAMP") && !line.startsWith("\"TS") && !line.startsWith("\"\",") && line.length() > 0) {
                    Pluvio pluvio = parseStock(line);
                    pluvios[counter++] = pluvio;
                }
        });

        lines.close();
        System.out.println( "CONCLUÍDO EM " + (System.currentTimeMillis() - inicioLeitura) + " ms" );
        return pluvios;
    }


    private Pluvio parseStock(String line) {
        Pluvio pluvio = new Pluvio();
        line = line.replace("\"", "");
        String[] dados = line.split(Pattern.quote(","));

        pluvio.setData(LocalDate.parse(dados[3], DATE_FORMATTER));
        pluvio.setChuvaTotal(Float.parseFloat(dados[13]));

        return pluvio;
    }
}
