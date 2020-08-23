package com.example.a1111

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.TextBasedSmsColumns.PERSON
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.text.StringBuilder

class MainActivity : AppCompatActivity() {
    var magazyn : ArrayList <Osoba> = ArrayList()

    companion object{
        val REQUEST_CODE_ADD_PERSON = 1
        val REQUEST_CODE_DELETE_PERSON = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        napis_1.text=getString(R.string.napis_1)
    }

    override fun onResume() {
        super.onResume()
        show()
    }

    fun guzik_1(view : View){
        // napis_1.text= "napis"
        val a = Osoba(editTextTextPersonName.text.toString(),editTextTextPersonSurname.text.toString(),editTextNumber.text.toString().toInt())
        napis_1.text = a.imie
        napis_1.visibility = View.VISIBLE
        textView2.text = a.nazwisko
        textView3.text = a.id.toString()

        if (!magazyn.contains(a)) {
            magazyn.add(a)
        }
        show()
    }
    fun guzik_usun(view : View){
        val a = editTextNumber.text.toString().toInt()

        for (osoba in magazyn){
            if (osoba.id== a)
            {magazyn.remove(osoba)
                break
            }

        }

        show()
    }
    fun guzik_znajdz(view:View){
        val b = editTextNumber.text.toString().toInt()
        var osoba1 : Osoba? = null
        for (osoba in magazyn) {
            if (osoba.id == b){
                osoba1=osoba
                break
            }

        }

        napis_1.text = osoba1!!.imie
        textView2.text = osoba1.nazwisko
        textView3.text = osoba1.id.toString()
    }

    fun zmienDane(view:View) {
        val b = editTextNumber.text.toString().toInt()
        for (osoba in magazyn) {
            if (osoba.id == b) {
                osoba.imie = editTextTextPersonName.text.toString()
                osoba.nazwisko = editTextTextPersonSurname.text.toString()

                break
            }
        }
        show()
    }

    fun show () {

        var zmienna: StringBuilder = StringBuilder()
        for (a in magazyn) {
            zmienna.append(a.imie+" "+a.nazwisko+ " "+ a.id.toString() + "\n")
        }

        textView.text = zmienna.toString()
    }
    fun nowaAktywnosc(view : View){
        val intent = Intent(this,AddPersonActivity::class.java)
        startActivityForResult(intent,REQUEST_CODE_ADD_PERSON)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
       if (requestCode == REQUEST_CODE_ADD_PERSON && Activity.RESULT_OK==resultCode ){
            val person = data!!.getSerializableExtra(AddPersonActivity.PERSON) as Osoba
           magazyn.add(person)

       }
    }
    fun deletePersonActivity(view: View){
        val intent = Intent(this,DeletePersonActivity::class.java)
        startActivityForResult(intent,REQUEST_CODE_DELETE_PERSON)
    }
}






