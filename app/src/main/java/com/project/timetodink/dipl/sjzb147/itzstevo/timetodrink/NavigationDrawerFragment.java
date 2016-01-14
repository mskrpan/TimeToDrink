package com.project.timetodink.dipl.sjzb147.itzstevo.timetodrink;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

//import bez kojeh se ne može definirati navigationdrawerfragment


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment {

    private View contanerView;
    private RecyclerView recyclerView;
    private RecycleAdapter adapter;

    public static final String PREF_FILE_NAME = "examplePrefs";
    public static final String USER_LEARN_DRAWER = "user_learn_drawer";

    //objekti u koje ćemo passat naše djelove tj prebacivanje iz šupljeg u prazno
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    //kreiranje boolean varijable koja će provjeravat dali je korisnik svjestan da drawer postoji ili ne
    private boolean mUsertLearnedDrawer;

    //kreiranje druge boolena vrijednosti koja će gledati dali je fragment pokrenut po prvi puta ili dolazi iz rotacije
    private boolean mFromSavedInstanceState;

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUsertLearnedDrawer = Boolean.valueOf(readSharedPreferances(getActivity(), USER_LEARN_DRAWER, "false"));
        //ako savedinstance nije null
        if (savedInstanceState != null) {
            mFromSavedInstanceState = true;
        }
    }

   // @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        //poziva drawerList iz Fragment_navigation_drawera
        recyclerView = (RecyclerView) layout.findViewById(R.id.drawerList);
        adapter = new RecycleAdapter(getActivity(),getPodatci());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity().getApplicationContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return layout;
    }

    public List<InformationRecycleList> getPodatci() {
        List<InformationRecycleList> podatci = new ArrayList<>();
        int[] icons = {R.drawable.ic_cal_1, R.drawable.ic_alarm_1, R.drawable.ic_assessment_1, R.drawable.ic_log_1};
        String[] titles = {"Calculator", "Alarm", "Chart", "Info List"};
        for (int i = 0; i < titles.length && i < icons.length; i++) {
            InformationRecycleList current = new InformationRecycleList();
            current.iconId=icons[i];
            current.title=titles[i];
            podatci.add(current);
        }
        return podatci;
    }

    //passamo sve što imamo unutra a to je drawerLayout i toolBar naš kako bi sve povezali
    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) {
        contanerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open,
                R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                //ako naš user nije nikad vidjeo drawer onda ga je upravio vidjeo
                if (!mUsertLearnedDrawer) {
                    mUsertLearnedDrawer = true;
                    // "" nam je da smo boolean pretvorili u string i tako ubacujemo tj sačuvamo da je otvoren drawer
                    saveSharedPreferances(getActivity(), USER_LEARN_DRAWER, mUsertLearnedDrawer + "");
                }
                getActivity().invalidateOptionsMenu();
                //s ovim kad otvorimo on će napravit redraw menua
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                //s ovim kad zatvorimo on će napravit redraw menua
                getActivity().invalidateOptionsMenu();
            }
           /*/da naredimo zasjenjivanje action bara kad otvaramo drawer
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                if (slideOffset<0.6){
                    toolbar.setAlpha(1-slideOffset);
                }
                //ne treba super.onDrawerSlide(drawerView, slideOffset);
            }*/
        };
        //ako korisnik nikad nije vidio drawer i ako je ovaj fragment
        //prvi put pokrenut u tom slučaju prikaži drawer
        if (!mUsertLearnedDrawer && !mFromSavedInstanceState) {
            //passali smo contener view i otvara drawer
            mDrawerLayout.openDrawer(contanerView);
        }
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        //s ovim radimo da napravimo hanburger menu
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }

    public static void saveSharedPreferances(Context context, String preferancesName, String preferanceValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(preferancesName, preferanceValue);
        editor.apply();
    }

    public static String readSharedPreferances(Context context, String preferancesName, String defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(preferancesName, defaultValue);
    }
}
