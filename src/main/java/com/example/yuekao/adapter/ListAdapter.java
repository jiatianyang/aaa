package com.example.yuekao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yuekao.R;
import com.example.yuekao.bean.Datass;

import java.net.Proxy;
import java.text.FieldPosition;
import java.util.List;

/**
 * @Author：贾天阳
 * @E-mail： 15001194794@163.com
 * @Date：2019/3/8 10:38
 * @Description：描述信息
 */
public class ListAdapter extends BaseAdapter {
    private Context context;
    private List<Datass> data;

    public ListAdapter(Context context, List<Datass> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        int type = getItemViewType(i);
                ViewHolder1 holder1;
                if (view == null) {
                    view = view.inflate(context, R.layout.item1, null);
                    holder1 = new ViewHolder1();
                    holder1.text1 = view.findViewById(R.id.text_list1);
                    holder1.ima1 = view.findViewById(R.id.ima1);
                    holder1.ima2 = view.findViewById(R.id.ima2);
                    holder1.ima3 = view.findViewById(R.id.ima3);
                    view.setTag(holder1);
                } else {
                    holder1 = (ViewHolder1) view.getTag();
                }
                holder1.text1.setText(data.get(i).getTitle());
                String str = "http://img.365jia.cn/uploads/special/tuku/201806/5b247f05646c345194.jpg";
                Glide.with(context).load(str).into(holder1.ima1);
                Glide.with(context).load(str).into(holder1.ima2);
                Glide.with(context).load(str).into(holder1.ima3);

        return view;
    }

    class ViewHolder1 {
        TextView text1;
        ImageView ima1;
        ImageView ima2;
        ImageView ima3;
    }

    class ViewHolder3 {
        TextView text3;
        ImageView ima7;
    }
}
