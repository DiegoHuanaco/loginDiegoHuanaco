package com.example.diego.logindiegohuanaco.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.diego.logindiegohuanaco.R;
import com.example.diego.logindiegohuanaco.adapters.MyAdapter;
import com.example.diego.logindiegohuanaco.models.Empleados;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class Muestra extends AppCompatActivity implements RealmChangeListener<RealmResults<Empleados>> {

private ListView listView;
private MyAdapter adapter;

private Realm realm;
private RealmResults<Empleados> empleado;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();
        listView = (ListView) findViewById(R.id.listView);
    addEmpleado();
        empleado = getAllEmpleado();
        empleado.addChangeListener(this);

        adapter = new MyAdapter(empleado, R.layout.list_item_view, this);

        listView.setAdapter(adapter);
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






private RealmResults<Empleados> getAllEmpleado() {
        return realm.where(Empleados.class).findAll();
        }



private void addEmpleado() {
        realm.executeTransaction(new Realm.Transaction() {
@Override
public void execute(Realm realm) {

        Empleados dog1 = new Dog("BOBY");
        Dog dog2 = new Dog("TEDDY");
        Dog dog3 = new Dog("RAMBO");
        Dog dog4 = new Dog("CHUCHO");
        Dog dog5 = new Dog("MICHEL");



        Person p1 = new Person("Alejandro");
        Person p2 = new Person("Asian");
        Person p3 = new Person("Fernando");

        realm.copyToRealmOrUpdate(p1);
        realm.copyToRealmOrUpdate(p2);
        realm.copyToRealmOrUpdate(p3);

        empleado = getAllEmpleado();
        }
        });
        }
        }
