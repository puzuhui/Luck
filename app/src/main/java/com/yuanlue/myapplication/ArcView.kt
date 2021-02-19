package com.yuanlue.myapplication

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kotlin.math.min

/**
 *@Description:  java类作用描述
 *@Author:       pzh
 *@CreateDate:   2021/2/19  11:17
 */
class ArcView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    var center = 0f
    val mPaint = Paint().apply {
        style = Paint.Style.STROKE
        color = Color.BLUE
        isAntiAlias = true
    }
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        center = min(width, height) / 2f
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            mPaint.color = Color.RED
            mPaint.style = Paint.Style.FILL
            it.drawCircle(center, center, 50f, mPaint)
            val path = Path()
            path.moveTo(center -20 ,center)
            path.lineTo(center+20,center)
            path.lineTo(center,center-240)
            path.close()
            it.drawPath(path,mPaint)
        }
    }
}