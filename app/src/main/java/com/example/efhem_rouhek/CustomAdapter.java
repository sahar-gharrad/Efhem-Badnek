package com.example.efhem_rouhek;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.efhem_rouhek.Entity.maladie;

import java.util.List;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {




    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final CardView cardme;
        private final ImageView imageview;
        private final Button btn;
        public ViewHolder(View view) {
            super(view);
            // Define click listener foimageMaladie

            textView = (TextView) view.findViewById(R.id.Textnow);
            imageview = (ImageView) view.findViewById(R.id.imageMaladie);
            btn = (Button) view.findViewById(R.id.more1);
            cardme = (CardView) view.findViewById(R.id.cardCardio);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */


    private List<maladie> localDataSet;
    private Context context;
    public CustomAdapter(Context c ,List<maladie> dataSet) {
        this.context = c;
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(context)
                .inflate(R.layout.itemmaladie, viewGroup, false);

        return new ViewHolder(view);
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {


        maladie m = localDataSet.get(position);
        viewHolder.textView.setText(m.getLabelle());

        String uri = m.getImage();  // where myresource (without the extension) is the file

        int imageResource =  viewHolder.itemView.getContext().getResources().getIdentifier(uri, null,  viewHolder.itemView.getContext().getPackageName());
        viewHolder.imageview.setImageDrawable( viewHolder.itemView.getContext().getResources().getDrawable(imageResource));
        if(m.getColor().equals("jaune")){
            viewHolder.cardme.setCardBackgroundColor(Color.argb(255,255,178,81));
        }else if(m.getColor().equals("bleu")){
            viewHolder.cardme.setCardBackgroundColor(Color.argb(255,6,146,180));
        }
        else if(m.getColor().equals("rouge")){
            viewHolder.cardme.setCardBackgroundColor(Color.argb(255,255,114,114));
        }

        viewHolder.btn.setOnClickListener(view ->
                {
                    Intent intent = new Intent(viewHolder.itemView.getContext(), maladieScreen.class);
int categ = m.getId_categorie();

String cc = String.valueOf(categ);

                    intent.putExtra("id",String.valueOf(m.getId_maladie()));
                    intent.putExtra("lab",m.getLabelle());
                    intent.putExtra("cat",cc);
                    intent.putExtra("desc",m.getDescription());
                    intent.putExtra("image",m.getImagegrand());

                    viewHolder.itemView.getContext().startActivity(intent);


                } );



    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
