package com.cit.complainretrive;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class adapterofitem extends RecyclerView.Adapter<adapterofitem.exampleviewholder>{

    private List<String> mData;
    private Context mcontext;
    private Onitemclicklistner mlistner;
    public interface Onitemclicklistner
    {
        void onitemclick(int position);
    }

    public void setonitemclicklistner(Onitemclicklistner listner)
    {
        mlistner=listner;
    }

    public adapterofitem(List<String> mData, Context mcontext) {
        this.mData = mData;
        this.mcontext = mcontext;
    }


    @NonNull
    @Override
    public exampleviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mcontext).inflate(R.layout.items,parent,false);

        return new exampleviewholder(v);    }


    @Override
    public void onBindViewHolder(@NonNull exampleviewholder holder, int position) {


        String Currentpostion=mData.get(position);
        holder.txtcomplaintitle.setText(Currentpostion);

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class exampleviewholder extends RecyclerView.ViewHolder{

    public TextView txtcomplaintitle;
    public TextView complainsolvedornot;
    public exampleviewholder(View itemView) {
        super(itemView);
        txtcomplaintitle=itemView.findViewById(R.id.itemtitles);
        complainsolvedornot=itemView.findViewById(R.id.solvedornot);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mlistner!=null)
                {
                    int position=getAdapterPosition();
                    if (position!=RecyclerView.NO_POSITION)
                    {
                        mlistner.onitemclick(position);
                    }
                }
            }
        });



    }
}

}
