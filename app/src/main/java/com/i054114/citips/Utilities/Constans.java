package com.i054114.citips.Utilities;

/**
 * Created by CAMILO on 28/11/2017.
 */

public class Constans {

    //BASE DE DATOS USUARIO
    public static final String TABLE_NAME_USERS = "users";
    public static final String TABLE_FIELD_USER_ID = "id";
    public static final String TABLE_FIELD_USER_USERNAME = "username";
    public static final String TABLE_FIELD_USER_PASSWORD = "password";
    public static final String TABLE_FIELD_USER_CONFIRMPASSWORD = "confirmpassword";
    public static final String CREATE_TABLE_USERS =
            "CREATE TABLE "+ TABLE_NAME_USERS+" ("+
                    TABLE_FIELD_USER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    TABLE_FIELD_USER_USERNAME+" TEXT, "+
                    TABLE_FIELD_USER_PASSWORD+" TEXT, "+
                    TABLE_FIELD_USER_CONFIRMPASSWORD+" TEXT)";

    //BASE DE DATOS CITA

    public static final String TABLE_NAME_CITAS = "citas";
    public static final String TABLE_FIELD_CITAS_ID = "id";
    public static final String TABLE_FIELD_CITAS_NAMEUSER= "namepaciente";
    public static final String TABLE_FIELD_CITAS_CEDULA = "cedula";
    public static final String TABLE_FIELD_CITAS_TELEFONO = "telefono";
    public static final String TABLE_FIELD_CITAS_NAMEDOCTOR = "nameDoctor";
    public static final String TABLE_FIELD_CITAS_FECHA = "fecha";
    public static final String TABLE_FIELD_CITAS_HORA= "hora";
    public static final String CREATE_TABLE_CITAS =
            "CREATE TABLE "+ TABLE_NAME_CITAS+" ("+
                    TABLE_FIELD_CITAS_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    TABLE_FIELD_CITAS_NAMEUSER+" TEXT, "+
                    TABLE_FIELD_CITAS_CEDULA+" TEXT, "+
                    TABLE_FIELD_CITAS_TELEFONO+" TEXT, "+
                    TABLE_FIELD_CITAS_NAMEDOCTOR+" TEXT, "+
                    TABLE_FIELD_CITAS_FECHA+" TEXT, "+
                    TABLE_FIELD_CITAS_HORA+" TEXT)";

}
