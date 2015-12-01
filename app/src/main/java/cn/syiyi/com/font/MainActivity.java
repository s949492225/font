package cn.syiyi.com.font;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<Bean> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        datas = new ArrayList<>();
        for (int i = 0; i < 120; i++) {
            if (i == 12) {
                datas.add(new Bean("这是字号为：" + i + "--Caption ,官方推荐字号", i + ""));
            } else if (i == 14) {
                datas.add(new Bean("这是字号为：" + i + "--Buttom，Menu，Body ,官方推荐字号", i + ""));
            } else if (i == 16) {
                datas.add(new Bean("这是字号为：" + i + "--SubHead ,官方推荐字号", i + ""));
            } else if (i == 20) {
                datas.add(new Bean("这是字号为：" + i + "--Title ,官方推荐字号", i + ""));
            } else if (i == 24) {
                datas.add(new Bean("这是字号为：" + i + "--HeadLine", i + ""));
            } else if (i == 34) {
                datas.add(new Bean("这是字号为：" + i + "--Dispay1,官方推荐字号", i + ""));
            } else {
                datas.add(new Bean("这是字号为：" + i + "", i + ""));
            }
        }
        listView.setAdapter(new Myadpter(datas, this, R.layout.item));

    }

    class Myadpter extends CommonAdapter<Bean> {

        /**
         * @param data     列表数据
         * @param mContext context
         * @param layoutID cell的布局id
         */
        public Myadpter(List<Bean> data, Context mContext, int layoutID) {
            super(data, mContext, layoutID);
        }

        @Override
        public void convert(ViewHolder holder, int position) {
            holder.setText(R.id.name, mData.get(position).getName());
            TextView textVie = holder.getView(R.id.name);
            textVie.setTextSize(Float.valueOf(mData.get(position).getSize()));
        }
    }

}
