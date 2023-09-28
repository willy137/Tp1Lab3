package com.example.loginpreferences.request;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.loginpreferences.model.Usuario;

public class ApiClient {
    private static SharedPreferences sp;
    private static SharedPreferences conetar(Context context){
        if (sp==null){
            sp=context.getSharedPreferences("datos",0);
        }
        return sp;
    }
    public static void guardar(Context context, Usuario user){
        SharedPreferences sp=conetar(context);
        SharedPreferences.Editor ed=sp.edit();
        ed.putLong("dni",user.getDni());
        ed.putString("apellido",user.getApellido());
        ed.putString("nombre",user.getNombre());
        ed.putString("mail",user.getMail());
        ed.putString("password",user.getPassword());
        ed.commit();
    }
    public static Usuario leer(Context context){
        SharedPreferences sp=conetar(context);
        Long dni=sp.getLong("dni",-1);
        String apellido=sp.getString("apellido","-1");
        String nombre=sp.getString("nombre","-1");
        String mail=sp.getString("mail","-1");
        String password=sp.getString("password","-1");
        Usuario usuario=new Usuario(dni,apellido,nombre,mail,password);
        return usuario;
    }

    public static Usuario login(Context context,String mail, String password){
        Usuario usuario=null;
        SharedPreferences sp=conetar(context);
        Long dni=sp.getLong("dni",-1);
        String apellido=sp.getString("apellido","-1");
        String nombre=sp.getString("nombre","-1");
        String mail1=sp.getString("mail","-1");
        String password1=sp.getString("password","-1");
        if(mail.equals(mail1)&&password.equals(password1)){
            usuario=new Usuario(dni,apellido,nombre,mail1,password1);
        }
        return usuario;
    }
}
