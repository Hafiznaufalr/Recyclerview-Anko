package com.hafiznaufalr.net.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.hafiznaufalr.net.footballclub.adapter.Adapter
import com.hafiznaufalr.net.footballclub.model.Footballdc
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    private val recyclerViewFootballClub by lazy {
        find<RecyclerView>(R.id.recycler_view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)

        val footballs = ArrayList<Footballdc>()
        footballs.add(Footballdc(name = "Barcelona FC", image = R.drawable.img_barca, detail = getString(R.string.barca_detail)))
        footballs.add(Footballdc(name = "Real Madrid FC", image = R.drawable.img_madrid, detail = getString(R.string.madrid_detail)))
        footballs.add(Footballdc(name = "Bayern Munchen FC", image = R.drawable.img_bayern, detail = getString(R.string.bayern_detail)))
        footballs.add(Footballdc(name = "Manchester City FC", image = R.drawable.img_city, detail = getString(R.string.city_detail)))
        footballs.add(Footballdc(name = "Manchester United FC", image = R.drawable.img_mu, detail = getString(R.string.mu_detail)))
        footballs.add(Footballdc(name = "Chelsea FC", image = R.drawable.img_chelsea, detail = getString(R.string.chelsea_detail)))
        footballs.add(Footballdc(name = "AC Milan FC", image = R.drawable.img_acm, detail = getString(R.string.acm_detail)))
        footballs.add(Footballdc(name = "Arsenal FC", image = R.drawable.img_arsenal, detail = getString(R.string.arsenal_detail)))
        val adapterFootballClub = Adapter(context = this, football = footballs, listenerAdapterFootballClub = object : Adapter.ListenerAdapterFootballClub {
            override fun onClick(football: Footballdc) {
                startActivity(intentFor<DetailActivity>("data" to football))
            }
        })
        recyclerViewFootballClub.layoutManager = LinearLayoutManager(this)
        recyclerViewFootballClub.adapter = adapterFootballClub
    }

    class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            relativeLayout {
                recyclerView {
                    id = R.id.recycler_view
                }.lparams(width = matchParent, height = wrapContent)
            }
        }
    }

}

