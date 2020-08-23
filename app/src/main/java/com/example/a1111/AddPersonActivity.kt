package com.example.a1111

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_person.*
import kotlinx.android.synthetic.main.activity_main.*


class AddPersonActivity : AppCompatActivity() {

   companion object {
       val PERSON= "com.example.a1111.person"
   }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_person)
    }
 fun addPerson(view: View){
     if(!name.text.isNullOrEmpty() && !surname.text.isNullOrEmpty() && !id.text.isNullOrEmpty()){
     val a = Osoba(name.text.toString(),surname.text.toString(),id.text.toString().toInt())
     intent.putExtra(PERSON,a)
     setResult(Activity.RESULT_OK,intent)
     finish()
     }
     else {
         Toast.makeText(applicationContext, "żadne pole nie może być puste!!!",Toast.LENGTH_SHORT).show()
     }

 }
}