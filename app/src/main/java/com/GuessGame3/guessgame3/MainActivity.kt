package com.GuessGame3.guessgame3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.GuessGame3.guessgame3.R.id.txtRightAnswer
import java.util.*

class MainActivity : AppCompatActivity() {
    internal var Fruits = arrayOf(

        "Apple","Banana","Mango","Avocado","Pomegranate","Litchi","Strawberry","Blueberry"
    )
    lateinit var fruit:String
    lateinit var random: Random


    lateinit var txtRightAnswer:TextView
    lateinit var txtQuestionContainer:TextView
    lateinit var txtCorrectAnswer:TextView
    lateinit var etUserInput:EditText
    lateinit var btnShow: Button
    lateinit var btnCheck:Button
    lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtRightAnswer = findViewById(R.id.txtRightAnswer)
        txtCorrectAnswer = findViewById(R.id.txtCorrectAnswer)
        txtQuestionContainer = findViewById(R.id.txtQuestionContainer)

        etUserInput = findViewById(R.id.etUserInput)
        btnShow = findViewById(R.id.btnShow)
        btnNext = findViewById(R.id.btnNext)
        btnCheck = findViewById(R.id.btnCheck)

        random = Random()
        //logic
        fruit = Fruits[random.nextInt(Fruits.size)]

        txtQuestionContainer.text = mixWords(fruit)

        btnCheck.setOnClickListener {
        if (etUserInput.text.toString().equals(fruit,ignoreCase = true))
        {
            Toast.makeText(this@MainActivity,"You Got it:)", Toast.LENGTH_SHORT).show()
        }
            else
        {
           Toast.makeText(this@MainActivity,"You Failed:(",Toast.LENGTH_SHORT).show()

        }
        btnNext.setOnClickListener{
            fruit = Fruits[random.nextInt(Fruits.size)]
            txtQuestionContainer.text = mixWords(fruit)

            etUserInput.setText("")
            txtRightAnswer.visibility = View.INVISIBLE
            txtCorrectAnswer.visibility = View.INVISIBLE

        }
        btnShow.setOnClickListener{
            txtCorrectAnswer.visibility = View.VISIBLE
            txtRightAnswer.visibility = View.VISIBLE

            txtRightAnswer.text = fruit
        }
    }
    }

    fun mixWords(word:String): String{

        val word = Arrays.asList<String>(*word.split("".toRegex()).dropLastWhile({it.isEmpty()}).toTypedArray())//gets arrays and splits into different characters for random arrangementes

        Collections.shuffle(word)
        var mixed = ""
        for(i in word){
            mixed += i
        }
        return mixed
    }
}