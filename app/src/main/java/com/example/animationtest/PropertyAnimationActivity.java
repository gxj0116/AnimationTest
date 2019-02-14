package com.example.animationtest;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * 使用属性动画实现Button的宽度变为500
 * 用一个类来包装原始对象, 间接为其提供get和set方法。
 */
public class PropertyAnimationActivity extends AppCompatActivity {

    private Button mButton;
    private Button mButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        mButton = findViewById(R.id.btn1);
        mButton2 = findViewById(R.id.btn2);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v instanceof Button) {
                    performAnimate();
                }
            }
        });
    }

    private void performAnimate() {
        ViewWrapper wrapper = new ViewWrapper(mButton2);
        /**
         * ofInt的第三个参数设置为500时, 属性动画会出现闪一下的问题, 随后继续正常执行。
         * 解决方案:
         *  改为：new int[]{20, 40, 60, 80, 100, 120, 140, 160, 180, 200}
         */
        ObjectAnimator.ofInt(wrapper, "width", new int[]{20, 40, 60, 80, 100, 120, 140, 160, 180, 200}).setDuration(5000).start();
    }
}
