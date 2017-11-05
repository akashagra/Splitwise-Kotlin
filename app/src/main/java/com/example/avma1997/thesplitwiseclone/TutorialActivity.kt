package com.example.avma1997.thesplitwiseclone

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Button
import android.text.Html;
import android.widget.EditText
import android.R.attr.layout
import android.content.Context
import android.view.WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS
import android.os.Build.VERSION_CODES.LOLLIPOP
import android.os.Build.VERSION.SDK_INT
import android.os.Build
import android.content.Intent

 import android.view.WindowManager

import android.support.annotation.RequiresApi
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.avma1997.thesplitwiseclone.R


class TutorialActivity : AppCompatActivity() {
    private var viewPager: ViewPager? = null
    private var myViewPagerAdapter:MyViewPagerAdapter? = null
    private var dotsLayout: LinearLayout? = null
    //    private var dots:TextView?=null
    private var dots: Array<TextView>? = null
      private var layouts: IntArray? = null
    private var btnSkip: Button? = null
    private var btnNext: Button? = null


    @RequiresApi(LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)
        viewPager = findViewById<View>(R.id.view_pager) as ViewPager
        dotsLayout = findViewById<View>(R.id.layoutDots) as LinearLayout
        btnSkip = findViewById<View>(R.id.btn_skip) as Button
        btnNext = findViewById<View>(R.id.btn_next) as Button
        layouts = intArrayOf(R.layout.tutorial_slide_one, R.layout.tutorial_slide_two, R.layout.tutorial_slide_three, R.layout.tutorial_slide_four)
        addBottomDots(0)
        changeStatusBarColor()
        myViewPagerAdapter = MyViewPagerAdapter(this)
        viewPager!!.setAdapter(myViewPagerAdapter);
        viewPager!!.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
                //To change body of created functions use File | Settings | File Templates.
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
               //To change body of created functions use File | Settings | File Templates.
            }

            override fun onPageSelected(position: Int) {
                addBottomDots(position);

                // changing the next button text 'NEXT' / 'GOT IT'
                if (position == layouts!!.size - 1) {
                    // last page. make button text to GOT IT
                    btnNext!!.setText(getString(R.string.start));
                    btnSkip!!.setVisibility(View.GONE);
                } else {
                    // still pages are left
                    btnNext!!.setText(getString(R.string.next));
                    btnSkip!!.setVisibility(View.VISIBLE);
                }
            }


        })
        btnSkip!!.setOnClickListener(View.OnClickListener { launchHomeScreen() })
        btnNext!!.setOnClickListener(View.OnClickListener {
            // checking for last page
            // if last page home screen will be launched
            val current = getItem(+1)
            if (current < layouts!!.size) {
                // move to next screen
                viewPager!!.setCurrentItem(current)
            } else {
                launchHomeScreen()
            }
        })

    }

    private fun getItem(i: Int): Int {
        return viewPager!!.getCurrentItem() + i
    }

    private fun addBottomDots(currentPage: Int) {


        dots  = Array(layouts!!.size,{i->TextView(this)})

        val colorsActive = resources.getIntArray(R.array.array_dot_active)
        val colorsInactive = resources.getIntArray(R.array.array_dot_inactive)

        dotsLayout!!.removeAllViews()
        for (i in 0..dots!!.size - 1) {
            dots!![i] = TextView(this)
            dots!![i].setText(Html.fromHtml("&#8226;"))
            dots!![i].setTextSize(35F)
            dots!![i].setTextColor(colorsInactive[currentPage])
            dotsLayout!!.addView(dots!![i])
        }

        if (dots!!.size > 0)
            dots!![currentPage].setTextColor(colorsActive[currentPage])
    }
    private fun launchHomeScreen() {

    val intent= Intent(this,SplitActivity::class.java)
        startActivity(intent)

    }

    @RequiresApi(LOLLIPOP)
    private fun changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

        class MyViewPagerAdapter: PagerAdapter {
           private var layouts=intArrayOf(R.layout.tutorial_slide_one, R.layout.tutorial_slide_two, R.layout.tutorial_slide_three, R.layout.tutorial_slide_four)
        private var layoutInflater: LayoutInflater? = null
            private var context:Context?=null
            constructor(context:Context){
                this.context=context

            }
        override fun isViewFromObject(view: View?, obj: Any?): Boolean {
            return view == obj;

        }

        override fun getCount(): Int {
            return layouts!!.size
        }


        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            layoutInflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            val view = layoutInflater!!.inflate(layouts!![position], container, false)
            container.addView(view)

            return view

        }


            override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
                val view = `object` as View
                container.removeView(view)
            }


    }

}
