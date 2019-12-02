package br.com.arearestrita.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description the class  ConverteDate - Classe de conversão para datas.
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version  $Revision: 1
 * @since Build 0.1 02/12/019
 */
public class ConverteDate {

    SimpleDateFormat formatBra = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat formatBraSimples = new SimpleDateFormat("ddMMyyyyHHmmss");
    SimpleDateFormat formatIso = new SimpleDateFormat("yyyy-MM-dd");
    Date date = null;


    /**
     * Método que converte Date em data por string em formato dd/MM/yyyy.
     *
     * @param dtData
     * @return String
     */
    public static String converteDateStringBr(Date dtData) {
        SimpleDateFormat formatBra = new SimpleDateFormat("dd/MM/yyyy");
        return (formatBra.format(dtData));
    }

    /**
     * Método que converte Date em data por string em formato ddMMyyyyHHmmss
     *
     * @param dtData
     * @return String
     */
    public static String converteDateStringBrSimples(Date dtData) {
        SimpleDateFormat formatBraSimples = new SimpleDateFormat("ddMMyyyyHHmmss");
        return (formatBraSimples.format(dtData));
    }

    /**
     * Método que converte Date em data por string em formato ddMMRR
     *
     * @param dtData
     * @return String
     */
    public static String converteDateString(Date dtData) {
        SimpleDateFormat formatBraSimples = new SimpleDateFormat("dd/MM/YY");
        return (formatBraSimples.format(dtData));
    }

    /**
     * Método que converte Date em data por string em formato dd/MM/yyyy HH:mm:ss
     *
     * @param dtData
     * @return String
     */
    public static String converteDateStringBrDataHora(Date dtData) {
        SimpleDateFormat formatBraSimples = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return (formatBraSimples.format(dtData));
    }

    /**
     * Método que converte Date em data por string em formato ddMMyyyyHHmmss
     *
     * @param data
     * @return String
     */
    public static Date converteStringDateBrDataHora(String data) {
        if (data == null || data.equals("")) {
            return null;
        }

        Date date = null;
        try {
            SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmmss");
            date = formato.parse(data);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Método que converte Date em data por string em formato dd/MM/yyyy
     *
     * @param data
     * @return String
     */
    public static Date converteStringDateBr(String data) {
        if (data == null || data.equals("")) {
            return null;
        }

        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = (java.util.Date) formatter.parse(data);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Método que converte Date em data por string em formato yyyy-MM-dd
     *
     * @param dtData
     * @return String
     */
    public static String converteDateStringIso(Date dtData) {
        SimpleDateFormat formatIso = new SimpleDateFormat("yyyy-MM-dd");
        return (formatIso.format(dtData));
    }

    /**
     * Método que converte string em Date em formato yyyy-MM-dd
     *
     * @param data
     * @return String
     */
    public static Date converteStringDateIso(String data) {
        if (data == null || data.equals("")) {
            return null;
        }

        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = (java.util.Date) formatter.parse(data);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Método que realiza a conversão de Date para Date SQL.
     *
     * @param data
     * @return java.sql.Date
     */
    public static java.sql.Date converteDateParaDateSql(Date data) {
        java.sql.Date dataSql = new java.sql.Date(data.getTime());
        return dataSql;
    }

    /**
     * Método que realiza a tradução de dd/MM/yyyy para yyyy-MM-dd
     *
     * @param dataBra
     * @return String
     */
    public String parseIso(String dataBra) {
        try {
            date = this.formatBra.parse(dataBra);
            //date = this.formatIso.parse(dataBra);
            return (this.formatIso.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
            return ("Parse Error");
        }
    }

    /**
     * Método que realiza a tradução de yyyy-MM-dd para dd/MM/yyyy
     *
     * @param dataIso
     * @return String
     */
    public String parseBra(String dataIso) {
        try {
            date = this.formatIso.parse(dataIso);
            return (this.formatBra.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
            return ("Parse Error");
        }
    }


}
