package com.example.ksron.znjt.Sqlite;

public class UserSqlite {
    private int id;
    private String yu_e;
    private int chehao;
    private String chongzhijin_e;
    private String caozuoren;
    private String time;
    public UserSqlite(int id, String yu_e, int chehao, String chongzhijin_e, String caozuoren, String time) {
        this.id = id;
        this.yu_e = yu_e;
        this.chehao = chehao;
        this.chongzhijin_e = chongzhijin_e;
        this.caozuoren = caozuoren;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYu_e() {
        return yu_e;
    }

    public void setYu_e(String yu_e) {
        this.yu_e = yu_e;
    }

    public int getChehao() {
        return chehao;
    }

    public void setChehao(int chehao) {
        this.chehao = chehao;
    }

    public String getChongzhijin_e() {
        return chongzhijin_e;
    }

    public void setChongzhijin_e(String chongzhijin_e) {
        this.chongzhijin_e = chongzhijin_e;
    }

    public String getCaozuoren() {
        return caozuoren;
    }

    public void setCaozuoren(String caozuoren) {
        this.caozuoren = caozuoren;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
