package com.meetic.shuffle.sample.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.meetic.shuffle.Shuffle;
import com.meetic.shuffle.sample.R;

public class TestAdapter extends Shuffle.Adapter<TestShuffleViewHolder> {

    public static final int ITEM_COUNT = 20;

    boolean displayText = false;

    public boolean isDisplayText() {
        return displayText;
    }

    public TestAdapter setDisplayText(boolean displayText) {
        this.displayText = displayText;
        return this;
    }

    @Override
    public TestShuffleViewHolder onCreateViewHolder(ViewGroup viewGroup, int type) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bal_tmp_cell, viewGroup, false);
        return new TestShuffleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TestShuffleViewHolder viewHolder, int position) {
        if (displayText) {
            viewHolder.bind(position);
        }
    }

    @Override
    public int getItemCount() {
        return ITEM_COUNT;
    }
}
