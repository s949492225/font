package cn.syiyi.com.font;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by songlintao on 15/7/10.
 */
public class ViewHolder {
    private SparseArray<View> mViews;
    public int mPosition;
    private View mContvertView;

    /**
     * @param mContext 上下文
     * @param parent   复用view 的父类
     * @param layoutId 复用view id
     * @param position 当前view 的位置
     */
    public ViewHolder(Context mContext, ViewGroup parent, int layoutId, int position) {

        this.mPosition = position;
        this.mViews = new SparseArray<View>();
        mContvertView = LayoutInflater.from(mContext).inflate(layoutId, parent, false);
        mContvertView.setTag(this);
    }

    /**
     * @param context     上下文
     * @param convertView 需要复用的view
     * @param parent      复用view 的父类
     * @param layoutId    复用view id
     * @param position    当前view 的位置
     * @return 当前对象
     */
    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {

        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId, position);
        } else {
            ViewHolder holder = (ViewHolder) convertView.getTag();
            if (holder == null) {
                return new ViewHolder(context, parent, layoutId, position);
            }
            holder.mPosition = position;
            return holder;
        }
    }

    /**
     * @param viewId 需要获取的view 的id
     * @param <T>    需要获取view 的类型
     * @return 返回需要返回的view
     */
    public <T extends View> T getView(int viewId) {

        View view = mViews.get(viewId);
        if (view == null) {
            view = mContvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * @return 返回当前view
     */
    public View getContvertView() {
        return mContvertView;
    }

    /**
     * 设置view的文字
     *
     * @param viewId 需要设置的view的text的id
     * @param text   需要设置的文本
     */
    public void setText(int viewId, CharSequence text) {
        ((TextView) getView(viewId)).setText(text);
    }

    /**
     * @param viewId 需要设置的view的图片的id
     * @param id     图片的id
     */
    public void setImage(int viewId, int id) {
        ((ImageView) getView(viewId)).setImageResource(id);
    }

    /**
     * @param viewId   需要设置的view的图片的id
     * @param drawable 图片的drawable
     */
    public void setImage(int viewId, Drawable drawable) {
        ((ImageView) getView(viewId)).setImageDrawable(drawable);
    }

    public void setVisible(int viewId, int visible) {
        getView(viewId).setVisibility(visible);
    }

}
