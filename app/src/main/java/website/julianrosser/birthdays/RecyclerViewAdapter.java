package website.julianrosser.birthdays;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RecyclerViewAdapter
        extends RecyclerView.Adapter
        <RecyclerViewAdapter.ListItemViewHolder> {

    String TAG = getClass().getSimpleName();

    // Constructor
    public RecyclerViewAdapter(ArrayList<Birthday> birthdayData) { //
        if (birthdayData == null) {
            MainActivity.birthdaysList = new ArrayList<>();
        } else if (birthdayData.size() == 0) {
            // After Adapter is constructed, start the process of loading data
            MainActivity.getContext().launchLoadBirthdaysTask();
        }

        Log.d(TAG, "newAdapter");
    }


    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.birthday_list_view, viewGroup, false);

        return new ListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ListItemViewHolder viewHolder, final int position) {
        // Get reference to birthday
        final Birthday birthday = MainActivity.birthdaysList.get(position);

        // Pass data to the TextViews
        viewHolder.textName.setText(birthday.getName());

        viewHolder.textDaysRemaining.setText(birthday.getFormattedDaysRemainingString());

        viewHolder.textDateDay.setText(birthday.getBirthDay());

        viewHolder.textDateMonth.setText(birthday.getBirthMonth());

        // When item is clicked, show context menu for that item
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open ItemOption menu for selected birthday
                MainActivity.getContext().showItemOptionsFragment(position);
            }
        });
    }

    @Override
    public void onViewRecycled(ListItemViewHolder holder) {
        holder.itemView.setOnLongClickListener(null);
        super.onViewRecycled(holder);
    }

    /**
     * Sort List by time remaining
     */
    public static void sortBirthdaysByDate() {

        for (Birthday b : MainActivity.birthdaysList)
            b.setYearOfDate(Birthday.getYearOfNextBirthday(b.getDate()));

        //Sorting
        Collections.sort(MainActivity.birthdaysList, new Comparator<Birthday>() {
            @Override
            public int compare(Birthday b1, Birthday b2) {
                return b1.getDate().compareTo(b2.getDate());
            }
        });
    }

    @Override
    public int getItemCount() {
        return MainActivity.birthdaysList.size();
    }

    /**
     * ViewHolder class to hold view references to be used in recyclerview.
     */
    public final static class ListItemViewHolder extends RecyclerView.ViewHolder {

        // TextView references
        TextView textDateDay;
        TextView textDateMonth;
        TextView textName;
        TextView textDaysRemaining;
        Typeface typeLight;

        public ListItemViewHolder(View itemView) {
            super(itemView);

            // Set up references
            textName = (TextView) itemView.findViewById(R.id.name);
            textDaysRemaining = (TextView) itemView.findViewById(R.id.days_remaining);
            textDateDay = (TextView) itemView.findViewById(R.id.dateDay);
            textDateMonth = (TextView) itemView.findViewById(R.id.dateMonth);
            typeLight = Typeface.createFromAsset(MainActivity.getAppContext().getResources().getAssets(), "Roboto-Light.ttf");
        }
    }
}