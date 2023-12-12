package com.example.fluganzeigetafel.Data;

import java.util.Objects;

public class Flight {
    private String fnr;
    private String knr;
    private String reg;
    private String typ;
    private String ha0;
    private String lsk;
    private String stt;
    private String itt;
    private String pos;
    private String ter;
    private String mad;
    private String saa;

    public String getFnr() {
        return fnr;
    }

    public void setFnr(String fnr) {
        this.fnr = fnr;
    }

    public String getKnr() {
        return knr;
    }

    public void setKnr(String knr) {
        this.knr = knr;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getHa0() {
        return ha0;
    }

    public void setHa0(String ha0) {
        this.ha0 = ha0;
    }

    public String getLsk() {
        return lsk;
    }

    public void setLsk(String lsk) {
        this.lsk = lsk;
    }

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    public String getItt() {
        return itt;
    }

    public void setItt(String itt) {
        this.itt = itt;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getTer() {
        return ter;
    }

    public void setTer(String ter) {
        this.ter = ter;
    }

    public String getMad() {
        return mad;
    }

    public void setMad(String mad) {
        this.mad = mad;
    }

    public String getSaa() {
        return saa;
    }

    public void setSaa(String saa) {
        this.saa = saa;
    }

    public Flight(String fnr, String knr, String reg, String typ, String ha0, String lsk,
                  String stt, String itt, String pos, String ter, String mad, String saa) {
        this.fnr = fnr;
        this.knr = knr;
        this.reg = reg;
        this.typ = typ;
        this.ha0 = ha0;
        this.lsk = lsk;
        this.stt = stt;
        this.itt = itt;
        this.pos = pos;
        this.ter = ter;
        this.mad = mad;
        this.saa = saa;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(fnr, flight.fnr) &&
                Objects.equals(knr, flight.knr) &&
                Objects.equals(reg, flight.reg) &&
                Objects.equals(typ, flight.typ) &&
                Objects.equals(ha0, flight.ha0) &&
                Objects.equals(lsk, flight.lsk) &&
                Objects.equals(stt, flight.stt) &&
                Objects.equals(itt, flight.itt) &&
                Objects.equals(pos, flight.pos) &&
                Objects.equals(ter, flight.ter) &&
                Objects.equals(mad, flight.mad) &&
                Objects.equals(saa, flight.saa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fnr, knr, reg, typ, ha0, lsk, stt, itt, pos, ter, mad, saa);
    }


}
