package com.example.animationtest;

import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * 使用属性动画实现Button的宽度变为500
 * 用一个类来包装原始对象, 间接为其提供get和set方法。
 */
public class PropertyAnimationActivity extends AppCompatActivity {

    private static final String TAG = PropertyAnimationActivity.class.getSimpleName();
    private Button mButton;
    private Button mButtonTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        mButton = findViewById(R.id.btn1);
        mButtonTwo = findViewById(R.id.btn2);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v instanceof Button) {
                     //第二种实现方式
//                    performAnimate();

                    //第二种实现方式
                    performAnimate(v, v.getWidth(), 500);
                }
            }
        });
    }

    private void performAnimate() {
        ViewWrapper wrapper = new ViewWrapper(mButtonTwo);
        /**
         * ofInt的第三个参数设置为500时, 属性动画会出现闪一下的问题, 随后继续正常执行。
         * 解决方案:
         *  改为：new int[]{20, 40, 60, 80, 100, 120, 140, 160, 180, 200}
         */
        ObjectAnimator.ofInt(wrapper, "width", new int[]{20, 40, 60, 80, 100, 120, 140, 160, 180, 200}).setDuration(5000).start();
    }

    //持有一个IntEvaluator对象, 方便下面估值的时候使用
    private IntEvaluator evaluator = new IntEvaluator();

    //采用ValueAnimator, 监听动画过程, 自己实现属性的改变
    private void performAnimate(final View target, final int start, final int end) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(1, 100);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //获得当前动画的进度值, 整形1~100之间
                int currentValue = (int) animation.getAnimatedValue();
                Log.d(TAG, "currentValue value: "+currentValue);

                //获取当前进度占整个动画过程的比例, 浮点型, 0~1之间
                float fraction = animation.getAnimatedFraction();

                //直接调用整形估值器, 通过比例计算出宽度, 然后再设给Button
                target.getLayoutParams().width = evaluator.evaluate(fraction, start, end);

                target.requestLayout();
            }
        });

        valueAnimator.setDuration(5000).start();
    }
}
