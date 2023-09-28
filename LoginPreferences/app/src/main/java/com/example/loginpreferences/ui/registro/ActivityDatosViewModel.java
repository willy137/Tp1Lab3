package com.example.loginpreferences.ui.registro;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.loginpreferences.model.Usuario;
import com.example.loginpreferences.request.ApiClient;

public class ActivityDatosViewModel extends AndroidViewModel {
    private MutableLiveData<Long> mutableDni;
    private MutableLiveData<String> mutableApellido;
    private MutableLiveData<String> mutableNombre;
    private MutableLiveData<String> mutableMail;
    private MutableLiveData<String> mutablePassword;

    private Context context;
    public ActivityDatosViewModel(@NonNull Application application) {
        super(application);
        context=application;
    }
    public LiveData<Long> getMutableDni(){
        if (mutableDni==null){
            mutableDni=new MutableLiveData<>();
        }
        return mutableDni;
    }

    public LiveData<String> getMutableApellido(){
        if (mutableApellido==null){
            mutableApellido=new MutableLiveData<>();
        }
        return mutableApellido;
    }
    public LiveData<String> getMutableNombre(){
        if (mutableNombre==null){
            mutableNombre=new MutableLiveData<>();
        }
        return mutableNombre;
    }
    public LiveData<String> getMutableMail(){
        if (mutableMail==null){
            mutableMail=new MutableLiveData<>();
        }
        return mutableMail;
    }
    public LiveData<String> getMutablePassword(){
        if (mutablePassword==null){
            mutablePassword=new MutableLiveData<>();
        }
        return mutablePassword;
    }
    public void cargar(Boolean si){
        Usuario usuario= ApiClient.leer(context);
        if(si){
            if(usuario!=null){
                mutableDni.setValue(usuario.getDni());
                mutableApellido.setValue(usuario.getApellido());
                mutableNombre.setValue(usuario.getNombre());
                mutableMail.setValue(usuario.getMail());
                mutablePassword.setValue(usuario.getPassword());
            }
        }
    }
    public void guardar(String dni,String apellido,String nombre,String mail,String password){
        if(dni.equals("")||apellido.equals("")|| nombre.equals("")||mail.equals("")||password.equals("")){
            Toast.makeText(context,"No puede dejar espacios en blanco",Toast.LENGTH_LONG).show();
        }else{
            Long dni1=Long.parseLong(dni);
            Usuario user=new Usuario(dni1,apellido,nombre,mail,password);
            ApiClient.guardar(context,user);
            Toast.makeText(context,"Datos Guardados con Exito",Toast.LENGTH_LONG).show();
        }
    }
}
