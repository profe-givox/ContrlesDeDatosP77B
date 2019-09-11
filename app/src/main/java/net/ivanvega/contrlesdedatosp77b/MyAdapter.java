package net.ivanvega.contrlesdedatosp77b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
    Context ctx;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;

        public MyViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.txtItem);
        }
    }


    String[] mdataSet;

    public MyAdapter(String[] dataSet){
        mdataSet = dataSet;
    }

    public MyAdapter(String[] dataSet, Context ctx){
        mdataSet = dataSet;
        this.ctx = ctx;
    }


    @NonNull
    @Override
    public MyViewHolder
    onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view,
                        parent, false   );

        MyViewHolder vh = new MyViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,
                                 int position) {

        holder.textView.setText(mdataSet[position]);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx,
                        "Presionando: " + ((TextView)view).getText() , Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mdataSet.length;
    }
}
