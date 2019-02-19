package com.example.ksron.znjt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Scond extends AppCompatActivity {

    ArrayList<ZNJT> arrayList = new ArrayList();
    MyDapter myDapter;
    Spinner spinner2;
    private String name2;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scond);
        TextView textView = (TextView)findViewById(R.id.biaoti);
        textView.setText("红路灯管理");
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] arrd = getResources().getStringArray(R.array.spinner2);
                name2 = arrd[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        arrayList.add(new ZNJT(1,9,9,9));
        arrayList.add(new ZNJT(2,8,8,8));
        arrayList.add(new ZNJT(3,7,8,7));
        myDapter = new MyDapter();
        listView = (ListView)findViewById(R.id.id_list);
        listView.setAdapter(myDapter);

    }

    public void chaxun2(View view) {
        MyDapter myDapter1 = new MyDapter();
        if(name2.equals("路口升序")){
            myDapter1.LKSX(arrayList);
            listView.setAdapter(myDapter1);
        }else if (name2.equals("路口降序")){
            myDapter1.LKJX(arrayList);
            listView.setAdapter(myDapter1);
        }else if (name2.equals("红灯升序")){
            myDapter1.HDSX(arrayList);
            listView.setAdapter(myDapter1);
        }else if (name2.equals("红灯降序")){
            myDapter1.HDJX(arrayList);
            listView.setAdapter(myDapter1);
        }else if (name2.equals("绿灯升序")){
            myDapter1.LDSX(arrayList);
            listView.setAdapter(myDapter1);
        }else if (name2.equals("绿灯降序")){
            myDapter1.LDSX(arrayList);
            listView.setAdapter(myDapter1);
        }else if (name2.equals("黄灯升序")){
            myDapter1.HUDSX(arrayList);
            listView.setAdapter(myDapter1);
        }else if (name2.equals("黄灯降序")){
            myDapter1.HUDSX(arrayList);
            listView.setAdapter(myDapter1);
        }
    }

    public class ZNJT{

        private int lukou;
        private int hongdeng;
        private int huangdeng;
        private int lvdeng;

        public ZNJT(int lukou, int hongdeng, int huangdeng, int lvdeng) {
            this.lukou = lukou;
            this.hongdeng = hongdeng;
            this.huangdeng = huangdeng;
            this.lvdeng = lvdeng;
        }

        public int getLukou() {
            return lukou;
        }

        public void setLukou(int lukou) {
            this.lukou = lukou;
        }

        public int getHongdeng() {
            return hongdeng;
        }

        public void setHongdeng(int hongdeng) {
            this.hongdeng = hongdeng;
        }

        public int getHuangdeng() {
            return huangdeng;
        }

        public void setHuangdeng(int huangdeng) {
            this.huangdeng = huangdeng;
        }

        public int getLvdeng() {
            return lvdeng;
        }

        public void setLvdeng(int lvdeng) {
            this.lvdeng = lvdeng;
        }


    }

    public class MyDapter extends BaseAdapter{

        public void LKSX(ArrayList arrayList){
            Collections.sort(arrayList, new Comparator<ZNJT>() {
                @Override
                public int compare(ZNJT o1, ZNJT o2) {
                    if (o1.getLukou() > o2.getLukou()) return 1;
                    if (o1.getLukou() == o2.getLukou()) return 0;
                    else return -1;
                }
            });
        }
        public void LKJX(ArrayList arrayList){
            Collections.sort(arrayList, new Comparator<ZNJT>() {
                @Override
                public int compare(ZNJT o1, ZNJT o2) {
                    if (o1.getLukou() < o2.getLukou()) return 1;
                    if (o1.getLukou() == o2.getLukou()) return 0;
                    else return -1;
                }
            });
        }

        public void HDSX(ArrayList arrayList){
            Collections.sort(arrayList, new Comparator<ZNJT>() {
                @Override
                public int compare(ZNJT o1, ZNJT o2) {
                    if (o1.getHongdeng() > o2.getHongdeng()) return 1;
                    if (o1.getHongdeng() == o2.getHongdeng()) return 0;
                    else return -1;
                }
            });
        }
        public void HDJX(ArrayList arrayList){
            Collections.sort(arrayList, new Comparator<ZNJT>() {
                @Override
                public int compare(ZNJT o1, ZNJT o2) {
                    if (o1.getHongdeng() < o2.getHongdeng()) return 1;
                    if (o1.getHongdeng() == o2.getHongdeng()) return 0;
                    else return -1;
                }
            });
        }

        public void HUDSX(ArrayList arrayList){
            Collections.sort(arrayList, new Comparator<ZNJT>() {
                @Override
                public int compare(ZNJT o1, ZNJT o2) {
                    if (o1.getHuangdeng() > o2.getHuangdeng()) return 1;
                    if (o1.getHuangdeng() == o2.getHuangdeng()) return 0;
                    else return -1;
                }
            });
        }
        public void HUDJX(ArrayList arrayList){
            Collections.sort(arrayList, new Comparator<ZNJT>() {
                @Override
                public int compare(ZNJT o1, ZNJT o2) {
                    if (o1.getHuangdeng() < o2.getHuangdeng()) return 1;
                    if (o1.getHuangdeng() == o2.getHuangdeng()) return 0;
                    else return -1;
                }
            });
        }

        public void LDSX(ArrayList arrayList){
            Collections.sort(arrayList, new Comparator<ZNJT>() {
                @Override
                public int compare(ZNJT o1, ZNJT o2) {
                    if (o1.getLvdeng() > o2.getLvdeng()) return 1;
                    if (o1.getLvdeng() == o2.getLvdeng()) return 0;
                    else return -1;
                }
            });
        }
        public void LDJX(ArrayList arrayList){
            Collections.sort(arrayList, new Comparator<ZNJT>() {
                @Override
                public int compare(ZNJT o1, ZNJT o2) {
                    if (o1.getLvdeng() < o2.getLvdeng()) return 1;
                    if (o1.getLvdeng() == o2.getLvdeng()) return 0;
                    else return -1;
                }
            });
        }
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.tab2,parent,false);
            }
            ZNJT znjt = (ZNJT)getItem(position);
            TextView textView1 = (TextView)convertView.findViewById(R.id.t1);
            TextView textView2 = (TextView)convertView.findViewById(R.id.t2);
            TextView textView3 = (TextView)convertView.findViewById(R.id.t3);
            TextView textView4 = (TextView)convertView.findViewById(R.id.t4);
            textView1.setText(String.valueOf(znjt.getLukou()));
            textView2.setText(String.valueOf(znjt.getHongdeng()));
            textView3.setText(String.valueOf(znjt.getHuangdeng()));
            textView4.setText(String.valueOf(znjt.getLvdeng()));
            return convertView;
        }
    }
}
