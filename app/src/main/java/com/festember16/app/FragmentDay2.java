package com.festember16.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by santh on 16-09-2016.
 */
public class FragmentDay2 extends android.support.v4.app.Fragment
{
    ListView listView;
    TextView t;

    List<String> eventNames = new ArrayList<>(), eventVenues = new ArrayList<>(), startTime = new ArrayList<>(), endTime = new ArrayList<>();

    public FragmentDay2()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        eventNames.clear();
        eventVenues.clear();
        startTime.clear();
        endTime.clear();
        for( Events e: EventsListByDay.eventsDay2)
        {
            eventNames.add( e.name );
            eventVenues.add( e.venue);
            startTime.add( e.startTime );
            endTime.add( e.endTime);
        }

        EventsScheduleAdapter adapter = new EventsScheduleAdapter( getContext() , eventNames, eventVenues , startTime , endTime);

        View list =  inflater.inflate( R.layout.layout_fragment_day_2 , container, false);
        t = (TextView) list.findViewById(R.id.day2NoEvent);
        if( eventNames.size() == 0)
        {
            t.setText("No Events");
            listView.setVisibility(View.GONE);

        }
        else
        {
            t.setVisibility(View.GONE);
        }
        listView = (ListView) list.findViewById(R.id.EventsListDay2);
        listView.setAdapter( adapter );

        return list;    }

}
