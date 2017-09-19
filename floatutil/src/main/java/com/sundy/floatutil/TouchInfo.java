package com.sundy.floatutil;

/**
 * 这个类包含时间触摸和手势信息。主要用于保存临时数据的onTouchEvent（位移事件）。
 * Created by sundy on 17-9-19.
 */

public class TouchInfo {
    /**
     * 窗户的状态。
     */
    public int firstX,firstY,lastX,lastY;
    public double dist,scale,firstWidth,firstHeight;
    public float ratio;
    /**
     *移动门卡标志位
     */
    public boolean moving;
    /**
     * 长按标志位
     */
    public boolean isLongPress;

    @Override
    public String toString() {
        return "WindowTouchInfo{" +
                "firstX=" + firstX +
                ", firstY=" + firstY +
                ", lastX=" + lastX +
                ", lastY=" + lastY +
                ", firstWidth=" + firstWidth +
                ", firstHeight=" + firstHeight +
                '}';
    }
}
