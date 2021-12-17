package com.example.fizzbuzz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var result:TextView = findViewById(R.id.result)
        var eTNum:EditText = findViewById(R.id.eTNum)//EditTextは（編集型）
        val btn:Button = findViewById(R.id.btn)

        btn.setOnClickListener {
            //数字が空だとエラー
            if (eTNum.text.toString()==("")) {
                AlertDialog.Builder(this)
                    .setTitle("エラー")
                    .setMessage("数字を入力して下さい")
                    .setPositiveButton("OK",null)
                    .show()
            }else{
                //EditTextは（編集型）なのでStrに変換してIntにしないといけない
                var eTNumInt = eTNum.text.toString().toInt()
                //15と3と5で割れるか判断、when式
                when {
                    eTNumInt == 0 -> result.text = "$eTNumInt" ////0
                    eTNumInt % 15 == 0 -> result.text = "FizzBuzz"
                    eTNumInt % 3 == 0 -> result.text = "Buzz"
                    eTNumInt % 5 == 0 -> result.text = "Fizz"
                else -> {
                    result.text = "$eTNumInt"
                    //全て割れなかった場合のトースト
                    Toast.makeText(this, "$eTNumInt" , Toast.LENGTH_SHORT).show()
                }
                }
            }

        }
    }
}