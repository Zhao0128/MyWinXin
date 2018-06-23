package com.example.mywinxin;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * MainFragment中ListView的适配器
 *
 * @author xukai
 * 2015年12月5日
 */
class MessFragAdapter extends BaseAdapter {

    private List<HashMap<String, Object>> list;
    private Context context;

    public MessFragAdapter(List<HashMap<String, Object>> list,
                           Context context) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.person, null);

            holder = new ViewHolder();
            holder.iv = (ImageView) convertView
                    .findViewById(R.id.image);
            holder.tvName = (TextView) convertView
                    .findViewById(R.id.name);
            holder.tvMsg = (TextView) convertView
                    .findViewById(R.id.Speak);
            holder.tvTime = (TextView) convertView
                    .findViewById(R.id.time);
            //设置Tag
            convertView.setTag(holder);
        } else {
            //获取Tag
            holder = (ViewHolder) convertView.getTag();
        }
        HashMap<String, Object> map = list.get(position);
        holder.iv.setImageResource((Integer) map.get("image"));
        holder.tvName.setText((CharSequence) map.get("name"));
        holder.tvTime.setText((CharSequence) map.get("time"));
        holder.tvMsg.setText((CharSequence) map.get("message"));
        return convertView;
    }

    /**
     * 内部类：为ListView的Item中的所有组件<br>
     * 方便使用，不用每次都重新new
     *
     * @author xukai
     * 2015年12月5日
     */
    class ViewHolder {
        ImageView iv;
        TextView tvName;
        TextView tvMsg;
        TextView tvTime;
    }

}