package ej5;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fecha {

    final static int[] NORMAL = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    final static int[] BISIESTO = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private Date date;

    public Fecha(int dia, int mes, int anio) {
        date = new Date(anio, mes, dia);
    }

    public void sumar() {
        GregorianCalendar gregorianCalendar =
                new GregorianCalendar(date.getYear(), date.getMonth(), date.getDay());
        gregorianCalendar.add(GregorianCalendar.DATE, 1);
        System.out.println(gregorianCalendar.toString());
    }

    public boolean esBisiesto() {
        return new GregorianCalendar().isLeapYear(date.getYear());
    }

    public static boolean esBisiesto(int anio) {
        return new GregorianCalendar().isLeapYear(anio);
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static boolean checkDate(int dia, int mes, int anio) {
        if (mes<0 || mes > 12)
            return false;
        int[] dias;
        if (Fecha.esBisiesto(anio))
            dias = NORMAL;
        else
            dias = BISIESTO;
        if (dia > 0 && dia < dias[mes - 1])
            return true;
        else
            return false;
    }
}
