package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    var variavelx:Int = 0
    var variavely:Int = 0
    var resultado:Int = 0

    val setVariavelXlauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if(result.resultCode == RESULT_OK){
            variavelx = result.data!!.getIntExtra("VALOR", 0)
            val textox = findViewById<TextView>(R.id.textoX)
             textox.text = "${variavelx}"
        }else{
            Toast.makeText(this, "cancelado", Toast.LENGTH_SHORT).show()
        }
    }

    val setVariavelYlauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if(result.resultCode == RESULT_OK){
            variavely = result.data!!.getIntExtra("VALOR", 0)
            val textox = findViewById<TextView>(R.id.textoY)
            textox.text = "${variavely}"
        }else{
            Toast.makeText(this, "cancelado", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textox = findViewById<TextView>(R.id.textoX)
        val textoy = findViewById<TextView>(R.id.textoY)
        val textoresultado = findViewById<TextView>(R.id.textoResultado)

        textox.text ="${variavelx}"
        textoy.text ="${variavely}"
        textoresultado.text ="${resultado}"

        val buttonx = findViewById<Button>(R.id.buttonX)
        val buttony = findViewById<Button>(R.id.buttonY)
        val buttonCalcular = findViewById<Button>(R.id.buttonCalcular)

        buttonx.setOnClickListener {
            val intent = Intent(this, Recebe::class.java)

            val bundle = Bundle()
            bundle.putString("LABEL","variavel x")
            bundle.putInt("VALOR", variavelx)
            intent.putExtras(bundle)

            setVariavelXlauncher.launch(intent)

        }

        buttony.setOnClickListener {
            val intent = Intent(this, Recebe::class.java)

            val bundle = Bundle()
            bundle.putString("LABEL","variavel y")
            bundle.putInt("VALOR", variavely)
            intent.putExtras(bundle)

            setVariavelYlauncher.launch(intent)
        }
        buttonCalcular.setOnClickListener {
            var result = variavelx + variavely
            textoresultado.text = result.toString()


            Toast.makeText(this, getString(R.string.resultado), Toast.LENGTH_SHORT).show()
        }
    }
}