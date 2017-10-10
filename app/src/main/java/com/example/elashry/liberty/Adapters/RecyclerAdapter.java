package com.example.elashry.liberty.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elashry.liberty.R;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

private static int NUM_OF_ITEMS;
private static String[]filmsNames;
private static String[]filmsRate;
private static int [] filmsImg;
private static Context mContext;



  public RecyclerAdapter(Context mContext, String[]filmsNames, String[]filmsRate,int[]filmsImg) {
        NUM_OF_ITEMS = filmsNames.length;
        this.filmsNames = filmsNames;
        this.filmsRate= filmsRate;
        this.filmsImg= filmsImg;
        this.mContext = mContext;

   }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.recyclerview_item,parent,false);
        RecyclerViewHolder holder = new RecyclerViewHolder(v);

        return holder;
    }

    private final static int FADE_DURATION = 1000;
    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
        holder.bind(position);
        setScaleAnimation(holder.itemView);
        holder.itemMovieImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext,filmsRate[position], Toast.LENGTH_SHORT).show();

            }
        });
    }
            // functions to Animate Recycler Items
    private void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }

    private void setScaleAnimation(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }

    @Override
    public int getItemCount() {
        if (NUM_OF_ITEMS >0){
            return NUM_OF_ITEMS;
        }else
        return 0;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        Typeface t1;
        TextView itemMovieName,itemMovieRate;
        ImageView itemMovieImage;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            itemMovieImage = (ImageView) itemView.findViewById(R.id.item_movie_image);
            itemMovieName = (TextView) itemView.findViewById(R.id.item_movie_name);

         //   itemMovieRate = (TextView) itemView.findViewById(R.id.item_movie_rate);
            itemMovieName.setTypeface(t1);
          //  t1= Typeface.createFromAsset(getAssets(),"d.ttf");
        }

        public void bind(int itemPosition){
          //  itemMovieRate.setText(filmsRate[itemPosition]);
            itemMovieName.setText(filmsNames[itemPosition]);

            itemMovieImage.setImageResource(filmsImg[itemPosition]);

        }


    }

}
