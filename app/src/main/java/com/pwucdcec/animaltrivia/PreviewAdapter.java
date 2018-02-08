package com.pwucdcec.animaltrivia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mykelneds on 07/02/2018.
 */

public class PreviewAdapter extends BaseAdapter {

    private Context ctx;
    private List<AnimalItem> items;
    private LayoutInflater inflater;

    public PreviewAdapter(Context ctx, List<AnimalItem> items) {
        this.ctx = ctx;
        this.items = items;

        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {

        final ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.cell_preview, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        AnimalItem item = items.get(i);
        Picasso.with(ctx).load(item.getDrawable()).into(holder.imageView);

//        if (item.getIsSolved() == 0)
//            Blurry.with(ctx).capture(view).into(holder.imageView);

        return view;
    }


    static class ViewHolder {
        @BindView(R.id.imageView)
        ImageView imageView;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
