package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Recebe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recebe)

        val label = intent.extras?.getString("LABEL")
        val valor = intent.extras?.getInt("VALOR")


        val labelVariavel = findViewById<TextView>(R.id.textLabelVariavel)

        val editText = findViewById<EditText>(R.id.editetextvariavel)

        labelVariavel.text = label
        editText.setText(valor.toString())
        val buttonOk = findViewById<Button>(R.id.buttonok)
        val buttonCancelar = findViewById<Button>(R.id.buttoncancelar)


        buttonOk.setOnClickListener {
            val intent = Intent()
            val bundle = Bundle()

            val editText = findViewById<EditText>(R.id.editetextvariavel)
            bundle.putInt("VALOR", editText.text.toString().toInt())
            intent.putExtras(bundle)

            setResult(RESULT_OK, intent)
            finish()
        }
        buttonCancelar.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
    }
