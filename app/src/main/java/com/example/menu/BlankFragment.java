package com.example.menu;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class BlankFragment extends Fragment {

    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        textView = view.findViewById(R.id.textView); // Предполагается, что у вас есть TextView с id textView
        registerForContextMenu(textView); // Регистрация для контекстного меню
        return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Выберите текст");
        menu.add(0, v.getId(), 0, "Текст 1");
        menu.add(0, v.getId(), 0, "Текст 2");
        menu.add(0, v.getId(), 0, "Текст 3");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.textView:
                textView .setText(item.getTitle());
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}