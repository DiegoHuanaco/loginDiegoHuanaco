package com.example.diego.logindiegohuanaco.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;

import com.example.diego.logindiegohuanaco.R;
import com.example.diego.logindiegohuanaco.adapters.MyAdapter;
import com.example.diego.logindiegohuanaco.models.Empleados;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class Login extends AppCompatActivity implements RealmChangeListener<RealmResults<Empleados>> {

    private ListView listView;
    private MyAdapter adapter;
    private GridView gridView;

    private Realm realm;
    private RealmResults<Empleados> empleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();

        empleado = getAllEmpleados();
        empleado.addChangeListener(this);

        adapter = new MyAdapter(empleado, R.layout.list_item_view, this);

        gridView.setAdapter(adapter);
    }

    @Override
    public void onChange(RealmResults<Empleados> element) {
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        realm.removeAllChangeListeners();
        realm.close();
        super.onDestroy();
    }




    private RealmResults<Empleados> getAllEmpleados() {
        return realm.where(Empleados.class).findAll();
    }

    private void removeAll() {
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }


    private void addEmpleado() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {


                Empleados e1 = new Empleados("18899263-3", "Diego",24,"callefalsa", 123,"vicepresidentejunior");
                Empleados e2 = new Empleados("18899263-3", "Diego",24,"callefalsa", 123,"vicepresidentejunior");
                Empleados e3 = new Empleados("18899263-3", "Diego",24,"callefalsa", 123,"vicepresidentejunior");
                Empleados e4 = new Empleados("18899263-3", "Diego",24,"callefalsa", 123,"vicepresidentejunior");
                Empleados e5 = new Empleados("18899263-3", "Diego",24,"callefalsa", 123,"vicepresidentejunior");


                realm.copyToRealmOrUpdate(e1);
                realm.copyToRealmOrUpdate(e2);
                realm.copyToRealmOrUpdate(e3);
                realm.copyToRealmOrUpdate(e4);
                realm.copyToRealmOrUpdate(e5);



                empleado = getAllEmpleados();
            }
        });
    }
}
