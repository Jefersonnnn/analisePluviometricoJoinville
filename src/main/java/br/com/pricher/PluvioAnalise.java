package br.com.pricher;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Created by Jeferson Machado on 13/06/2017.
 */
public class PluvioAnalise {
    Pluvio[] dados;
    PluvioReader pr;
    JFileChooser file;
    Scanner scanner;
    int[] meses;

    public PluvioAnalise() {
        pr = new PluvioReader();

        try {
            dados = pr.readAsArray(abrirArquivo().getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (NullPointerException ne) {
            System.out.println(ne.getCause());
            System.out.println(ne.getMessage());
            System.out.println(ne.getLocalizedMessage());
            ne.printStackTrace();
        }

        if (dados != null || !(dados.length <= 0)) {
            while (true) {
                scanner = new Scanner(System.in);
                System.out.println("Informe os meses para análise");
                System.out.println("Digite o mês e ano a ser analisado [2 2016] : ");
                analiseMediaMesAno(scanner.nextInt(), scanner.nextInt());

                System.out.println("");
                System.out.println("Aperte qualquer tecla para iniciar novamente");
                scanner.nextLine();
            }
        }
    }


    public double analiseMediaMesAno(int mes, int ano) {
        System.out.format("MES %s, ANO %d\n", PluvioHelper.intToMonth(mes), ano);
        int count = 0;
        float media, total = 0, maximo = 0, minimo = 500;
        LocalDate diaMaximo = null, diaMinimo = null, diaMaximoAnterior = null, diaMinimoAnterior = null;
        int countAnterior = 0;
        float mediaAnterior, totalAnterior = 0, maximoAnterior = 0, minimoAnterior = 500;

        System.out.println("DATA\t|\tCHUVA TOTAL(mm)");
        for (Pluvio pluvio : dados) {
            if (pluvio != null && pluvio.getData() != null) {
                if (pluvio.getData().getMonthValue() == mes && pluvio.getData().getYear() == ano) {
                    count++;
                    System.out.println(pluvio.getData() + " | " + pluvio.getChuvaTotal());
                    if (maximo < Math.max(maximo, pluvio.getChuvaTotal())) {
                        maximo = Math.max(maximo, pluvio.getChuvaTotal());
                        diaMaximo = pluvio.getData();
                    }

                    if (minimo > Math.min(minimo, pluvio.getChuvaTotal())) {
                        minimo = Math.min(minimo, pluvio.getChuvaTotal());
                        diaMinimo = pluvio.getData();
                    }

                    total += pluvio.getChuvaTotal();
                }

                if (pluvio.getData().getMonthValue() == mes && pluvio.getData().getYear() == ano - 1) {
                    countAnterior++;
                    System.out.println(pluvio.getData() + " | " + pluvio.getChuvaTotal());
                    if (maximoAnterior < Math.max(maximoAnterior, pluvio.getChuvaTotal())) {
                        maximoAnterior = Math.max(maximoAnterior, pluvio.getChuvaTotal());
                        diaMaximoAnterior = pluvio.getData();
                    }

                    if (minimoAnterior > Math.min(minimoAnterior, pluvio.getChuvaTotal())) {
                        minimoAnterior = Math.min(minimoAnterior, pluvio.getChuvaTotal());
                        diaMinimoAnterior = pluvio.getData();
                    }
                    totalAnterior += pluvio.getChuvaTotal();
                }
            }
        }

        media = total / count;
        mediaAnterior = totalAnterior / countAnterior;
        System.out.println("|------------------------------------");
        System.out.printf("|  %s de %d\n", PluvioHelper.intToMonth(mes), ano);
        System.out.printf("|- Total de chuva: %f mm\n", total);
        System.out.printf("|- Média de chuva: %f mm\n", media);
        System.out.printf("|- Máximo - Dia %s com %f mm de chuva\n", diaMaximo != null ? PluvioHelper.formatarData(diaMaximo) : "00/00/00", maximo);
        System.out.printf("|- Mínimo - Dia %s com %f mm de chuva\n", diaMinimo != null ? PluvioHelper.formatarData(diaMinimo) : "00/00/00", minimo != 500 ? minimo : 0);
        System.out.println(count + " dados encontrados");
        System.out.println("|------------------------------------");


        System.out.printf("|  %s de %d\n", PluvioHelper.intToMonth(mes), ano - 1);
        System.out.printf("|- Total de chuva: %f mm\n", totalAnterior);
        System.out.printf("|- Média de chuva: %f mm\n", mediaAnterior);
        System.out.printf("|- Máximo - Dia %s com %f mm de chuva\n", diaMaximoAnterior != null ? PluvioHelper.formatarData(diaMaximoAnterior) : "00/00/00", maximoAnterior);
        System.out.printf("|- Mínimo - Dia %s com %f mm de chuva\n", diaMinimoAnterior != null ? PluvioHelper.formatarData(diaMinimoAnterior) : "00/00/00", minimoAnterior != 500 ? minimoAnterior : 0);
        System.out.println(countAnterior + " dados encontrados");
        System.out.println("|------------------------------------");
        scanner.nextLine();


        return 0;
    }


    private File abrirArquivo() {
        file = new JFileChooser();
        //file.setFileSelectionMode(JFileChooser.FILES_ONLY);

        file.setDialogTitle("Selecione um arquivo para análise");
        file.setApproveButtonText("Abrir");
        String caminho_padrao = new File(".").getAbsolutePath();
        File pathInicial = new File(caminho_padrao);
        file.setCurrentDirectory(pathInicial); //vai abrir direto no dir

        //Filtro dos arquivos a serem analisados
        file.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public boolean accept(File f) {
                return (f.getName().endsWith(".txt")) || f.isDirectory() || f.getName().endsWith(".dat");
            }

            public String getDescription() {
                return "*.txt | *.dat";
            }
        });

        int i = file.showSaveDialog(null);
        if (i == 1) {
            return null;
        } else {
            return file.getSelectedFile();
        }
    }
}
