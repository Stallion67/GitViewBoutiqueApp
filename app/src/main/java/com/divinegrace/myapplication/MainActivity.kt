package com.divinegrace.myapplication

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_fashion_detail.view.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var adapter:FoodAdapter?=null
    var listOfFashion= ArrayList<Fashion>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //loads Fashions
        listOfFashion.add(Fashion("Kids Wear","Kids Fashion desinger clothes",R.drawable.cpic))
        listOfFashion.add(Fashion("Baby Wear","Baby Fashion desinger clothes",R.drawable.baby));
        listOfFashion.add(Fashion("Foot Wear","Foot Wear Fashion desinger Shoes",R.drawable.boots));
        listOfFashion.add(Fashion("Ladies Wear","Ladies wear Fashion desinger clothes",R.drawable.w1));
        listOfFashion.add(Fashion("Mens Wear","Mens Fashion desinger clothes",R.drawable.mpic));
        listOfFashion.add(Fashion("Sports Wear","Sports Wear Fashion desinger clothes",R.drawable.sports));

        adapter= FoodAdapter(this,listOfFashion)

        gvListFashion.adapter=adapter

    }

   class FoodAdapter:BaseAdapter{
       var listOfFashion=ArrayList<Fashion>()
       var context:Context?=null
       constructor(context: Context,listOfFashion:ArrayList<Fashion>):super(){
           this.context=context
           this.listOfFashion=listOfFashion
       }

       override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

           val  fashion=this.listOfFashion[position]

           var inflator =context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
           var fashionView=inflator.inflate(R.layout.fashion_ticket,null)
               fashionView.ivFashionImage.setImageResource(fashion.image!!)
               fashionView.setOnClickListener{
                   val  intent =Intent(context,FashionDetail::class.java)
                   intent.putExtra("name",fashion.name!!)
                   intent.putExtra("des",fashion.des!!)
                   intent.putExtra("image",fashion.image!!)
                   context!!.startActivity(intent)
               }
               //fashionView.tvName.text=fashion.name!!
           fashionView.tvName.text=fashion.name!!


           return fashionView

        }

       override fun getItem(position: Int): Any {
         return listOfFashion[position]
       }

       override fun getItemId(position: Int): Long {
          return position.toLong()
       }

       override fun getCount(): Int {

           return listOfFashion.size
       }

   }
}
