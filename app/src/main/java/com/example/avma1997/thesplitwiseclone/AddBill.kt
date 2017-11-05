package com.example.avma1997.thesplitwiseclone

import android.app.DatePickerDialog
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.*
import com.example.avma1997.thesplitwiseclone.R.mipmap.ic_launcher
import java.util.*


class AddBill : AppCompatActivity() {
    var dateTextView=findViewById<View>(R.id.date_textview) as TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_bill)

        var catogeryList=ArrayList<Catogery>();
        catogeryList.add(Catogery("Games","https://www.google.co.in/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwjjr83506bXAhUDQo8KHeMiDnoQjRwIBw&url=https%3A%2F%2Fwww.iconfinder.com%2Ficons%2F194073%2Fconsole_game_ps_xbox_icon&psig=AOvVaw1bzyF2nF9wnxFjd3FYlw7v&ust=1509944554231789"))
        catogeryList.add(Catogery("Movies","https://www.google.co.in/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwiqqoqo1KbXAhVKpo8KHUB8ANsQjRwIBw&url=http%3A%2F%2Fdownloadicons.net%2Fmovies-icon-27923&psig=AOvVaw0KuZ54oXaz1fqvFMwkxXkM&ust=1509944650133655"))
        catogeryList.add(Catogery("Music","https://n6-img-fp.akamaized.net/free-icon/headphones-with-music-note_318-43350.jpg?size=338c&ext=jpg"))
        catogeryList.add(Catogery("Sports","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQAhqC1TcXRepNj8c7_gryyxhz0YC-21LubgeDWeogIK7NYP0o5fg"))
        catogeryList.add(Catogery("Dining Out","https://d30y9cdsu7xlg0.cloudfront.net/png/53773-200.png"))
        catogeryList.add(Catogery("Groceries","https://d30y9cdsu7xlg0.cloudfront.net/png/177723-200.png"))
        catogeryList.add(Catogery("Liquor","https://cdn2.iconfinder.com/data/icons/kitchen-pt-2-glyph/32/wine-512.png"))
        catogeryList.add(Catogery("Electronics","https://d30y9cdsu7xlg0.cloudfront.net/png/37565-200.png"))
        catogeryList.add(Catogery("Furniture","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfLvYTIE42q5hopis0EnHLDVjtXUX314ER-0x5OrQqZWjpBoXV"))
        catogeryList.add(Catogery("Household Supplies","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLWHB2tsg7rJ03cNuTvOqyLLeoGKCjm7Lr9N5CPImyUqesf8Ga"))
        catogeryList.add(Catogery("Maintaineance","http://www.freeiconspng.com/uploads/maintenance-icon-8.png"))
        catogeryList.add(Catogery("Mortgage","https://cdn3.iconfinder.com/data/icons/personal-finance/256/Home_Mortgage-512.png"))
        catogeryList.add(Catogery("Pets","https://d30y9cdsu7xlg0.cloudfront.net/png/13421-200.png"))
        catogeryList.add(Catogery("Rent","https://d30y9cdsu7xlg0.cloudfront.net/png/111368-200.png"))
        catogeryList.add(Catogery("Services","http://www.talentwave.com/wp-content/uploads/icon-home-CS-VendorQualification-02.png"))
        catogeryList.add(Catogery("Clothing","https://d30y9cdsu7xlg0.cloudfront.net/png/524455-200.png"))
        catogeryList.add(Catogery("Gifts","http://downloadicons.net/sites/default/files/love-gift-icon-85644.png"));
        catogeryList.add(Catogery("Insurance","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRYxUoPCg8xwV6_Kjv21KMorrMeP1y5bc_OjoRwVi5Lf3UdzQi9"))
        catogeryList.add(Catogery("Medical Expenses","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5kCTp-iy97Ij9eUZ9nQNRkf7zczHnIVKfJYICkHgFw9NvFxOXtA"))
        catogeryList.add(Catogery("Taxes","https://image.flaticon.com/icons/png/512/46/46587.png"))
        catogeryList.add(Catogery("Bicycle","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRMAIJOeJqeAAWLyWDVA5cqRnh_9Vjh9pRkKKQCH2G26RRDcM_C"))
        catogeryList.add(Catogery("Bus/train","https://d30y9cdsu7xlg0.cloudfront.net/png/19255-200.png"))
        catogeryList.add(Catogery("Car","https://d30y9cdsu7xlg0.cloudfront.net/png/996-200.png"))
        catogeryList.add(Catogery("Gas/fuel","https://d30y9cdsu7xlg0.cloudfront.net/png/3223-200.png"))
        catogeryList.add(Catogery("Hotel","https://d30y9cdsu7xlg0.cloudfront.net/png/13419-200.png"))
        catogeryList.add(Catogery("Parking","https://image.flaticon.com/icons/png/128/75/75905.png"))
        catogeryList.add(Catogery("Plane","https://image.flaticon.com/icons/svg/0/614.svg"))
        catogeryList.add(Catogery("Taxi","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCtO1BWMly9btULOc7tzecOIm1eBlNjudnilq7we0s9HyOB1L44A"))
        catogeryList.add(Catogery("General","http://www.iconarchive.com/download/i29294/rade8/minium-2/General-Burn.ico"))
        catogeryList.add(Catogery("Cleaning","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTbbDQN_1XGQmoHFBYEGPVX6T3OyTnMfjK4mnp1_TmWphHog_tb"))
        catogeryList.add(Catogery("Electricity","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRWP_5d9No5wrQfcF8lTAnyPFIbm-LMHp7otyPW3OPw7T6d_3yZ1w"))
        catogeryList.add(Catogery("Heat/Gas","https://d30y9cdsu7xlg0.cloudfront.net/png/689784-200.png"))
        catogeryList.add(Catogery("Trash","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTOs0oGizDPgm_Sgrm-C5tFZalhDtOPAEJdU7MeDPWvtDYxlOS_TA"))
        catogeryList.add(Catogery("TV/Phone/Internet","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTrtkw5kXTZDs-LbOWsfiYf2QGfX9RoVh9xh55yr0eJ_H_ISUj3rg"))
        catogeryList.add(Catogery("Water","https://d30y9cdsu7xlg0.cloudfront.net/png/237768-200.png"))

        var catogeryButton=findViewById<View>(R.id.catogery_image) as ImageButton
        catogeryButton.setOnClickListener(View.OnClickListener {
            val builderSingle = AlertDialog.Builder(this@AddBill)
            builderSingle.setTitle("Choose a catogery")



            val arrayAdapter=CatogeryArrayAdapter(this,catogeryList)

            builderSingle.setNegativeButton("cancel", DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })

            builderSingle.setAdapter(arrayAdapter, DialogInterface.OnClickListener { dialog, which ->
                // set the image in the imageview
            })
            builderSingle.show()
        })
        var dateBill=findViewById<View>(R.id.bill_date) as LinearLayout
        dateBill.setOnClickListener { View.OnClickListener {
            val newCalendar = Calendar.getInstance()
            val month = newCalendar.get(Calendar.MONTH)  // Current month
            val year = newCalendar.get(Calendar.YEAR)   // Current year
            showDatePicker(this@AddBill, year, month, 1)

        }}
        var groupLayout= findViewById<View>(R.id.add_bill_group) as LinearLayout
        groupLayout.setOnClickListener(View.OnClickListener {
            val builderGroup=AlertDialog.Builder(this@AddBill)
            builderGroup.setTitle("Choose group")
            // Show groups
        })
        var saveButton=findViewById<View>(R.id.save_button) as Button
        saveButton.setOnClickListener(View.OnClickListener {
            var descriptionEditText=findViewById<View>(R.id.description_editText) as EditText
            var description=descriptionEditText.text


        })



    }

    fun showDatePicker(context: Context, initialYear: Int, initialMonth: Int, initialDay: Int) {

        // Creating datePicker dialog object
        // It requires context and listener that is used when a date is selected by the user.

        val datePickerDialog = DatePickerDialog(context,
                DatePickerDialog.OnDateSetListener { datepicker, year, month, day ->
                    //This method is called when the user has finished selecting a date.
                    // Arguments passed are selected year, month and day
                    // To get epoch, You can store this date(in epoch) in database
                    val calendar = Calendar.getInstance()
                    calendar.set(year, month, day)
                    val hours = calendar.get(Calendar.HOUR_OF_DAY)
                    val minutes = calendar.get(Calendar.MINUTE)


                    // Setting date selected in the edit text
                    dateTextView.setText(day.toString() + "/" + (month + 1) + "/" + year)
                }, initialYear, initialMonth, initialDay)

        //Call show() to simply show the dialog
        datePickerDialog.show()

    }


}
