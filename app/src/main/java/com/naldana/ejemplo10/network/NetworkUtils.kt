package com.naldana.ejemplo10.network

import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.naldana.ejemplo10.Utilities.Coin


class NetworkUtils {
    val db = FirebaseFirestore.getInstance()
    
    val lista : MutableList<Coin> = arrayListOf()
    
    val colecion = db.collection("coin")
        .get()
        .addOnCompleteListener (OnCompleteListener<QuerySnapshot> { task ->
            if (task.isSuccessful) {
                for (document in task.result!!) {
                   val moneda = Coin(
                       document.id,
                       document.data.get("name").toString(),
                       document.data.get("country").toString(),
                       document.data.get("value").toString().toFloat(),
                       document.data.get("value_us").toString().toFloat(),
                       document.data.get("year").toString().toInt(),
                       document.data.get("review").toString(),
                       document.data.get("isAvailable") as Boolean,
                       document.data.get("img").toString()
                   )
                    lista.add(moneda)
                }
                
            } else {
                Log.d("ERROR", "Error getting documents: ", task.exception)
            }
        })
    
    fun start(): MutableList<Coin> {
        colecion.isSuccessful
        return lista
    }
    
    
    
}