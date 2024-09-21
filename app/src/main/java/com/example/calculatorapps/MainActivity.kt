package com.example.calculatorapps

import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ReportFragment.Companion.reportFragment

class MainActivity : AppCompatActivity() {
    private lateinit var display: EditText
    private var currentExpression: String = ""
    private var history: MutableList<String> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById((R.id.disply))

        val buttons = listOf<Button>(
            findViewById(R.id.Btn0),
            findViewById(R.id.Btn1),
            findViewById(R.id.Btn2),
            findViewById((((R.id.Btn3)))),
            findViewById(R.id.Btn4),
            findViewById((R.id.Btn5)),
            findViewById(R.id.Btn6),
            findViewById(R.id.Btn7),
            findViewById(R.id.Btn8),
            findViewById(R.id.Btn9),
            findViewById(R.id.Btnadd),
            findViewById(R.id.Btnsub),
            findViewById(R.id.BtnMul),
            findViewById(R.id.BtnDiv),
            findViewById(R.id.BtnDot),
            findViewById(R.id.BtnEqual),
            findViewById(R.id.BtnClear),
            findViewById(R.id.BtnMod),
            findViewById((((((R.id.Btnsqrt)))))),
            findViewById(R.id.BtnExp),
            findViewById(R.id.BtnUndo),
            findViewById(R.id.Btnredo),
            findViewById(R.id.BtnparenL),
            findViewById(R.id.BtnparenR)
        )
        buttons.forEach { button ->
            button.setOnClickListener { onButtonClick(button.text.toString()) }
        }


    }

    private fun onButtonClick(value: String) {

        when (value) {

            "=" -> evaluteExpression()
            "C" -> clear()
            "Undo" -> undo()
            "Redo" -> Redo()
            else -> updateDisply(value)


        }

    }

    private fun clear() {
        currentExpression = ""
        display.setText("")
    }

    private fun undo() {
        if (history.isNotEmpty()) {
            currentExpression = history.removeLast()
            display.setText(currentExpression)
        }
    }

    class
    Redo {
        private fun redo() {

        }

    }

    private fun updateDisply(value: String) {
        currentExpression += value
        display.setText(currentExpression)
    }


    private fun evaluteExpression() {

        try {
            val result = evaluate(currentExpression)
            display.setText(result.toString())
            history.add(currentExpression)
            currentExpression = ""

        } catch (e: Exception) {

            display.setText("Error")
        }

    }

    private fun evaluate(exception: String): Double {
      return  exception.toDouble()


    }
}