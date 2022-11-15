package com.example.efhem_rouhek;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.efhem_rouhek.Entity.doctor;

import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder>{


    private List<doctor> localDataSet;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final TextView spec;
        private final TextView loc;

        private final CardView cardme;
        private final ImageView imageview;
        private final Button btn;

        public ViewHolder(View view) {
            super(view);
            // Define click listener foimageMaladie
            spec=(TextView) view.findViewById(R.id.spec);
            loc=(TextView) view.findViewById(R.id.localisation);
            textView = (TextView) view.findViewById(R.id.nom);
            imageview = (ImageView) view.findViewById(R.id.idUrlImg1);
            btn = (Button) view.findViewById(R.id.btnMore2);
            cardme = (CardView) view.findViewById(R.id.appCompatBon);
        }

        public TextView getTextView() {
            return textView;
        }
    }
    public CustomerAdapter(Context c , List<doctor> dataSet) {
        this.context = c;
        localDataSet = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(context)
                .inflate(R.layout.activity_doc, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {


        doctor m = localDataSet.get(position);
        viewHolder.textView.setText(m.getNom()+m.getPrenom());
        viewHolder.loc.setText(m.getAdresse());
        viewHolder.spec.setText(m.getSpecialite());

        String uri = m.getPhoto();  // where myresource (without the extension) is the file

        int imageResource =  viewHolder.itemView.getContext().getResources().getIdentifier(uri, null,  viewHolder.itemView.getContext().getPackageName());
        viewHolder.imageview.setImageDrawable( viewHolder.itemView.getContext().getResources().getDrawable(imageResource));

        viewHolder.btn.setOnClickListener(view ->
        {
            Intent intent = new Intent(this.context, Doctors.class);

            intent.putExtra("nom",m.getNom()+m.getPrenom());

            intent.putExtra("spec",m.getSpecialite());
            intent.putExtra("loc",m.getAdresse());
            intent.putExtra("image",m.getPhoto());

            viewHolder.itemView.getContext().startActivity(intent);


        } );



    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
