package com.example.a1111

class DataSource {
    companion object {


        val lista = ArrayList<Osoba>()

        init{
            for (i in 1 until 11){
                lista.add(Osoba("Imię$i","Nazwisko$i",i))
            }
        }

        fun addPerson(osoba:Osoba){
            lista.add(osoba)
        }

        fun removePerson(id:Int){
            for (osoba in lista){
                if (osoba.id==id){
                    lista.remove(osoba)
                    break
                }
            }
        }
    }
}