package br.com.pricher;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Jeferson Machado on 12/06/2017.
 */
public class Pluvio implements Comparable<Pluvio> {

    //,12.38          ,18.94   ,53          ,0          ,1.21482    ,"2012-04-18 11:21:30",1.204635   ,"2012-04-18 18:52:30",19.98    ,21.49      ,21.49
    //,"Rad_Total_Tot","Rajada","Dir_Rajada","Chuva_Tot","Nivel_Max","Nivel_TMx"          ,"Nivel_Min","Nivel_TMn"          ,"Orvalho","Ind_Calor","WindChill"

    //TIMESTAMP,
    private LocalDate data;
    private int record;
    //Deg C - "Temp_Ar_Max"
    private float tempArMax;
    //Deg C "Temp_Ar_TMx",
    private LocalDate tempArTimeMx;
    //Deg C "Temp_Ar_Min",
    private float tempArMin;
    //Deg C "Temp_Ar_TMn",
    private LocalDate tempArTimemin;

    //"Umid_Rel_Max",
    private int UmidadeRelMax;
    private LocalDate UmidadeRelTimeMax;
    private int UmidadeRelMin;
    private LocalDate UmidadeRelTimeMin;

    //"Rad_Total_Tot",
    private float radTotalTot;
    //"Rajada", km/h
    private float rajadaKmPorHora;
    //"Dir_Rajada", degrees
    private int dirRajada;
    //"Chuva_Tot", mm
    private float chuvaTotal;

    //"Nivel_Max";
    private float nivelMax;
    private LocalDate nivelMaxData;
    private float nivelMin;
    private LocalDate nivelMinData;

    //"Orvalho",
    private float orvalho;
    //"Ind_Calor",
    private float indCalor;
    //"WindChill"
    private float windChill;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    public float getTempArMax() {
        return tempArMax;
    }

    public void setTempArMax(float tempArMax) {
        this.tempArMax = tempArMax;
    }

    public LocalDate getTempArTimeMx() {
        return tempArTimeMx;
    }

    public void setTempArTimeMx(LocalDate tempArTimeMx) {
        this.tempArTimeMx = tempArTimeMx;
    }

    public float getTempArMin() {
        return tempArMin;
    }

    public void setTempArMin(float tempArMin) {
        this.tempArMin = tempArMin;
    }

    public LocalDate getTempArTimemin() {
        return tempArTimemin;
    }

    public void setTempArTimemin(LocalDate tempArTimemin) {
        this.tempArTimemin = tempArTimemin;
    }

    public int getUmidadeRelMax() {
        return UmidadeRelMax;
    }

    public void setUmidadeRelMax(int umidadeRelMax) {
        UmidadeRelMax = umidadeRelMax;
    }

    public LocalDate getUmidadeRelTimeMax() {
        return UmidadeRelTimeMax;
    }

    public void setUmidadeRelTimeMax(LocalDate umidadeRelTimeMax) {
        UmidadeRelTimeMax = umidadeRelTimeMax;
    }

    public int getUmidadeRelMin() {
        return UmidadeRelMin;
    }

    public void setUmidadeRelMin(int umidadeRelMin) {
        UmidadeRelMin = umidadeRelMin;
    }

    public LocalDate getUmidadeRelTimeMin() {
        return UmidadeRelTimeMin;
    }

    public void setUmidadeRelTimeMin(LocalDate umidadeRelTimeMin) {
        UmidadeRelTimeMin = umidadeRelTimeMin;
    }

    public float getRadTotalTot() {
        return radTotalTot;
    }

    public void setRadTotalTot(float radTotalTot) {
        this.radTotalTot = radTotalTot;
    }

    public float getRajadaKmPorHora() {
        return rajadaKmPorHora;
    }

    public void setRajadaKmPorHora(float rajadaKmPorHora) {
        this.rajadaKmPorHora = rajadaKmPorHora;
    }

    public int getDirRajada() {
        return dirRajada;
    }

    public void setDirRajada(int dirRajada) {
        this.dirRajada = dirRajada;
    }

    public float getChuvaTotal() {
        return chuvaTotal;
    }

    public void setChuvaTotal(float chuvaTotal) {
        this.chuvaTotal = chuvaTotal;
    }

    public float getNivelMax() {
        return nivelMax;
    }

    public void setNivelMax(float nivelMax) {
        this.nivelMax = nivelMax;
    }

    public LocalDate getNivelMaxData() {
        return nivelMaxData;
    }

    public void setNivelMaxData(LocalDate nivelMaxData) {
        this.nivelMaxData = nivelMaxData;
    }

    public float getNivelMin() {
        return nivelMin;
    }

    public void setNivelMin(float nivelMin) {
        this.nivelMin = nivelMin;
    }

    public LocalDate getNivelMinData() {
        return nivelMinData;
    }

    public void setNivelMinData(LocalDate nivelMinData) {
        this.nivelMinData = nivelMinData;
    }

    public float getOrvalho() {
        return orvalho;
    }

    public void setOrvalho(float orvalho) {
        this.orvalho = orvalho;
    }

    public float getIndCalor() {
        return indCalor;
    }

    public void setIndCalor(float indCalor) {
        this.indCalor = indCalor;
    }

    public float getWindChill() {
        return windChill;
    }

    public void setWindChill(float windChill) {
        this.windChill = windChill;
    }

    @Override
    public int compareTo(Pluvio o) {
        return this.data.compareTo(o.data);
    }
}
