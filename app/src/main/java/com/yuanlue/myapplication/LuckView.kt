package com.yuanlue.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import kotlin.math.min

/**
 *@Description:  java类作用描述
 *@Author:       pzh
 *@CreateDate:   2021/1/12  15:27
 */
class LuckView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    var center = 0f
    val mPaint = Paint().apply {
        style = Paint.Style.STROKE
        color = Color.BLUE
        isAntiAlias = true
    }
    val mPaint1 = Paint().apply {
        style = Paint.Style.FILL
        color = Color.GRAY
    }
    val mTextPaint = Paint().apply {
        style = Paint.Style.FILL
        color = Color.WHITE
        textSize = 50f
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        center = min(width, height) / 2f
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            it.drawCircle(center, center, center, mPaint)
            val rectF = RectF(0f, 0f, width.toFloat(), height.toFloat())
            for (i in 0..5) {
                if (i % 2 == 0) {
                    mPaint1.color = Color.GRAY
                    it.drawArc(rectF, i * 60f, 60f, true, mPaint1)
                } else {
                    mPaint1.color = Color.BLUE
                    it.drawArc(rectF, i * 60f, 60f, true, mPaint1)
                }
            }

            val rectF1 = RectF(80f, 80f, center * 2 - 80f, center * 2 - 80f)
            mTextPaint.textAlign = Paint.Align.CENTER
            for (i in 0..5) {
                val path = Path()
                path.addArc(rectF1, 60f * i, 60f)
                it.drawTextOnPath("你好啊${i}", path, 0f, 0f, mTextPaint)
            }
        }
    }

    fun start(index:Int){
        val animation = RotateAnimation(
            0f,
            (index-1) * 60  + 360 * 5f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
        ).apply {
            duration = 2000
        }
        animation.fillAfter = true
        startAnimation(animation)
    }
}