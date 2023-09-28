package com.example.loginpreferences.ui.registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.loginpreferences.R;
import com.example.loginpreferences.databinding.ActivityVistaDatosBinding;
import com.example.loginpreferences.model.Usuario;
import com.example.loginpreferences.ui.login.MainActivity;

public class DatosActivity extends AppCompatActivity {
    private ActivityVistaDatosBinding binding;
    private ActivityDatosViewModel mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityVistaDatosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ActivityDatosViewModel.class);
        mv.getMutableDni().observe(this, new Observer<Long>() {
            @Override
            public void onChanged(Long dni) {
                binding.etDni.setText(dni+"");
            }
        });
        mv.getMutableApellido().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String apellido) {
                binding.etApellido.setText(apellido);
            }
        });
        mv.getMutableNombre().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String nombre) {
                binding.etNombre.setText(nombre);
            }
        });
        mv.getMutableMail().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String mail) {
                binding.etMail.setText(mail);
            }
        });
        mv.getMutablePassword().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String password) {
                binding.etPassword.setText(password);
            }
        });
        Intent intent=getIntent();
        mv.cargar(intent.getBooleanExtra("login",false));
        binding.btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mv.guardar(binding.etDni.getText().toString(),binding.etApellido.getText().toString(),binding.etNombre.getText().toString(),binding.etMail.getText().toString(),binding.etPassword.getText().toString());
            }
        });
        binding.btVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplication(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplication().startActivity(intent);
            }
        });
    }
}