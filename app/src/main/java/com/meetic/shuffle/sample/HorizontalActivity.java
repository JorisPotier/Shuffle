package com.meetic.shuffle.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.meetic.dragueur.Direction;
import com.meetic.dragueur.DraggableView;
import com.meetic.shuffle.Shuffle;
import com.meetic.shuffle.sample.adapter.TestAdapter;

public class HorizontalActivity extends AppCompatActivity {

    @Bind(R.id.shuffle)
    Shuffle shuffle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal);
        ButterKnife.bind(this);
        shuffle.setShuffleAdapter(new TestAdapter());

        shuffle.addListener(new Shuffle.Listener() {
            @Override
            public void onViewChanged(int position) {
                Log.d("HorizontalActivity", "onViewChanged(" + position + ")");
            }

            @Override
            public void onScrollStarted() {
//                Log.d("HorizontalActivity", "onScrollStarted()");
                // NOOP
            }

            @Override
            public void onScrollFinished() {
//                Log.d("HorizontalActivity", "onScrollFinished()");
                // NOOP
            }

            @Override
            public void onViewExited(DraggableView draggableView, Direction direction) {
                final int currentPosition = shuffle.getCurrentAdapterPosition();
                Log.d("HorizontalActivity",
                        String.format("onViewExited(view, %s) -> shuffle.getCurrentAdapterPosition() = %d",
                                direction, currentPosition));

                if (currentPosition > TestAdapter.ITEM_COUNT) {
                    HorizontalActivity.this.finish();
                }
            }

            @Override
            public void onViewScrolled(DraggableView draggableView, float percentX, float percentY) {
//                Log.d("HorizontalActivity", "onViewScrolled(draggableView, percentX, percentY)");
                // NOOP
            }
        });
    }

    @OnClick(R.id.left)
    public void onClickLeft() {
        shuffle.swipeLeft(1000);
    }

    @OnClick(R.id.right)
    public void onClickRight() {
        shuffle.swipeRight(1000);
    }

}