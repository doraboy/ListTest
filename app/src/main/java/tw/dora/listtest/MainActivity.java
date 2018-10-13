package tw.dora.listtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private SimpleAdapter simpleAdapter;
    private LinkedList<HashMap<String,Object>> data;


    private int[] imgs = {R.drawable.img0, R.drawable.img1,
                            R.drawable.img2 ,R.drawable.img3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //要寫ListView這行之前,一定要先寫setContentView(R.layout.activity_main)
        //順序不能顛倒,要先設置好版面,才能來建立裡面的元件
        listView = findViewById(R.id.listView);
        initListView();

    }

    //建議onCreate裡面避免寫太複雜的code, 所以寫個方法獨立處理ListView的內容
    private void initListView(){
        String[] from = {"title","cont","img"};
        int[] to = {R.id.item_title, R.id.item_context, R.id.item_img};
        data =  new LinkedList<>();

        for(int i=0;i<100;i++){
            HashMap<String,Object> row = new HashMap<>();
            row.put(from[0], "title "+i);
            row.put(from[1], "content "+i);
            row.put(from[2], imgs[i%4]);
            data.add(row);

        }

//        String[] from = {"brad"};
//        HashMap<String,String> r0 = new HashMap<>();
//        r0.put(from[0],"Value1");
//        data.add(r0);
//
//        HashMap<String,String> r1 = new HashMap<>();
//        r1.put(from[0],"Value2");
//        data.add(r1);


        simpleAdapter = new SimpleAdapter(
                this, data, R.layout.item, from, to);
        listView.setAdapter(simpleAdapter);
    }


}
