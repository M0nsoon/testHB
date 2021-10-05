package de.ur.mi.android.demos.healthbestie.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

import de.ur.mi.android.demos.healthbestie.R;
import de.ur.mi.android.demos.healthbestie.dashboard.Service.ShoppingItem;
import de.ur.mi.android.demos.healthbestie.dashboard.Service.ShoppingListAdapter;

public class ShoppingList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<ShoppingItem> arrayList;
    private EditText itemName;
    private Button confirm;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        itemName = findViewById(R.id.inputNewShoppingItem);
        confirm = findViewById(R.id.shoppingList_add);
        checkBox = (CheckBox) findViewById(R.id.listItem_checkBox);

        arrayList = new ArrayList<>();
        arrayList.add(new ShoppingItem("Eating correctly"));
        arrayList.add(new ShoppingItem("Sleep enough"));

        recyclerView = findViewById(R.id.rcViewItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ShoppingListAdapter adapter = new ShoppingListAdapter(arrayList);
        recyclerView.setAdapter(adapter);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(new ShoppingItem(itemName.getText().toString()));
                adapter.notifyDataSetChanged();
            }
        });



    }
}