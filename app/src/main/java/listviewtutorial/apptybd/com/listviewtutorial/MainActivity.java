package listviewtutorial.apptybd.com.listviewtutorial;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;



public class MainActivity extends Activity {
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView)findViewById(R.id.listView);
        list.setAdapter(new MyAdapter(this));
    }

}
class SingleRow{
    String title;
    String description;
    int image;

    SingleRow(String title, String description, int image) {
        this.title = title;
        this.description = description;
        this.image = image;

    }
}
class MyAdapter extends BaseAdapter{

    ArrayList<SingleRow> list;
    Context context;
    MyAdapter(Context c) {
        context=c;
        list=new ArrayList<SingleRow>();
        Resources res=c.getResources();
        String[] titles=res.getStringArray(R.array.titles);
        String[] descriptions=res.getStringArray(R.array.descriptions);
        int[] images={R.drawable.meme1,R.drawable.meme2,R.drawable.meme3,R.drawable.meme4,
                R.drawable.meme5,R.drawable.meme6,R.drawable.meme7,R.drawable.meme8,
                R.drawable.meme9,R.drawable.meme10};
        for (int i=0;i<10;i++){
           list.add(new SingleRow(titles[i],descriptions[i],images[i]));
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.single_row, viewGroup, false);

        TextView title=(TextView)row.findViewById(R.id.textView);
        TextView description=(TextView)row.findViewById(R.id.textView2);
        ImageView image=(ImageView)row.findViewById(R.id.imageView);

        SingleRow temp=list.get(i);

        title.setText(temp.title);
        description.setText(temp.description);
        image.setImageResource(temp.image);


        return row;
    }
}