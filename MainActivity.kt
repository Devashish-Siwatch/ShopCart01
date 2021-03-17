package com.example.shopcart01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var items: ListView
    lateinit var cart: ListView
    lateinit var Total: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var total_cost: Int = 0
        cart = findViewById(R.id.cart_list)
        items = findViewById(R.id.items)
        Total = findViewById(R.id.Total)
        var arrayAdapter: ArrayAdapter<*>
        var arrayAdapterCart: ArrayAdapter<*>
        val users = arrayOf(
                "Laptop @ 75000INR", "PC @ 55000INR", "Phone @ 15000INR",
                "Mouse @ 1000INR", "Keyboard @ 2000INR"
        )
        var cartArray: MutableList<String> = ArrayList()

        // access the listView from xml file
        arrayAdapter = ArrayAdapter(this,
                android.R.layout.simple_list_item_1, users)

        items.adapter = arrayAdapter

        items.setOnItemClickListener { _, _, position, _ ->
            val element = arrayAdapter.getItem(position) // The item that was clicked
            total_cost+=  when(element){
                "Laptop @ 75000INR"->75000
                "PC @ 55000INR"->55000
                "Phone @ 15000INR"->15000
                "Mouse @ 1000INR"->1000
                else -> 2000
            }
            if (element != null) {
                cartArray.add(element)
            }
            arrayAdapterCart = ArrayAdapter(this,
                    android.R.layout.simple_list_item_1, cartArray)
            cart.adapter = arrayAdapterCart
            Total.text= total_cost.toString()
            //Deleting an item from cart
            cart.setOnItemClickListener { _, _, position, _ ->
                val element = arrayAdapterCart.getItem(position) // The item that was clicked
                total_cost-=  when(element){
                    "Laptop @ 75000INR"->75000
                    "PC @ 55000INR"->55000
                    "Phone @ 15000INR"->15000
                    "Mouse @ 1000INR"->1000
                    else -> 2000
                }
                if (element != null) {
                    cartArray.remove(element)
                }

                arrayAdapterCart = ArrayAdapter(this,
                        android.R.layout.simple_list_item_1, cartArray)
                cart.adapter = arrayAdapterCart
                Total.text= total_cost.toString()
            }
        }




    }
}