package com.example.loginpreferences.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.loginpreferences.model.Usuario;
import com.example.loginpreferences.request.ApiClient;
import com.example.loginpreferences.ui.registro.DatosActivity;

public class ActivityMainViewModel extends AndroidViewModel {
    private Context context;
    public ActivityMainViewModel(@NonNull Application application) {
        super(application);
        context=application;
    }
    public void inicio(String mail,String password){
        Usuario usuario= ApiClient.login(context,mail,password);
        if(usuario==null){
            Toast.makeText(context,"Usuario o Contraseña incorrectos",Toast.LENGTH_LONG).show();
        }else {
            Intent intent=new Intent(context, DatosActivity.class);
            intent.putExtra("login",true);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
    public void registrarse(){
        Intent intent=new Intent(context, DatosActivity.class);
        intent.putExtra("login",false);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
