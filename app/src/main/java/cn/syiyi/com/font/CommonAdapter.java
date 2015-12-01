package cn.syiyi.com.font;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 继承此类只需要实现convert(ViewHolder holder, int position)此方法，不需要单独写viewholder
 * Created by songlintao on 15/7/10.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    protected Context mContext;
    protected List<T> mData;
    protected LayoutInflater mInflate;
    protected int layoutID;
    protected ViewHolder mViewHolder;

    /**
     * @param data     列表数据
     * @param mContext context
     * @param layoutID cell的布局id
     */
    public CommonAdapter(List<T> data, Context mContext, int layoutID) {

        this.mData = data;
        this.mContext = mContext;
        this.mInflate = LayoutInflater.from(mContext);
        this.layoutID = layoutID;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//       实现convertView复用，并向ViewHolder填充字段
        final ViewHolder holder = ViewHolder.get(mContext, convertView, parent, layoutID, position);
        mViewHolder=holder;
        convert(holder, position);
        View v = holder.getContvertView();
        final int mPosition = position;
        //这只列表项单击事件
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick(holder,mPosition);
            }
        });
        return v;
    }

    public abstract void convert(ViewHolder holder, int position);

    /**
     * 如果需要cell的点击事件复写此方法即可
     *
     * @param holder
     * @param position 当前cell的位置
     */
    public void onItemClick(ViewHolder holder, int position) {

    }


    /**
     * 初始化或重新设置列表的数据并刷新ui
     *
     * @param data 列表数据
     */
    public void setData(List<T> data) {

        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    /**
     * 加载更多数据并刷新ui
     *
     * @param data 列表数据
     */
    public void loadMoreData(List<T> data) {

        mData.addAll(data);
        notifyDataSetChanged();
    }


}
